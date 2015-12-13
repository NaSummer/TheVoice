package client.transmission;

import java.io.IOException;

/**
 * @author Qiufan(Andy) Xu 
 * @date CreateTime: Oct 10, 2015 10:44:02 PM 
 * @version 1.0 
 * @param 
 */

public class PulseListener extends Thread {
	
	Client client;
	private long lastPacketTime;
	final int INTERVAL_TIME = 1*1000;
	final long TIMEOUT = 40*1000L;
	
	public PulseListener(Client client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		try {
			
			lastPacketTime = System.currentTimeMillis();
			
			do {
				if (System.currentTimeMillis()-lastPacketTime>TIMEOUT) {
					client.in.close();
					client.out.close();
					client.socket.close();
					client.isAuth = false;
					System.out.println("Lost connection.");
					break;
				}
				PulseListener.sleep(INTERVAL_TIME);
			} while (true);
			
		} catch (IOException e) {
			System.err.println("[PulseListener] Fail to close the Socket or it had closed already.");
		} catch (InterruptedException e) {
			System.err.println("[PulseListener] Fail to sleep the PulseListener Thread.");
//			e.printStackTrace();
		}
		
	}
	
	public void setLastPacketTime(long t) {
		this.lastPacketTime = t;
	}
	
}
