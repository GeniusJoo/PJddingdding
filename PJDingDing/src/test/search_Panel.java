package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
// 조회용 패널

class search_Panel extends JPanel {
	JFrame mainframe;
	JScrollPane graphScroll;
	JTextField tf1 = new JTextField(15);
	JPanel centerPanel = new JPanel(new GridBagLayout());
	GridBagConstraints gbc;
	CardLayout cLayout;
	information info = new information();
	TreeNode root = info.Tree(); // 트리 root
	JLabel newLabel[] = new JLabel[5];
	JLabel newLabel2[]=new JLabel[5];// 정보표시 라벨
	JLabel la1 = new JLabel("");
	JLabel imgLabel = new JLabel();
	Image img=new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\find.jpg").getImage();
	ImageIcon background1 = new ImageIcon(img);
    Image originImg = background1.getImage(); 
    Image changedImg= originImg.getScaledInstance(200, 250, Image.SCALE_SMOOTH );
    ImageIcon Icon = new ImageIcon(changedImg);
	
	public search_Panel(JFrame mainframe, CardLayout cLayout) {
		
		this.mainframe= mainframe; 
		this.cLayout=cLayout;
		setLayout(new BorderLayout());
		//////////////////////////////////////////


		newLabel[0] = new JLabel("강의실명 : ");
		newLabel[1] = new JLabel("담당자 : ");
		newLabel[2] = new JLabel("주의사항");
		newLabel[3] = new JLabel("예약상태 : ");
		newLabel[4] = new JLabel("예약시간 : ");
		
		gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.fill= GridBagConstraints.BOTH;
		for(int i=0; i<newLabel.length;i++) {
			gbc.gridy=0+i;
			centerPanel.add(newLabel[i], gbc);
		}

		for(int i=0;i<newLabel2.length;i++) {
			newLabel2[i] = new JLabel("");
			gbc.gridx=1;
			gbc.gridy=0+i;
			centerPanel.add(newLabel2[i], gbc);
		}
		gbc.gridx=3;
		gbc.gridy=0;
        gbc.gridheight = 5;
		imgLabel.setIcon(Icon);
		centerPanel.add(imgLabel, gbc);
		
		gbc.gridx=0;
		gbc.gridy=5;
		gbc.gridwidth=4;
		centerPanel.add(la1,gbc);
		//검색창
				
		///////////////////////////////////////////
		// NORTH: menu 메뉴바 테스트 샘플
		Menu menu = new Menu();
		menu.addMenu("User");
		menu.getMenu().setMnemonic(KeyEvent.VK_1);
		menu.addMenuItem("나가기", KeyEvent.VK_E, new searchPanelListener());
		menu.addMenuItem("강의실", KeyEvent.VK_E, new searchPanelListener());
		menu.addMenuItem("도서실", KeyEvent.VK_E, new searchPanelListener());
		menu.addMenuItem("식당", KeyEvent.VK_E, new searchPanelListener());
		menu.addMenuItem("조회", KeyEvent.VK_E, new searchPanelListener());
		menu.finishAddItem();
		
		add(menu, BorderLayout.NORTH);
		///////////////////////
		//CENTER
		
		add(centerPanel,BorderLayout.CENTER);
		centerPanel.revalidate();
		///////////////
		///SOUTH
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,3));
		JButton btnBack = new JButton("뒤로가기");// 뒤로가기
		btnBack.addActionListener(e -> cLayout.first(
				mainframe.getContentPane())); // 뒤로가기 이벤트
		
		JButton btnRe = new JButton("찾기"); // 찾기버튼
		btnRe.addActionListener(new searchPanelListener());// 찾기 이벤트
		buttonPanel.add(btnBack);
		buttonPanel.add(tf1);
		buttonPanel.add(btnRe);
		southPanel.add(buttonPanel);
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
		btnRe.setBackground(new Color(230, 230, 255));
		btnBack.setBackground(new Color(255, 230, 255));
		
	}
	
	private class searchPanelListener implements ActionListener { //버튼 리스너
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			String search = tf1.getText();
			
			switch (name) {
			case "찾기":
				// 트리 탐색 구조 불러오기
				String s = "";
				s=root.searchAllNode(tf1.getText());
				la1.setText(s);
				
				TreeNode A = root.findnode(tf1.getText());
				String[] k = A.getleafnode();
				System.out.println(A.getNodeName());
				for(int i = 0; i<k.length;i++){
					newLabel2[i].setText(k[i]);
				}
				if(A.getParentNode().getParentNode().getNodeName().equals("5공학관")) {
					ImageIcon img1 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\find5.jpg");
					imgLabel.setIcon(img1);
				}else {
					ImageIcon img1 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\find5.jpg");
					imgLabel.setIcon(img1);
				}
				break;
			case "나가기":
				cLayout.show(mainframe.getContentPane(), "main");
				break;	
			case "강의실":
				cLayout.show(mainframe.getContentPane(), "classroom");
				break;
			case "도서실":
				cLayout.show(mainframe.getContentPane(), "library");
				break;
			case "식당":
				cLayout.show(mainframe.getContentPane(), "cafeteria");
				break;
			default:
				break;
			}
			
		}
	}
}
