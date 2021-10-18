package test;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

import javax.swing.JButton;

public class loginPanel extends JFrame {// 로그인 패널
	private Connection connection;
	private DBM queries;
	private int a=0;
	private String c="";
	
	public loginPanel(String name) {

		Font f1 = new Font("바탕",Font.PLAIN,15);
		
		JLabel lb1 = new JLabel("시간(시분):");            
		lb1.setBounds(20,150, 80,30);  
		lb1.setFont(f1);
   
		JLabel lb2=new JLabel("UserID:");    
		lb2.setBounds(20,50, 80,30);
		lb2.setFont(f1);
		
		JTextField tf1 = new JTextField();  
		tf1.setBounds(100,50, 100,30);
		tf1.setFont(f1);
		
		JTextField tf2 = new JTextField();  
		tf2.setBounds(100,150, 100,30);
		tf2.setFont(f1);
		
		JLabel lb3=new JLabel("Password:");    
		lb3.setBounds(20,100, 80,30);
		lb3.setFont(f1);
		
		JPasswordField pw1 = new JPasswordField();   
		pw1.setBounds(100,100,100,30);
		pw1.setFont(f1);
		
		JButton bt1 = new JButton("Login");    
		bt1.setBounds(100,200, 80,30);    
		bt1.setFont(f1);
		
		setLocationRelativeTo(null);
		
		bt1.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {       
				DBM d = new DBM(connection);
				int i = d.login(tf1.getText(), new String(pw1.getPassword()));
				if(i==1) {
					JOptionPane.showMessageDialog(null, "로그인성공");
					dispose();
					a=1;
					c=tf2.getText();
					queries.lib_ap(tf1.getText(),tf2.getText(),name);
				}else {
					JOptionPane.showMessageDialog(null, "로그인실패");
				}
             }  
          });

		add(lb1);add(pw1);
		add(lb2);add(tf1);
		add(lb3);add(bt1);
		add(tf2);
		setTitle("로그인창");
		setSize(320,320);
		setLayout(null);
		setVisible(true);
	
	}
	
	public int re() {
		int b=a;
		return b;
	}
	
	public String time() {
		return c;
	}

}
