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

		// ����Frame
		jf.setSize(600, 850); // ���ô�СΪ 600 �� 850
		jf.add(jp);
		// jf.setResizable(false); // ʹ���ڴ�С�޷��ı�
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����Ĭ�Ϲرղ���
		jf.setVisible(true);

	}// end main

}
