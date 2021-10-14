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
	
	public library_Panel(JFrame mainframe, CardLayout cLayout, Connection conn, DBM queries) {
		this.mainframe= mainframe; 
		this.connection = conn;
		this.queries = queries;
				
		setLayout(new BorderLayout());
		//////////////////////////////////////////
		// NORTH: menu 메뉴바 테스트 샘플
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
		
		JButton btnBack = new JButton("뒤로가기");
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane()));
		buttonPanel.add(btnBack);
		southPanel.add(buttonPanel);
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	private class librayPanelListener implements ActionListener { //버튼 리스너

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
