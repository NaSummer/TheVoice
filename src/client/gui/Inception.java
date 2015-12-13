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
 * ��ʼ���棬����
 * @Author Xu Wenbo(Charles), Zheng Haoewn(Albert), Jin XinBin(Allen), Xu Qiufan, Hu Suihao
 * @Date 
 */

public class Inception implements MouseListener {
	
	Client client = new Client();
	
	JFrame inceptionFrame = new JFrame("The Vioce");
	BufferedImage LogoBuffered;
	BufferedImage signInBuffered;
	BufferedImage signUpBuffered;
	BufferedImage trainingModeBuffered;
	

	// ����Label
	JLabel LogoLbl = new JLabel();
	JLabel signUpBtn = new JLabel();
	JLabel signInBtn = new JLabel();
	JLabel trainingModeBtn = new JLabel();

	Inception() {	
		// ����Frame
		inceptionFrame.setSize(600, 850); // ���ô�СΪ 600 �� 850
		inceptionFrame.setResizable(false); // ʹ���ڴ�С�޷��ı�
		inceptionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����Ĭ�Ϲرղ���

		// ����ͼƬ
		try{
			 LogoBuffered = ImageIO.read(new File(
				"resource/Index//Logo2.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon Logo = new ImageIcon(LogoBuffered);
		
		try{
			 signInBuffered = ImageIO.read(new File(
				"resource/Index//Word Button Sign In.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon signIn = new ImageIcon(signInBuffered);
		try{
			 signUpBuffered = ImageIO.read(new File(
				"resource/Index//Word Button Sign Up.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon signUp = new ImageIcon(signUpBuffered);
		try{
			trainingModeBuffered = ImageIO.read(new File(
				"resource/Index//Word Button TrainingMode.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon trainingMode = new ImageIcon(trainingModeBuffered);
		
		Logo.setImage(Logo.getImage().getScaledInstance(600, 800,
				Image.SCALE_DEFAULT));
		signUp.setImage(signUp.getImage().getScaledInstance(90, 30,
				Image.SCALE_DEFAULT));
		signIn.setImage(signIn.getImage().getScaledInstance(90, 30,
				Image.SCALE_DEFAULT));
		trainingMode.setImage(trainingMode.getImage().getScaledInstance(120,
				40, Image.SCALE_DEFAULT));

		// ����Lbl
		LogoLbl.setBounds(0, 0, 600, 800); // LogoLblλ��Ϊ 0��0 ��СΪ 600 �� 800
		LogoLbl.setIcon(Logo); // LogoLbl����ͼƬLogo

		signUpBtn.setBounds(350, 30, 90, 30); // signUpBtnλ��Ϊ 350�� 30 ��СΪ 90 ��
												// 30
		signUpBtn.setIcon(signUp); // signUpBtn����ͼƬsignUp
		signUpBtn.addMouseListener(this); // ����signUpBtn�ļ���

		signInBtn.setBounds(450, 30, 90, 30); // signInBtnλ��Ϊ 450�� 30 ��СΪ 90 ��
												// 30
		signInBtn.setIcon(signIn); // signInBtn����ͼƬsignIn
		signInBtn.addMouseListener(this); // ����signInBtn�ļ���

		trainingModeBtn.setBounds(385, 70, 120, 40); // trainingModeBtnλ��Ϊ 385��
														// 70 ��СΪ 120 �� 40
		trainingModeBtn.setIcon(trainingMode); // trainingModeBtn����ͼƬtrainingMode
		trainingModeBtn.addMouseListener(this); // ����trainingModeBtn�ļ���

		// ���lbl
		LogoLbl.add(signInBtn); // �� signInBtn����� LogoLbl��
		LogoLbl.add(signUpBtn); // �� signUpBtn����� LogoLbl��
		LogoLbl.add(trainingModeBtn); // �� trainingModeBtn ����� LogoLbl��

		inceptionFrame.add(LogoLbl); // �� LogoLbl����� inceptionFrame��
		inceptionFrame.setVisible(true); // ����inceptionFrameΪ�ɷ��ʵ�
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // ����temporary��ǩ

		if (Lbl == signInBtn) {
			new SignInClass(client); // ��� signInBtn����ת�� SignInClass�Ĵ���		
			inceptionFrame.dispose(); // �رյ�ǰ����
		} else if (Lbl == signUpBtn) {
			new SignUpClass(client); // ��� signUpBtn����ת�� SignUpClass�Ĵ���
			inceptionFrame.dispose(); // �رյ�ǰ����
		} else if (Lbl == trainingModeBtn) {
			new TrainingModeClass(client); // ��� trainingModeBtn����ת��
										// TrainingModeClass�Ĵ���
			inceptionFrame.dispose(); // �رյ�ǰ����
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
