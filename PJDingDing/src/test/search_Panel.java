package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
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
	CardLayout cLayout;
	public search_Panel(JFrame mainframe, CardLayout cLayout) {
		
		this.mainframe= mainframe; 
		this.cLayout=cLayout;
		setLayout(new BorderLayout());
		//////////////////////////////////////////
		
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
		JPanel centerPanel = new JPanel();
		
		add(centerPanel,BorderLayout.CENTER);
		centerPanel.revalidate();
		///////////////
		///SOUTH
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,3));
		JButton btnBack = new JButton("뒤로가기");// 뒤로가기
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane())); // 뒤로가기 이벤트
		JTextField tf1 = new JTextField(15);// 입력창 
		JButton btnRe = new JButton("찾기"); // 찾기버튼
		btnRe.addActionListener(new searchPanelListener());// 찾기 이벤트
		
		buttonPanel.add(btnBack);
		buttonPanel.add(tf1);
		buttonPanel.add(btnRe);
		southPanel.add(buttonPanel);
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
	}
	
	private class searchPanelListener implements ActionListener { //버튼 리스너
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			String search = tf1.getText();
			
			switch (name) {
			case "찾기":
				// 트리 탐색 구조 불러오기
				
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
