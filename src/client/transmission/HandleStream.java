package client.transmission;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import transfer.Packet;

/**
 * @author Qiufan(Andy) Xu 
 * @date CreateTime: 2015年10月25日 下午11:27:07 
 * @version 1.0 
 * @param 
 */

public class HandleStream extends Thread{

	Client client;
	String username;
	ObjectOutputStream out;
	ObjectInputStream in;
	PulseListener pulseListener;
	
	
	public HandleStream(Client client) {
		this.client = client;
		this.pulseListener = client.pulseListener;
		this.out = client.out;
		this.in = client.in;
	}
	
	@Override
	public void run() {
		
		try {
			
			while (true) {
				
				Packet packet = (Packet) in.readObject();
				pulseListener.setLastPacketTime(System.currentTimeMillis());
				
				System.out.println("[Client_HandleStream] "+packet.TYPE+" - "+packet.USERNAME);
				
				switch (packet.TYPE) {
				case Packet.ARTICLE_LIST:
					client.articleList = packet.getArticleList();
					client.isNewArticleList = true;
					break;
					
				case Packet.ARTICLE_URL:
					client.articleUrl = packet.getArticleUrl();
					client.isNewArticleUrl = true;
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
			System.err.println("[Client_HandleStream_run] Fail to read Packet.");
//			e.printStackTrace();
		}
		
	
		
		// TODO Auto-generated method stub
	}
	
}
