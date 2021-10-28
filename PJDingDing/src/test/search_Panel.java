package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.SpringLayout;
// ��ȸ�� �г�

class search_Panel extends JPanel {
	JFrame mainframe;
	JScrollPane graphScroll;
	JTextField tf1 = new JTextField(15);
	CardLayout cLayout;
	public search_Panel(JFrame mainframe, CardLayout cLayout) {
		
		this.mainframe= mainframe; 
		this.cLayout=cLayout;
		setLayout(new BorderLayout());
		//////////////////////////////////////////
		
		//�˻�â
				
		///////////////////////////////////////////
		// NORTH: menu �޴��� �׽�Ʈ ����
		Menu menu = new Menu();
		menu.addMenu("User");
		menu.getMenu().setMnemonic(KeyEvent.VK_1);
		menu.addMenuItem("������", KeyEvent.VK_E, new searchPanelListener());
		menu.addMenuItem("���ǽ�", KeyEvent.VK_E, new searchPanelListener());
		menu.addMenuItem("������", KeyEvent.VK_E, new searchPanelListener());
		menu.addMenuItem("�Ĵ�", KeyEvent.VK_E, new searchPanelListener());
		menu.addMenuItem("��ȸ", KeyEvent.VK_E, new searchPanelListener());
		menu.finishAddItem();
		add(menu, BorderLayout.NORTH);
		
		///////////////////////
		//CENTER
		JPanel centerPanel = new JPanel();
		
		add(centerPanel,BorderLayout.CENTER);
		centerPanel.revalidate();
		///////////////
		///SOUTH
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,3));
		JButton btnBack = new JButton("�ڷΰ���");// �ڷΰ���
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane())); // �ڷΰ��� �̺�Ʈ
		JTextField tf1 = new JTextField(15);// �Է�â 
		JButton btnRe = new JButton("ã��"); // ã���ư
		btnRe.addActionListener(new searchPanelListener());// ã�� �̺�Ʈ
		
		buttonPanel.add(btnBack);
		buttonPanel.add(tf1);
		buttonPanel.add(btnRe);
		southPanel.add(buttonPanel);
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
	}
	
	private class searchPanelListener implements ActionListener { //��ư ������
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			String search = tf1.getText();
			
			switch (name) {
			case "ã��":
				// Ʈ�� Ž�� ���� �ҷ�����
				
				break;
			case "������":
				cLayout.show(mainframe.getContentPane(), "main");
				break;	
			case "���ǽ�":
				cLayout.show(mainframe.getContentPane(), "classroom");
				break;
			case "������":
				cLayout.show(mainframe.getContentPane(), "library");
				break;
			case "�Ĵ�":
				cLayout.show(mainframe.getContentPane(), "cafeteria");
				break;
			default:
				break;
			}
			
		}
	}
}
