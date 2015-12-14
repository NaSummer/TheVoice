package client.gui;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface implements MouseListener{
	//Inception Label
	static JLabel LogoLbl_Inception;
	static JLabel signUpLbl_Inception;
	static JLabel signInLbl_Inception;
	static JLabel trainingModeLbl_Inception;
	
	//SignUp Label
	static JLabel SignUpLbl_SignUp;
	static JLabel signIn1Lbl_SignUp;
	static JLabel submit1Lbl_SignUp;
	static JLabel trainingMode1Lbl_SignUp;
	
	//SignIn Label
	static JLabel SignInLbl_SignIn;
	static JLabel Enter2Lbl_SignIn;
	static JLabel SignUp2Lbl_SignIn;
	static JLabel trainingModeLbl_SignIn;
	
	//Setting Label
	static JLabel SettingLbl_Setting;
	static JLabel SubmitLbl_Setting;
	static JLabel Select1Lbl_Setting;
	static JLabel Select2Lbl_Setting;
	static JLabel BackLbl_Setting;
	
	//TrainingMode Label
	static JLabel TrainingModeLbl_TraningMode;
	static JLabel WordButton1Lbl_TraningMode;
	static JLabel WordButton2Lbl_TraningMode;
	static JLabel WordButton3Lbl_TraningMode;
	static JLabel WordButton4Lbl_TraningMode;
	static JLabel WordButton5Lbl_TraningMode;
	static JLabel settingLbl_TraningMode;
	static JLabel indexLbl_TraningMode;
	
	//TraningMode Interface Label
	static JLabel TrainingModeInterface2ClassLbl;
	static JLabel picture1Lbl_TraningInterface;
	static JLabel picture2Lbl_TraningInterface;
	static JLabel backLbl_TraningInterface;
	static JLabel word1_TraningInterface;
	static JLabel word2_TraningInterface;
	
	//DisscusGround Label
	static JLabel DisscusGroundBGLbl_Dg;
	static JLabel backToTrainingLbl_Dg;
	static JLabel LogOutLbl_Dg;
	static JLabel More1Lbl_Dg;
	static JLabel More2Lbl_Dg;
	static JLabel BackLbl_Dg;
	static JLabel articleLbl1_Dg;
	static JLabel articleLbl2_Dg;
	static JLabel articleLbl3_Dg;
	static JLabel picOne_Dg;
	static JLabel picTwo_Dg;
	static JLabel picThree_Dg;
	static JPanel jp = new JPanel();
	
	
	
	Interface() {

	}

	public static JLabel buildLabel(int x, int y, int width, int height, ImageIcon image) {
		JLabel jLbl = new JLabel();
		jLbl.setIcon(image);
		jLbl.setBounds(x, y, width, height);
		jLbl.addMouseListener(new Interface());
		return jLbl;
	}

	//Inception
	public static JPanel InceptionInterface(){

		BufferedImage LogoBuffered = null;
		BufferedImage signInBuffered = null;
		BufferedImage signUpBuffered = null;
		BufferedImage trainingModeBuffered = null;
				
		// 设置图片
				try{
					 LogoBuffered = ImageIO.read(new File(
						"resource/Index//Logo.jpg"));
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
				

				// 创建Label
				LogoLbl_Inception = buildLabel(0, 0, 600, 800, Logo);
				signUpLbl_Inception = buildLabel(350, 30, 90, 30, signUp);
				signInLbl_Inception = buildLabel(450, 30, 90, 30, signIn);
				trainingModeLbl_Inception = buildLabel(385, 70, 120, 40, trainingMode);
							
				LogoLbl_Inception.add(signInLbl_Inception);
				LogoLbl_Inception.add(signUpLbl_Inception);
				LogoLbl_Inception.add(trainingModeLbl_Inception);
				jp.add(LogoLbl_Inception);
				
				return jp;
	}
	
	
	//SignUp
	public static JPanel SignUpInterface(){

		// 加载图片
		BufferedImage SignUpBGBuffered = null;
		BufferedImage WordButtonSignIn1Buffered = null;
		BufferedImage WordButtonsubmit1Buffered = null;
		BufferedImage WordButtonTrainingMode1Buffered = null;

				
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
				WordButtonTrainingMode1.setImage(WordButtonTrainingMode1.getImage().getScaledInstance(120, 40, Image.SCALE_DEFAULT));

				
				// 创建Label
				SignUpLbl_SignUp = buildLabel(0, 0, 600, 800, SignUpBG);
				signIn1Lbl_SignUp = buildLabel(200, 300, 90, 30, WordButtonSignIn1);
				submit1Lbl_SignUp = buildLabel(400, 400, 90, 30, WordButtonsubmit1);
				trainingMode1Lbl_SignUp = buildLabel(385, 70, 120, 40, WordButtonTrainingMode1);
							
				return jp;
	}
	
	
	//SignIn
		public static JPanel SignInInterface(){

			// 加载图片
			BufferedImage SignInBGBuffered = null;
			BufferedImage WordButtonEnter2Buffered = null;
			BufferedImage WordButtonSignUp2Buffered = null;
			BufferedImage WordButtonTrainingModeBuffered = null;
					
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

					
					// 创建Label
			SignInLbl_SignIn = buildLabel(0, 0, 600, 800, SignInBG);
			Enter2Lbl_SignIn = buildLabel(175, 400, 90, 30, WordButtonEnter2);
			SignUp2Lbl_SignIn = buildLabel(345, 400, 90, 30, WordButtonSignUp2);
			trainingModeLbl_SignIn = buildLabel(385, 70, 120, 40, WordButtonTrainingMode);
								
					return jp;
		}
		
	//setting
		public static JPanel SettingInterface(){
			JPanel jp = new JPanel();

			// 加载图片
			BufferedImage SettingBGBuffered = null;
			BufferedImage WordButtonSubmitBuffered = null;
			BufferedImage WordButtonSelectBuffered = null;
			BufferedImage WordButtonBackBuffered = null;
					
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

					// 创建Label
			SettingLbl_Setting = buildLabel(0, 0, 600, 800, SettingBG);
			SubmitLbl_Setting = buildLabel(250, 430, 90, 30, WordButtonSubmit);
			Select1Lbl_Setting = buildLabel(430, 280, 90, 30, WordButtonSelect);
			Select2Lbl_Setting = buildLabel(430, 360, 90, 30, WordButtonSelect);
			BackLbl_Setting = buildLabel(30, 30, 120, 40, WordButtonBack);
								
					return jp;
		}

	@Override
//	static JLabel LogoLbl_Inception;
//	static JLabel signUpLbl_Inception;
//	static JLabel signInLbl_Inception;
//	static JLabel trainingModeLbl_Inception;
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource(); // 创建temporary标签

		if (Lbl == signInLbl_Inception) {
			jp.removeAll();
			/*Undo*/
			jp.repaint();
		} else if (Lbl == signUpLbl_Inception) {
			jp.removeAll();
			SignUpInterface();
			jp.repaint();
		} else if (Lbl == trainingModeLbl_Inception) {
			jp.removeAll();
			/*Undo*/
			jp.repaint();

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
