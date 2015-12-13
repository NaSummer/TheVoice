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
public class TrainingModeInterface2Class implements MouseListener {
	
	Client client;
	
	JFrame TrainingModeInterface2Frame = new JFrame("TrainingModeInterface2Class");

	// ����ͼƬ
	BufferedImage TrainingModeInterface2ClassBGBuffered;
	ImageIcon WordButtonPicture1 = new ImageIcon(SettingClass.path);
	ImageIcon WordButtonPicture2 = new ImageIcon(SettingClass.path2);
	BufferedImage WordButtonBackBuffered;

	// ����Label
	JLabel TrainingModeInterface2ClassLbl = new JLabel();
	JLabel picture1Btn = new JLabel();
	JLabel picture2Btn = new JLabel();
	JLabel backBtn = new JLabel();
	JLabel word1 = new JLabel("I want to eat!");
	JLabel word2 = new JLabel("I want to play!");

	TrainingModeInterface2Class(Client client) {
		
		this.client = client;

		// ����Frame
		TrainingModeInterface2Frame.setSize(600, 850); // ���ô�СΪ 600 �� 850
		TrainingModeInterface2Frame.setResizable(false); // ʹ���ڴ�С�޷��ı�
		TrainingModeInterface2Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����Ĭ�Ϲرղ���

		// ����ͼƬ
		try{
			TrainingModeInterface2ClassBGBuffered = ImageIO.read(new File(
				"resource/TrainingModeInterface//Training Mode Interface2.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon TrainingModeInterface1ClassBG = new ImageIcon(TrainingModeInterface2ClassBGBuffered);
		
//		try{
//			WordButtonPicture1Buffered = ImageIO.read(new File(
//				"resource/Training Mode Photo//rice.jpg"));
//		}
//		catch(Exception e){
//			System.out.println(e);
//		}
//		ImageIcon WordButtonPicture1 = new ImageIcon(WordButtonPicture1Buffered);
//		
//		try{
//			WordButtonPicture2Buffered = ImageIO.read(new File(
//				"resource/Training Mode Photo//toy.jpg"));
//		}
//		catch(Exception e){
//			System.out.println(e);
//		}
//		ImageIcon WordButtonPicture2 = new ImageIcon(WordButtonPicture2Buffered);
		
		try{
			WordButtonBackBuffered = ImageIO.read(new File(
				"resource/TrainingModeInterface//Word Button back3.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon WordButtonBack = new ImageIcon(WordButtonBackBuffered);
		
		
		TrainingModeInterface1ClassBG
				.setImage(TrainingModeInterface1ClassBG.getImage().getScaledInstance(600, 800, Image.SCALE_DEFAULT));
		WordButtonPicture1.setImage(WordButtonPicture1.getImage().getScaledInstance(300, 180, Image.SCALE_DEFAULT));
		WordButtonPicture2.setImage(WordButtonPicture2.getImage().getScaledInstance(300, 180, Image.SCALE_DEFAULT));
		WordButtonBack.setImage(WordButtonBack.getImage().getScaledInstance(120, 40, Image.SCALE_DEFAULT));

		// ����Lbl
		TrainingModeInterface2ClassLbl.setBounds(0, 0, 600, 800); // TrainingModeInterface1ClassLblλ��Ϊ0��0
																	// ��СΪ 600 ��
																	// 800
		TrainingModeInterface2ClassLbl.setIcon(TrainingModeInterface1ClassBG); // TrainingModeInterface1ClassLbl����ͼƬTrainingModeInterface1ClassBG

		picture1Btn.setBounds(150, 130, 300, 180); // picture1Btnλ��Ϊ150��130 ��СΪ
													// 300 �� 180
		picture1Btn.setIcon(WordButtonPicture1); // picture1Btn����ͼƬWordButtonPicture1
		picture1Btn.addMouseListener(this); // ����picture1Btn�ļ���

		picture2Btn.setBounds(150, 330, 300, 180); // picture2Btnλ��Ϊ150��330 ��СΪ
													// 300 �� 180
		picture2Btn.setIcon(WordButtonPicture2); // picture2Btn����ͼƬWordButtonPicture2
		picture2Btn.addMouseListener(this); // ����picture2Btn�ļ���

		backBtn.setBounds(235, 530, 120, 40); // backBtnλ��Ϊ235��530 ��СΪ 120 �� 40
		backBtn.setIcon(WordButtonBack); // backBtn����ͼƬWordButtonBack
		backBtn.addMouseListener(this); // ����backBtn�ļ���

		word1.setBounds(480, 180, 100, 100);
		word2.setBounds(480, 400, 100, 100);
		
		word1.setFont(new Font("Comic Sans MC",Font.PLAIN,24));
		word2.setFont(new Font("Comic Sans MC",Font.PLAIN,24));
		
		word1.setText(("<html>I <br>want to<br> eat!</html>"));
		word2.setText(("<html>I <br>want to<br> play!</html>"));
		// ���lbl
		TrainingModeInterface2ClassLbl.add(picture1Btn); // ��picture1Btn�����TrainingModeInterface1ClassLbl��
		TrainingModeInterface2ClassLbl.add(picture2Btn); // ��picture2Btn�����TrainingModeInterface1ClassLbl��
		TrainingModeInterface2ClassLbl.add(backBtn); // ��backBtn�����TrainingModeInterface1ClassLbl��
		TrainingModeInterface2ClassLbl.add(word1);
		TrainingModeInterface2ClassLbl.add(word2);
		
		TrainingModeInterface2Frame.add(TrainingModeInterface2ClassLbl); // ��TrainingModeInterface1ClassLbl�����TrainingModeInterface1Frame��
		TrainingModeInterface2Frame.setVisible(true); // ����TrainingModeInterface1FrameΪ�ɷ��ʵ�
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // ����temporary��ǩ

		if (Lbl == picture1Btn) {
			sound.main(null);
			new Response();
			
		} else if (Lbl == picture2Btn) {
			sound.main(null);
			new Response();
			
		} else if (Lbl == backBtn) {
			new TrainingModeClass(client); // ���backBtn����ת��TrainingModeClass�Ĵ���
			TrainingModeInterface2Frame.dispose(); // �رյ�ǰ����
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
