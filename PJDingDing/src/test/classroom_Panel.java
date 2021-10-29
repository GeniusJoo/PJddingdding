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
import java.util.EventListener;
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
	TreeNode eb5_1[];// 5공1층
	JButton bt1_1[];// 5공1층버튼
	TreeNode eb5_2[];// 5공2층
	JButton bt1_2[];// 5공2층버튼
	TreeNode eb5_3[];// 5공3층
	JButton bt1_3[];// 5공3층버튼
	
	TreeNode eb1[];// 1공학관
	JButton bt2[];// 1공학관 버튼
	TreeNode eb1_1[];// 1공학관 1층
	JButton bt2_1[];// 1공학관 1층 버튼
	TreeNode eb1_2[];// 1공학관 2층
	JButton bt2_2[];// 1공학관 2층 버튼
	TreeNode eb1_3[];// 1공학관 3층
	JButton bt2_3[];// 1공학관 3층 버튼
	
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
		//5공
		eb5=new TreeNode[building[0].getChildNodeArray().size()]; // 5공학관 트리
		bt1=new JButton[building[0].getChildNodeArray().size()]; // 5공학관 버튼 크기
		eb5=info.reTree(building, 0); //정보 저장
		bt1=info.reButton(building, 0); // 버튼 만들기
		for(int i =0; i<eb5.length;i++) { // 버튼 넣어두고 화면에 사라짐
			centerPanel.add(bt1[i]);
			bt1[i].setVisible(false);
		}
		
		//5공 1층
		eb5_1 = new TreeNode[eb5[0].getChildNodeArray().size()];
		bt1_1 = new JButton[eb5[0].getChildNodeArray().size()];
		eb5_1=info.reTree(eb5, 0); //정보 저장
		bt1_1=info.reButton(eb5, 0); // 버튼 만들기
		for(int i =0; i<eb5_1.length;i++) { // 버튼 넣어두고 화면에 사라짐
			centerPanel.add(bt1_1[i]);
			bt1_1[i].setVisible(false);
		}
		
		//5공 2층
		eb5_2 = new TreeNode[eb5[1].getChildNodeArray().size()];
		bt1_2 = new JButton[eb5[1].getChildNodeArray().size()];
		eb5_2=info.reTree(eb5, 1); //정보 저장
		bt1_2=info.reButton(eb5, 1); // 버튼 만들기
		for(int i =0; i<eb5_2.length;i++) { // 버튼 넣어두고 화면에 사라짐
			centerPanel.add(bt1_2[i]);
			bt1_2[i].setVisible(false);
		}
		
		//5공 3층
		eb5_3 = new TreeNode[eb5[2].getChildNodeArray().size()];
		bt1_3 = new JButton[eb5[2].getChildNodeArray().size()];
		eb5_3=info.reTree(eb5, 2); //정보 저장
		bt1_3=info.reButton(eb5, 2); // 버튼 만들기
		for(int i =0; i<eb5_3.length;i++) { // 버튼 넣어두고 화면에 사라짐
			centerPanel.add(bt1_3[i]);
			bt1_3[i].setVisible(false);
		}
		
		//1공
		eb1=new TreeNode[building[1].getChildNodeArray().size()]; // 1공학관 트리
		bt2=new JButton[building[1].getChildNodeArray().size()]; // 1공학관 버튼 크기
		eb1=info.reTree(building, 1); //정보 저장
		bt2=info.reButton(building, 1); // 버튼 만들기
		for(int i =0; i<eb1.length;i++) { // 버튼 넣어두고 화면에 사라짐
			centerPanel.add(bt2[i]);
			bt2[i].setVisible(false);
		}
		
		//1공 1층
		eb1_1 = new TreeNode[eb1[0].getChildNodeArray().size()];
		bt2_1 = new JButton[eb1[0].getChildNodeArray().size()];
		eb1_1=info.reTree(eb1, 0); //정보 저장
		bt2_1=info.reButton(eb1, 0); // 버튼 만들기
		for(int i =0; i<eb1_1.length;i++) { // 버튼 넣어두고 화면에 사라짐
			centerPanel.add(bt2_1[i]);
			bt2_1[i].setVisible(false);
		}
		
		//1공 2층
		eb1_2 = new TreeNode[eb1[1].getChildNodeArray().size()];
		bt2_2 = new JButton[eb1[1].getChildNodeArray().size()];
		eb1_2=info.reTree(eb1, 1); //정보 저장
		bt2_2=info.reButton(eb1, 1); // 버튼 만들기
		for(int i =0; i<eb1_2.length;i++) { // 버튼 넣어두고 화면에 사라짐
			centerPanel.add(bt2_2[i]);
			bt2_2[i].setVisible(false);
		}
		
		//1공 3층
		eb1_3 = new TreeNode[eb1[2].getChildNodeArray().size()];
		bt2_3 = new JButton[eb1[2].getChildNodeArray().size()];
		eb1_3=info.reTree(eb1, 2); //정보 저장
		bt2_3=info.reButton(eb1, 2); // 버튼 만들기
		for(int i =0; i<eb1_3.length;i++) { // 버튼 넣어두고 화면에 사라짐
			centerPanel.add(bt2_3[i]);
			bt2_3[i].setVisible(false);
		}
		///////////////////////// 버튼 리스너 
		int j=0;
		bt[0].addActionListener(new ActionListener() {//
			public void actionPerformed(ActionEvent e) {
				for(int i =0; i<eb5.length;i++) {
					bt1[i].setVisible(true);
				}
				for(int i =0; i<building.length;i++) {
							bt[i].setVisible(false);
				}
			}
		});

		bt[1].addActionListener(new ActionListener() {//
			public void actionPerformed(ActionEvent e) {
				for(int i =0; i<eb1.length;i++) {
							bt2[i].setVisible(true);
				}
				for(int i =0; i<building.length;i++) {
							bt[i].setVisible(false);
				}
			}
		});
	
		
		
		//////////////////////////////
		add(centerPanel, BorderLayout.CENTER);
		/////////////////////////////////////
		//SOUTH
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		
		JButton btnBack = new JButton("뒤로가기");
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane()));
		JButton btnre = new JButton("처음으로");
		btnre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
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
