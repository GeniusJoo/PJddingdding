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

//������ �г�
public class library_Panel extends JPanel{
	
	JFrame mainframe;
	JScrollPane graphScroll;
	
	JButton[] libBk = new JButton[30];//��������ư
	JLabel[] label1 = new JLabel[25];// ��������
	JLabel[] label2 = new JLabel[25];// ���¶�
	ArrayList<li>[] te = new ArrayList[25]; // �¼����� ����Ʈ
	loginPanel1 a;
	int b=0;
	
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
		menu.addMenuItem("������", KeyEvent.VK_E, new librayPanelListener());
		menu.addMenuItem("�Ĵ�", KeyEvent.VK_E, new librayPanelListener());
		menu.addMenuItem("��ȸ", KeyEvent.VK_E, new librayPanelListener());
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
			label1[i].setText(te[i].get(0).number+"�� �¼�");
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
	
	class li{
		int number; // �¼���ȣ
		int name; // �¼� ������
		int time; //�¼��ð�
		int orr; //�¼� ���� �Ϸ� 
		public li() {}
		public li(int a) {
			number = a+1;
			name = 0;
			time = 0;
			orr =0;
		}
	}
	
	private class librayPanelListener implements ActionListener { //��ư ������

		public void actionPerformed(ActionEvent e) {
			
			String name = e.getActionCommand();
			switch(name) {
				case "������":
	
					break;
				case"�����ϱ�":
					a = new loginPanel1();
				default:
					break;
					
			}
		}
	}

	public class loginPanel1 extends JFrame {// �α��� �г�
		public int a=0;
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
					if(i==1) {
						JOptionPane.showMessageDialog(null, "�α��μ���");
						dispose();
						b=1;
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
}


