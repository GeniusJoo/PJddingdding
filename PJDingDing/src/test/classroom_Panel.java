package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.SpringLayout;

//강의실 패널
public class classroom_Panel extends JPanel{
	
	JFrame mainframe;
	JScrollPane graphScroll;
	CardLayout cLayout;
	information info = new information();
	JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	TreeNode root = info.Tree(); // 트리 root
	TreeNode building[] = new TreeNode[root.getChildNodeArray().size()];// 전체 건물
	JButton bt[]=new JButton[root.getChildNodeArray().size()];// 전체건물 버튼
	TreeNode eb5[];// 5공학관
	JButton bt1[];// 5공학관 버튼
	
	public classroom_Panel(JFrame mainframe, CardLayout cLayout) {
		this.mainframe= mainframe;
		this.cLayout=cLayout;
		setLayout(new BorderLayout());
		//////////////////////////////////////////
		// NORTH: menu 메뉴바 테스트 샘플
		Menu menu = new Menu();
		menu.addMenu("User");
		menu.getMenu().setMnemonic(KeyEvent.VK_1);
		menu.addMenuItem("나가기", KeyEvent.VK_E, new classroomlListener());
		menu.addMenuItem("도서실", KeyEvent.VK_E, new classroomlListener());
		menu.addMenuItem("식당", KeyEvent.VK_E, new classroomlListener());
		menu.addMenuItem("조회", KeyEvent.VK_E, new classroomlListener());
		menu.finishAddItem();
		add(menu, BorderLayout.NORTH);
		
		////////////////////////////////////
		//CENTER
		//////트리만들기///////
		//학교(root) -> 건물 -> 층 -> 강의실 강의실정보
		//학교 건물 층 강의실 정보
		//강의실 예약 로그인 
		
		
		 // 건물 전체 정보
		for(int i=0 ; i<root.getChildNodeArray().size() ; i++) { // 전체 건물 정보 저장
			building[i]=root.getChildNodeArray().get(i);
		}
		for(int i =0; i<root.getChildNodeArray().size();i++) { // 전체 건물 버튼 생성
			bt[i]= new JButton(root.getChildNodeArray().get(i).getNodeName());
			centerPanel.add(bt[i]);
		}
		
		eb5=new TreeNode[building[0].getChildNodeArray().size()]; // 5공학관 트리
		bt1=new JButton[building[0].getChildNodeArray().size()]; // 5공학관 버튼 크기
		
		eb5=info.reTree(building, 0); //정보 저장
		bt1=info.reButton(building, 0); // 버튼 만들기
		
		for(int i =0; i<eb5.length;i++) { // 버튼 넣어두고 화면에 사라짐
			centerPanel.add(bt1[i]);
			bt1[i].setVisible(false);
		}
		
		bt[0].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				for(int i =0; i<eb5.length;i++) {
					bt1[i].setVisible(true);
				}
				for(int i =0; i<building.length;i++) {
					bt[i].setVisible(false);
				}
			}
		});
		root.searchAllTreeNode();
		
		add(centerPanel, BorderLayout.CENTER);
		/////////////////////////////////////
		//SOUTH
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		
		JButton btnBack = new JButton("뒤로가기");
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane()));
		JButton btnre = new JButton("Re");
		btnre.addActionListener(new classroomlListener());
		buttonPanel.add(btnBack);
		buttonPanel.add(btnre);
		southPanel.add(buttonPanel);
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
	}
	
	private class classroomlListener implements ActionListener { //버튼 리스너
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			switch(name) {
			case "나가기":
				cLayout.show(mainframe.getContentPane(), "main");
				
				break;	
			case "도서관":
				cLayout.show(mainframe.getContentPane(), "library");
				break;
			case "조회":
				cLayout.show(mainframe.getContentPane(), "search");
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
