package client.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.transmission.Client;

public class StartClient {
	static Client client = new Client();

	public static void main(String[] args) {
		// new Inception();

		JFrame jf = new JFrame();
		Interface i = new Interface(client);
		JPanel jp = i.InceptionInterface();

		// 设置Frame
		jf.setSize(600, 850); // 设置大小为 600 × 850
		jf.add(jp);
		// jf.setResizable(false); // 使窗口大小无法改变
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置默认关闭操作
		jf.setVisible(true);

	}// end main

}
