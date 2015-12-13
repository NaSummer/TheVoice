package client.gui;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import client.transmission.Client;

/*
 * ģʽѡ�񣬡���
 * @Author Xu Wenbo(Charles), Zheng Haoewn(Albert), Jin XinBin(Allen), Xu Qiufan, Hu Suihao
 * @Date
 */
public class TrainingModeClass implements MouseListener {
	
	Client client;
	
	JFrame TrainingModeFrame = new JFrame("Training Mode");

	// ����ͼƬ
	BufferedImage TraingingModeBGBuffered;
	BufferedImage WordButton1Buffered;
	BufferedImage WordButton2Buffered;
	BufferedImage WordButton3Buffered;
	BufferedImage WordButton4Buffered;
	BufferedImage WordButton5Buffered;
	BufferedImage WordButtonIndexBuffered;
	BufferedImage WordButtonSettingBuffered;
	
	// ����Label
	JLabel TrainingModeLbl = new JLabel();
	JLabel WordButton1Lbl = new JLabel();
	JLabel WordButton2Lbl = new JLabel();
	JLabel WordButton3Lbl = new JLabel();
	JLabel WordButton4Lbl = new JLabel();
	JLabel WordButton5Lbl = new JLabel();
	JLabel settingBtn = new JLabel();
	JLabel indexBtn = new JLabel();

