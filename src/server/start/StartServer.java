package server.start;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

import server.transmission.SocketListener;

/**
 * @author Qiufan(Andy) Xu 
 * @date CreateTime: Oct 10, 2015 11:34:55 PM 
 * @version 1.0 
 */

public class StartServer {

	
	public final static int PORT = 20488;
	
	protected ServerSocket serverSocket;
	
	public StartServer() {
		try {
			
			serverSocket = new ServerSocket(PORT);
			
			/* get local host address */
			InetAddress addr = InetAddress.getLocalHost();
			System.out.println("Server IP address: " + addr.getHostAddress());
			
			new Thread(new SocketListener(serverSocket)).start();
			
		} catch (IOException e) {
			System.err.println("[StartServer] Fail to open ServerSocket at Port " + PORT);
//			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new StartServer();
	}

}
