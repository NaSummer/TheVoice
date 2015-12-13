package server.transmission;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import transfer.Packet;

/**
 * @author Qiufan(Andy) Xu 
 * @date CreateTime: Oct 10, 2015 3:19:10 PM 
 * @version 1.0 
 * @param 
 */

class Authenticate extends Thread{
	
	Socket client;
	ObjectOutputStream out;
	ObjectInputStream in;
	SocketListener socketListener;
	String username;
	CheckInfo checkInfo = new CheckInfo();
	boolean isAuth = false;
	
	public Authenticate(Socket client, SocketListener socketListener) {
		this.client = client;
		this.socketListener = socketListener;
	}
	
	
	@Override
	public void run() {
		
		// create stream between server and client
		createStream();
		
		try {
			
			do {
				
				// get user name
				Packet firstPacket = (Packet) in.readObject();
				username = firstPacket.USERNAME;
				
				// whether sign in or sign up
				sort(firstPacket);
				
			} while (!isAuth);
			
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("[Authenticate] Fail to read object(Packet).");
//			e.printStackTrace();
		}
		
	}
	
	
	
	/* whether sign in or sign up */
	private void sort(Packet packet) {
		
		switch (packet.TYPE) {
		
		// sign up
		case Packet.SIGN_UP:
			if (!checkInfo.isUserExisted(packet.USERNAME)) {
				// user not exist
				checkInfo.writeUserInfo(packet.USERNAME, packet.getPassword());
				authSuccess(packet.USERNAME);
			} else {
				// user exist
				authFail();
			}
			break;
			
		// sign in
		case Packet.SIGN_IN:
			if (checkInfo.isInfoRight(packet.USERNAME, packet.getPassword())) {
				// auth success
				System.out.println("[Authenticate_sort_switch_SIGN_IN] Info auth pass");
				authSuccess(packet.USERNAME);
			} else {
				// auth fail
				System.out.println("[Authenticate_sort_switch_SIGN_IN] Info not right");
				authFail();
			}
			break;
			
		// wrong packet type
		default:
			System.out.println("[Auth_sort] received wrong type Packet");
			authFail();
			break;
			
		}
		
	}
	
	
	/**
	 * auth Success
	 * @param 
	 * @return 
	 */
	private void authSuccess(String username) {
		
		socketListener.OOSList.add(out);
		isAuth = true;
		
		Packet back = new Packet(Packet.AUTH_SUCCESSFUL, username);
		
		sendBackPacket(back);
		
		// if auth success, give the control of handling information between server and client
		new Thread(new HandleStream(this)).start();
		
	}
	
	/**
	 * auth fail
	 * @param 
	 * @return 
	 */
	private void authFail() {
		
		Packet back = new Packet(Packet.AUTH_FAIL, username);
		
		sendBackPacket(back);
		
	}
	
	
	/**
	 * send back packet
	 * @param 
	 * @return 
	 */
	private void sendBackPacket(Packet packet) {
		
		try {
			out.writeObject(packet);
			out.flush();
			System.out.println("[Auth_sendBackPacke] send back packet " + packet.TYPE + " - " + packet.USERNAME);
			
		} catch (IOException e) {
			System.err.println("[Auth_sendBackPacket] fail to send back Packet.");
//					e.printStackTrace();
		}
		
	}
	
	
	/**
	 * create stream between server and client
	 * @param 
	 * @return 
	 */
	private void createStream() {
		
		try {
			
			OutputStream os = this.client.getOutputStream();
			out = new ObjectOutputStream(os);
			
			InputStream is = this.client.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			in = new ObjectInputStream(bis);
			
		} catch (IOException e) {
			System.err.println("[Authenticate_CreateStream] Fail to create Stream.");
//			e.printStackTrace();
		}
		
		
	}
	
}
