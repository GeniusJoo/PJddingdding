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

//���ǽ� �г�
public class classroom_Panel extends JPanel{
	
	JFrame mainframe;
	JScrollPane graphScroll;
	CardLayout cLayout;
	information info = new information();
	JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
	TreeNode root = info.Tree(); // Ʈ�� root
	TreeNode building[] = new TreeNode[root.getChildNodeArray().size()];// ��ü �ǹ�
	JButton bt[]=new JButton[root.getChildNodeArray().size()];// ��ü�ǹ� ��ư
	TreeNode eb5[];// 5���а�
	JButton bt1[];// 5���а� ��ư
	
	public classroom_Panel(JFrame mainframe, CardLayout cLayout) {
		this.mainframe= mainframe;
		this.cLayout=cLayout;
		setLayout(new BorderLayout());
		//////////////////////////////////////////
		// NORTH: menu �޴��� �׽�Ʈ ����
		Menu menu = new Menu();
		menu.addMenu("User");
		menu.getMenu().setMnemonic(KeyEvent.VK_1);
		menu.addMenuItem("������", KeyEvent.VK_E, new classroomlListener());
		menu.addMenuItem("������", KeyEvent.VK_E, new classroomlListener());
		menu.addMenuItem("�Ĵ�", KeyEvent.VK_E, new classroomlListener());
		menu.addMenuItem("��ȸ", KeyEvent.VK_E, new classroomlListener());
		menu.finishAddItem();
		add(menu, BorderLayout.NORTH);
		
		////////////////////////////////////
		//CENTER
		//////Ʈ�������///////
		//�б�(root) -> �ǹ� -> �� -> ���ǽ� ���ǽ�����
		//�б� �ǹ� �� ���ǽ� ����
		//���ǽ� ���� �α��� 
		
		
		 // �ǹ� ��ü ����
		for(int i=0 ; i<root.getChildNodeArray().size() ; i++) { // ��ü �ǹ� ���� ����
			building[i]=root.getChildNodeArray().get(i);
		}
		for(int i =0; i<root.getChildNodeArray().size();i++) { // ��ü �ǹ� ��ư ����
			bt[i]= new JButton(root.getChildNodeArray().get(i).getNodeName());
			centerPanel.add(bt[i]);
		}
		
		eb5=new TreeNode[building[0].getChildNodeArray().size()]; // 5���а� Ʈ��
		bt1=new JButton[building[0].getChildNodeArray().size()]; // 5���а� ��ư ũ��
		
		eb5=info.reTree(building, 0); //���� ����
		bt1=info.reButton(building, 0); // ��ư �����
		
		for(int i =0; i<eb5.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			centerPanel.add(bt1[i]);
			bt1[i].setVisible(false);
		}
		
		bt[0].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				for(int i =0; i<eb5.length;i++) {
					bt1[i].setVisible(true);
				}
				for(int i =0; i<building.length;i++) {
					bt[i].setVisible(false);
				}
			}
		});
		root.searchAllTreeNode();
		
		add(centerPanel, BorderLayout.CENTER);
		/////////////////////////////////////
		//SOUTH
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		
		JButton btnBack = new JButton("�ڷΰ���");
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane()));
		JButton btnre = new JButton("Re");
		btnre.addActionListener(new classroomlListener());
		buttonPanel.add(btnBack);
		buttonPanel.add(btnre);
		southPanel.add(buttonPanel);
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
	}
	
	private class classroomlListener implements ActionListener { //��ư ������
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			switch(name) {
			case "������":
				cLayout.show(mainframe.getContentPane(), "main");
				
				break;	
			case "������":
				cLayout.show(mainframe.getContentPane(), "library");
				break;
			case "��ȸ":
				cLayout.show(mainframe.getContentPane(), "search");
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
