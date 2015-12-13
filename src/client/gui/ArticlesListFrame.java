package client.gui;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import client.transmission.Client;

public class ArticlesListFrame implements MouseListener {
	
	Client client;
	
	int pageNum = 0;
	JFrame articlesListFrame = new JFrame("Articles_Page" + (pageNum + 1) + "");
	List<String> articlesList = client.getArticleList();
	JLabel[] articleLbls = new JLabel[articlesList.size()];
	JLabel BGLbl = new JLabel();
	JLabel nextLbl = new JLabel();
	JLabel lastLbl = new JLabel();

	int numOfPage = 0;

	ArticlesListFrame(Client client) {
		
		this.client = client;
		
		articlesListFrame.setSize(600, 850); // 设置大小为 600 × 850
		articlesListFrame.setResizable(false); // 使窗口大小无法改变
		articlesListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置默认关闭操作
		articlesListFrame.setVisible(true); // 设置inceptionFrame为可访问的

		if (articleLbls.length % 14 == 0) {
			numOfPage = articleLbls.length / 14 - 1;
		} else {
			numOfPage = (int) (articleLbls.length / 14);
		}

		BGLbl.setBounds(0, 0, 600, 800); // BGLbl位置为0，0 大小为 600 × 800
		// BGLbl.setIcon(); // 载入图片

		nextLbl = new JLabel("Next");
		nextLbl.setFont(new Font("Times New Romen", Font.PLAIN, 25));
		nextLbl.setBounds(500, 730, 90, 30);
		nextLbl.addMouseListener(this);
		BGLbl.add(nextLbl);

		lastLbl = new JLabel("Last");
		lastLbl.setFont(new Font("Times New Romen", Font.PLAIN, 25));
		lastLbl.setBounds(400, 730, 90, 30);
		lastLbl.addMouseListener(this);
		// BGLbl.add(lastLbl);

		for (int i = 0; i < articleLbls.length; ++i) {
			articleLbls[i] = new JLabel("what are you doing." + i + "");
			articleLbls[i]
					.setFont(new Font("Times New Romen", Font.ITALIC, 25));
			articleLbls[i].setBounds(10, 10 + i % 14 * 50, 500, 80); // 位置为10，280
																		// 大小为
																		// 90 ×
																		// 30
			articleLbls[i].addMouseListener(this);
		}

		for (int i = 0; i < 14; ++i) {
			BGLbl.add(articleLbls[i]);
		}

		articlesListFrame.add(BGLbl);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel lbl = (JLabel) e.getSource();
		if (lbl == nextLbl) {
			if (numOfPage == 0) {
				for (int i = 0 + pageNum * 14; i < articleLbls.length; ++i) {
					BGLbl.remove(articleLbls[i]);
					BGLbl.repaint();
				}
			} else {
				for (int i = 0 + pageNum * 14; i < 14 + pageNum * 14; ++i) {
					BGLbl.remove(articleLbls[i]);
					BGLbl.repaint();
				}
			}
			pageNum = pageNum + 1;
			numOfPage = numOfPage - 1;
			System.out.println(numOfPage);

		}
		if (lbl == lastLbl) {
			if (numOfPage == 0) {
				for (int i = pageNum * 14; i < articleLbls.length; ++i) {
					BGLbl.remove(articleLbls[i]);
					BGLbl.repaint();
				}
			} else {
				for (int i = 0 + pageNum * 14; i < 14 + pageNum * 14; ++i) {
					BGLbl.remove(articleLbls[i]);
					BGLbl.repaint();
				}
			}
			pageNum = pageNum - 1;
			numOfPage += 1;
			System.out.println(numOfPage);
		}

		articlesListFrame.setTitle("Articles_Page" + (pageNum + 1) + "");
		if (pageNum != 0) {
			BGLbl.add(lastLbl);
		} else {
			BGLbl.remove(lastLbl);
			BGLbl.repaint();
		}
		if (numOfPage == 0) {
			BGLbl.remove(nextLbl);
		} else {
			BGLbl.add(nextLbl);
		}
		if (numOfPage == 0) {
			for (int i = pageNum * 14; i < articleLbls.length; ++i) {
				BGLbl.add(articleLbls[i]);
			}
		} else {
			for (int i = 0 + pageNum * 14; i < 14 + pageNum * 14; ++i) {
				BGLbl.add(articleLbls[i]);
			}
		}

		BGLbl.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
