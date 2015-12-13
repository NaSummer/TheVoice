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
 * ��̳���棬����
 * @Author Xu Wenbo(Charles), Zheng Haoewn(Albert), Jin XinBin(Allen), Xu Qiufan, Hu Suihao
 * @Date
 */
public class DisscusGroundClass implements MouseListener {

	Client client;

	JFrame DisscusGroundFrame = new JFrame("DisscusGroundFrame");

	// ����ͼƬ
	ImageIcon comeBackToTraining = new ImageIcon(
			DisscusGroundClass.class.getResource("resource//Come back to training.jpg"));
	ImageIcon disscusGroud = new ImageIcon(DisscusGroundClass.class.getResource("resource//Disscus Groud.jpg"));
	ImageIcon logOut = new ImageIcon(DisscusGroundClass.class.getResource("resource//Log Out.jpg"));
	ImageIcon more = new ImageIcon(DisscusGroundClass.class.getResource("resource//More.jpg"));
	ImageIcon back = new ImageIcon(DisscusGroundClass.class.getResource("resource//Word Button back.jpg"));
	ImageIcon photo1 = new ImageIcon(DisscusGroundClass.class.getResource("resource//1.jpg"));
	ImageIcon photo2 = new ImageIcon(DisscusGroundClass.class.getResource("resource//2.jpg"));
	ImageIcon photo3 = new ImageIcon(DisscusGroundClass.class.getResource("resource//3.jpg"));

	// ����Label
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

	// ������
	List<String> articlesList;

