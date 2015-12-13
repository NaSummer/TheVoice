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
 * 模式界面1，。。
 * @Author Xu Wenbo(Charles), Zheng Haoewn(Albert), Jin XinBin(Allen), Xu Qiufan, Hu Suihao
 * @Date
 */
public class TrainingModeInterface1Class implements MouseListener {
	
	Client client;
	
	JFrame TrainingModeInterface1Frame = new JFrame("TrainingModeInterface1Class");

	// 加载图片
	BufferedImage TrainingModeInterface1ClassBGBuffered;
	ImageIcon WordButtonPicture1 = new ImageIcon(SettingClass.path);
	ImageIcon WordButtonPicture2 = new ImageIcon(SettingClass.path2);
	BufferedImage WordButtonBackBuffered;

	// 创建Label
	JLabel TrainingModeInterface1ClassLbl = new JLabel();
	JLabel picture1Btn = new JLabel();
	JLabel picture2Btn = new JLabel();
	JLabel backBtn = new JLabel();

	TrainingModeInterface1Class(Client client) {
		
		this.client = client;

		// 设置Frame
		TrainingModeInterface1Frame.setSize(600, 850); // 设置大小为 600 × 850
		TrainingModeInterface1Frame.setResizable(false); // 使窗口大小无法改变
		TrainingModeInterface1Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置默认关闭操作

		// 设置图片
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

		// 设置Lbl
		TrainingModeInterface1ClassLbl.setBounds(0, 0, 600, 800); // TrainingModeInterface1ClassLbl位置为0，0
																	// 大小为 600 ×
																	// 800
		TrainingModeInterface1ClassLbl.setIcon(TrainingModeInterface1ClassBG); // TrainingModeInterface1ClassLbl载入图片TrainingModeInterface1ClassBG

		picture1Btn.setBounds(150, 130, 300, 180); // picture1Btn位置为150，130 大小为
													// 300 × 180
		picture1Btn.setIcon(WordButtonPicture1); // picture1Btn载入图片WordButtonPicture1
		picture1Btn.addMouseListener(this); // 设置picture1Btn的监听

		picture2Btn.setBounds(150, 330, 300, 180); // picture2Btn位置为150，330 大小为
													// 300 × 180
		picture2Btn.setIcon(WordButtonPicture2); // picture2Btn载入图片WordButtonPicture2
		picture2Btn.addMouseListener(this); // 设置picture2Btn的监听

		backBtn.setBounds(235, 530, 120, 40); // backBtn位置为235，530 大小为 120 × 40
		backBtn.setIcon(WordButtonBack); // backBtn载入图片WordButtonBack
		backBtn.addMouseListener(this); // 设置backBtn的监听

		// 添加lbl
		TrainingModeInterface1ClassLbl.add(picture1Btn); // 将picture1Btn添加至TrainingModeInterface1ClassLbl上
		TrainingModeInterface1ClassLbl.add(picture2Btn); // 将picture2Btn添加至TrainingModeInterface1ClassLbl上
		TrainingModeInterface1ClassLbl.add(backBtn); // 将backBtn添加至TrainingModeInterface1ClassLbl上

		TrainingModeInterface1Frame.add(TrainingModeInterface1ClassLbl); // 将TrainingModeInterface1ClassLbl添加至TrainingModeInterface1Frame中
		TrainingModeInterface1Frame.setVisible(true); // 设置TrainingModeInterface1Frame为可访问的
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // 创建temporary标签

		if (Lbl == picture1Btn) {
			sound.main(null);
//			new Response();
			
		} else if (Lbl == picture2Btn) {
			sound2.main(null);
			new Response();
			
		} else if (Lbl == backBtn) {
			new TrainingModeClass(client); // 点击backBtn后跳转至TrainingModeClass的窗口
			TrainingModeInterface1Frame.dispose(); // 关闭当前窗口
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
