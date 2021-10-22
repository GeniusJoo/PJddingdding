package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

//강의실 패널
public class classroom_Panel extends JPanel{
	
	JFrame mainframe;
	JScrollPane graphScroll;

	public classroom_Panel(JFrame mainframe, CardLayout cLayout) {
		this.mainframe= mainframe; 		
		setLayout(new BorderLayout());
		//////////////////////////////////////////
		// NORTH: menu 메뉴바 테스트 샘플
		Menu menu = new Menu();
		menu.addMenu("User");
		menu.getMenu().setMnemonic(KeyEvent.VK_1);
		menu.addMenuItem("나가기", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("강의실", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("도서실", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("식당", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("조회", KeyEvent.VK_E, new UserPanelListener());
		menu.finishAddItem();
		add(menu, BorderLayout.NORTH);
		
		////////////////////////////////////
		//CENTER
		
				
		
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
	
	private class UserPanelListener implements ActionListener { //버튼 리스너
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			switch(name) {
				case "exit":
					
					break;
			}
		}
	}
}
