package server.transmission;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import server.pulse.PulseListener;
import server.pulse.PulseSender;
import tool.GetArticle;
import transfer.Packet;

/**
 * @author Qiufan(Andy) Xu 
 * @date CreateTime: Oct 10, 2015 10:17:38 PM 
 * @version 1.0 
 * @param 
 */

class HandleStream extends Thread{
	
	String username;
	Socket client;
	ObjectOutputStream out;
	ObjectInputStream in;
	SocketListener socketListener;
	GetArticle articleTool;

	/* constructor */
	public HandleStream(Authenticate infoPack) {
		this.username = infoPack.username;
		this.client = infoPack.client;
		this.socketListener = infoPack.socketListener;
		this.in = infoPack.in;
		this.out = infoPack.out;
		this.articleTool = infoPack.socketListener.articleTool;
	}
	
	@Override
	public void run() {
		
		PulseListener pulseListener = new PulseListener(socketListener, client, in, out);
		pulseListener.start();
		
		new Thread(new PulseSender(out, username)).start();
		
		try {
			
			while (true) {
				
				Packet packet = (Packet) in.readObject();
				pulseListener.setLastPacketTime(System.currentTimeMillis());
				
				System.out.println("[Server_HandleStream] "+packet.TYPE+" - "+packet.USERNAME);
				
				switch (packet.TYPE) {
				case Packet.ASK_ARTICLE_LIST:
					sendArticleList();
					break;
					
				case Packet.ASK_ARTICLE_URL:
					sendArticleUrl(packet.getArticleNumber());
					break;
				
				
//				case Packet.value:
//					//TODO
//					break;
//					
				default:
					break;
				}
				
			}
			
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("[Server_HandleStream_run] Fail to read Packet.");
//			e.printStackTrace();
		}
		
	}
	
	private void sendArticleList() {
		Packet backPacket = new Packet(Packet.ARTICLE_LIST, username);
		backPacket.setArticleList(articleTool.getArticleList());
		sendPacket(backPacket);
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	private void sendArticleUrl(int articleNumber) {
		Packet backPacket = new Packet(Packet.ARTICLE_URL, username);
		backPacket.setArticleUrl(articleTool.getArticleUrl(articleNumber));
		sendPacket(backPacket);
		// TODO Auto-generated method stub
	}
	
	
	
	protected void sendPacket(Packet packet) {
		try {
			System.out.println("[sendPacket] "+packet.TYPE);
			out.writeObject(packet);
			out.flush();
		} catch (IOException e) {
			System.err.println("[Server_HandleStream_sendPacket]");
//			e.printStackTrace();
		}
	}
	
}
