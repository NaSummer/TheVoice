package client.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartClient {

	JFrame jf = new JFrame();
	Interface i = new Interface();
	JPanel jp = i.InceptionInterface();
	public static void main(String[] args) {
		
		JFrame jf = new JFrame();
		Interface i = new Interface();
		JPanel jp = i.InceptionInterface();
		//new Inception();

	
		// ����Frame
				jf.setSize(600, 850); // ���ô�СΪ 600 �� 850
				jf.add(jp);
//				jf.setResizable(false); // ʹ���ڴ�С�޷��ı�
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����Ĭ�Ϲرղ���
				jf.setVisible(true);

	}//end main

}
