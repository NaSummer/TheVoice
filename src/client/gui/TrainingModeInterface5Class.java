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
 * ģʽ����1������
 * @Author Xu Wenbo(Charles), Zheng Haoewn(Albert), Jin XinBin(Allen), Xu Qiufan, Hu Suihao
 * @Date
 */
public class TrainingModeInterface5Class{
	
	Client client;
	
	JFrame TrainingModeInterface5Frame = new JFrame("TrainingModeInterface2Class");

	// ����ͼƬ
	BufferedImage TrainingModeInterface5ClassBGBuffered;

	// ����Label
	JLabel TrainingModeInterface5ClassLbl = new JLabel();
	JLabel word1 = new JLabel();

	TrainingModeInterface5Class(Client client) {
		
		this.client = client;

		// ����Frame
		TrainingModeInterface5Frame.setSize(600, 850); // ���ô�СΪ 600 �� 850
		TrainingModeInterface5Frame.setResizable(false); // ʹ���ڴ�С�޷��ı�
		TrainingModeInterface5Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����Ĭ�Ϲرղ���

		// ����ͼƬ
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

		// ����Lbl
		TrainingModeInterface5ClassLbl.setBounds(0, 0, 600, 800); // TrainingModeInterface1ClassLblλ��Ϊ0��0
																	// ��СΪ 600 ��
																	// 800
		TrainingModeInterface5ClassLbl.setIcon(TrainingModeInterface5ClassBG); // TrainingModeInterface1ClassLbl����ͼƬTrainingModeInterface1ClassBG

		word1.setBounds(170, 140, 500, 400); // picture1Btnλ��Ϊ150��130 ��С


		word1.setFont(new Font("Comic Sans MC",Font.PLAIN,50));
	
		
		word1.setText(("<html>I hope you can <br>speak it out to us.</html>"));

		TrainingModeInterface5ClassLbl.add(word1);

		
		TrainingModeInterface5Frame.add(TrainingModeInterface5ClassLbl); // ��TrainingModeInterface1ClassLbl�����TrainingModeInterface1Frame��
		TrainingModeInterface5Frame.setVisible(true); // ����TrainingModeInterface1FrameΪ�ɷ��ʵ�
	}
}