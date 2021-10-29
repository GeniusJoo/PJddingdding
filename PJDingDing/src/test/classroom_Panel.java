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
import java.util.EventListener;
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
	TreeNode eb5_1[];// 5��1��
	JButton bt1_1[];// 5��1����ư
	TreeNode eb5_2[];// 5��2��
	JButton bt1_2[];// 5��2����ư
	TreeNode eb5_3[];// 5��3��
	JButton bt1_3[];// 5��3����ư
	
	TreeNode eb1[];// 1���а�
	JButton bt2[];// 1���а� ��ư
	TreeNode eb1_1[];// 1���а� 1��
	JButton bt2_1[];// 1���а� 1�� ��ư
	TreeNode eb1_2[];// 1���а� 2��
	JButton bt2_2[];// 1���а� 2�� ��ư
	TreeNode eb1_3[];// 1���а� 3��
	JButton bt2_3[];// 1���а� 3�� ��ư
	
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
		//5��
		eb5=new TreeNode[building[0].getChildNodeArray().size()]; // 5���а� Ʈ��
		bt1=new JButton[building[0].getChildNodeArray().size()]; // 5���а� ��ư ũ��
		eb5=info.reTree(building, 0); //���� ����
		bt1=info.reButton(building, 0); // ��ư �����
		for(int i =0; i<eb5.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			centerPanel.add(bt1[i]);
			bt1[i].setVisible(false);
		}
		
		//5�� 1��
		eb5_1 = new TreeNode[eb5[0].getChildNodeArray().size()];
		bt1_1 = new JButton[eb5[0].getChildNodeArray().size()];
		eb5_1=info.reTree(eb5, 0); //���� ����
		bt1_1=info.reButton(eb5, 0); // ��ư �����
		for(int i =0; i<eb5_1.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			centerPanel.add(bt1_1[i]);
			bt1_1[i].setVisible(false);
		}
		
		//5�� 2��
		eb5_2 = new TreeNode[eb5[1].getChildNodeArray().size()];
		bt1_2 = new JButton[eb5[1].getChildNodeArray().size()];
		eb5_2=info.reTree(eb5, 1); //���� ����
		bt1_2=info.reButton(eb5, 1); // ��ư �����
		for(int i =0; i<eb5_2.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			centerPanel.add(bt1_2[i]);
			bt1_2[i].setVisible(false);
		}
		
		//5�� 3��
		eb5_3 = new TreeNode[eb5[2].getChildNodeArray().size()];
		bt1_3 = new JButton[eb5[2].getChildNodeArray().size()];
		eb5_3=info.reTree(eb5, 2); //���� ����
		bt1_3=info.reButton(eb5, 2); // ��ư �����
		for(int i =0; i<eb5_3.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			centerPanel.add(bt1_3[i]);
			bt1_3[i].setVisible(false);
		}
		
		//1��
		eb1=new TreeNode[building[1].getChildNodeArray().size()]; // 1���а� Ʈ��
		bt2=new JButton[building[1].getChildNodeArray().size()]; // 1���а� ��ư ũ��
		eb1=info.reTree(building, 1); //���� ����
		bt2=info.reButton(building, 1); // ��ư �����
		for(int i =0; i<eb1.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			centerPanel.add(bt2[i]);
			bt2[i].setVisible(false);
		}
		
		//1�� 1��
		eb1_1 = new TreeNode[eb1[0].getChildNodeArray().size()];
		bt2_1 = new JButton[eb1[0].getChildNodeArray().size()];
		eb1_1=info.reTree(eb1, 0); //���� ����
		bt2_1=info.reButton(eb1, 0); // ��ư �����
		for(int i =0; i<eb1_1.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			centerPanel.add(bt2_1[i]);
			bt2_1[i].setVisible(false);
		}
		
		//1�� 2��
		eb1_2 = new TreeNode[eb1[1].getChildNodeArray().size()];
		bt2_2 = new JButton[eb1[1].getChildNodeArray().size()];
		eb1_2=info.reTree(eb1, 1); //���� ����
		bt2_2=info.reButton(eb1, 1); // ��ư �����
		for(int i =0; i<eb1_2.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			centerPanel.add(bt2_2[i]);
			bt2_2[i].setVisible(false);
		}
		
		//1�� 3��
		eb1_3 = new TreeNode[eb1[2].getChildNodeArray().size()];
		bt2_3 = new JButton[eb1[2].getChildNodeArray().size()];
		eb1_3=info.reTree(eb1, 2); //���� ����
		bt2_3=info.reButton(eb1, 2); // ��ư �����
		for(int i =0; i<eb1_3.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			centerPanel.add(bt2_3[i]);
			bt2_3[i].setVisible(false);
		}
		///////////////////////// ��ư ������ 
		int j=0;
		bt[0].addActionListener(new ActionListener() {//
			public void actionPerformed(ActionEvent e) {
				for(int i =0; i<eb5.length;i++) {
					bt1[i].setVisible(true);
				}
				for(int i =0; i<building.length;i++) {
							bt[i].setVisible(false);
				}
			}
		});

		bt[1].addActionListener(new ActionListener() {//
			public void actionPerformed(ActionEvent e) {
				for(int i =0; i<eb1.length;i++) {
							bt2[i].setVisible(true);
				}
				for(int i =0; i<building.length;i++) {
							bt[i].setVisible(false);
				}
			}
		});
	
		
		
		//////////////////////////////
		add(centerPanel, BorderLayout.CENTER);
		/////////////////////////////////////
		//SOUTH
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		
		JButton btnBack = new JButton("�ڷΰ���");
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane()));
		JButton btnre = new JButton("ó������");
		btnre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
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
