package client.gui;

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
public class TrainingModeInterface1Class implements MouseListener {
	
	Client client;
	
	JFrame TrainingModeInterface1Frame = new JFrame("TrainingModeInterface1Class");

	// ����ͼƬ
	BufferedImage TrainingModeInterface1ClassBGBuffered;
	ImageIcon WordButtonPicture1 = new ImageIcon(SettingClass.path);
	ImageIcon WordButtonPicture2 = new ImageIcon(SettingClass.path2);
	BufferedImage WordButtonBackBuffered;

	// ����Label
	JLabel TrainingModeInterface1ClassLbl = new JLabel();
	JLabel picture1Btn = new JLabel();
	JLabel picture2Btn = new JLabel();
	JLabel backBtn = new JLabel();

	TrainingModeInterface1Class(Client client) {
		
		this.client = client;

		// ����Frame
		TrainingModeInterface1Frame.setSize(600, 850); // ���ô�СΪ 600 �� 850
		TrainingModeInterface1Frame.setResizable(false); // ʹ���ڴ�С�޷��ı�
		TrainingModeInterface1Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����Ĭ�Ϲرղ���

		// ����ͼƬ
		try{
			TrainingModeInterface1ClassBGBuffered = ImageIO.read(new File(
				"resource/TrainingModeInterface//Training Mode Interface1.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon TrainingModeInterface1ClassBG = new ImageIcon(TrainingModeInterface1ClassBGBuffered);
		
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
		TrainingModeInterface1ClassLbl.setBounds(0, 0, 600, 800); // TrainingModeInterface1ClassLblλ��Ϊ0��0
																	// ��СΪ 600 ��
																	// 800
		TrainingModeInterface1ClassLbl.setIcon(TrainingModeInterface1ClassBG); // TrainingModeInterface1ClassLbl����ͼƬTrainingModeInterface1ClassBG

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

		// ���lbl
		TrainingModeInterface1ClassLbl.add(picture1Btn); // ��picture1Btn�����TrainingModeInterface1ClassLbl��
		TrainingModeInterface1ClassLbl.add(picture2Btn); // ��picture2Btn�����TrainingModeInterface1ClassLbl��
		TrainingModeInterface1ClassLbl.add(backBtn); // ��backBtn�����TrainingModeInterface1ClassLbl��

		TrainingModeInterface1Frame.add(TrainingModeInterface1ClassLbl); // ��TrainingModeInterface1ClassLbl�����TrainingModeInterface1Frame��
		TrainingModeInterface1Frame.setVisible(true); // ����TrainingModeInterface1FrameΪ�ɷ��ʵ�
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // ����temporary��ǩ

		if (Lbl == picture1Btn) {
			sound.main(null);
//			new Response();
			
		} else if (Lbl == picture2Btn) {
			sound2.main(null);
			new Response();
			
		} else if (Lbl == backBtn) {
			new TrainingModeClass(client); // ���backBtn����ת��TrainingModeClass�Ĵ���
			TrainingModeInterface1Frame.dispose(); // �رյ�ǰ����
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
