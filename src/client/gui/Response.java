package client.gui;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import sun.audio.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Response implements MouseListener{
	
	JFrame ResponseFrame = new JFrame("Response");
	
	BufferedImage picture1Buffered;
	BufferedImage picture2Buffered;
	
	
	JLabel picturelbl1 = new JLabel();
	JLabel picturelbl2 = new JLabel();
	
	
	Response(){
	
		ResponseFrame.setSize(600, 850); 
		ResponseFrame.setResizable(false); 
		ResponseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
	
		try{
			picture1Buffered = ImageIO.read(new File(
				"resource/Painting//crying.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon picture1 = new ImageIcon(picture1Buffered);
		
		try{
			picture2Buffered = ImageIO.read(new File(
				"resource/Painting//smile.jpg"));
		}
		catch(Exception e){
			System.out.println(e);
		}
		ImageIcon picture2 = new ImageIcon(picture2Buffered);
		
		
		picture1.setImage(picture1.getImage().getScaledInstance(400, 400,
				Image.SCALE_DEFAULT));
		picture2.setImage(picture2.getImage().getScaledInstance(400, 400,
				Image.SCALE_DEFAULT));
		
		
		
		picturelbl1.setBounds(100, 0, 400, 400); 
		picturelbl1.setIcon(picture1); 
		picturelbl1.addMouseListener(this);
		
		picturelbl2.setBounds(100, 420, 400, 400); 
		picturelbl2.setIcon(picture2); 
		picturelbl2.addMouseListener(this);
		
		ResponseFrame.add(picturelbl1);
		ResponseFrame.add(picturelbl2);
		ResponseFrame.setLayout(null);
		ResponseFrame.setVisible(true); 
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel Lbl = (JLabel) e.getSource();

		if (Lbl == picturelbl1) {
			ResponseFrame.dispose();
		} else if (Lbl == picturelbl2){
			ResponseFrame.dispose();
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
