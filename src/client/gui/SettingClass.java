package client.gui;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileSystemView;

import client.transmission.Client;
/*
 * ���ã�����
 * @Author Xu Wenbo(Charles), Zheng Haoewn(Albert), Jin XinBin(Allen), Xu Qiufan, Hu Suihao
 * @Date 
 */
public class SettingClass  implements MouseListener {
	static String path = null;
	static String path2 = null;
	Client client;
	
	JFrame SettingFrame = new JFrame("Setting");
	
	//����ͼƬ
	BufferedImage SettingBGBuffered;
	BufferedImage WordButtonSubmitBuffered;
	BufferedImage WordButtonSelectBuffered;
	BufferedImage WordButtonBackBuffered;

	//����Label
	JLabel SettingLbl = new JLabel();
	JLabel SubmitBtn = new JLabel();
	JLabel Select1Btn = new JLabel();
	JLabel Select2Btn = new JLabel();
	JLabel BackBtn = new JLabel();

	
	
	SettingClass(Client client) {
		
		this.client = client;
		
		// ����Frame
		SettingFrame.setSize(600, 850);                                           //���ô�СΪ 600 �� 850
		SettingFrame.setResizable(false);                                         //ʹ���ڴ�С�޷��ı�
		SettingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);              //����Ĭ�Ϲرղ���
		
		// ����ͼƬ
		try{
			SettingBGBuffered = ImageIO.read(new File(
				"resource/Setting//Setting.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon SettingBG = new ImageIcon(SettingBGBuffered);
		
		try{
			WordButtonSubmitBuffered = ImageIO.read(new File(
				"resource/Setting//Word Button Submit.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon WordButtonSubmit = new ImageIcon(WordButtonSubmitBuffered);
		
		try{
			WordButtonSelectBuffered = ImageIO.read(new File(
				"resource/Setting//Word Button select.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon WordButtonSelect = new ImageIcon(WordButtonSelectBuffered);
		try{
			WordButtonBackBuffered = ImageIO.read(new File(
				"resource/Setting//Word Button back.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon WordButtonBack = new ImageIcon(WordButtonBackBuffered);
		
		
		SettingBG.setImage(SettingBG.getImage().getScaledInstance(600, 800,
				Image.SCALE_DEFAULT));
		WordButtonSubmit.setImage(WordButtonSubmit.getImage()
				.getScaledInstance(90, 30, Image.SCALE_DEFAULT));
		WordButtonSelect.setImage(WordButtonSelect.getImage()
				.getScaledInstance(90, 30, Image.SCALE_DEFAULT));
		WordButtonBack.setImage(WordButtonBack.getImage().getScaledInstance(
				120, 40, Image.SCALE_DEFAULT));
		
		// ����Lbl
		SettingLbl.setBounds(0, 0, 600, 800);                                     //SettingLblλ��Ϊ0��0 ��СΪ 600 �� 800
		SettingLbl.setIcon(SettingBG);                                            //SettingLbl����ͼƬSettingBG
		
		SubmitBtn.setBounds(250, 430, 90, 30);                                    //SubmitBtnλ��Ϊ250��430 ��СΪ 90 �� 30
		SubmitBtn.setIcon(WordButtonSubmit);                                      //SubmitBtn����ͼƬWordButtonSubmit
		SubmitBtn.addMouseListener(this);                                         //����SubmitBtn�ļ���
		
		Select1Btn.setBounds(430, 280, 90, 30);                                   //Select1Btnλ��Ϊ430��280 ��СΪ 90 �� 30
		Select1Btn.setIcon(WordButtonSelect);                                     //Select1Btn����ͼƬWordButtonSelect
		Select1Btn.addMouseListener(this);                                        //����Select1Btn�ļ���
		
		Select2Btn.setBounds(430, 360, 90, 30);                                   //Select2Btnλ��Ϊ430��360 ��СΪ 90 �� 30
		Select2Btn.setIcon(WordButtonSelect);                                     //Select2Btn����ͼƬWordButtonSelect
		Select2Btn.addMouseListener(this);                                        //����Select2Btn�ļ���
		
		BackBtn.setBounds(30, 30, 120, 40);                                       //BackBtnλ��Ϊ30��30 ��СΪ 120 �� 40
		BackBtn.setIcon(WordButtonBack);                                          //BackBtn����ͼƬWordButtonBack
		BackBtn.addMouseListener(this);                                           //����BackBtn�ļ���

		// ���lbl
		SettingLbl.add(SubmitBtn);                                                //��SubmitBtn�����SettingLbl��
		SettingLbl.add(Select1Btn);                                               //��Select1Btn�����SettingLbl��
		SettingLbl.add(Select2Btn);                                               //��Select2Btn�����SettingLbl��
		SettingLbl.add(BackBtn);                                                  //��BackBtn�����SettingLbl��
		
		SettingFrame.add(SettingLbl);                                             //��SettingLbl�����SettingFrame��
		SettingFrame.setVisible(true);                                            //����SettingFrameΪ�ɷ��ʵ�
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource();                                      //����temporary��ǩ
	
		if (Lbl == SubmitBtn) {

		} else if (Lbl == Select1Btn) {
			int result = 0;
			File file = null;
			
			JFileChooser fileChooser = new JFileChooser();
			FileSystemView fsv = FileSystemView.getFileSystemView(); 
			System.out.println(fsv.getHomeDirectory()); 
			fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
			fileChooser.setDialogTitle("��ѡ��Ҫ�ϴ����ļ�...");
			fileChooser.setApproveButtonText("ȷ��");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			result = fileChooser.showOpenDialog(null);
			if (JFileChooser.APPROVE_OPTION == result) {
			try {
				path=fileChooser.getSelectedFile().getCanonicalPath();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				path = "TrainingModeInterface"+"\\"+"\\Recommond1.jpg";
			}

			System.out.println("path: "+path);
			}
		} else if (Lbl == Select2Btn) {
			int result = 0;
			File file2 = null;
			
			JFileChooser fileChooser2 = new JFileChooser();
			FileSystemView fsv = FileSystemView.getFileSystemView(); 
			System.out.println(fsv.getHomeDirectory()); 
			fileChooser2.setCurrentDirectory(fsv.getHomeDirectory());
			fileChooser2.setDialogTitle("��ѡ��Ҫ�ϴ����ļ�...");
			fileChooser2.setApproveButtonText("ȷ��");
			fileChooser2.setFileSelectionMode(JFileChooser.FILES_ONLY);
			result = fileChooser2.showOpenDialog(null);
			if (JFileChooser.APPROVE_OPTION == result) {
			try {
				path2=fileChooser2.getSelectedFile().getCanonicalPath();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				path2 = "TrainingModeInterface"+"\\"+"\\recommond2.jpg";
			}
			}
			System.out.println("path: "+path2);
		} else if (Lbl == BackBtn) {
			new TrainingModeClass(client);                                              //���BackBtn����ת��TrainingModeClass�Ĵ���
			SettingFrame.dispose();                                               //�رյ�ǰ����
		}
	}//end mouseClicked

	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}//end mousePressed

	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}//end mouseReleased

	
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}//end mouseEntered

	
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}//end mouseExited
}