	DisscusGroundClass(Client client) {

		this.client = client;

		System.out.println(1);
		articlesList = client.getArticleList();
		System.out.println(2);

		// ����Frame
		DisscusGroundFrame.setSize(600, 850); // ���ô�СΪ 600 �� 850
		DisscusGroundFrame.setResizable(false); // ʹ���ڴ�С�޷��ı�
		DisscusGroundFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����Ĭ�Ϲرղ���

		// ����ͼƬ
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

		// ����Lbl
		DisscusGroundBGLbl.setBounds(0, 0, 600, 800); // DisscusGroundBGLblλ��Ϊ0��0
														// ��СΪ 600 �� 800
		DisscusGroundBGLbl.setIcon(disscusGroud); // DisscusGroundBGLbl����ͼƬDisscusGroundBG

		backToTrainingLbl.setBounds(360, 123, 150, 50); // backToTrainingLblλ��Ϊ360��123
														// ��СΪ 150 �� 50
		backToTrainingLbl.setIcon(comeBackToTraining); // backToTrainingLbl����ͼƬbackToTraining
		backToTrainingLbl.addMouseListener(this); // ����backToTrainingLbl�ļ���

		LogOutLbl.setBounds(250, 140, 60, 20); // LogOutLblλ��Ϊ250��140 ��СΪ 60 ��
												// 20
		LogOutLbl.setIcon(logOut); // LogOutLbl����ͼƬLogOut
		LogOutLbl.addMouseListener(this); // ����LogOutLbl�ļ���

		More1Lbl.setBounds(380, 330, 90, 30); // More1Lblλ��Ϊ380��330 ��СΪ 90 �� 30
		More1Lbl.setIcon(more); // More1Lbl����ͼƬMore
		More1Lbl.addMouseListener(this); // ����More1Lbl�ļ���

		More2Lbl.setBounds(380, 540, 90, 30); // More2Lblλ��Ϊ380��540 ��СΪ 90 �� 30
		More2Lbl.setIcon(more); // More2Lbl����ͼƬMore
		More2Lbl.addMouseListener(this); // ����More2Lbl�ļ���

		BackLbl.setBounds(30, 30, 120, 40); // BackLblλ��Ϊ30��30 ��СΪ 120 �� 40
		BackLbl.setIcon(back); // BackLbl����ͼƬBack
		BackLbl.addMouseListener(this); // ����BackLbl�ļ���
		System.out.println(3);

		// articleLbl1 = new JLabel(articlesList.get(0));//�õ���1ƪ���±���
		// articleLbl2 = new JLabel(articlesList.get(1));//�õ���2ƪ���±���
		// articleLbl3 = new JLabel(articlesList.get(2));//�õ���3ƪ���±���

		int articleListSize = articlesList.size();
		System.out.println(4);
		switch (articleListSize) {
		case 0:
			articleLbl1 = new JLabel();// �õ���1ƪ���±���
			articleLbl2 = new JLabel();// �õ���2ƪ���±���
			articleLbl3 = new JLabel();// �õ���3ƪ���±���
			break;
		case 1:
			articleLbl1 = new JLabel(articlesList.get(0));// �õ���1ƪ���±���
			articleLbl2 = new JLabel();// �õ���2ƪ���±���
			articleLbl3 = new JLabel();// �õ���3ƪ���±���
			break;
		case 2:
			articleLbl1 = new JLabel(articlesList.get(0));// �õ���1ƪ���±���
			articleLbl2 = new JLabel(articlesList.get(1));// �õ���2ƪ���±���
			articleLbl3 = new JLabel();// �õ���3ƪ���±���
			break;
		default:
			articleLbl1 = new JLabel(articlesList.get(0));// �õ���1ƪ���±���
			articleLbl2 = new JLabel(articlesList.get(1));// �õ���2ƪ���±���
			articleLbl3 = new JLabel(articlesList.get(2));// �õ���3ƪ���±���
			break;
		}
		System.out.println(5);
		articleLbl1.setBounds(190, 215, 250, 30); // articleLbl1λ��Ϊ170��215 ��СΪ
													// 250 �� 30
		articleLbl1.addMouseListener(this); // ����articleLbl�ļ���

		articleLbl2.setBounds(190, 250, 250, 30); // articleLbl2λ��Ϊ170��250 ��СΪ
													// 250 �� 30
		articleLbl2.addMouseListener(this); // ����articleLbl2�ļ���

		articleLbl3.setBounds(190, 283, 250, 30); // articleLbl3λ��Ϊ170��283��СΪ
													// 250 �� 30
		articleLbl3.addMouseListener(this); // ����articleLbl3�ļ���

		picOne.setBounds(100, 400, 100, 100);
		picOne.setIcon(photo1);
		picTwo.setBounds(210, 400, 100, 100);
		picTwo.setIcon(photo2);
		picThree.setBounds(320, 400, 100, 100);
		picThree.setIcon(photo3);
		System.out.println(6);
		// ���lbl
		DisscusGroundBGLbl.add(backToTrainingLbl); // ��backToTrainingLbl�����DisscusGroundBGLbl��
		DisscusGroundBGLbl.add(LogOutLbl); // ��LogOutLbl�����DisscusGroundBGLbl��
		DisscusGroundBGLbl.add(More1Lbl); // ��More1Lbl�����DisscusGroundBGLbl��
		DisscusGroundBGLbl.add(More2Lbl); // ��More2Lbl�����DisscusGroundBGLbl��
		DisscusGroundBGLbl.add(BackLbl); // ��BackLbl�����DisscusGroundBGLbl��
		DisscusGroundBGLbl.add(articleLbl1); // ��BackLbl�����DisscusGroundBGLbl��
		DisscusGroundBGLbl.add(articleLbl2); // ��BackLbl�����DisscusGroundBGLbl��
		DisscusGroundBGLbl.add(articleLbl3); // ��BackLbl�����DisscusGroundBGLbl��
		DisscusGroundBGLbl.add(picOne);
		DisscusGroundBGLbl.add(picTwo);
		DisscusGroundBGLbl.add(picThree);
		System.out.println(7);

		DisscusGroundFrame.add(DisscusGroundBGLbl); // ��DisscusGroundBGLbl�����DisscusGroundFrame��
		DisscusGroundFrame.setVisible(true); // ����DisscusGroundFrameΪ�ɷ��ʵ�
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // ����temporary��ǩ

		if (Lbl == BackLbl) {
			new Inception(); // ���backBtn����ת��TrainingModeClass�Ĵ���
			DisscusGroundFrame.dispose(); // �رյ�ǰ����
		} else if (Lbl == LogOutLbl) {
			new SignInClass(client); // ���backBtn����ת��TrainingModeClass�Ĵ���
			DisscusGroundFrame.dispose(); // �رյ�ǰ����
		} else if (Lbl == backToTrainingLbl) {
			new TrainingModeClass(client); // ���backBtn����ת��TrainingModeClass�Ĵ���
			DisscusGroundFrame.dispose(); // �رյ�ǰ����
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
