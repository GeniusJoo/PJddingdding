package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
	JPanel centerPanel = new JPanel(new GridBagLayout());
	GridBagConstraints gbc;
	CardLayout cLayout;
	information info = new information();
	TreeNode root = info.Tree(); // Ʈ�� root
	JLabel newLabel[] = new JLabel[5];
	JLabel newLabel2[]=new JLabel[5];// ����ǥ�� ��
	JLabel la1 = new JLabel("");
	JLabel imgLabel = new JLabel();
	Image img=new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\find.jpg").getImage();
	ImageIcon background1 = new ImageIcon(img);
    Image originImg = background1.getImage(); 
    Image changedImg= originImg.getScaledInstance(200, 250, Image.SCALE_SMOOTH );
    ImageIcon Icon = new ImageIcon(changedImg);
	
	public search_Panel(JFrame mainframe, CardLayout cLayout) {
		
		this.mainframe= mainframe; 
		this.cLayout=cLayout;
		setLayout(new BorderLayout());
		//////////////////////////////////////////


		newLabel[0] = new JLabel("���ǽǸ� : ");
		newLabel[1] = new JLabel("����� : ");
		newLabel[2] = new JLabel("���ǻ���");
		newLabel[3] = new JLabel("������� : ");
		newLabel[4] = new JLabel("����ð� : ");
		
		gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.fill= GridBagConstraints.BOTH;
		for(int i=0; i<newLabel.length;i++) {
			gbc.gridy=0+i;
			centerPanel.add(newLabel[i], gbc);
		}

		for(int i=0;i<newLabel2.length;i++) {
			newLabel2[i] = new JLabel("");
			gbc.gridx=1;
			gbc.gridy=0+i;
			centerPanel.add(newLabel2[i], gbc);
		}
		gbc.gridx=3;
		gbc.gridy=0;
        gbc.gridheight = 5;
		imgLabel.setIcon(Icon);
		centerPanel.add(imgLabel, gbc);
		
		gbc.gridx=0;
		gbc.gridy=5;
		gbc.gridwidth=4;
		centerPanel.add(la1,gbc);
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
		
		add(centerPanel,BorderLayout.CENTER);
		centerPanel.revalidate();
		///////////////
		///SOUTH
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,3));
		JButton btnBack = new JButton("�ڷΰ���");// �ڷΰ���
		btnBack.addActionListener(e -> cLayout.first(
				mainframe.getContentPane())); // �ڷΰ��� �̺�Ʈ
		
		JButton btnRe = new JButton("ã��"); // ã���ư
		btnRe.addActionListener(new searchPanelListener());// ã�� �̺�Ʈ
		buttonPanel.add(btnBack);
		buttonPanel.add(tf1);
		buttonPanel.add(btnRe);
		southPanel.add(buttonPanel);
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		
		btnRe.setBackground(new Color(230, 230, 255));
		btnBack.setBackground(new Color(255, 230, 255));
		
	}
	
	private class searchPanelListener implements ActionListener { //��ư ������
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			String search = tf1.getText();
			
			switch (name) {
			case "ã��":
				// Ʈ�� Ž�� ���� �ҷ�����
				String s = "";
				s=root.searchAllNode(tf1.getText());
				la1.setText(s);
				
				TreeNode A = root.findnode(tf1.getText());
				String[] k = A.getleafnode();
				System.out.println(A.getNodeName());
				for(int i = 0; i<k.length;i++){
					newLabel2[i].setText(k[i]);
				}
				if(A.getParentNode().getParentNode().getNodeName().equals("5���а�")) {
					ImageIcon img1 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\find5.jpg");
					imgLabel.setIcon(img1);
				}else {
					ImageIcon img1 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\find5.jpg");
					imgLabel.setIcon(img1);
				}
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
