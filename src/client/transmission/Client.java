package client.transmission;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import tool.Tool;
import transfer.Packet;

/**
 * 
 * @author Qiufan(Andy) Xu
 * @date CreateTime: Oct 10, 2015 11:34:55 PM
 * @version 1.2
 */

public class Client {

	protected final static int PORT = 20488;
	protected final static int TIMEOUT = 5 * 1000;

	public final long DEVICE_ID;
	public final String SERVER_ADDRESS;

	protected Socket socket;
	protected ObjectOutputStream out;
	protected ObjectInputStream in;

	protected PulseListener pulseListener;
	protected Thread handleStreamThread;
	protected Thread pulseListenerThread;
	protected Thread pulseSender;

	protected HandleStream handleStream;

	protected String username;
	protected boolean isAuth = false;

	List<String> articleList;
	String articleUrl;
	boolean isNewArticleList = false;
	boolean isNewArticleUrl = false;

	public Client() {
		this.DEVICE_ID = Tool.generateID();
		this.SERVER_ADDRESS = "127.0.0.1";

		connectServer();
	}

	public Client(String serverAddress) {
		this.DEVICE_ID = Tool.generateID();
		this.SERVER_ADDRESS = serverAddress;

		connectServer();
	}

	/* ========Sign In======== */
	/**
	 * sign in server
	 * 
	 * @param
	 * @return [boolean] whether login successful
	 */
	public boolean signIn(String username, String password) {
		try {
			Packet packet = new Packet(Packet.SIGN_IN, username);
			packet.setPassword(password);
			sendPacket(packet);
			Packet receivedPacket;
			receivedPacket = (Packet) in.readObject();
			if (receivedPacket.TYPE == Packet.AUTH_SUCCESSFUL) {
				authSuccess(username);
			}
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("[Client_login]");
			// e.printStackTrace();
		}
		return isAuth;
	}

	/* ========Sign Up======== */
	/**
	 * sign up a new user in server. If sign up successful, don't need to sign
	 * in again
	 * 
	 * @param
	 * @return [boolean] whether register successful
	 */
	public boolean signUp(String username, String password) {
		try {
			Packet packet = new Packet(Packet.SIGN_UP, username);
			packet.setPassword(password);
			sendPacket(packet);
			Packet receivedPacket;
			receivedPacket = (Packet) in.readObject();
			System.out.println("[Client_signUp] received packet " + receivedPacket.TYPE);
			if (receivedPacket.TYPE == Packet.AUTH_SUCCESSFUL) {
				authSuccess(username);
			}
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("[Client_register]");
			// e.printStackTrace();
		}
		return isAuth;
	}

	/* =======Ask Article List====== */
	/**
	 * 
	 * @param
	 * @return
	 */
	public List<String> getArticleList() {

		Packet packet = new Packet(Packet.ASK_ARTICLE_LIST, this.username);
		sendPacket(packet);
		long tmpTime = System.currentTimeMillis();
		while ((!isNewArticleList) && (System.currentTimeMillis() - tmpTime < 3000L)) {
			// blank
			System.out.println("9 "+tmpTime+" "+System.currentTimeMillis() + " "+isNewArticleList);
		}
		if (isNewArticleList) {
			isNewArticleList = false;
			return articleList;
		} else {
			return new ArrayList<String>();
		}
	}

	/**
	 * 
	 * @param
	 * @return
	 */
	public String getArticleUrl(int articleNumber) {

		Packet packet = new Packet(Packet.ASK_ARTICLE_URL, this.username);
		packet.setArticleNumber(articleNumber);
		sendPacket(packet);
		long tmpTime = System.currentTimeMillis();
		while (!isNewArticleUrl && System.currentTimeMillis() - tmpTime < 3000L) {
			// blank
		}
		if (isNewArticleUrl) {
			isNewArticleUrl = false;
			return articleUrl;
		} else {
			return new String();
		}

	}

	/* ========private method======== */

	/**
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	private void connectServer() {

		try {

			socket = new Socket(SERVER_ADDRESS, PORT);

			OutputStream os = socket.getOutputStream();
			out = new ObjectOutputStream(os);

			InputStream is = socket.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			in = new ObjectInputStream(bis);

		} catch (IOException e) {
			System.err.println("[Client_connectServer] Fail to connect server or disconnect.");
			// e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param
	 * @return
	 */
	private void sendPacket(Packet packet) {
		try {
			out.writeObject(packet);
			out.flush();
			System.out.println("[Client] sendPacket " + packet.TYPE);
		} catch (IOException e) {
			System.err.println("[Client_sendPacket]");
			// e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param
	 * @return
	 */
	private void authSuccess(String username) {
		isAuth = true;
		this.username = username;

		pulseListener = new PulseListener(this);
		pulseListenerThread = new Thread(pulseListener);
		pulseListenerThread.start();

		pulseSender = new Thread(new PulseSender(out, username));
		pulseSender.start();

		handleStream = new HandleStream(this);
		handleStreamThread = new Thread(handleStream);
		handleStreamThread.start();

	}

}
