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

//������ �г�
public class library_Panel extends JPanel{
	
	JFrame mainframe;
	private Connection connection;
	private DBM queries;
	JScrollPane graphScroll;
	
	JButton[] libBk = new JButton[30];//��������ư
	JLabel[] label = new JLabel[30];// ��������
	
	public library_Panel(JFrame mainframe, CardLayout cLayout, Connection conn, DBM queries) {
		this.mainframe= mainframe; 
		this.connection = conn;
		this.queries = queries;
				
		setLayout(new BorderLayout());
		//////////////////////////////////////////
		// NORTH: menu �޴��� �׽�Ʈ ����
		Menu menu = new Menu();
		menu.addMenu("User");
		menu.getMenu().setMnemonic(KeyEvent.VK_1);
		menu.addMenuItem("exit", KeyEvent.VK_E, new librayPanelListener());
		menu.finishAddItem();
		
		////////////////////////////////////
		//CENTER
		
		JPanel centerPanel = new JPanel(new GridLayout(10,6));//5x5
		
		List<String> labelnum;

		int k=1;
		for(int i=0;i<30;i++) {
			libBk[i]=new JButton(""+k);
			libBk[i].addActionListener(new librayPanelListener());
			centerPanel.add(libBk[i]);
			label[i]=new JLabel();
			centerPanel.add(label[i]);
			k++;
		}
		k=29;

		add(centerPanel,BorderLayout.CENTER);
		
		/////////////////////////////////////
		//SOUTH
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		
		JButton btnBack = new JButton("�ڷΰ���");
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane()));
		buttonPanel.add(btnBack);
		southPanel.add(buttonPanel);
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	private class librayPanelListener implements ActionListener { //��ư ������

		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			int i =Integer.parseInt(name);
			switch(name) {
				case "exit":
					break;
			}
			if(i<26) {
				int b=0;
				loginPanel a = new loginPanel(connection, queries, name);
			}

		}
	}

}
