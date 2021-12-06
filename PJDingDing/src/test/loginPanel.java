package test;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import test.information.stu;
import test.library_Panel.cancel;
import test.library_Panel.reservation;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class loginPanel extends JFrame {// 로그인 패널
	information info = new information(); // 정보 받아오기
	ArrayList<stu>[] st = info.student_info();
	int man=0;
	int cancel =0;
	TreeNode root1=null;
	public loginPanel(int num, TreeNode root) {
		cancel=num;
		root1=root;
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
		bt1.setBackground(new Color(230, 230, 255));
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
						if(cancel==1) { //상태에 따라 예약과 취소로 이동
							reservation1 re = new reservation1();
							re.setLocationRelativeTo(null);
						}else {
							can ce = new can();
							ce.setLocationRelativeTo(null);
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
	
	public class reservation1 extends JFrame {
		public reservation1(){
			
			Font f1 = new Font("바탕",Font.PLAIN,15);
			
			JLabel lb1=new JLabel("좌석");    
			lb1.setBounds(20,50, 80,30);
			lb1.setFont(f1);
			
			Choice ch1 = new Choice(); // 예약 자리 초이스
			String[] b =root1.nodeString();
			//System.out.println(Arrays.toString(b));
			for(int i=0;i<b.length;i++) {
				if(b[i].startsWith("Y"))
					ch1.add(b[i]);
				
			}
			ch1.setBounds(100,50, 100,100);
			

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
			ch2.setBounds(100,100,100,100);
			
			JButton bt2 = new JButton("예약");
			bt2.setBackground(new Color(230, 230, 255));
			bt2.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) { // 예약 하기
					String k =ch1.getSelectedItem();
					String l =ch2.getSelectedItem();
					
					TreeNode A = root1.findnode(k);
					String[] B=A.getleafnode();
					if(B[3].equals(" ")){
						if(st[man].get(0).clorr!="") {
							JOptionPane.showMessageDialog(null, "이미예약하셨습니다.");
							dispose();
						}else {
							ArrayList<String> list = new ArrayList<>(Arrays.asList(B));
							list.remove(3);
							list.remove(3);
							list.add("예약됨");
							list.add(l);
							int arrListSize = list.size();
							B = list.toArray(new String[arrListSize]);
							A.setleafnode(Arrays.toString(B));
							info.updateTree(root1);
							st[man].get(0).clorr=A.getNodeName();
							info.updateStu(man, st[man]);
							JOptionPane.showMessageDialog(null, "예약되었습니다.");
							dispose();
						}
					}else{
						JOptionPane.showMessageDialog(null, "예약된 강의실입니다.");
						dispose();
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
	
	class can extends JFrame {
		
		public can() {
			String lt1 = st[man].get(0).clorr;
			System.out.println(st[man].get(0).clorr);
			if(lt1==""){
				JOptionPane.showMessageDialog(null, "예약한 항목이 없습니다.");
				dispose();
			}
			JLabel lb1=new JLabel("예약자:"+st[man].get(0).name);
			lb1.setBounds(20,50, 80,30);
			JLabel lb2=new JLabel("강의실");
			lb2.setBounds(20,100, 80,30);
			JLabel lb3 = new JLabel("취소하시겠습니까?");
			lb3.setBounds(120,150, 120,30);
			JButton bt1 = new JButton("예약취소");
			bt1.setBounds(50,200, 90,30);  
			JButton bt2 = new JButton("나가기");
			bt2.setBounds(160,200, 90,30);  
			
			bt1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
						String name = st[man].get(0).clorr;
						TreeNode A = root1.findnode(name);
						String[] B = A.getleafnode();
						ArrayList<String> list = new ArrayList<String>();
						for(int i = 0; i<3 ; i++) {
							list.add(B[i]);
						}
						for(int i =0 ; i<2 ; i++) {
							list.add(" ");
						}
						int arrListSize = list.size();
						B = list.toArray(new String[arrListSize]);
						A.setleafnode(Arrays.toString(B));
						info.updateTree(root1);
						st[man].get(0).clorr="";
						info.updateStu(man, st[man]);
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
			
			
			setTitle("예약취소");
			setSize(320,320);
			setLayout(null);
			setLocationRelativeTo(null);
			setVisible(true);
			}
			}
		}


	
