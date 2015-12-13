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
 * ��½������
 * @Author Xu Wenbo(Charles), Zheng Haoewn(Albert), Jin XinBin(Allen), Xu Qiufan, Hu Suihao
 * @Date
 */

public class SignInClass implements MouseListener {
	
	Client client;
	
	JFrame SignInFrame = new JFrame("Sign In");

	// ����ͼƬ
	BufferedImage SignInBGBuffered;
	BufferedImage WordButtonEnter2Buffered;
	BufferedImage WordButtonSignUp2Buffered;
	BufferedImage WordButtonTrainingModeBuffered;

	// ����Label
	JLabel SignInLbl = new JLabel();
	JLabel Enter2Btn = new JLabel();
	JLabel SignUp2Btn = new JLabel();
	JLabel trainingModeBtn = new JLabel();

	// ����TextField��PasswordField
	JTextField account = new JTextField();
	JPasswordField password = new JPasswordField();

	SignInClass(Client client) {
		
		this.client = client;
		
		// ����Frame
		SignInFrame.setSize(600, 850); // ���ô�СΪ 600 �� 850
		SignInFrame.setResizable(false); // ʹ���ڴ�С�޷��ı�
		SignInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����Ĭ�Ϲرղ���

		// ����ͼƬ
		try {
			SignInBGBuffered = ImageIO.read(new File(
					"resource/SignIn//Sign In.jpg"));
		} catch (Exception e) {
			System.out.println(e);
		}
		ImageIcon SignInBG = new ImageIcon(SignInBGBuffered);

		try {
			WordButtonEnter2Buffered = ImageIO.read(new File(
					"resource/SignIn//Word Button enter2.jpg"));
		} catch (Exception e) {
			System.out.println(e);
		}
		ImageIcon WordButtonEnter2 = new ImageIcon(WordButtonEnter2Buffered);

		try {
			WordButtonSignUp2Buffered = ImageIO.read(new File(
					"resource/SignIn//Word Button Sign Up2.jpg"));
		} catch (Exception e) {
			System.out.println(e);
		}
		ImageIcon WordButtonSignUp2 = new ImageIcon(WordButtonSignUp2Buffered);

		try {
			WordButtonTrainingModeBuffered = ImageIO.read(new File(
					"resource/SignIn//Word Button TrainingMode.jpg"));
		} catch (Exception e) {
			System.out.println(e);
		}
		ImageIcon WordButtonTrainingMode = new ImageIcon(
				WordButtonTrainingModeBuffered);

		SignInBG.setImage(SignInBG.getImage().getScaledInstance(600, 800,
				Image.SCALE_DEFAULT));
		WordButtonEnter2.setImage(WordButtonEnter2.getImage()
				.getScaledInstance(90, 30, Image.SCALE_DEFAULT));
		WordButtonSignUp2.setImage(WordButtonSignUp2.getImage()
				.getScaledInstance(90, 30, Image.SCALE_DEFAULT));
		WordButtonTrainingMode.setImage(WordButtonTrainingMode.getImage()
				.getScaledInstance(120, 40, Image.SCALE_DEFAULT));

		// ����Lbl��Btn��TestField
		SignInLbl.setBounds(0, 0, 600, 800); // SignInLblλ��Ϊ0��0 ��СΪ 600 �� 800
		SignInLbl.setIcon(SignInBG); // SignInLbl����ͼƬSignInBG

		Enter2Btn.setBounds(175, 400, 90, 30); // Enter2Btnλ��Ϊ175�� 400 ��СΪ 90 ��
												// 30
		Enter2Btn.setIcon(WordButtonEnter2); // Enter2Btn����ͼƬWordButtonEnter2
		Enter2Btn.addMouseListener(this); // ����Enter2Btn�ļ���

		SignUp2Btn.setBounds(345, 400, 90, 30); // SignUp2Btnλ��Ϊ345�� 400 ��СΪ 90
												// �� 30
		SignUp2Btn.setIcon(WordButtonSignUp2); // SignUp2Btn����ͼƬWordButtonSignUp2
		SignUp2Btn.addMouseListener(this); // ����SignUp2Btn�ļ���

		trainingModeBtn.setBounds(385, 70, 120, 40); // trainingModeBtnλ��Ϊ385��
														// 70 ��СΪ 120 �� 40
		trainingModeBtn.setIcon(WordButtonTrainingMode); // trainingModeBtn����ͼƬWordButtonTrainingMode
		trainingModeBtn.addMouseListener(this); // ����trainingModeBtn�ļ���

		account.setBounds(203, 260, 250, 30); // accountλ��Ϊ203�� 260 ��СΪ 250 �� 30
		password.setBounds(203, 345, 250, 30); // passwordλ��Ϊ203�� 345 ��СΪ 250 ��
												// 30

		// ���lbl��Btn��TestField
		SignInLbl.add(Enter2Btn); // ��Enter2Btn�����SignInLbl��
		SignInLbl.add(SignUp2Btn); // ��SignUp2Btn�����SignInLbl��
		SignInLbl.add(trainingModeBtn); // ��trainingModeBtn�����SignInLbl��
		SignInLbl.add(account); // ��account�����SignInLbl��
		SignInLbl.add(password); // ��password�����SignInLbl��

		SignInFrame.add(SignInLbl); // ��SignInLbl�����SignInFrame��
		SignInFrame.setVisible(true); // ����SignInFrameΪ�ɷ��ʵ�
	}

	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // ����temporary��ǩ

		if (Lbl == Enter2Btn) {
			if (client.signIn(account.getText(), password.getText())) {
				new DisscusGroundClass(client); // ���Enter2Btn����ת��DisscusGroundClass�Ĵ���
//				new TrainingModeClass(client);
				SignInFrame.dispose(); // �رյ�ǰ����
			} else{
				JOptionPane.showMessageDialog(null,"the account or password may be wrong!","Error",JOptionPane.ERROR_MESSAGE);
			}
		} else if (Lbl == SignUp2Btn) {
			new SignUpClass(client); // ���SignUp2Btn����ת��SignUpClass�Ĵ���
			SignInFrame.dispose(); // �رյ�ǰ����
		} else if (Lbl == trainingModeBtn) {
			new TrainingModeClass(client); // ���trainingModeBtn����ת��TrainingModeClass�Ĵ���
			SignInFrame.dispose(); // �رյ�ǰ����
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
