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

	
		// 设置Frame
				jf.setSize(600, 850); // 设置大小为 600 × 850
				jf.add(jp);
//				jf.setResizable(false); // 使窗口大小无法改变
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置默认关闭操作
				jf.setVisible(true);

	}//end main

}
