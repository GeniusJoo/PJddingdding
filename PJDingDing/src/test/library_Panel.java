package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

//도서관 패널
public class library_Panel extends JPanel{
	
	JFrame mainframe;
	JScrollPane graphScroll;
	
	JButton[] libBk = new JButton[30];//도서관버튼
	JLabel[] label1 = new JLabel[25];// 도서관라벨
	JLabel[] label2 = new JLabel[25];// 상태라벨
	ArrayList<li>[] te = new ArrayList[25]; // 좌석정보 리스트
	loginPanel1 a;
	int b=0;
	
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
		
		JPanel centerPanel = new JPanel(new GridLayout(10,5));//5x5
		
		int i = 0;
		int k = 0;
		int o = 0;
		
		for(int j=0;j<25;j++) {
			li s = new li(j);
			te[j] = new ArrayList<li>();
			te[j].add(s);
		}
		
		while(i<25||k<25) {
			if(o==0) {
				for(int j=0;j<5;j++) {
					label1[i]=new JLabel();
					centerPanel.add(label1[i]);
					i++;
				}
				o=1;
			}else {
				for(int j=0;j<5;j++) {
					label2[k]=new JLabel();
					centerPanel.add(label2[k]);
					k++;
				}
				o=0;
			}
		}
		
		i = 0;
		k = 0;
		
		while(i<=24) {
			label1[i].setText(te[i].get(0).number+"번 좌석");
			label2[i].setText("***");
			i++;
		}

		
		add(centerPanel,BorderLayout.CENTER);
		centerPanel.revalidate();
		
		/////////////////////////////////////
		//SOUTH
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,3));
		
		JButton btnBack = new JButton("뒤로가기");
		JButton btnRe = new JButton("예약하기");
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane()));
		btnRe.addActionListener(new librayPanelListener());
		buttonPanel.add(btnBack);
		buttonPanel.add(btnRe);
		southPanel.add(buttonPanel);
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	class li{
		int number; // 좌석번호
		int name; // 좌석 예약자
		int time; //좌석시간
		int orr; //좌석 예약 완료 
		public li() {}
		public li(int a) {
			number = a+1;
			name = 0;
			time = 0;
			orr =0;
		}
	}
	
	private class librayPanelListener implements ActionListener { //버튼 리스너

		public void actionPerformed(ActionEvent e) {
			
			String name = e.getActionCommand();
			switch(name) {
				case "나가기":
	
					break;
				case"예약하기":
					a = new loginPanel1();
				default:
					break;
					
			}
		}
	}

	public class loginPanel1 extends JFrame {// 로그인 패널
		public int a=0;
		public loginPanel1() {

			Font f1 = new Font("바탕",Font.PLAIN,15);
	   
			JLabel lb1=new JLabel("학생ID:");    
			lb1.setBounds(20,50, 80,30);
			lb1.setFont(f1);
			
			JTextField tf1 = new JTextField();  
			tf1.setBounds(100,50, 100,30);
			tf1.setFont(f1);
			
			JLabel lb3=new JLabel("비밀번호:");    
			lb3.setBounds(20,100, 80,30);
			lb3.setFont(f1);
			
			JPasswordField pw1 = new JPasswordField();   
			pw1.setBounds(100,100,100,30);
			pw1.setFont(f1);
			
			JButton bt1 = new JButton("로그인");    
			bt1.setBounds(100,200, 80,30);    
			bt1.setFont(f1);
			
			setLocationRelativeTo(null);
			
			bt1.addActionListener(new ActionListener() {  
				public void actionPerformed(ActionEvent e) {       
					int i =0;
					if(i==1) {
						JOptionPane.showMessageDialog(null, "로그인성공");
						dispose();
						b=1;
					}else {
						JOptionPane.showMessageDialog(null, "로그인실패");
					}
	             }  
	          });
			
			add(lb1);add(pw1);
			add(tf1);
			add(lb3);add(bt1);
			setTitle("로그인창");
			setSize(320,320);
			setLayout(null);
			setVisible(true);
		}
		
	}
}


