package test;
//a
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.SpringLayout;

// �Ĵ��г�
public class cafeteria_Panel extends JPanel {
	JFrame mainframe;
	JScrollPane graphScroll;
	
	Image background = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\rest.jpg").getImage(); // ������ ��
    ImageIcon background1 = new ImageIcon(background);
    Image originImg = background1.getImage(); 
    Image changedImg= originImg.getScaledInstance(500, 300, Image.SCALE_SMOOTH );
    ImageIcon Icon = new ImageIcon(changedImg);
    JPanel centerPanel = new JPanel();

	public cafeteria_Panel(JFrame mainframe, CardLayout cLayout) {
		this.mainframe= mainframe; 
		
		setLayout(new BorderLayout());
		//////////////////////////////////////////
		// NORTH: menu �޴��� �׽�Ʈ ����
		Menu menu = new Menu();
		menu.addMenu("User");
		menu.getMenu().setMnemonic(KeyEvent.VK_1);
		menu.addMenuItem("������", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("���ǽ�", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("������", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("�Ĵ�", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("��ȸ", KeyEvent.VK_E, new UserPanelListener());
		menu.finishAddItem();
		add(menu, BorderLayout.NORTH);
		
		////////////////////////////////////
		//CENTER
		
		centerPanel.setLayout(new FlowLayout());
		JLabel picLabel = new JLabel(Icon);
		picLabel.setAlignmentX(picLabel.LEFT_ALIGNMENT);
		centerPanel.add(picLabel, centerPanel);
	
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.revalidate();
		/////////////////////////////////////
		//SOUTH
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,4));
		
		JButton btnBack = new JButton("�ڷΰ���");
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane()));
		JButton btnse = new JButton("�˻�"); // �˻� ��ư
		Choice ch1 = new Choice(); // ���� ���̽� 
		for(int i =1 ; i<=12 ;i++) {
			ch1.add(i+"��");
		}
		JLabel lb1 = new JLabel("��¥");
		
		btnse.addActionListener(new ActionListener(){ // ���� ���� �ٲٱ�
			String month = ch1.getSelectedItem();
			public void actionPerformed(ActionEvent e) {
				month = ch1.getSelectedItem();
				switch(month) {
					case "1��":
						ImageIcon img1 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\1.png");
						picLabel.setIcon(img1);
						break;
					case "2��":
						ImageIcon img2 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\2.png");
						picLabel.setIcon(img2);
						break;
					case "3��":
						ImageIcon img3 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\3.png");
						picLabel.setIcon(img3);
						break;
					case "4��":
						ImageIcon img4 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\4.png");
						picLabel.setIcon(img4);
						break;
					case "5��":
						ImageIcon img5 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\3.png");
						picLabel.setIcon(img5);
						break;
					case "6��":
						ImageIcon img6 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\4.png");
						picLabel.setIcon(img6);
						break;
					case "7��":
						ImageIcon img7 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\1.png");
						picLabel.setIcon(img7);
						break;
					case "8��":
						ImageIcon img8 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\1.png");
						picLabel.setIcon(img8);
						break;
					case "9��":
						ImageIcon img9 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\1.png");
						picLabel.setIcon(img9);
						break;
					case "10��":
						ImageIcon img10 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\1.png");
						picLabel.setIcon(img10);
						break;
					case "11��":
						ImageIcon img11 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\1.png");
						picLabel.setIcon(img11);
						break;
					case "12��":
						ImageIcon img12 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\1.png");
						picLabel.setIcon(img12);
						break;
					default:
						break;
				}
			}
		});
		
		// south�߰�
		buttonPanel.add(lb1);
		buttonPanel.add(ch1);
		buttonPanel.add(btnse);
		buttonPanel.add(btnBack);
		southPanel.add(buttonPanel);
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
	}
	

	private class UserPanelListener implements ActionListener { //��ư ������
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			switch(name) {
				case "exit":
					break;	
			}
		}
	}
}
