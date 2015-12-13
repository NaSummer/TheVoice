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
 * 注册，。。
 * @Author Xu Wenbo(Charles), Zheng Haoewn(Albert), Jin XinBin(Allen), Xu Qiufan, Hu Suihao
 * @Date 
 */

public class SignUpClass implements MouseListener {
	
	Client client;
	
	JFrame SignUpFrame = new JFrame("Sign Up");

	// 加载图片
	BufferedImage SignUpBGBuffered;
	BufferedImage WordButtonSignIn1Buffered;
	BufferedImage WordButtonsubmit1Buffered;
	BufferedImage WordButtonTrainingMode1Buffered;

	// 创建Label
	JLabel SignUpLbl = new JLabel();
	JLabel signIn1Btn = new JLabel();
	JLabel submit1Btn = new JLabel();
	JLabel trainingMode1Btn = new JLabel();

	// 创建TextField和PasswordField
	JTextField account = new JTextField();
	JPasswordField password = new JPasswordField();
	JPasswordField confirm = new JPasswordField();

	SignUpClass(Client client) {
		
		this.client = client;
		
		// 设置Frame
		SignUpFrame.setSize(600, 850); // 设置大小为 600 × 850
		SignUpFrame.setResizable(false); // 使窗口大小无法改变
		SignUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置默认关闭操作

		// 设置图片
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

		// 设置Lbl和Btn和TestField
		SignUpLbl.setBounds(0, 0, 600, 800); // SignUpLbl位置为0，0 大小为 600 × 800
		SignUpLbl.setIcon(SignUpBG); // SignUpLbl载入图片SignUpBG

		signIn1Btn.setBounds(200, 400, 90, 30); // signIn1Btn位置为200， 400 大小为 90
												// × 30
		signIn1Btn.setIcon(WordButtonSignIn1); // signIn1Btn载入图片WordButtonSignIn1
		signIn1Btn.addMouseListener(this); // 设置signIn1Btn的监听

		submit1Btn.setBounds(400, 400, 90, 30); // submit1Btn位置为400， 400 大小为 90
												// × 30
		submit1Btn.setIcon(WordButtonsubmit1); // submit1Btn载入图片WordButtonsubmit1
		submit1Btn.addMouseListener(this); // 设置submit1Btn的监听

		trainingMode1Btn.setBounds(385, 70, 120, 40); // trainingMode1Btn位置为385，
														// 70 大小为 120 × 40
		trainingMode1Btn.setIcon(WordButtonTrainingMode1); // trainingMode1Btn载入图片WordButtonTrainingMode1
		trainingMode1Btn.addMouseListener(this); // 设置trainingMode1Btn的监听

		account.setBounds(200, 260, 250, 30); // account位置为200， 260 大小为 250 × 30
		password.setBounds(200, 310, 250, 30); // password位置为200， 310 大小为 250 ×
												// 30
		confirm.setBounds(200, 360, 250, 30); // confirm位置为200， 360 大小为 250 × 30

		// 添加lbl和Btn和TestField
		SignUpLbl.add(signIn1Btn); // 将signIn1Btn添加至SignUpLbl上
		SignUpLbl.add(submit1Btn); // 将submit1Btn添加至SignUpLbl上
		SignUpLbl.add(trainingMode1Btn); // 将trainingMode1Btn添加至SignUpLbl上
		SignUpLbl.add(account); // 将account添加至SignUpLbl上
		SignUpLbl.add(password); // 将password添加至SignUpLbl上
		SignUpLbl.add(confirm); // 将confirm添加至SignUpLbl上

		SignUpFrame.add(SignUpLbl); // 将SignUpLbl添加至SignUpFrame中
		SignUpFrame.setVisible(true); // 设置SignUpFrame为可访问的
	}

	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // 创建temporary标签

		if (Lbl == signIn1Btn) {
			new SignInClass(client); // 点击signIn1Btn后跳转至SignInClass的窗口
			SignUpFrame.dispose(); // 关闭当前窗口
		} else if (Lbl == trainingMode1Btn) {
			new TrainingModeClass(client); // 点击trainingMode1Btn后跳转至TrainingModeClass的窗口
			SignUpFrame.dispose(); // 关闭当前窗口
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
