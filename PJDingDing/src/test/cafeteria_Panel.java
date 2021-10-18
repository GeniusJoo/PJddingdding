package test;
//a
import java.awt.BorderLayout;
import java.awt.CardLayout;
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
	
	Image background = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\rest.jpg").getImage();
    ImageIcon background1 = new ImageIcon(background);
    Image originImg = background1.getImage(); 
    Image changedImg= originImg.getScaledInstance(500, 300, Image.SCALE_SMOOTH );
    ImageIcon Icon = new ImageIcon(changedImg);


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
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		JLabel picLabel = new JLabel(Icon);
		picLabel.setAlignmentX(picLabel.LEFT_ALIGNMENT);
		centerPanel.add(picLabel, centerPanel);
		
		add(centerPanel, BorderLayout.CENTER);
		
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
