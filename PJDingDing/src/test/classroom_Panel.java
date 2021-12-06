package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
	CardLayout cLayout;
	information info = new information();
	JPanel centerPanel = new JPanel(new GridBagLayout());
	GridBagConstraints gbc;
	JLabel newLabel2[] = new JLabel[5];// ���ǽ� �̸� ����ڰ��� ���� ǥ��
	TreeNode root = info.Tree(); // Ʈ�� root
	loginPanel login;
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
	String position=""; // ����ġ 
	
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
		
		position="�������б� �ڿ�ķ�۽� ->";
		JLabel JL = new JLabel(position);
		
		JLabel newLabel[] = new JLabel[5];
		newLabel[0] = new JLabel("���ǽǸ� : ");
		newLabel[1] = new JLabel("����� : ");
		newLabel[2] = new JLabel("���ǻ���");
		newLabel[3] = new JLabel("������� : ");
		newLabel[4] = new JLabel("����ð� : ");
		
		
		gbc = new GridBagConstraints();
		gbc.fill= GridBagConstraints.BOTH; 
		gbc.gridx=0;
		gbc.gridy=0;
	    gbc.weightx = 1.0;
	    gbc.weighty = 1.0;
	    centerPanel.add(JL, gbc);
		for(int i=0; i<newLabel.length;i++) {
			gbc.gridy=3+i;
			centerPanel.add(newLabel[i], gbc);
		}
		
		for(int i=0;i<newLabel2.length;i++) {
			newLabel2[i] = new JLabel("");
			gbc.gridx=1;
			gbc.gridy=3+i;
			centerPanel.add(newLabel2[i], gbc);
		}
		gbc.gridx=0;
		//////Ʈ�������///////
		//�б�(root) -> �ǹ� -> �� -> ���ǽ� ���ǽ�����
		//�б� �ǹ� �� ���ǽ� ����
		//���ǽ� ���� �α��� 
		
		
		 // �ǹ� ��ü ����
		for(int i=0 ; i<root.getChildNodeArray().size() ; i++) { // ��ü �ǹ� ���� ����
			building[i]=root.getChildNodeArray().get(i);
		}
		gbc.gridy=1;
		for(int i =0; i<root.getChildNodeArray().size();i++) { // ��ü �ǹ� ��ư ����
			bt[i]= new JButton(root.getChildNodeArray().get(i).getNodeName());
			gbc.gridx=i;
			centerPanel.add(bt[i], gbc);
		}
		//5��
		eb5=new TreeNode[building[0].getChildNodeArray().size()]; // 5���а� Ʈ��
		bt1=new JButton[building[0].getChildNodeArray().size()]; // 5���а� ��ư ũ��
		eb5=info.reTree(building, 0); //���� ����
		bt1=info.reButton(building, 0); // ��ư �����
		for(int i =0; i<eb5.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			gbc.gridx=i;
			centerPanel.add(bt1[i],gbc);
			bt1[i].setVisible(false);
		}
		
		//5�� 1��
		eb5_1 = new TreeNode[eb5[0].getChildNodeArray().size()];
		bt1_1 = new JButton[eb5[0].getChildNodeArray().size()];
		eb5_1=info.reTree(eb5, 0); //���� ����
		bt1_1=info.reButton(eb5, 0); // ��ư �����
		for(int i =0; i<eb5_1.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			gbc.gridx=i;
			centerPanel.add(bt1_1[i],gbc);
			bt1_1[i].setVisible(false);
		}
		
		//5�� 2��
		eb5_2 = new TreeNode[eb5[1].getChildNodeArray().size()];
		bt1_2 = new JButton[eb5[1].getChildNodeArray().size()];
		eb5_2=info.reTree(eb5, 1); //���� ����
		bt1_2=info.reButton(eb5, 1); // ��ư �����
		for(int i =0; i<eb5_2.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			gbc.gridx=i;
			centerPanel.add(bt1_2[i], gbc);
			bt1_2[i].setVisible(false);
		}
		
		//5�� 3��
		eb5_3 = new TreeNode[eb5[2].getChildNodeArray().size()];
		bt1_3 = new JButton[eb5[2].getChildNodeArray().size()];
		eb5_3=info.reTree(eb5, 2); //���� ����
		bt1_3=info.reButton(eb5, 2); // ��ư �����
		for(int i =0; i<eb5_3.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			gbc.gridx=i;
			centerPanel.add(bt1_3[i],gbc);
			bt1_3[i].setVisible(false);
		}
		
		//1��
		eb1=new TreeNode[building[1].getChildNodeArray().size()]; // 1���а� Ʈ��
		bt2=new JButton[building[1].getChildNodeArray().size()]; // 1���а� ��ư ũ��
		eb1=info.reTree(building, 1); //���� ����
		bt2=info.reButton(building, 1); // ��ư �����
		for(int i =0; i<eb1.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			gbc.gridx=i;
			centerPanel.add(bt2[i],gbc);
			bt2[i].setVisible(false);
		}
		
		//1�� 1��
		eb1_1 = new TreeNode[eb1[0].getChildNodeArray().size()];
		bt2_1 = new JButton[eb1[0].getChildNodeArray().size()];
		eb1_1=info.reTree(eb1, 0); //���� ����
		bt2_1=info.reButton(eb1, 0); // ��ư �����
		for(int i =0; i<eb1_1.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			gbc.gridx=i;
			centerPanel.add(bt2_1[i],gbc);
			bt2_1[i].setVisible(false);
		}
		
		//1�� 2��
		eb1_2 = new TreeNode[eb1[1].getChildNodeArray().size()];
		bt2_2 = new JButton[eb1[1].getChildNodeArray().size()];
		eb1_2=info.reTree(eb1, 1); //���� ����
		bt2_2=info.reButton(eb1, 1); // ��ư �����
		for(int i =0; i<eb1_2.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			gbc.gridx=i;
			centerPanel.add(bt2_2[i],gbc);
			bt2_2[i].setVisible(false);
		}
		
		//1�� 3��
		eb1_3 = new TreeNode[eb1[2].getChildNodeArray().size()];
		bt2_3 = new JButton[eb1[2].getChildNodeArray().size()];
		eb1_3=info.reTree(eb1, 2); //���� ����
		bt2_3=info.reButton(eb1, 2); // ��ư �����
		for(int i =0; i<eb1_3.length;i++) { // ��ư �־�ΰ� ȭ�鿡 �����
			gbc.gridx=i;
			centerPanel.add(bt2_3[i],gbc);
			bt2_3[i].setVisible(false);
		}
		///////////////////////// ��ư ������ 
		int j=0;
		bt[0].addActionListener(new ActionListener() {//5��
			public void actionPerformed(ActionEvent e) {
				position+=bt[0].getText()+"->";
				JL.setText(position);
				for(int i =0; i<eb5.length;i++) {
					bt1[i].setVisible(true);
				}
				for(int i =0; i<building.length;i++) {
						bt[i].setVisible(false);
				}
			}
		});

		bt[1].addActionListener(new ActionListener() {//1��
			public void actionPerformed(ActionEvent e) {
				position+=bt[1].getText()+"->";
				JL.setText(position);
				for(int i =0; i<eb1.length;i++) {
							bt2[i].setVisible(true);
				}
				for(int i =0; i<building.length;i++) {
							bt[i].setVisible(false);
				}
			}
		});
	
		
		bt1[0].addActionListener(new ActionListener() {//5��1��
			public void actionPerformed(ActionEvent e) {
				position+=bt1[0].getText()+"->";
				JL.setText(position);
				for(int i =0; i<eb5_1.length;i++) {
							bt1_1[i].setVisible(true);
				}
				for(int i =0; i<eb5.length;i++) {
							bt1[i].setVisible(false);
				}
			}
		});
		
		bt1[1].addActionListener(new ActionListener() {//5��2��
			public void actionPerformed(ActionEvent e) {
				position+=bt1[1].getText()+"->";
				JL.setText(position);
				for(int i =0; i<eb5_2.length;i++) {
							bt1_2[i].setVisible(true);
				}
				for(int i =0; i<eb5.length;i++) {
							bt1[i].setVisible(false);
				}
			}
		});
		
		bt1[2].addActionListener(new ActionListener() {//5��3��
			public void actionPerformed(ActionEvent e) {
				position+=bt1[2].getText()+"->";
				JL.setText(position);
				for(int i =0; i<eb5_3.length;i++) {
							bt1_3[i].setVisible(true);
				}
				for(int i =0; i<eb5.length;i++) {
							bt1[i].setVisible(false);
				}
			}
		});
		
		bt2[0].addActionListener(new ActionListener() {//1��1��
			public void actionPerformed(ActionEvent e) {
				position+=bt2[0].getText()+"->";
				JL.setText(position);
				for(int i =0; i<eb1_1.length;i++) {
							bt2_1[i].setVisible(true);
				}
				for(int i =0; i<eb1.length;i++) {
							bt2[i].setVisible(false);
				}
			}
		});
		
		bt2[1].addActionListener(new ActionListener() {//1��2��
			public void actionPerformed(ActionEvent e) {
				position+=bt2[1].getText()+"->";
				JL.setText(position);
				for(int i =0; i<eb1_2.length;i++) {
							bt2_2[i].setVisible(true);
				}
				for(int i =0; i<eb1.length;i++) {
							bt2[i].setVisible(false);
				}
			}
		});
		
		bt2[2].addActionListener(new ActionListener() {//1��3��
			public void actionPerformed(ActionEvent e) {
				position+=bt2[1].getText()+"->";
				JL.setText(position);
				for(int i =0; i<eb1_3.length;i++) {
							bt2_3[i].setVisible(true);
				}
				for(int i =0; i<eb1.length;i++) {
							bt2[i].setVisible(false);
				}
			}
		});
		
		////////////////////////////// ���ǽ� �ð� ���� ����
		for(int i = 0;i<eb5_1.length;i++) { //5�� 1��
			int loc=i;
			bt1_1[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TreeNode A = root.findnode(eb5_1[loc].getNodeName());
					String[] k = A.getleafnode();
					System.out.println(A.getNodeName());
					for(int i = 0; i<k.length;i++){
						newLabel2[i].setText(k[i]);
					}
				}
			});
		}
		
		for(int i = 0;i<eb5_2.length;i++) { //5�� 2��
			int loc=i;
			bt1_2[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TreeNode A = root.findnode(eb5_2[loc].getNodeName());
					String[] k = A.getleafnode();
					System.out.println(A.getNodeName());
					for(int i = 0; i<k.length;i++){
						newLabel2[i].setText(k[i]);
					}
				}
			});
		}
		
		for(int i = 0;i<eb5_3.length;i++) { //5�� 3��
			int loc=i;
			bt1_3[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TreeNode A = root.findnode(eb5_3[loc].getNodeName());
					String[] k = A.getleafnode();
					System.out.println(A.getNodeName());
					for(int i = 0; i<k.length;i++){
						newLabel2[i].setText(k[i]);
					}
				}
			});
		}
		
		for(int i = 0;i<eb1_1.length;i++) {// 1�� 1��
			int loc=i;
			bt2_1[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					TreeNode A = root.findnode(eb1_1[loc].getNodeName());
					String[] k = A.getleafnode();
					System.out.println(A.getNodeName());
					for(int i = 0; i<k.length;i++){
						newLabel2[i].setText(k[i]);
					}
				}
			});
		}
		
		
		for(int i = 0;i<eb1_2.length;i++) {// 1�� 2��
			int loc=i;
			bt2_2[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					TreeNode A = root.findnode(eb1_2[loc].getNodeName());
					String[] k = A.getleafnode();
					System.out.println(A.getNodeName());
					for(int i = 0; i<k.length;i++){
						newLabel2[i].setText(k[i]);
					}
				}
			});
		}
		
		for(int i = 0;i<eb1_3.length;i++) {// 1�� 3��
			int loc=i;
			bt2_3[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					TreeNode A = root.findnode(eb1_3[loc].getNodeName());
					String[] k = A.getleafnode();
					System.out.println(A.getNodeName());
					for(int i = 0; i<k.length;i++){
						newLabel2[i].setText(k[i]);
					}
				}
			});
		}

		add(centerPanel, BorderLayout.CENTER);
		/////////////////////////////////////
		//SOUTH
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		
		JButton btnBack = new JButton("�ڷΰ���");
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane()));
		JButton btnre = new JButton("ó������"); // ó������ �ٽ� ���ư��� ���� ���δ� �Ⱥ��̰� �ѵ� ó���κи� ���̰��Ѵ�
		btnre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				position="�������б� �ڿ�ķ�۽�";
				JL.setText(position);
				for(int i =0; i<eb5.length;i++) {
					bt1[i].setVisible(false);
				}
				for(int i =0; i<eb1.length;i++) {
					bt2[i].setVisible(false);
				}
				for(int i =0; i<eb5_1.length;i++) {
					bt1_1[i].setVisible(false);
				}
				for(int i =0; i<eb5_2.length;i++) {
					bt1_2[i].setVisible(false);
				}
				for(int i =0; i<eb5_3.length;i++) {
					bt1_3[i].setVisible(false);
				}
				for(int i =0; i<eb1_1.length;i++) {
					bt2_1[i].setVisible(false);
				}
				for(int i =0; i<eb1_2.length;i++) {
					bt2_2[i].setVisible(false);
				}
				for(int i =0; i<eb1_3.length;i++) {
					bt2_3[i].setVisible(false);
				}
				
				for(int i =0; i<building.length;i++) {
					bt[i].setVisible(true);
				}
				for(int i =0; i<newLabel2.length;i++) {
					newLabel2[i].setText("");
				}
				centerPanel.revalidate();
			}
		});
		
		JButton btnlogin = new JButton("�����ϱ�");
		btnlogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				login = new loginPanel(1, root);
			}
			
		});
		
		JButton btncancel = new JButton("�������");
		btncancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				login = new loginPanel(0, root);
			}
			
		});
		
		buttonPanel.add(btnBack);
		buttonPanel.add(btnre);
		buttonPanel.add(btnlogin);
		buttonPanel.add(btncancel);
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
