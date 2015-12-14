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
	static JLabel TrainingModeInterface2ClassLbl_TraningInterface;
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
							
				SignUpLbl_SignUp.add(signIn1Lbl_SignUp);
				SignUpLbl_SignUp.add(submit1Lbl_SignUp);
				SignUpLbl_SignUp.add(trainingMode1Lbl_SignUp);
				jp.add(SignUpLbl_SignUp);
				
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
						
			SignInLbl_SignIn.add(Enter2Lbl_SignIn);
			SignInLbl_SignIn.add(SignUp2Lbl_SignIn);
			SignInLbl_SignIn.add(trainingModeLbl_SignIn);
			jp.add(SignInLbl_SignIn);
			
			
					return jp;
		}
		
	//setting
		public static JPanel SettingInterface(){
			
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
								
			
			SettingLbl_Setting.add(SubmitLbl_Setting);
			SettingLbl_Setting.add(Select1Lbl_Setting);
			SettingLbl_Setting.add(Select2Lbl_Setting);
			SettingLbl_Setting.add(BackLbl_Setting);
			jp.add(SettingLbl_Setting);
			
			
					return jp;
		}
	
	
		
		//TrainingMode
				public static JPanel TrainingMode(){

					// 加载图片
					BufferedImage TraingingModeBGBuffered = null;
					BufferedImage WordButton1Buffered = null;
					BufferedImage WordButton2Buffered = null;
					BufferedImage WordButton3Buffered = null;
					BufferedImage WordButton4Buffered = null;
					BufferedImage WordButton5Buffered = null;
					BufferedImage WordButtonIndexBuffered = null;
					BufferedImage WordButtonSettingBuffered = null;
							
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
					

							// 创建Label
					TrainingModeLbl_TraningMode = buildLabel(0, 0, 600, 800, TrainingModeBG);
					WordButton1Lbl_TraningMode = buildLabel(150, 270, 60, 60, WordButton1);
					WordButton2Lbl_TraningMode = buildLabel(210, 360, 60, 60, WordButton2);
					WordButton3Lbl_TraningMode = buildLabel(270, 270, 60, 60, WordButton3);
					WordButton4Lbl_TraningMode = buildLabel(330, 360, 60, 60, WordButton4);
					WordButton5Lbl_TraningMode = buildLabel(390, 270, 60, 60, WordButton5);
					settingLbl_TraningMode = buildLabel(175, 200, 250, 40, WordButtonSetting);
					indexLbl_TraningMode = buildLabel(385, 70, 90, 30, WordButtonIndex);
										
					
					TrainingModeLbl_TraningMode.add(WordButton1Lbl_TraningMode);
					TrainingModeLbl_TraningMode.add(WordButton2Lbl_TraningMode);
					TrainingModeLbl_TraningMode.add(WordButton3Lbl_TraningMode);
					TrainingModeLbl_TraningMode.add(WordButton4Lbl_TraningMode);
					TrainingModeLbl_TraningMode.add(WordButton5Lbl_TraningMode);
					TrainingModeLbl_TraningMode.add(settingLbl_TraningMode);
					TrainingModeLbl_TraningMode.add(indexLbl_TraningMode);
					jp.add(TrainingModeLbl_TraningMode);
					
					
							return jp;
				}
		
				
				//TraningMode Interface
				public static JPanel TrainingModeInterface(){

					// 加载图片
					BufferedImage TrainingModeInterface2ClassBGBuffered = null;
					ImageIcon WordButtonPicture1 = new ImageIcon(SettingClass.path);
					ImageIcon WordButtonPicture2 = new ImageIcon(SettingClass.path2);
					BufferedImage WordButtonBackBuffered = null;
							
					// 设置图片
					try{
						TrainingModeInterface2ClassBGBuffered = ImageIO.read(new File(
							"resource/TrainingModeInterface//Training Mode Interface2.jpg"));
					}
					catch(Exception e){
						System.out.println(e);
					}
					ImageIcon TrainingModeInterface1ClassBG = new ImageIcon(TrainingModeInterface2ClassBGBuffered);
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


							// 创建Label
					TrainingModeInterface2ClassLbl_TraningInterface = buildLabel(0, 0, 600, 800, TrainingModeInterface1ClassBG);
					picture1Lbl_TraningInterface = buildLabel(150, 130, 300, 180, WordButtonPicture1);
					picture2Lbl_TraningInterface = buildLabel(150, 330, 300, 180, WordButtonPicture2);
					backLbl_TraningInterface = buildLabel(235, 530, 120, 40, WordButtonBack);
//					word1_TraningInterface = buildLabel(330, 360, 60, 60, WordButton4);
//					word2_TraningInterface = buildLabel(390, 270, 60, 60, WordButton5);
										
					
					TrainingModeInterface2ClassLbl_TraningInterface.add(picture1Lbl_TraningInterface);
					TrainingModeInterface2ClassLbl_TraningInterface.add(picture2Lbl_TraningInterface);
					TrainingModeInterface2ClassLbl_TraningInterface.add(backLbl_TraningInterface);
//					TrainingModeInterface2ClassLbl_TraningInterface.add(word1_TraningInterface);
//					TrainingModeInterface2ClassLbl_TraningInterface.add(word2_TraningInterface);
					jp.add(TrainingModeInterface2ClassLbl_TraningInterface);
					
					
							return jp;
				}
				
				
				
				
				//DisscusGround
				public static JPanel DisscusGroundInterface(){
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

					
//					comeBackToTraining.setImage(comeBackToTraining.getImage().getScaledInstance(150, 50, Image.SCALE_DEFAULT));
//					disscusGroud.setImage(WordButton1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
//					logOut.setImage(WordButton2.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
//					more.setImage(WordButton3.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
//					back.setImage(WordButton4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
//					photo1.setImage(WordButton5.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
//					photo2.setImage(WordButtonSetting.getImage().getScaledInstance(250, 40, Image.SCALE_DEFAULT));
//					photo3.setImage(WordButtonIndex.getImage().getScaledInstance(90, 30, Image.SCALE_DEFAULT));
					

							// 创建Label
					DisscusGroundBGLbl_Dg = buildLabel(0, 0, 600, 800, disscusGroud);
					backToTrainingLbl_Dg = buildLabel(360, 123, 150, 50, comeBackToTraining);
					LogOutLbl_Dg = buildLabel(250, 140, 60, 20, logOut);
					More1Lbl_Dg = buildLabel(380, 330, 90, 30, more);
					More2Lbl_Dg = buildLabel(380, 540, 90, 30, more);
					BackLbl_Dg = buildLabel(30, 30, 120, 40, back);
					picOne_Dg = buildLabel(100, 400, 100, 100, photo1);
					picTwo_Dg = buildLabel(210, 400, 100, 100, photo2);
					picThree_Dg = buildLabel(320, 400, 100, 100, photo3);
										
					
					DisscusGroundBGLbl_Dg.add(backToTrainingLbl_Dg);
					DisscusGroundBGLbl_Dg.add(LogOutLbl_Dg);
					DisscusGroundBGLbl_Dg.add(More1Lbl_Dg);
					DisscusGroundBGLbl_Dg.add(More2Lbl_Dg);
					DisscusGroundBGLbl_Dg.add(BackLbl_Dg);
					DisscusGroundBGLbl_Dg.add(picOne_Dg);
					DisscusGroundBGLbl_Dg.add(picTwo_Dg);
					DisscusGroundBGLbl_Dg.add(picThree_Dg);
					jp.add(DisscusGroundBGLbl_Dg);
					
							
					
							return jp;
				}
				
				
				
				
				
	
				
				
				
				
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					JLabel Lbl = (JLabel) e.getSource(); // 创建temporary标签

					//Inception
					if (Lbl == signInLbl_Inception) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == signUpLbl_Inception) {
						jp.removeAll();
						SignUpInterface();
						jp.repaint();
					} else if (Lbl == trainingModeLbl_Inception) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} 
					
					//sign up
					else if (Lbl == SignUpLbl_SignUp) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == signIn1Lbl_SignUp) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == submit1Lbl_SignUp) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == trainingMode1Lbl_SignUp) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} 
					
					//sign in 
					else if (Lbl == SignInLbl_SignIn) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == Enter2Lbl_SignIn) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == SignUp2Lbl_SignIn) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == trainingModeLbl_SignIn) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} 
					
					//setting
					else if (Lbl == SettingLbl_Setting) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == SubmitLbl_Setting) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == SubmitLbl_Setting) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == Select1Lbl_Setting) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == Select2Lbl_Setting) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == BackLbl_Setting) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					}
					
					
					//Training mode
					else if (Lbl == TrainingModeLbl_TraningMode) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == WordButton1Lbl_TraningMode) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == WordButton2Lbl_TraningMode) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == WordButton3Lbl_TraningMode) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == WordButton4Lbl_TraningMode) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == WordButton5Lbl_TraningMode) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == settingLbl_TraningMode) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == indexLbl_TraningMode) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} 
					
					//training mode interface
					else if (Lbl == TrainingModeInterface2ClassLbl_TraningInterface) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == picture1Lbl_TraningInterface) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == picture2Lbl_TraningInterface) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == backLbl_TraningInterface) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == word1_TraningInterface) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == word2_TraningInterface) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
						
						//DG
					} else if (Lbl == DisscusGroundBGLbl_Dg) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == backToTrainingLbl_Dg) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == LogOutLbl_Dg) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == More1Lbl_Dg) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == More2Lbl_Dg) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == BackLbl_Dg) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == articleLbl1_Dg) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == articleLbl2_Dg) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == articleLbl3_Dg) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == picOne_Dg) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == picTwo_Dg) {
						jp.removeAll();
						/* Undo */
						jp.repaint();
					} else if (Lbl == picThree_Dg) {
						jp.removeAll();
						/* Undo */
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
