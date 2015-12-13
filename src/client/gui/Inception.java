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
 * 初始界面，。。
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
	

	// 创建Label
	JLabel LogoLbl = new JLabel();
	JLabel signUpBtn = new JLabel();
	JLabel signInBtn = new JLabel();
	JLabel trainingModeBtn = new JLabel();

	Inception() {	
		// 设置Frame
		inceptionFrame.setSize(600, 850); // 设置大小为 600 × 850
		inceptionFrame.setResizable(false); // 使窗口大小无法改变
		inceptionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置默认关闭操作

		// 设置图片
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

		// 设置Lbl
		LogoLbl.setBounds(0, 0, 600, 800); // LogoLbl位置为 0，0 大小为 600 × 800
		LogoLbl.setIcon(Logo); // LogoLbl载入图片Logo

		signUpBtn.setBounds(350, 30, 90, 30); // signUpBtn位置为 350， 30 大小为 90 ×
												// 30
		signUpBtn.setIcon(signUp); // signUpBtn载入图片signUp
		signUpBtn.addMouseListener(this); // 设置signUpBtn的监听

		signInBtn.setBounds(450, 30, 90, 30); // signInBtn位置为 450， 30 大小为 90 ×
												// 30
		signInBtn.setIcon(signIn); // signInBtn载入图片signIn
		signInBtn.addMouseListener(this); // 设置signInBtn的监听

		trainingModeBtn.setBounds(385, 70, 120, 40); // trainingModeBtn位置为 385，
														// 70 大小为 120 × 40
		trainingModeBtn.setIcon(trainingMode); // trainingModeBtn载入图片trainingMode
		trainingModeBtn.addMouseListener(this); // 设置trainingModeBtn的监听

		// 添加lbl
		LogoLbl.add(signInBtn); // 将 signInBtn添加至 LogoLbl上
		LogoLbl.add(signUpBtn); // 将 signUpBtn添加至 LogoLbl上
		LogoLbl.add(trainingModeBtn); // 将 trainingModeBtn 添加至 LogoLbl上

		inceptionFrame.add(LogoLbl); // 将 LogoLbl添加至 inceptionFrame中
		inceptionFrame.setVisible(true); // 设置inceptionFrame为可访问的
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // 创建temporary标签

		if (Lbl == signInBtn) {
			new SignInClass(client); // 点击 signInBtn后跳转至 SignInClass的窗口		
			inceptionFrame.dispose(); // 关闭当前窗口
		} else if (Lbl == signUpBtn) {
			new SignUpClass(client); // 点击 signUpBtn后跳转至 SignUpClass的窗口
			inceptionFrame.dispose(); // 关闭当前窗口
		} else if (Lbl == trainingModeBtn) {
			new TrainingModeClass(client); // 点击 trainingModeBtn后跳转至
										// TrainingModeClass的窗口
			inceptionFrame.dispose(); // 关闭当前窗口
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
