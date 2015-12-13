package client.gui;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import client.transmission.Client;

/*
 * 论坛界面，。。
 * @Author Xu Wenbo(Charles), Zheng Haoewn(Albert), Jin XinBin(Allen), Xu Qiufan, Hu Suihao
 * @Date
 */
public class DisscusGroundClass implements MouseListener {

	Client client;

	JFrame DisscusGroundFrame = new JFrame("DisscusGroundFrame");

	// 加载图片
	ImageIcon comeBackToTraining = new ImageIcon(
			DisscusGroundClass.class.getResource("resource//Come back to training.jpg"));
	ImageIcon disscusGroud = new ImageIcon(DisscusGroundClass.class.getResource("resource//Disscus Groud.jpg"));
	ImageIcon logOut = new ImageIcon(DisscusGroundClass.class.getResource("resource//Log Out.jpg"));
	ImageIcon more = new ImageIcon(DisscusGroundClass.class.getResource("resource//More.jpg"));
	ImageIcon back = new ImageIcon(DisscusGroundClass.class.getResource("resource//Word Button back.jpg"));
	ImageIcon photo1 = new ImageIcon(DisscusGroundClass.class.getResource("resource//1.jpg"));
	ImageIcon photo2 = new ImageIcon(DisscusGroundClass.class.getResource("resource//2.jpg"));
	ImageIcon photo3 = new ImageIcon(DisscusGroundClass.class.getResource("resource//3.jpg"));

	// 创建Label
	JLabel DisscusGroundBGLbl = new JLabel();
	JLabel backToTrainingLbl = new JLabel();
	JLabel LogOutLbl = new JLabel();

	JLabel More1Lbl = new JLabel();
	JLabel More2Lbl = new JLabel();
	JLabel BackLbl = new JLabel();
	JLabel articleLbl1;
	JLabel articleLbl2;
	JLabel articleLbl3;
	JLabel picOne = new JLabel();
	JLabel picTwo = new JLabel();
	JLabel picThree = new JLabel();

	// 文章名
	List<String> articlesList;

