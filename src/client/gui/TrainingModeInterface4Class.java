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
public class TrainingModeInterface4Class implements MouseListener {
	
	Client client;
	
	JFrame TrainingModeInterface4Frame = new JFrame("TrainingModeInterface2Class");

	// ����ͼƬ
	BufferedImage TrainingModeInterface4ClassBGBuffered;
	BufferedImage WordButtonPicture1Buffered;
	BufferedImage WordButtonPicture2Buffered;
	BufferedImage WordButtonBackBuffered;

	// ����Label
	JLabel TrainingModeInterface4ClassLbl = new JLabel();
	JLabel backBtn = new JLabel();
	JLabel word1 = new JLabel("I want to eat!");
	JLabel word2 = new JLabel("I want to play!");

	TrainingModeInterface4Class(Client client) {
		
		this.client = client;

		// ����Frame
		TrainingModeInterface4Frame.setSize(600, 850); // ���ô�СΪ 600 �� 850
		TrainingModeInterface4Frame.setResizable(false); // ʹ���ڴ�С�޷��ı�
		TrainingModeInterface4Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����Ĭ�Ϲرղ���

		// ����ͼƬ
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

		// ����Lbl
		TrainingModeInterface4ClassLbl.setBounds(0, 0, 600, 800); // TrainingModeInterface1ClassLblλ��Ϊ0��0
																	// ��СΪ 600 ��
																	// 800
		TrainingModeInterface4ClassLbl.setIcon(TrainingModeInterface4ClassBG); // TrainingModeInterface1ClassLbl����ͼƬTrainingModeInterface1ClassBG

		word1.setBounds(150, 130, 300, 180); // picture1Btnλ��Ϊ150��130 ��С
		word1.addMouseListener(this); // ����picture1Btn�ļ���

		word2.setBounds(150, 330, 300, 180); // picture2Btnλ��Ϊ150��330 ��СΪ
		word2.addMouseListener(this); // ����picture2Btn�ļ���

		backBtn.setBounds(235, 530, 120, 40); // backBtnλ��Ϊ235��530 ��СΪ 120 �� 40
		backBtn.setIcon(WordButtonBack); // backBtn����ͼƬWordButtonBack
		backBtn.addMouseListener(this); // ����backBtn�ļ���
		
		word1.setFont(new Font("Comic Sans MC",Font.PLAIN,24));
		word2.setFont(new Font("Comic Sans MC",Font.PLAIN,24));
		
		word1.setText(("<html>I <br>want to<br> eat!</html>"));
		word2.setText(("<html>I <br>want to<br> play!</html>"));
		// ���lbl

		TrainingModeInterface4ClassLbl.add(backBtn); // ��backBtn�����TrainingModeInterface1ClassLbl��
		TrainingModeInterface4ClassLbl.add(word1);
		TrainingModeInterface4ClassLbl.add(word2);
		
		TrainingModeInterface4Frame.add(TrainingModeInterface4ClassLbl); // ��TrainingModeInterface1ClassLbl�����TrainingModeInterface1Frame��
		TrainingModeInterface4Frame.setVisible(true); // ����TrainingModeInterface1FrameΪ�ɷ��ʵ�
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // ����temporary��ǩ

		if (Lbl == word1) {
			new Response();
		} else if (Lbl == word2) {
			new Response();
		} else if (Lbl == backBtn) {
			new TrainingModeClass(client); // ���backBtn����ת��TrainingModeClass�Ĵ���
			TrainingModeInterface4Frame.dispose(); // �رյ�ǰ����
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

