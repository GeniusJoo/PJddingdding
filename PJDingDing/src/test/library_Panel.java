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

//������ �г�
public class library_Panel extends JPanel{
	
	JFrame mainframe;
	JScrollPane graphScroll;
	
	JButton[] libBk = new JButton[30];//��������ư
	JLabel[] label1 = new JLabel[25];// ��������
	JLabel[] label2 = new JLabel[25];// ���¶�
	information info = new information(); // ���� �޾ƿ���
	ArrayList<lib>[] lt = info.library_info(); // �¼����� ����Ʈ
	ArrayList<stu>[] st = info.student_info(); // �л�����
	loginPanel1 login; // �α��� �г�
	int man; // ������ �ӽ�����
	
	public library_Panel(JFrame mainframe, CardLayout cLayout) {
		this.mainframe= mainframe; 
				
		setLayout(new BorderLayout());
		//////////////////////////////////////////
		// NORTH: menu �޴��� �׽�Ʈ ����
		Menu menu = new Menu();
		menu.addMenu("User");
		menu.getMenu().setMnemonic(KeyEvent.VK_1);
		menu.addMenuItem("������", KeyEvent.VK_E, new librayPanelListener());
		menu.addMenuItem("���ǽ�", KeyEvent.VK_E, new librayPanelListener());
		menu.addMenuItem("�Ĵ�", KeyEvent.VK_E, new librayPanelListener());
		menu.addMenuItem("��ȸ", KeyEvent.VK_E, new librayPanelListener());
		menu.finishAddItem();
		add(menu, BorderLayout.NORTH);
		
		////////////////////////////////////
		//CENTER
		JPanel centerPanel = new JPanel(new GridLayout(10,5));//10x5
		
		int i = 0;
		int k = 0;
		int o = 0;
		
		while(i<25||k<25) {//�����ư��鼭 �� �ۼ�
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
		
		while(i<=24) { // �� ���̱� 
			label1[i].setText(lt[i].get(0).number+"�� �¼�");
			label2[i].setText("***");
			i++;
		}

		
		add(centerPanel,BorderLayout.CENTER);
		centerPanel.revalidate();
		
		/////////////////////////////////////
		//SOUTH
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,3));
		
		JButton btnBack = new JButton("�ڷΰ���");
		JButton btnRe = new JButton("�����ϱ�");
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane()));
		btnRe.addActionListener(new librayPanelListener());
		buttonPanel.add(btnBack);
		buttonPanel.add(btnRe);
		southPanel.add(buttonPanel);
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	
	private class librayPanelListener implements ActionListener { //��ư ������
		
		public void actionPerformed(ActionEvent e) {
			
			String name = e.getActionCommand();
			switch(name) {
				case"�����ϱ�":
					login = new loginPanel1();
				case"������":
					
					break;
				case"���ǽ�":
					break;
				case"�Ĵ�":
					break;
				case"��ȸ":
					break;
				default:
					break;
					
			}
		}
	}

	public class loginPanel1 extends JFrame {// �α��� �г�

		public loginPanel1() {

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
			
			setLocationRelativeTo(null);
			
			bt1.addActionListener(new ActionListener() {  
				public void actionPerformed(ActionEvent e) {       
					int i =0;
					// �α��� �ϴ� ���� �ڷᱸ��
					Binary_search bs = new Binary_search();
					i = bs.BSearch_id(st, Integer.parseInt(tf1.getText())); // ���� Ž������ ã�ƿ���
					System.out.println(st[i].get(0).number);
					System.out.println(st[i].get(0).pass);
					if(i!=-1) {// -1�� �ƴϸ� ���̵� �ִٴ°�
						
						String pw=""; // ��й�ȣ ���ص�
						char[] secret_pw = pw1.getPassword();
						for(char cha : secret_pw){ Character.toString(cha); 
							pw += (pw.equals("")) ? ""+cha+"" : ""+cha+""; 
						}
						System.out.println(pw);
						
						if(st[i].get(0).pass.equals(pw)){ // ��й�ȣ ��
							JOptionPane.showMessageDialog(null, "�α��μ���");
							man=i;
							reservation re = new reservation();
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
		
	}
	
	public class reservation extends JFrame { // ����â
		public reservation(){
			
			Font f1 = new Font("����",Font.PLAIN,15);
			
			JLabel lb1=new JLabel("�¼�");    
			lb1.setBounds(20,50, 80,30);
			lb1.setFont(f1);
			
			Choice ch1 = new Choice(); // ���� �ڸ� ���̽�
			for(int i = 0; i<25 ;i++) {
				if(lt[i].get(0).orr==0){
					ch1.add(lt[i].get(0).number+"");
				}else {
					ch1.add("�����");
				}
			}
			ch1.setBounds(100,50, 100,30);
			

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
			ch2.setBounds(100,100,100,30);
			
			JButton bt2 = new JButton("����");
			
			bt2.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) { // ���� �ϱ�
					String k =ch1.getSelectedItem();
					String l =ch2.getSelectedItem();
					int a=Integer.parseInt(k);
					a=a-1;
					
					if(lt[a].get(0).orr!=1) {
						if(st[man].get(0).orr!=1) { // �ߺ����� ����
							label2[a].setText(st[man].get(0).name+"  "+ l);
							st[man].get(0).orr=1;
							lt[a].get(0).orr=1;
						}else {
							JOptionPane.showMessageDialog(null, "�̹� ���� �ϼ̽��ϴ�");
							dispose();
						}
					}else {
						JOptionPane.showMessageDialog(null, "����� �¼��Դϴ�.");
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
	
	
}