	DisscusGroundClass(Client client) {

		this.client = client;

		System.out.println(1);
		articlesList = client.getArticleList();
		System.out.println(2);

		// 设置Frame
		DisscusGroundFrame.setSize(600, 850); // 设置大小为 600 × 850
		DisscusGroundFrame.setResizable(false); // 使窗口大小无法改变
		DisscusGroundFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置默认关闭操作

		// 设置图片
		// try {
		// disscusGroudBuffered = ImageIO.read(new
		// File("resource/DisscusGround//Disscus Groud.jpg"));
		// } catch (Exception e) {
		//
		// }
		// ImageIcon disscusGroundBG = new ImageIcon(disscusGroudBuffered);
		//
		// try {
		// comeBackToTrainingBuffered = ImageIO.read(new
		// File("resource/DisscusGround//Come back to training.jpg"));
		// } catch (Exception e) {
		//
		// }
		// ImageIcon backToTraining = new ImageIcon(comeBackToTrainingBuffered);
		//
		// try {
		// logOutBuffered = ImageIO.read(new File("resource/DisscusGround//Log
		// Out.jpg"));
		// } catch (Exception e) {
		//
		// }
		// ImageIcon logOut = new ImageIcon(logOutBuffered);
		// try {
		// moreBuffered = ImageIO.read(new
		// File("resource/DisscusGround//More.jpg"));
		// } catch (Exception e) {
		//
		// }
		// ImageIcon more = new ImageIcon(moreBuffered);
		// try {
		// backBuffered = ImageIO.read(new File("resource/Setting//Word Button
		// back.jpg"));
		// } catch (Exception e) {
		//
		// }
		// ImageIcon back = new ImageIcon(backBuffered);
		//
		// try {
		// photo1Buffered = ImageIO.read(new File("resource/Painting//1.jpg"));
		// } catch (Exception e) {
		//
		// }
		// ImageIcon photo1 = new ImageIcon(photo1Buffered);
		//
		// try {
		// photo2Buffered = ImageIO.read(new File("resource/Painting//2.jpg"));
		// } catch (Exception e) {
		//
		// }
		// ImageIcon photo2 = new ImageIcon(photo2Buffered);
		//
		// try {
		// photo3Buffered = ImageIO.read(new File("resource/Painting//3.jpg"));
		// } catch (Exception e) {
		//
		// }
		// ImageIcon photo3 = new ImageIcon(photo3Buffered);

		// disscusGroud.setImage(disscusGroud.getImage().getScaledInstance(600,
		// 800, Image.SCALE_DEFAULT));
		comeBackToTraining.setImage(comeBackToTraining.getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
		// logOut.setImage(logOut.getImage().getScaledInstance(60, 20,
		// Image.SCALE_DEFAULT));
		// more.setImage(more.getImage().getScaledInstance(90, 30,
		// Image.SCALE_DEFAULT));
		// back.setImage(back.getImage().getScaledInstance(90, 30,
		// Image.SCALE_DEFAULT));

		// 设置Lbl
		DisscusGroundBGLbl.setBounds(0, 0, 600, 800); // DisscusGroundBGLbl位置为0，0
														// 大小为 600 × 800
		DisscusGroundBGLbl.setIcon(disscusGroud); // DisscusGroundBGLbl载入图片DisscusGroundBG

		backToTrainingLbl.setBounds(360, 123, 150, 50); // backToTrainingLbl位置为360，123
														// 大小为 150 × 50
		backToTrainingLbl.setIcon(comeBackToTraining); // backToTrainingLbl载入图片backToTraining
		backToTrainingLbl.addMouseListener(this); // 设置backToTrainingLbl的监听

		LogOutLbl.setBounds(250, 140, 60, 20); // LogOutLbl位置为250，140 大小为 60 ×
												// 20
		LogOutLbl.setIcon(logOut); // LogOutLbl载入图片LogOut
		LogOutLbl.addMouseListener(this); // 设置LogOutLbl的监听

		More1Lbl.setBounds(380, 330, 90, 30); // More1Lbl位置为380，330 大小为 90 × 30
		More1Lbl.setIcon(more); // More1Lbl载入图片More
		More1Lbl.addMouseListener(this); // 设置More1Lbl的监听

		More2Lbl.setBounds(380, 540, 90, 30); // More2Lbl位置为380，540 大小为 90 × 30
		More2Lbl.setIcon(more); // More2Lbl载入图片More
		More2Lbl.addMouseListener(this); // 设置More2Lbl的监听

		BackLbl.setBounds(30, 30, 120, 40); // BackLbl位置为30，30 大小为 120 × 40
		BackLbl.setIcon(back); // BackLbl载入图片Back
		BackLbl.addMouseListener(this); // 设置BackLbl的监听
		System.out.println(3);

		// articleLbl1 = new JLabel(articlesList.get(0));//得到第1篇文章标题
		// articleLbl2 = new JLabel(articlesList.get(1));//得到第2篇文章标题
		// articleLbl3 = new JLabel(articlesList.get(2));//得到第3篇文章标题

		int articleListSize = articlesList.size();
		System.out.println(4);
		switch (articleListSize) {
		case 0:
			articleLbl1 = new JLabel();// 得到第1篇文章标题
			articleLbl2 = new JLabel();// 得到第2篇文章标题
			articleLbl3 = new JLabel();// 得到第3篇文章标题
			break;
		case 1:
			articleLbl1 = new JLabel(articlesList.get(0));// 得到第1篇文章标题
			articleLbl2 = new JLabel();// 得到第2篇文章标题
			articleLbl3 = new JLabel();// 得到第3篇文章标题
			break;
		case 2:
			articleLbl1 = new JLabel(articlesList.get(0));// 得到第1篇文章标题
			articleLbl2 = new JLabel(articlesList.get(1));// 得到第2篇文章标题
			articleLbl3 = new JLabel();// 得到第3篇文章标题
			break;
		default:
			articleLbl1 = new JLabel(articlesList.get(0));// 得到第1篇文章标题
			articleLbl2 = new JLabel(articlesList.get(1));// 得到第2篇文章标题
			articleLbl3 = new JLabel(articlesList.get(2));// 得到第3篇文章标题
			break;
		}
		System.out.println(5);
		articleLbl1.setBounds(190, 215, 250, 30); // articleLbl1位置为170，215 大小为
													// 250 × 30
		articleLbl1.addMouseListener(this); // 设置articleLbl的监听

		articleLbl2.setBounds(190, 250, 250, 30); // articleLbl2位置为170，250 大小为
													// 250 × 30
		articleLbl2.addMouseListener(this); // 设置articleLbl2的监听

		articleLbl3.setBounds(190, 283, 250, 30); // articleLbl3位置为170，283大小为
													// 250 × 30
		articleLbl3.addMouseListener(this); // 设置articleLbl3的监听

		picOne.setBounds(100, 400, 100, 100);
		picOne.setIcon(photo1);
		picTwo.setBounds(210, 400, 100, 100);
		picTwo.setIcon(photo2);
		picThree.setBounds(320, 400, 100, 100);
		picThree.setIcon(photo3);
		System.out.println(6);
		// 添加lbl
		DisscusGroundBGLbl.add(backToTrainingLbl); // 将backToTrainingLbl添加至DisscusGroundBGLbl上
		DisscusGroundBGLbl.add(LogOutLbl); // 将LogOutLbl添加至DisscusGroundBGLbl上
		DisscusGroundBGLbl.add(More1Lbl); // 将More1Lbl添加至DisscusGroundBGLbl上
		DisscusGroundBGLbl.add(More2Lbl); // 将More2Lbl添加至DisscusGroundBGLbl上
		DisscusGroundBGLbl.add(BackLbl); // 将BackLbl添加至DisscusGroundBGLbl上
		DisscusGroundBGLbl.add(articleLbl1); // 将BackLbl添加至DisscusGroundBGLbl上
		DisscusGroundBGLbl.add(articleLbl2); // 将BackLbl添加至DisscusGroundBGLbl上
		DisscusGroundBGLbl.add(articleLbl3); // 将BackLbl添加至DisscusGroundBGLbl上
		DisscusGroundBGLbl.add(picOne);
		DisscusGroundBGLbl.add(picTwo);
		DisscusGroundBGLbl.add(picThree);
		System.out.println(7);

		DisscusGroundFrame.add(DisscusGroundBGLbl); // 将DisscusGroundBGLbl添加至DisscusGroundFrame中
		DisscusGroundFrame.setVisible(true); // 设置DisscusGroundFrame为可访问的
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // 创建temporary标签

		if (Lbl == BackLbl) {
			new Inception(); // 点击backBtn后跳转至TrainingModeClass的窗口
			DisscusGroundFrame.dispose(); // 关闭当前窗口
		} else if (Lbl == LogOutLbl) {
			new SignInClass(client); // 点击backBtn后跳转至TrainingModeClass的窗口
			DisscusGroundFrame.dispose(); // 关闭当前窗口
		} else if (Lbl == backToTrainingLbl) {
			new TrainingModeClass(client); // 点击backBtn后跳转至TrainingModeClass的窗口
			DisscusGroundFrame.dispose(); // 关闭当前窗口
		} else if (Lbl == articleLbl1) {
			new CheckArticle(DisscusGroundFrame, client, 0);
			DisscusGroundFrame.setVisible(false);
		} else if (Lbl == articleLbl2) {
			new CheckArticle(DisscusGroundFrame, client, 1);
			DisscusGroundFrame.setVisible(false);
		} else if (Lbl == articleLbl3) {
			new CheckArticle(DisscusGroundFrame, client, 2);
			DisscusGroundFrame.setVisible(false);
		} else if (Lbl == More1Lbl) {

		} else if (Lbl == More2Lbl) {

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
