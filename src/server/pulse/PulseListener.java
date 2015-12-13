package server.pulse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import server.transmission.SocketListener;

/**
 * @author Qiufan(Andy) Xu 
 * @date CreateTime: Oct 10, 2015 10:44:02 PM 
 * @version 1.0 
 * @param 
 */

public class PulseListener extends Thread {
	
	Socket client;
	SocketListener socketListener;
	ObjectInputStream in;
	ObjectOutputStream out;
	private long lastPacketTime;
	final int INTERVAL_TIME = 1*1000;
	final long TIMEOUT = 40*1000L;
	
	public PulseListener(SocketListener socketListener, Socket client, ObjectInputStream ois, ObjectOutputStream oos) {
		this.socketListener = socketListener;
		this.in = ois;
		this.out = oos;
	}
	
	@Override
	public void run() {
		try {
			
			lastPacketTime = System.currentTimeMillis();
			
			do {
				if (System.currentTimeMillis()-lastPacketTime>TIMEOUT) {
					socketListener.clientConnection.remove(client);
					socketListener.OOSList.remove(out);
					in.close();
					out.close();
					client.close();
					System.out.println("Lost one connection.");
					System.out.println("There are " + socketListener.clientConnection.size() + " connection now after one disconnection.");
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
