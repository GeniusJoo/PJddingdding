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
	int[] labelnum=new int[30]; // ������ ��Ȳ ����
	
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
		
		JPanel centerPanel = new JPanel(new GridLayout(10,6));//5x5
	
		int k=1;
		for(int i=0;i<30;i++) { // ��ư�� ���� �� �����
			libBk[i]=new JButton(""+k);
			libBk[i].addActionListener(new librayPanelListener());
			centerPanel.add(libBk[i]);
			label[i]=new JLabel();
			centerPanel.add(label[i]);
			k++;
			if(labelnum[i]==0) {
				label[i].setText("����ȵ�");
			}else {
				label[i].setText("�����");
			}
		}
		
	
		add(centerPanel,BorderLayout.CENTER);
		
		/////////////////////////////////////
		//SOUTH
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		
		JButton btnBack = new JButton("�ڷΰ���");
		JButton btnRe = new JButton("���ΰ�ħ");
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane()));
		btnRe.addActionListener(new librayPanelListener());
		buttonPanel.add(btnBack);
		buttonPanel.add(btnRe);
		southPanel.add(buttonPanel);
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	private class librayPanelListener implements ActionListener { //��ư ������

		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			int i=0;
			switch(name) {
				case "������":
					
					break;
				case"���ΰ�ħ":
					for(int j= 0; j<30;j++) {
						labelnum=null;
						labelnum=new int[30];
						labelnum[j]=queries.lib_se(j+1);
						if(labelnum[j]==0) {
							label[j].setText("����ȵ�");
						}else {
							label[j].setText("�����");
						}
					}
					break;
				default:
					i=Integer.parseInt(name);
					if(i<31) {
						int b=0;
						loginPanel a = new loginPanel(name);
					}
					break;
					
			}
		}
	}

}
