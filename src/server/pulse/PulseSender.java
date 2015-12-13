package server.pulse;

import java.io.IOException;
import java.io.ObjectOutputStream;

import server.transmission.SocketListener;
import transfer.Packet;

/**
 * @author Qiufan(Andy) Xu 
 * @date CreateTime: Oct 10, 2015 10:47:38 PM 
 * @version 1.0 
 * @param 
 */

public class PulseSender extends Thread {

	String username;
	ObjectOutputStream out;
	SocketListener socketListener;
	final int INTERVAL_TIME = 20*1000;
	boolean isConnected = true;
	
	public PulseSender(ObjectOutputStream oos, String username) {
		this.out = oos;
		this.username = username;
	}
	
	@Override
	public void run() {
		while (isConnected) {
			
			try {
				
				Packet back = new Packet(Packet.PULSE, username);
				out.writeObject(back);
				out.flush();
				
			} catch (IOException e) {
				System.err.println("[PulseSender] Fail to send back pulse.");
				isConnected = false;
//				e.printStackTrace();
			}
			
			try {
				PulseSender.sleep(INTERVAL_TIME);
			} catch (InterruptedException e) {
				System.err.println("[Server_PulseSender] Fail to sleep");
//				e.printStackTrace();
			}
			
			
		}
	}
	
}
