package server.transmission;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import tool.GetArticle;

/**
 * @author Qiufan(Andy) Xu 
 * @date CreateTime: Oct 10, 2015 2:15:44 PM 
 * @version 1.0 
 * @param 
 */

public class SocketListener extends Thread{
	
	ServerSocket serverSocket;
	
	GetArticle articleTool = new GetArticle();
	public List<Socket> clientConnection = new ArrayList<Socket>();
	public List<ObjectOutputStream> OOSList = new ArrayList<ObjectOutputStream>();
	
	public SocketListener(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
		new Thread(new ConnectionChecker()).start();
	}
	
	
	@Override
	public void run() {
		
		try {
			
			while (true) {
				
				Socket client = serverSocket.accept();
				
				/* add client in to list */
				clientConnection.add(client);
				System.out.println("The no." + clientConnection.size() + " client connected to the server.");
				
				new Thread(new Authenticate(client, this)).start();
				
			}
			
		} catch (IOException e) {
			System.err.println("[SocketListener] Fail to accept client Socket.");
//			e.printStackTrace();
		}
		
		
	}
	
	
	
	class ConnectionChecker extends Thread {
		
		final static int INTERVAL = 1000;
		
		@Override
		public void run() {
			while (true) {
				
				int i = 0;
				
				while (i < clientConnection.size()) {
					
					if (!clientConnection.get(i).isConnected()) {
						clientConnection.remove(i);
						System.out.println("[ConnectionChecker] 1 client disconnected.");
					} else {
						i++;
					}
					
				}
				
				try {
					ConnectionChecker.sleep(INTERVAL);
				} catch (InterruptedException e) {
					System.err.println("[ConnectionChecker] Fail to sleep.");
//					e.printStackTrace();
				}
				
			}
		
		}
		
	}
	
	
	
}
