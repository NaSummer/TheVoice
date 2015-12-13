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
public class TrainingModeInterface5Class{
	
	Client client;
	
	JFrame TrainingModeInterface5Frame = new JFrame("TrainingModeInterface2Class");

	// 加载图片
	BufferedImage TrainingModeInterface5ClassBGBuffered;

	// 创建Label
	JLabel TrainingModeInterface5ClassLbl = new JLabel();
	JLabel word1 = new JLabel();

	TrainingModeInterface5Class(Client client) {
		
		this.client = client;

		// 设置Frame
		TrainingModeInterface5Frame.setSize(600, 850); // 设置大小为 600 × 850
		TrainingModeInterface5Frame.setResizable(false); // 使窗口大小无法改变
		TrainingModeInterface5Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置默认关闭操作

		// 设置图片
		try{
			TrainingModeInterface5ClassBGBuffered = ImageIO.read(new File(
				"resource/TrainingModeInterface//Training Mode Interface5.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon TrainingModeInterface5ClassBG = new ImageIcon(TrainingModeInterface5ClassBGBuffered);
	
		
		
		TrainingModeInterface5ClassBG
				.setImage(TrainingModeInterface5ClassBG.getImage().getScaledInstance(600, 800, Image.SCALE_DEFAULT));

		// 设置Lbl
		TrainingModeInterface5ClassLbl.setBounds(0, 0, 600, 800); // TrainingModeInterface1ClassLbl位置为0，0
																	// 大小为 600 ×
																	// 800
		TrainingModeInterface5ClassLbl.setIcon(TrainingModeInterface5ClassBG); // TrainingModeInterface1ClassLbl载入图片TrainingModeInterface1ClassBG

		word1.setBounds(170, 140, 500, 400); // picture1Btn位置为150，130 大小


		word1.setFont(new Font("Comic Sans MC",Font.PLAIN,50));
	
		
		word1.setText(("<html>I hope you can <br>speak it out to us.</html>"));

		TrainingModeInterface5ClassLbl.add(word1);

		
		TrainingModeInterface5Frame.add(TrainingModeInterface5ClassLbl); // 将TrainingModeInterface1ClassLbl添加至TrainingModeInterface1Frame中
		TrainingModeInterface5Frame.setVisible(true); // 设置TrainingModeInterface1Frame为可访问的
	}
}