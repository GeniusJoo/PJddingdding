package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainTest extends JFrame{

	Image background = new ImageIcon("C:\\Users\\y0n\\Documents\\GitHub\\PJddingdding\\PJDingDing\\src\\image\\map.png").getImage();
    ImageIcon background1 = new ImageIcon(background);
	
	CardLayout cLayout = new CardLayout();
	JButton btnslr, btnlib, btnrest, btnser;
	
	public mainTest() {// �׽�Ʈ�� ������
		
		//�迭����
		//���ǽ� �迭�� �ǹ� ����� �ǹ��� 3~4��, �б�->�ǹ�->����->���ǽ�->���ǽ����� ������ Ʈ�� ����
		information info = new information();
		info.Treeset();
		info.student_infoset();
		//�л������� �л��̸�, ��ȣ, ��й�ȣ�� 10������
		//������������ �ڸ�, ������, �����ð� ���� 20�ڸ� ����
		
		//���ǽü� ���� �߰� �ð� ���� ���
		
		//������ ����
		setTitle("���������");
		
		// layout
		setLayout(cLayout);
		add("main",new MainPanel());
		add("search",new search_Panel(this, cLayout));
		add("cafeteria", new cafeteria_Panel(this, cLayout));
		add("classroom", new classroom_Panel(this, cLayout));
		add("library", new library_Panel(this, cLayout));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(630, 450);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	class MainPanel extends JPanel {// ���� �г�  // ��ư��ġ ���ڰ��ϴ°� �𸣰���
		
		public MainPanel() {
			setLayout(new BorderLayout());
			//setResizable(false);
			
			//���(center)
			JPanel centerPanel = new JPanel();
			centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
			
			JLabel picLabel = new JLabel(background1);
			picLabel.setAlignmentX(picLabel.LEFT_ALIGNMENT);
			centerPanel.add(picLabel, centerPanel);
			
			add(centerPanel, BorderLayout.CENTER);
			//
			
			//�Ʒ� ��ư
			JPanel btnPanel =  new JPanel();
			btnPanel.setLayout(new GridLayout(1, 4));
						
			btnslr = new JButton("���ǽ�");
			btnlib = new JButton("������");
			btnrest = new JButton("�Ĵ�");
			btnser =new JButton("��ȸ");
			
			btnslr.addActionListener(new MainPanelListener());
			btnlib.addActionListener(new MainPanelListener());
			btnrest.addActionListener(new MainPanelListener());
			btnser.addActionListener(new MainPanelListener());
			//color 
			btnslr.setBackground(new Color(153, 204, 255));
			btnlib.setBackground(new Color(153, 204, 255));
			btnrest.setBackground(new Color(153, 204, 255));
			btnser.setBackground(new Color(153, 204, 255));
			
			btnPanel.add(btnslr);
			btnPanel.add(btnlib);
			btnPanel.add(btnrest);
			btnPanel.add(btnser);
			
			//southPanel.add(btnPanel);
			add(btnPanel, BorderLayout.SOUTH);
			//
		}
	}
	
	
	private class MainPanelListener implements ActionListener { // ��ư ������
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			switch(name) {
				case "��ȸ":
					cLayout.show(getContentPane(), "search");
					break;
				case "�Ĵ�":
					cLayout.show(getContentPane(), "cafeteria");
					break;
				case "���ǽ�":
					cLayout.show(getContentPane(), "classroom");
					break;
				case "������":
					cLayout.show(getContentPane(), "library");
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		new mainTest(); 
				
	}
}
