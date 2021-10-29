package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Choice;
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
import test.information.lib;
import test.information.stu;

//도서관 패널
public class library_Panel extends JPanel{
	
	JFrame mainframe;
	JScrollPane graphScroll;
	CardLayout cLayout;
	
	JButton[] libBk = new JButton[30];//도서관버튼
	JLabel[] label1 = new JLabel[25];// 도서관라벨
	JLabel[] label2 = new JLabel[25];// 상태라벨
	information info = new information(); // 정보 받아오기
	ArrayList<lib>[] lt = info.library_info(); // 좌석정보 리스트
	ArrayList<stu>[] st = info.student_info(); // 학생정보
	loginPanel1 login; // 로그인 패널
	int man; // 예약자 임시저장
	int canor=0; // 예약 or 취소
	
	public library_Panel(JFrame mainframe, CardLayout cLayout) {
		this.mainframe= mainframe; 
		this.cLayout = cLayout;		
		setLayout(new BorderLayout());
		//////////////////////////////////////////
		// NORTH: menu 메뉴바 테스트 샘플
		Menu menu = new Menu();
		menu.addMenu("User");
		menu.getMenu().setMnemonic(KeyEvent.VK_1);
		menu.addMenuItem("나가기", KeyEvent.VK_E, new librayPanelListener());
		menu.addMenuItem("강의실", KeyEvent.VK_E, new librayPanelListener());
		menu.addMenuItem("식당", KeyEvent.VK_E, new librayPanelListener());
		menu.addMenuItem("조회", KeyEvent.VK_E, new librayPanelListener());
		menu.finishAddItem();
		add(menu, BorderLayout.NORTH);
		
		////////////////////////////////////
		//CENTER
		JPanel centerPanel = new JPanel(new GridLayout(10,5));//10x5
		
		int i = 0;
		int k = 0;
		int o = 0;
		
		while(i<25||k<25) {//번갈아가면서 라벨 작성
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
		
		while(i<=24) { // 라벨 붙이기 
			label1[i].setText(lt[i].get(0).number+"번 좌석");
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
		JButton btnce = new JButton("예약취소");
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane()));
		btnRe.addActionListener(new librayPanelListener());
		btnce.addActionListener(new librayPanelListener());
		buttonPanel.add(btnBack);
		buttonPanel.add(btnRe);
		buttonPanel.add(btnce);
		southPanel.add(buttonPanel);
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	
	private class librayPanelListener implements ActionListener { //버튼 리스너
		
		public void actionPerformed(ActionEvent e) {
			
			String name = e.getActionCommand();
			switch(name) {
				case"예약하기":
					canor=0;
					login = new loginPanel1();
					break;
				case"예약취소":
					canor=1;
					login = new loginPanel1();
					break;
				case "나가기":
					cLayout.show(mainframe.getContentPane(), "main");
					break;	
				case "강의실":
					cLayout.show(mainframe.getContentPane(), "classroom");
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

	public class loginPanel1 extends JFrame {// 로그인 패널

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
					// 로그인 하는 것을 자료구조
					Binary_search bs = new Binary_search();
					i = bs.BSearch_id(st, Integer.parseInt(tf1.getText())); // 이진 탐색으로 찾아오기
					if(i==-1) {JOptionPane.showMessageDialog(null, "로그인실패");} // 아이디 없음
					if(i!=-1) {// -1이 아니면 아이디가 있다는것
						String pw=""; // 비밀번호 재해독
						char[] secret_pw = pw1.getPassword();
						for(char cha : secret_pw){ Character.toString(cha); 
							pw += (pw.equals("")) ? ""+cha+"" : ""+cha+""; 
						}
						
						if(st[i].get(0).pass.equals(pw)){ // 비밀번호 비교
							JOptionPane.showMessageDialog(null, "로그인성공");
							man=i;
							if(canor==0) { //상태에 따라 예약과 취소로 이동
								reservation re = new reservation();
							}else {
								cancel ce = new cancel();
							}
							dispose();
							
						}else {
							JOptionPane.showMessageDialog(null, "로그인실패");
						}
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
	
	public class reservation extends JFrame { // 예약창
		public reservation(){
			
			Font f1 = new Font("바탕",Font.PLAIN,15);
			
			JLabel lb1=new JLabel("좌석");    
			lb1.setBounds(20,50, 80,30);
			lb1.setFont(f1);
			
			Choice ch1 = new Choice(); // 예약 자리 초이스
			for(int i = 0; i<25 ;i++) {
				if(lt[i].get(0).orr==0){
					ch1.add(lt[i].get(0).number+"");
				}else {
					ch1.add("예약됨");
				}
			}
			ch1.setBounds(100,50, 100,30);
			

			JLabel lb2=new JLabel("시간");    
			lb2.setBounds(20,100, 80,30);
			lb2.setFont(f1);
			
			Choice ch2 = new Choice(); // 예약 시간 초이스
			ch2.add("00:30");
			ch2.add("01:00");
			ch2.add("01:30");
			ch2.add("02:00");
			ch2.add("02:30");
			ch2.add("03:00");
			ch2.setBounds(100,100,100,30);
			
			JButton bt2 = new JButton("예약");
			
			bt2.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) { // 예약 하기
					String k =ch1.getSelectedItem();
					String l =ch2.getSelectedItem();
					int a=Integer.parseInt(k);
					a=a-1;
					
					if(lt[a].get(0).orr!=-1) {
						if(st[man].get(0).orr==30) { // 중복예약 선별
							label2[a].setText(st[man].get(0).name+"  "+ l);
							st[man].get(0).orr=a;
							lt[a].get(0).orr=st[man].get(0).number;
							man=0;
						}else {
							JOptionPane.showMessageDialog(null, "이미 예약 하셨습니다");
							dispose();
						}
					}else {
						JOptionPane.showMessageDialog(null, "예약된 좌석입니다.");
					}
				}
				
			});
			bt2.setBounds(100,200, 80,30);  
			
			add(lb1);
			add(lb2);
			add(ch1);
			add(ch2);
			add(bt2);
			setLocationRelativeTo(null);
			setTitle("예약창");
			setSize(320,320);
			setLayout(null);
			setVisible(true);
		}
	}
	
	public class cancel extends JFrame{ // 예약 취소
		public cancel() {
			int man1 = man;
			int lt1 = st[man1].get(0).orr;
			if(lt1==30){
				JOptionPane.showMessageDialog(null, "예약한 항목이 없습니다.");
				dispose();}
			
			JLabel lb1=new JLabel("예약자:"+st[man].get(0).name);
			lb1.setBounds(20,50, 80,30);
			JLabel lb2=new JLabel("좌석:"+lt[lt1].get(0).number);
			lb2.setBounds(20,100, 80,30);
			JLabel lb3 = new JLabel("취소하시겠습니까?");
			lb3.setBounds(120,150, 120,30);
			JButton bt1 = new JButton("예약취소");
			bt1.setBounds(50,200, 90,30);  
			JButton bt2 = new JButton("나가기");
			bt2.setBounds(160,200, 90,30);  
			
			bt1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					st[man].get(0).orr=30;
					lt[lt1].get(0).orr=-1;
					man=0;
					label2[lt1].setText("***");
					JOptionPane.showMessageDialog(null, "취소되었습니다.");
					dispose();
				}
			});
			
			bt2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
			add(lb1);
			add(lb2);
			add(lb3);
			add(bt1);
			add(bt2);
			
			setLocationRelativeTo(null);
			setTitle("예약취소");
			setSize(320,320);
			setLayout(null);
			setVisible(true);
		}
	}
	
}


