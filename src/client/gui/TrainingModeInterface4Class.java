package client.gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.applet.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import client.transmission.Client;

/*
 * 模式界面1，。。
 * @Author Xu Wenbo(Charles), Zheng Haoewn(Albert), Jin XinBin(Allen), Xu Qiufan, Hu Suihao
 * @Date
 */
public class TrainingModeInterface4Class implements MouseListener {
	
	Client client;
	
	JFrame TrainingModeInterface4Frame = new JFrame("TrainingModeInterface2Class");

	// 加载图片
	BufferedImage TrainingModeInterface4ClassBGBuffered;
	BufferedImage WordButtonPicture1Buffered;
	BufferedImage WordButtonPicture2Buffered;
	BufferedImage WordButtonBackBuffered;

	// 创建Label
	JLabel TrainingModeInterface4ClassLbl = new JLabel();
	JLabel backBtn = new JLabel();
	JLabel word1 = new JLabel("I want to eat!");
	JLabel word2 = new JLabel("I want to play!");

	TrainingModeInterface4Class(Client client) {
		
		this.client = client;

		// 设置Frame
		TrainingModeInterface4Frame.setSize(600, 850); // 设置大小为 600 × 850
		TrainingModeInterface4Frame.setResizable(false); // 使窗口大小无法改变
		TrainingModeInterface4Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置默认关闭操作

		// 设置图片
		try{
			TrainingModeInterface4ClassBGBuffered = ImageIO.read(new File(
				"resource/TrainingModeInterface//Training Mode Interface4.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon TrainingModeInterface4ClassBG = new ImageIcon(TrainingModeInterface4ClassBGBuffered);
		
		try{
			WordButtonBackBuffered = ImageIO.read(new File(
				"resource/TrainingModeInterface//Word Button back3.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon WordButtonBack = new ImageIcon(WordButtonBackBuffered);
		
		
		TrainingModeInterface4ClassBG
				.setImage(TrainingModeInterface4ClassBG.getImage().getScaledInstance(600, 800, Image.SCALE_DEFAULT));
		WordButtonBack.setImage(WordButtonBack.getImage().getScaledInstance(120, 40, Image.SCALE_DEFAULT));

		// 设置Lbl
		TrainingModeInterface4ClassLbl.setBounds(0, 0, 600, 800); // TrainingModeInterface1ClassLbl位置为0，0
																	// 大小为 600 ×
																	// 800
		TrainingModeInterface4ClassLbl.setIcon(TrainingModeInterface4ClassBG); // TrainingModeInterface1ClassLbl载入图片TrainingModeInterface1ClassBG

		word1.setBounds(150, 130, 300, 180); // picture1Btn位置为150，130 大小
		word1.addMouseListener(this); // 设置picture1Btn的监听

		word2.setBounds(150, 330, 300, 180); // picture2Btn位置为150，330 大小为
		word2.addMouseListener(this); // 设置picture2Btn的监听

		backBtn.setBounds(235, 530, 120, 40); // backBtn位置为235，530 大小为 120 × 40
		backBtn.setIcon(WordButtonBack); // backBtn载入图片WordButtonBack
		backBtn.addMouseListener(this); // 设置backBtn的监听
		
		word1.setFont(new Font("Comic Sans MC",Font.PLAIN,24));
		word2.setFont(new Font("Comic Sans MC",Font.PLAIN,24));
		
		word1.setText(("<html>I <br>want to<br> eat!</html>"));
		word2.setText(("<html>I <br>want to<br> play!</html>"));
		// 添加lbl

		TrainingModeInterface4ClassLbl.add(backBtn); // 将backBtn添加至TrainingModeInterface1ClassLbl上
		TrainingModeInterface4ClassLbl.add(word1);
		TrainingModeInterface4ClassLbl.add(word2);
		
		TrainingModeInterface4Frame.add(TrainingModeInterface4ClassLbl); // 将TrainingModeInterface1ClassLbl添加至TrainingModeInterface1Frame中
		TrainingModeInterface4Frame.setVisible(true); // 设置TrainingModeInterface1Frame为可访问的
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // 创建temporary标签

		if (Lbl == word1) {
			new Response();
		} else if (Lbl == word2) {
			new Response();
		} else if (Lbl == backBtn) {
			new TrainingModeClass(client); // 点击backBtn后跳转至TrainingModeClass的窗口
			TrainingModeInterface4Frame.dispose(); // 关闭当前窗口
		}
	}// end mouseClicked

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}// end mousePressed

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}// end mouseReleased

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}// end mouseEntered

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}// end mouseExited
}

