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

public class loginPanel extends JFrame {// �α��� �г�
	information info = new information(); // ���� �޾ƿ���
	ArrayList<stu>[] st = info.student_info();
	int man=0;
	int cancel =0;
	TreeNode root1=null;
	public loginPanel(int num, TreeNode root) {
		cancel=num;
		root1=root;
		Font f1 = new Font("����",Font.PLAIN,15);
   
		JLabel lb1=new JLabel("�л�ID:");    
		lb1.setBounds(20,50, 80,30);
		lb1.setFont(f1);
		
		JTextField tf1 = new JTextField();  
		tf1.setBounds(100,50, 100,30);
		tf1.setFont(f1);
		
		JLabel lb3=new JLabel("��й�ȣ:");    
		lb3.setBounds(20,100, 80,30);
		lb3.setFont(f1);
		
		JPasswordField pw1 = new JPasswordField();   
		pw1.setBounds(100,100,100,30);
		pw1.setFont(f1);
		
		JButton bt1 = new JButton("�α���");    
		bt1.setBounds(100,200, 80,30);    
		bt1.setFont(f1);
		bt1.setBackground(new Color(230, 230, 255));
		setLocationRelativeTo(null);
		
		bt1.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				int i =0;
				// �α��� �ϴ� ���� �ڷᱸ��
				Binary_search bs = new Binary_search();
				i = bs.BSearch_id(st, Integer.parseInt(tf1.getText())); // ���� Ž������ ã�ƿ���
				if(i==-1) {JOptionPane.showMessageDialog(null, "�α��ν���");} // ���̵� ����
				if(i!=-1) {// -1�� �ƴϸ� ���̵� �ִٴ°�
					String pw=""; // ��й�ȣ ���ص�
					char[] secret_pw = pw1.getPassword();
					for(char cha : secret_pw){ Character.toString(cha); 
						pw += (pw.equals("")) ? ""+cha+"" : ""+cha+""; 
					}
					
					if(st[i].get(0).pass.equals(pw)){ // ��й�ȣ ��
						JOptionPane.showMessageDialog(null, "�α��μ���");
						man=i;
						if(cancel==1) { //���¿� ���� ����� ��ҷ� �̵�
							reservation1 re = new reservation1();
							re.setLocationRelativeTo(null);
						}else {
							can ce = new can();
							ce.setLocationRelativeTo(null);
						}
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "�α��ν���");
					}
				}else {
					JOptionPane.showMessageDialog(null, "�α��ν���");
				}
             }  
          });
		
		add(lb1);add(pw1);
		add(tf1);
		add(lb3);add(bt1);
		setTitle("�α���â");
		setSize(320,320);
		setLayout(null);
		setVisible(true);
		}
	
	public class reservation1 extends JFrame {
		public reservation1(){
			
			Font f1 = new Font("����",Font.PLAIN,15);
			
			JLabel lb1=new JLabel("�¼�");    
			lb1.setBounds(20,50, 80,30);
			lb1.setFont(f1);
			
			Choice ch1 = new Choice(); // ���� �ڸ� ���̽�
			String[] b =root1.nodeString();
			//System.out.println(Arrays.toString(b));
			for(int i=0;i<b.length;i++) {
				if(b[i].startsWith("Y"))
					ch1.add(b[i]);
				
			}
			ch1.setBounds(100,50, 100,100);
			

			JLabel lb2=new JLabel("�ð�");    
			lb2.setBounds(20,100, 80,30);
			lb2.setFont(f1);
			
			Choice ch2 = new Choice(); // ���� �ð� ���̽�
			ch2.add("00:30");
			ch2.add("01:00");
			ch2.add("01:30");
			ch2.add("02:00");
			ch2.add("02:30");
			ch2.add("03:00");
			ch2.setBounds(100,100,100,100);
			
			JButton bt2 = new JButton("����");
			bt2.setBackground(new Color(230, 230, 255));
			bt2.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) { // ���� �ϱ�
					String k =ch1.getSelectedItem();
					String l =ch2.getSelectedItem();
					
					TreeNode A = root1.findnode(k);
					String[] B=A.getleafnode();
					if(B[3].equals(" ")){
						if(st[man].get(0).clorr!="") {
							JOptionPane.showMessageDialog(null, "�̹̿����ϼ̽��ϴ�.");
							dispose();
						}else {
							ArrayList<String> list = new ArrayList<>(Arrays.asList(B));
							list.remove(3);
							list.remove(3);
							list.add("�����");
							list.add(l);
							int arrListSize = list.size();
							B = list.toArray(new String[arrListSize]);
							A.setleafnode(Arrays.toString(B));
							info.updateTree(root1);
							st[man].get(0).clorr=A.getNodeName();
							info.updateStu(man, st[man]);
							JOptionPane.showMessageDialog(null, "����Ǿ����ϴ�.");
							dispose();
						}
					}else{
						JOptionPane.showMessageDialog(null, "����� ���ǽ��Դϴ�.");
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
			setTitle("����â");
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
				JOptionPane.showMessageDialog(null, "������ �׸��� �����ϴ�.");
				dispose();
			}
			JLabel lb1=new JLabel("������:"+st[man].get(0).name);
			lb1.setBounds(20,50, 80,30);
			JLabel lb2=new JLabel("���ǽ�");
			lb2.setBounds(20,100, 80,30);
			JLabel lb3 = new JLabel("����Ͻðڽ��ϱ�?");
			lb3.setBounds(120,150, 120,30);
			JButton bt1 = new JButton("�������");
			bt1.setBounds(50,200, 90,30);  
			JButton bt2 = new JButton("������");
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
			
			
			setTitle("�������");
			setSize(320,320);
			setLayout(null);
			setLocationRelativeTo(null);
			setVisible(true);
			}
			}
		}


	
