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
 * 模式选择，。。
 * @Author Xu Wenbo(Charles), Zheng Haoewn(Albert), Jin XinBin(Allen), Xu Qiufan, Hu Suihao
 * @Date
 */
public class TrainingModeClass implements MouseListener {
	
	Client client;
	
	JFrame TrainingModeFrame = new JFrame("Training Mode");

	// 加载图片
	BufferedImage TraingingModeBGBuffered;
	BufferedImage WordButton1Buffered;
	BufferedImage WordButton2Buffered;
	BufferedImage WordButton3Buffered;
	BufferedImage WordButton4Buffered;
	BufferedImage WordButton5Buffered;
	BufferedImage WordButtonIndexBuffered;
	BufferedImage WordButtonSettingBuffered;
	
	// 创建Label
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
		
		// 设置Frame
		TrainingModeFrame.setSize(600, 850); // 设置大小为 600 × 850
		TrainingModeFrame.setResizable(false); // 使窗口大小无法改变
		TrainingModeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置默认关闭操作

		// 设置图片
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
		

		// 设置Lbl
		TrainingModeLbl.setBounds(0, 0, 600, 800); // TrainingModeLbl位置为0，0 大小为
													// 600 × 800
		TrainingModeLbl.setIcon(TrainingModeBG); // TrainingModeLbl载入图片TraingingModeBG

		settingBtn.setBounds(175, 200, 250, 40); // settingBtn位置为175，200 大小为 250
													// × 40
		settingBtn.setIcon(WordButtonSetting); // settingBtn载入图片WordButtonSetting
		settingBtn.addMouseListener(this); // 设置settingBtn的监听

		indexBtn.setBounds(385, 70, 90, 30); // indexBtn位置为385， 70 大小为 90 × 30
		indexBtn.setIcon(WordButtonIndex); // indexBtn载入图片WordButtonIndex
		indexBtn.addMouseListener(this); // 设置indexBtn的监听

		WordButton1Lbl.setBounds(150, 270, 60, 60); // WordButton1Lbl位置为150， 270
													// 大小为 60 × 60
		WordButton1Lbl.setIcon(WordButton1); // WordButton1Lbl载入图片WordButton1
		WordButton1Lbl.addMouseListener(this); // 设置WordButton1Lbl的监听

		WordButton3Lbl.setBounds(270, 270, 60, 60); // WordButton3Lbl位置为270， 270
													// 大小为 60 × 60
		WordButton3Lbl.setIcon(WordButton3); // WordButton3Lbl载入图片WordButton3
		WordButton3Lbl.addMouseListener(this); // 设置WordButton3Lbl的监听

		WordButton5Lbl.setBounds(390, 270, 60, 60); // WordButton5Lbl位置为390， 270
													// 大小为 60 × 60
		WordButton5Lbl.setIcon(WordButton5); // WordButton5Lbl载入图片WordButton5
		WordButton5Lbl.addMouseListener(this); // 设置WordButton5Lbl的监听

		WordButton2Lbl.setBounds(210, 360, 60, 60); // WordButton2Lbl位置为210， 360
													// 大小为 60 × 60
		WordButton2Lbl.setIcon(WordButton2); // WordButton2Lbl载入图片WordButton2
		WordButton2Lbl.addMouseListener(this); // 设置WordButton2Lbl的监听

		WordButton4Lbl.setBounds(330, 360, 60, 60); // WordButton4Lbl位置为330， 360
													// 大小为 60 × 60
		WordButton4Lbl.setIcon(WordButton4); // WordButton4Lbl载入图片WordButton4
		WordButton4Lbl.addMouseListener(this); // 设置WordButton4Lbl的监听

		// 添加lbl
		TrainingModeLbl.add(settingBtn); // 将settingBtn添加至TrainingModeLbl上
		TrainingModeLbl.add(indexBtn); // 将indexBtn添加至TrainingModeLbl上
		TrainingModeLbl.add(WordButton1Lbl); // 将WordButton1Lbl添加至TrainingModeLbl上
		TrainingModeLbl.add(WordButton3Lbl); // 将WordButton3Lbl添加至TrainingModeLbl上
		TrainingModeLbl.add(WordButton5Lbl); // 将WordButton5Lbl添加至TrainingModeLbl上
		TrainingModeLbl.add(WordButton2Lbl); // 将WordButton2Lbl添加至TrainingModeLbl上
		TrainingModeLbl.add(WordButton4Lbl); // 将WordButton4Lbl添加至TrainingModeLbl上

		TrainingModeFrame.add(TrainingModeLbl); // 将TrainingModeLbl添加至TrainingModeFrame中
		TrainingModeFrame.setVisible(true); // 设置TrainingModeFrame为可访问的
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // 创建temporary标签

		if (Lbl == indexBtn) {
			new Inception(); // 点击indexBtn后跳转至Inception的窗口
			TrainingModeFrame.dispose(); // 关闭当前窗口
		} else if (Lbl == settingBtn) {
			new SettingClass(client); // 点击settingBtn后跳转至SettingClass的窗口
			TrainingModeFrame.dispose(); // 关闭当前窗口
		} else if (Lbl == WordButton1Lbl) {
			new TrainingModeInterface1Class(client); // 点击WordButton1Lbl后跳转至TrainingModeInterface1Class的窗口
			TrainingModeFrame.dispose(); // 关闭当前窗口
		} else if (Lbl == WordButton2Lbl) {
			new TrainingModeInterface2Class(client); // 点击WordButton1Lbl后跳转至TrainingModeInterface1Class的窗口
			TrainingModeFrame.dispose(); // 关闭当前窗口
		} else if (Lbl == WordButton3Lbl) {
			new TrainingModeInterface3Class(client); // 点击WordButton1Lbl后跳转至TrainingModeInterface1Class的窗口
			TrainingModeFrame.dispose(); // 关闭当前窗口
		} else if (Lbl == WordButton4Lbl) {
			new TrainingModeInterface4Class(client); // 点击WordButton1Lbl后跳转至TrainingModeInterface1Class的窗口
			TrainingModeFrame.dispose(); // 关闭当前窗口
		} else if (Lbl == WordButton5Lbl) {
			new TrainingModeInterface5Class(client); // 点击WordButton1Lbl后跳转至TrainingModeInterface1Class的窗口
			TrainingModeFrame.dispose(); // 关闭当前窗口
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
		JLabel Lbl = (JLabel) e.getSource(); // 创建temporary标签

		// 鼠标移动到5个按钮上的任意一个时
		if (Lbl == WordButton1Lbl || Lbl == WordButton2Lbl || Lbl == WordButton3Lbl || Lbl == WordButton4Lbl
				|| Lbl == WordButton5Lbl) {
			Lbl.setLocation(Lbl.getX(), Lbl.getY() + 10); // 按钮向下移动10
		} else {

		}
	}// end mouseEntered

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // 创建temporary标签

		// 鼠标从5个按钮上的任意一个时
		if (Lbl == WordButton1Lbl || Lbl == WordButton2Lbl || Lbl == WordButton3Lbl || Lbl == WordButton4Lbl
				|| Lbl == WordButton5Lbl) {
			Lbl.setLocation(Lbl.getX(), Lbl.getY() - 10); // 按钮向上移动10（恢复原状）
		} else {

		}
	}// end mouseExited
}
