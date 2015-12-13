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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import client.transmission.Client;

/*
 * ע�ᣬ����
 * @Author Xu Wenbo(Charles), Zheng Haoewn(Albert), Jin XinBin(Allen), Xu Qiufan, Hu Suihao
 * @Date 
 */

public class SignUpClass implements MouseListener {
	
	Client client;
	
	JFrame SignUpFrame = new JFrame("Sign Up");

	// ����ͼƬ
	BufferedImage SignUpBGBuffered;
	BufferedImage WordButtonSignIn1Buffered;
	BufferedImage WordButtonsubmit1Buffered;
	BufferedImage WordButtonTrainingMode1Buffered;

	// ����Label
	JLabel SignUpLbl = new JLabel();
	JLabel signIn1Btn = new JLabel();
	JLabel submit1Btn = new JLabel();
	JLabel trainingMode1Btn = new JLabel();

	// ����TextField��PasswordField
	JTextField account = new JTextField();
	JPasswordField password = new JPasswordField();
	JPasswordField confirm = new JPasswordField();

	SignUpClass(Client client) {
		
		this.client = client;
		
		// ����Frame
		SignUpFrame.setSize(600, 850); // ���ô�СΪ 600 �� 850
		SignUpFrame.setResizable(false); // ʹ���ڴ�С�޷��ı�
		SignUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����Ĭ�Ϲرղ���

		// ����ͼƬ
		try{
			SignUpBGBuffered = ImageIO.read(new File(
				"resource/SignUp//Sign Up.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon SignUpBG = new ImageIcon(SignUpBGBuffered);
		
		try{
			WordButtonSignIn1Buffered = ImageIO.read(new File(
				"resource/SignUp//Word Button Sign In1.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon WordButtonSignIn1 = new ImageIcon(WordButtonSignIn1Buffered);
		
		try{
			WordButtonsubmit1Buffered = ImageIO.read(new File(
				"resource/SignUp//Word Button submit1.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon WordButtonsubmit1 = new ImageIcon(WordButtonsubmit1Buffered);
		
		try{
			WordButtonTrainingMode1Buffered = ImageIO.read(new File(
				"resource/SignUp//Word Button TrainingMode1.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon WordButtonTrainingMode1 = new ImageIcon(WordButtonTrainingMode1Buffered);
		
		SignUpBG.setImage(SignUpBG.getImage().getScaledInstance(600, 800, Image.SCALE_DEFAULT));
		WordButtonSignIn1.setImage(WordButtonSignIn1.getImage().getScaledInstance(90, 30, Image.SCALE_DEFAULT));
		WordButtonsubmit1.setImage(WordButtonsubmit1.getImage().getScaledInstance(90, 30, Image.SCALE_DEFAULT));
		WordButtonTrainingMode1
				.setImage(WordButtonTrainingMode1.getImage().getScaledInstance(120, 40, Image.SCALE_DEFAULT));

		// ����Lbl��Btn��TestField
		SignUpLbl.setBounds(0, 0, 600, 800); // SignUpLblλ��Ϊ0��0 ��СΪ 600 �� 800
		SignUpLbl.setIcon(SignUpBG); // SignUpLbl����ͼƬSignUpBG

		signIn1Btn.setBounds(200, 400, 90, 30); // signIn1Btnλ��Ϊ200�� 400 ��СΪ 90
												// �� 30
		signIn1Btn.setIcon(WordButtonSignIn1); // signIn1Btn����ͼƬWordButtonSignIn1
		signIn1Btn.addMouseListener(this); // ����signIn1Btn�ļ���

		submit1Btn.setBounds(400, 400, 90, 30); // submit1Btnλ��Ϊ400�� 400 ��СΪ 90
												// �� 30
		submit1Btn.setIcon(WordButtonsubmit1); // submit1Btn����ͼƬWordButtonsubmit1
		submit1Btn.addMouseListener(this); // ����submit1Btn�ļ���

		trainingMode1Btn.setBounds(385, 70, 120, 40); // trainingMode1Btnλ��Ϊ385��
														// 70 ��СΪ 120 �� 40
		trainingMode1Btn.setIcon(WordButtonTrainingMode1); // trainingMode1Btn����ͼƬWordButtonTrainingMode1
		trainingMode1Btn.addMouseListener(this); // ����trainingMode1Btn�ļ���

		account.setBounds(200, 260, 250, 30); // accountλ��Ϊ200�� 260 ��СΪ 250 �� 30
		password.setBounds(200, 310, 250, 30); // passwordλ��Ϊ200�� 310 ��СΪ 250 ��
												// 30
		confirm.setBounds(200, 360, 250, 30); // confirmλ��Ϊ200�� 360 ��СΪ 250 �� 30

		// ���lbl��Btn��TestField
		SignUpLbl.add(signIn1Btn); // ��signIn1Btn�����SignUpLbl��
		SignUpLbl.add(submit1Btn); // ��submit1Btn�����SignUpLbl��
		SignUpLbl.add(trainingMode1Btn); // ��trainingMode1Btn�����SignUpLbl��
		SignUpLbl.add(account); // ��account�����SignUpLbl��
		SignUpLbl.add(password); // ��password�����SignUpLbl��
		SignUpLbl.add(confirm); // ��confirm�����SignUpLbl��

		SignUpFrame.add(SignUpLbl); // ��SignUpLbl�����SignUpFrame��
		SignUpFrame.setVisible(true); // ����SignUpFrameΪ�ɷ��ʵ�
	}

	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // ����temporary��ǩ

		if (Lbl == signIn1Btn) {
			new SignInClass(client); // ���signIn1Btn����ת��SignInClass�Ĵ���
			SignUpFrame.dispose(); // �رյ�ǰ����
		} else if (Lbl == trainingMode1Btn) {
			new TrainingModeClass(client); // ���trainingMode1Btn����ת��TrainingModeClass�Ĵ���
			SignUpFrame.dispose(); // �رյ�ǰ����
		} else if (Lbl == submit1Btn) {
			if(account.getText() == "")	{
				JOptionPane.showMessageDialog(null,"The account cannot be blank!","Error",JOptionPane.ERROR_MESSAGE);
			}
			else if(password.getText() == "")	{
				JOptionPane.showMessageDialog(null,"The password cannot be blank!","Error",JOptionPane.ERROR_MESSAGE);
			}
			else if(confirm.getText() == "")	{
				JOptionPane.showMessageDialog(null,"The confirm cannot be blank!","Error",JOptionPane.ERROR_MESSAGE);
			}
			else if(!password.getText().equals(confirm.getText()))	{
				JOptionPane.showMessageDialog(null,"Your password and confirm must be the same!","Error",JOptionPane.ERROR_MESSAGE);
			}
			else {
				boolean isAuth = client.signUp(account.getText(), password.getText());
				if (isAuth) {
					new DisscusGroundClass(client);
					SignUpFrame.dispose();
				} else {
					JOptionPane.showMessageDialog(null,"Sign Up failed, username may exist.","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
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
