package client.gui;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import client.transmission.Client;

public class CheckArticle {
	JFrame  checkArticleFrame = new JFrame("CheckArticle");
	JTextArea theArticle = new JTextArea();
	JPanel articlePanel = new JPanel(new BorderLayout());
	Client client;
	JFrame frame;
	//JScrollPane articlePanel = new JScrollPane(theArticle); 
	
	CheckArticle(JFrame frame, Client client, int indexOfList){
		this.client = client;
		this.frame = frame;
		
		String article = client.getArticle(indexOfList);
		theArticle.setText(article);
		checkArticleFrame.setSize(600, 850); 
		checkArticleFrame.setResizable(false); 
//		checkArticleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		checkArticleFrame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				/**
				 * 
				 * @param 
				 * @return 
				 */
				// TODO Auto-generated method stub
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				/**
				 * 
				 * @param 
				 * @return 
				 */
				// TODO Auto-generated method stub
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				/**
				 * 
				 * @param 
				 * @return 
				 */
				// TODO Auto-generated method stub
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				/**
				 * 
				 * @param 
				 * @return 
				 */
				// TODO Auto-generated method stub
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				checkArticleFrame.dispose();
				frame.setVisible(true);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				/**
				 * 
				 * @param 
				 * @return 
				 */
				// TODO Auto-generated method stub
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				/**
				 * 
				 * @param 
				 * @return 
				 */
				// TODO Auto-generated method stub
			}
		});
		articlePanel.setVisible(true);
		JScrollPane panel = new JScrollPane(articlePanel);
		panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//articlePanel.add(new JScrollPane(theArticle));
		
//		articlePanel.setHorizontalScrollBarPolicy( 
//				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
//		articlePanel.setVerticalScrollBarPolicy( 
//				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				
		theArticle.setFont(new Font("Times New Romen", Font.PLAIN, 30));
		theArticle.setLineWrap(true);//激活自动换行功能
		theArticle.setWrapStyleWord(true);// 激活断行不断字功能
		theArticle.setEditable(false);
		
		articlePanel.add(theArticle);
		
		checkArticleFrame.add(panel);
		checkArticleFrame.setVisible(true);
		
	}
}