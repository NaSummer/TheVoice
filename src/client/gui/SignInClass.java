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
 * 登陆，。。
 * @Author Xu Wenbo(Charles), Zheng Haoewn(Albert), Jin XinBin(Allen), Xu Qiufan, Hu Suihao
 * @Date
 */

public class SignInClass implements MouseListener {
	
	Client client;
	
	JFrame SignInFrame = new JFrame("Sign In");

	// 加载图片
	BufferedImage SignInBGBuffered;
	BufferedImage WordButtonEnter2Buffered;
	BufferedImage WordButtonSignUp2Buffered;
	BufferedImage WordButtonTrainingModeBuffered;

	// 创建Label
	JLabel SignInLbl = new JLabel();
	JLabel Enter2Btn = new JLabel();
	JLabel SignUp2Btn = new JLabel();
	JLabel trainingModeBtn = new JLabel();

	// 创建TextField和PasswordField
	JTextField account = new JTextField();
	JPasswordField password = new JPasswordField();

	SignInClass(Client client) {
		
		this.client = client;
		
		// 设置Frame
		SignInFrame.setSize(600, 850); // 设置大小为 600 × 850
		SignInFrame.setResizable(false); // 使窗口大小无法改变
		SignInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置默认关闭操作

		// 设置图片
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

		// 设置Lbl和Btn和TestField
		SignInLbl.setBounds(0, 0, 600, 800); // SignInLbl位置为0，0 大小为 600 × 800
		SignInLbl.setIcon(SignInBG); // SignInLbl载入图片SignInBG

		Enter2Btn.setBounds(175, 400, 90, 30); // Enter2Btn位置为175， 400 大小为 90 ×
												// 30
		Enter2Btn.setIcon(WordButtonEnter2); // Enter2Btn载入图片WordButtonEnter2
		Enter2Btn.addMouseListener(this); // 设置Enter2Btn的监听

		SignUp2Btn.setBounds(345, 400, 90, 30); // SignUp2Btn位置为345， 400 大小为 90
												// × 30
		SignUp2Btn.setIcon(WordButtonSignUp2); // SignUp2Btn载入图片WordButtonSignUp2
		SignUp2Btn.addMouseListener(this); // 设置SignUp2Btn的监听

		trainingModeBtn.setBounds(385, 70, 120, 40); // trainingModeBtn位置为385，
														// 70 大小为 120 × 40
		trainingModeBtn.setIcon(WordButtonTrainingMode); // trainingModeBtn载入图片WordButtonTrainingMode
		trainingModeBtn.addMouseListener(this); // 设置trainingModeBtn的监听

		account.setBounds(203, 260, 250, 30); // account位置为203， 260 大小为 250 × 30
		password.setBounds(203, 345, 250, 30); // password位置为203， 345 大小为 250 ×
												// 30

		// 添加lbl和Btn和TestField
		SignInLbl.add(Enter2Btn); // 将Enter2Btn添加至SignInLbl上
		SignInLbl.add(SignUp2Btn); // 将SignUp2Btn添加至SignInLbl上
		SignInLbl.add(trainingModeBtn); // 将trainingModeBtn添加至SignInLbl上
		SignInLbl.add(account); // 将account添加至SignInLbl上
		SignInLbl.add(password); // 将password添加至SignInLbl上

		SignInFrame.add(SignInLbl); // 将SignInLbl添加至SignInFrame中
		SignInFrame.setVisible(true); // 设置SignInFrame为可访问的
	}

	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // 创建temporary标签

		if (Lbl == Enter2Btn) {
			if (client.signIn(account.getText(), password.getText())) {
				new DisscusGroundClass(client); // 点击Enter2Btn后跳转至DisscusGroundClass的窗口
//				new TrainingModeClass(client);
				SignInFrame.dispose(); // 关闭当前窗口
			} else{
				JOptionPane.showMessageDialog(null,"the account or password may be wrong!","Error",JOptionPane.ERROR_MESSAGE);
			}
		} else if (Lbl == SignUp2Btn) {
			new SignUpClass(client); // 点击SignUp2Btn后跳转至SignUpClass的窗口
			SignInFrame.dispose(); // 关闭当前窗口
		} else if (Lbl == trainingModeBtn) {
			new TrainingModeClass(client); // 点击trainingModeBtn后跳转至TrainingModeClass的窗口
			SignInFrame.dispose(); // 关闭当前窗口
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
