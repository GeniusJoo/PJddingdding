package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
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

//도서관 패널
public class library_Panel extends JPanel{
	
	JFrame mainframe;
	private Connection connection;
	private DBM queries;
	JScrollPane graphScroll;
	
	JButton[] libBk = new JButton[30];//도서관버튼
	JLabel[] label = new JLabel[30];// 도서관라벨
	int[] labelnum=new int[30]; // 예약자 현황 저장
	
	public library_Panel(JFrame mainframe, CardLayout cLayout) {
		this.mainframe= mainframe; 
				
		setLayout(new BorderLayout());
		//////////////////////////////////////////
		// NORTH: menu 메뉴바 테스트 샘플
		Menu menu = new Menu();
		menu.addMenu("User");
		menu.getMenu().setMnemonic(KeyEvent.VK_1);
		menu.addMenuItem("나가기", KeyEvent.VK_E, new librayPanelListener());
		menu.addMenuItem("강의실", KeyEvent.VK_E, new librayPanelListener());
		menu.addMenuItem("도서실", KeyEvent.VK_E, new librayPanelListener());
		menu.addMenuItem("식당", KeyEvent.VK_E, new librayPanelListener());
		menu.addMenuItem("조회", KeyEvent.VK_E, new librayPanelListener());
		menu.finishAddItem();
		add(menu, BorderLayout.NORTH);
		
		////////////////////////////////////
		//CENTER
		
		JPanel centerPanel = new JPanel(new GridLayout(10,6));//5x5
	
		int k=1;
		for(int i=0;i<30;i++) { // 버튼과 예약 라벨 만들기
			libBk[i]=new JButton(""+k);
			libBk[i].addActionListener(new librayPanelListener());
			centerPanel.add(libBk[i]);
			label[i]=new JLabel();
			centerPanel.add(label[i]);
			k++;
			if(labelnum[i]==0) {
				label[i].setText("예약안됨");
			}else {
				label[i].setText("예약됨");
			}
		}
		
	
		add(centerPanel,BorderLayout.CENTER);
		
		/////////////////////////////////////
		//SOUTH
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		
		JButton btnBack = new JButton("뒤로가기");
		JButton btnRe = new JButton("새로고침");
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane()));
		btnRe.addActionListener(new librayPanelListener());
		buttonPanel.add(btnBack);
		buttonPanel.add(btnRe);
		southPanel.add(buttonPanel);
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	private class librayPanelListener implements ActionListener { //버튼 리스너

		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			int i=0;
			switch(name) {
				case "나가기":
					
					break;
				case"새로고침":
					for(int j= 0; j<30;j++) {
						labelnum=null;
						labelnum=new int[30];
						labelnum[j]=queries.lib_se(j+1);
						if(labelnum[j]==0) {
							label[j].setText("예약안됨");
						}else {
							label[j].setText("예약됨");
						}
					}
					break;
				default:
					i=Integer.parseInt(name);
					if(i<31) {
						int b=0;
						loginPanel a = new loginPanel(name);
					}
					break;
					
			}
		}
	}

}
