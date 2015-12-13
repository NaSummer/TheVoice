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
 * 设置，。。
 * @Author Xu Wenbo(Charles), Zheng Haoewn(Albert), Jin XinBin(Allen), Xu Qiufan, Hu Suihao
 * @Date 
 */
public class SettingClass  implements MouseListener {
	static String path = null;
	static String path2 = null;
	Client client;
	
	JFrame SettingFrame = new JFrame("Setting");
	
	//加载图片
	BufferedImage SettingBGBuffered;
	BufferedImage WordButtonSubmitBuffered;
	BufferedImage WordButtonSelectBuffered;
	BufferedImage WordButtonBackBuffered;

	//创建Label
	JLabel SettingLbl = new JLabel();
	JLabel SubmitBtn = new JLabel();
	JLabel Select1Btn = new JLabel();
	JLabel Select2Btn = new JLabel();
	JLabel BackBtn = new JLabel();

	
	
	SettingClass(Client client) {
		
		this.client = client;
		
		// 设置Frame
		SettingFrame.setSize(600, 850);                                           //设置大小为 600 × 850
		SettingFrame.setResizable(false);                                         //使窗口大小无法改变
		SettingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);              //设置默认关闭操作
		
		// 设置图片
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
		
		// 设置Lbl
		SettingLbl.setBounds(0, 0, 600, 800);                                     //SettingLbl位置为0，0 大小为 600 × 800
		SettingLbl.setIcon(SettingBG);                                            //SettingLbl载入图片SettingBG
		
		SubmitBtn.setBounds(250, 430, 90, 30);                                    //SubmitBtn位置为250，430 大小为 90 × 30
		SubmitBtn.setIcon(WordButtonSubmit);                                      //SubmitBtn载入图片WordButtonSubmit
		SubmitBtn.addMouseListener(this);                                         //设置SubmitBtn的监听
		
		Select1Btn.setBounds(430, 280, 90, 30);                                   //Select1Btn位置为430，280 大小为 90 × 30
		Select1Btn.setIcon(WordButtonSelect);                                     //Select1Btn载入图片WordButtonSelect
		Select1Btn.addMouseListener(this);                                        //设置Select1Btn的监听
		
		Select2Btn.setBounds(430, 360, 90, 30);                                   //Select2Btn位置为430，360 大小为 90 × 30
		Select2Btn.setIcon(WordButtonSelect);                                     //Select2Btn载入图片WordButtonSelect
		Select2Btn.addMouseListener(this);                                        //设置Select2Btn的监听
		
		BackBtn.setBounds(30, 30, 120, 40);                                       //BackBtn位置为30，30 大小为 120 × 40
		BackBtn.setIcon(WordButtonBack);                                          //BackBtn载入图片WordButtonBack
		BackBtn.addMouseListener(this);                                           //设置BackBtn的监听

		// 添加lbl
		SettingLbl.add(SubmitBtn);                                                //将SubmitBtn添加至SettingLbl上
		SettingLbl.add(Select1Btn);                                               //将Select1Btn添加至SettingLbl上
		SettingLbl.add(Select2Btn);                                               //将Select2Btn添加至SettingLbl上
		SettingLbl.add(BackBtn);                                                  //将BackBtn添加至SettingLbl上
		
		SettingFrame.add(SettingLbl);                                             //将SettingLbl添加至SettingFrame中
		SettingFrame.setVisible(true);                                            //设置SettingFrame为可访问的
	}

	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource();                                      //创建temporary标签
	
		if (Lbl == SubmitBtn) {

		} else if (Lbl == Select1Btn) {
			int result = 0;
			File file = null;
			
			JFileChooser fileChooser = new JFileChooser();
			FileSystemView fsv = FileSystemView.getFileSystemView(); 
			System.out.println(fsv.getHomeDirectory()); 
			fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
			fileChooser.setDialogTitle("请选择要上传的文件...");
			fileChooser.setApproveButtonText("确定");
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
			fileChooser2.setDialogTitle("请选择要上传的文件...");
			fileChooser2.setApproveButtonText("确定");
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
			new TrainingModeClass(client);                                              //点击BackBtn后跳转至TrainingModeClass的窗口
			SettingFrame.dispose();                                               //关闭当前窗口
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