	TrainingModeClass(Client client) {
		
		this.client = client;
		
		// ����Frame
		TrainingModeFrame.setSize(600, 850); // ���ô�СΪ 600 �� 850
		TrainingModeFrame.setResizable(false); // ʹ���ڴ�С�޷��ı�
		TrainingModeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����Ĭ�Ϲرղ���

		// ����ͼƬ
		try{
			TraingingModeBGBuffered = ImageIO.read(new File(
				"resource/TrainingMode//Training Mode.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon TrainingModeBG = new ImageIcon(TraingingModeBGBuffered);
		
		try{
			WordButton1Buffered = ImageIO.read(new File(
				"resource/TrainingMode//Word Button 1.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon WordButton1 = new ImageIcon(WordButton1Buffered);
		
		try{
			WordButton2Buffered = ImageIO.read(new File(
				"resource/TrainingMode//Word Button 2.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon WordButton2 = new ImageIcon(WordButton2Buffered);
		
		try{
			WordButton3Buffered = ImageIO.read(new File(
				"resource/TrainingMode//Word Button 3.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon WordButton3 = new ImageIcon(WordButton3Buffered);
		
		try{
			WordButton4Buffered = ImageIO.read(new File(
				"resource/TrainingMode//Word Button 4.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon WordButton4 = new ImageIcon(WordButton4Buffered);
		
		try{
			WordButton5Buffered = ImageIO.read(new File(
				"resource/TrainingMode//Word Button 5.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon WordButton5 = new ImageIcon(WordButton5Buffered);
		
		try{
			WordButtonIndexBuffered = ImageIO.read(new File(
				"resource/TrainingMode//Word Button Index.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon WordButtonIndex= new ImageIcon(WordButtonIndexBuffered);
		
		try{
			WordButtonSettingBuffered = ImageIO.read(new File(
				"resource/TrainingMode//Word Button Setting.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon WordButtonSetting = new ImageIcon(WordButtonSettingBuffered);
		
		TrainingModeBG.setImage(TrainingModeBG.getImage().getScaledInstance(600, 800, Image.SCALE_DEFAULT));
		WordButton1.setImage(WordButton1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		WordButton2.setImage(WordButton2.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		WordButton3.setImage(WordButton3.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		WordButton4.setImage(WordButton4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		WordButton5.setImage(WordButton5.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		WordButtonSetting.setImage(WordButtonSetting.getImage().getScaledInstance(250, 40, Image.SCALE_DEFAULT));
		WordButtonIndex.setImage(WordButtonIndex.getImage().getScaledInstance(90, 30, Image.SCALE_DEFAULT));
		

		// ����Lbl
		TrainingModeLbl.setBounds(0, 0, 600, 800); // TrainingModeLblλ��Ϊ0��0 ��СΪ
													// 600 �� 800
		TrainingModeLbl.setIcon(TrainingModeBG); // TrainingModeLbl����ͼƬTraingingModeBG

		settingBtn.setBounds(175, 200, 250, 40); // settingBtnλ��Ϊ175��200 ��СΪ 250
													// �� 40
		settingBtn.setIcon(WordButtonSetting); // settingBtn����ͼƬWordButtonSetting
		settingBtn.addMouseListener(this); // ����settingBtn�ļ���

		indexBtn.setBounds(385, 70, 90, 30); // indexBtnλ��Ϊ385�� 70 ��СΪ 90 �� 30
		indexBtn.setIcon(WordButtonIndex); // indexBtn����ͼƬWordButtonIndex
		indexBtn.addMouseListener(this); // ����indexBtn�ļ���

		WordButton1Lbl.setBounds(150, 270, 60, 60); // WordButton1Lblλ��Ϊ150�� 270
													// ��СΪ 60 �� 60
		WordButton1Lbl.setIcon(WordButton1); // WordButton1Lbl����ͼƬWordButton1
		WordButton1Lbl.addMouseListener(this); // ����WordButton1Lbl�ļ���

		WordButton3Lbl.setBounds(270, 270, 60, 60); // WordButton3Lblλ��Ϊ270�� 270
													// ��СΪ 60 �� 60
		WordButton3Lbl.setIcon(WordButton3); // WordButton3Lbl����ͼƬWordButton3
		WordButton3Lbl.addMouseListener(this); // ����WordButton3Lbl�ļ���

		WordButton5Lbl.setBounds(390, 270, 60, 60); // WordButton5Lblλ��Ϊ390�� 270
													// ��СΪ 60 �� 60
		WordButton5Lbl.setIcon(WordButton5); // WordButton5Lbl����ͼƬWordButton5
		WordButton5Lbl.addMouseListener(this); // ����WordButton5Lbl�ļ���

		WordButton2Lbl.setBounds(210, 360, 60, 60); // WordButton2Lblλ��Ϊ210�� 360
													// ��СΪ 60 �� 60
		WordButton2Lbl.setIcon(WordButton2); // WordButton2Lbl����ͼƬWordButton2
		WordButton2Lbl.addMouseListener(this); // ����WordButton2Lbl�ļ���

		WordButton4Lbl.setBounds(330, 360, 60, 60); // WordButton4Lblλ��Ϊ330�� 360
													// ��СΪ 60 �� 60
		WordButton4Lbl.setIcon(WordButton4); // WordButton4Lbl����ͼƬWordButton4
		WordButton4Lbl.addMouseListener(this); // ����WordButton4Lbl�ļ���

		// ���lbl
		TrainingModeLbl.add(settingBtn); // ��settingBtn�����TrainingModeLbl��
		TrainingModeLbl.add(indexBtn); // ��indexBtn�����TrainingModeLbl��
		TrainingModeLbl.add(WordButton1Lbl); // ��WordButton1Lbl�����TrainingModeLbl��
		TrainingModeLbl.add(WordButton3Lbl); // ��WordButton3Lbl�����TrainingModeLbl��
		TrainingModeLbl.add(WordButton5Lbl); // ��WordButton5Lbl�����TrainingModeLbl��
		TrainingModeLbl.add(WordButton2Lbl); // ��WordButton2Lbl�����TrainingModeLbl��
		TrainingModeLbl.add(WordButton4Lbl); // ��WordButton4Lbl�����TrainingModeLbl��

		TrainingModeFrame.add(TrainingModeLbl); // ��TrainingModeLbl�����TrainingModeFrame��
		TrainingModeFrame.setVisible(true); // ����TrainingModeFrameΪ�ɷ��ʵ�
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // ����temporary��ǩ

		if (Lbl == indexBtn) {
			new Inception(); // ���indexBtn����ת��Inception�Ĵ���
			TrainingModeFrame.dispose(); // �رյ�ǰ����
		} else if (Lbl == settingBtn) {
			new SettingClass(client); // ���settingBtn����ת��SettingClass�Ĵ���
			TrainingModeFrame.dispose(); // �رյ�ǰ����
		} else if (Lbl == WordButton1Lbl) {
			new TrainingModeInterface1Class(client); // ���WordButton1Lbl����ת��TrainingModeInterface1Class�Ĵ���
			TrainingModeFrame.dispose(); // �رյ�ǰ����
		} else if (Lbl == WordButton2Lbl) {
			new TrainingModeInterface2Class(client); // ���WordButton1Lbl����ת��TrainingModeInterface1Class�Ĵ���
			TrainingModeFrame.dispose(); // �رյ�ǰ����
		} else if (Lbl == WordButton3Lbl) {
			new TrainingModeInterface3Class(client); // ���WordButton1Lbl����ת��TrainingModeInterface1Class�Ĵ���
			TrainingModeFrame.dispose(); // �رյ�ǰ����
		} else if (Lbl == WordButton4Lbl) {
			new TrainingModeInterface4Class(client); // ���WordButton1Lbl����ת��TrainingModeInterface1Class�Ĵ���
			TrainingModeFrame.dispose(); // �رյ�ǰ����
		} else if (Lbl == WordButton5Lbl) {
			new TrainingModeInterface5Class(client); // ���WordButton1Lbl����ת��TrainingModeInterface1Class�Ĵ���
			TrainingModeFrame.dispose(); // �رյ�ǰ����
		} else {

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
		JLabel Lbl = (JLabel) e.getSource(); // ����temporary��ǩ

		// ����ƶ���5����ť�ϵ�����һ��ʱ
		if (Lbl == WordButton1Lbl || Lbl == WordButton2Lbl || Lbl == WordButton3Lbl || Lbl == WordButton4Lbl
				|| Lbl == WordButton5Lbl) {
			Lbl.setLocation(Lbl.getX(), Lbl.getY() + 10); // ��ť�����ƶ�10
		} else {

		}
	}// end mouseEntered

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // ����temporary��ǩ

		// ����5����ť�ϵ�����һ��ʱ
		if (Lbl == WordButton1Lbl || Lbl == WordButton2Lbl || Lbl == WordButton3Lbl || Lbl == WordButton4Lbl
				|| Lbl == WordButton5Lbl) {
			Lbl.setLocation(Lbl.getX(), Lbl.getY() - 10); // ��ť�����ƶ�10���ָ�ԭ״��
		} else {

		}
	}// end mouseExited
}
