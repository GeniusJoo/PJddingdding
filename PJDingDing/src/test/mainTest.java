package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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

public class mainTest extends JFrame{// mysql �����ϱ� ���� Ŭ����
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/school_information?chracterEncoding=UTF-8&serverTimezone=UTC";
	static final String USERNAME = "root"; // mysql���̵�
	static final String PASSWORD = "dhsmf"; // mysql���
	private Connection connection;
	private DBM dbm;
	
	CardLayout cLayout;
	JButton btnslr, btnlib, btnrest, btnser;
	
	public static Connection makeConnection() { //db Ŀ�ؼ� ��ü ����
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		} catch(SQLException sqlException) {
			sqlException.getStackTrace();
			System.exit(1);
		}
		return conn;
	}
	
	private Image background=new ImageIcon(mainTest.class.getResource("../image/map.png")).getImage(); // �׸� ��������
	
	public mainTest() {// �׽�Ʈ�� ������
		connection = makeConnection(); //Ŀ�ؼ� ����
		dbm=new DBM(connection);//db Ŀ�ؼ� ��ü ����, ��� �������� DBM���� �۵��ϰ� ��
		
		// db Ȱ�� ���� �ּ� �������� �ϸ��
		//dbm.sl_search("5700"); //���ǽ� ��ġ�Ͽ� ��� �Է³��� : ���ǽǹ�ȣ // ��ġ ���� �ٲܼ�����
		//int a = dbm.sl_ap("60000005", "5700");// ���ǽ� ������ ��� �Է³��� : �л���ȣ, ���ǽǹ�ȣ
		//System.out.println(a); // �Է¼����ϸ� 1// �Է¼����׽�Ʈ
		//dbm.sl_search("5700"); // �Է¼���Ȯ�� ���
		
		//int c = dbm.newstudent("������", "60142342", "1234");// �л�������� �Է³��� �л��̸�, �л����̵�, �л���й�ȣ
		//System.out.println(c);
		//int b=dbm.login("60142342", "1234");// �α��� �Է³��� : �л����̵� , ���
		//System.out.println(b);// ����� 1�̸� ����, 0�̸� ���Ʋ��, -1�̸� ���̵� ����, -2�� db����
		
		//dbm.lib_search("1"); // "1"���ڸ� Ȯ��
		//int d = dbm.lib_ap("60142342", "010000", "3");// �л���ȣ, �ð�(00��,00��,00��), �ڸ���ȣ
		//System.out.println(d);// �����ϸ� 1
		
		//sdbm.allroom();//���ǽ� ��ü���
		//dbm.all_library();// ������ ��ü���
		//dbm.allstudent();// �л����� ��ü���
		
		//������ ����
		setTitle("Main");
		
		// layout
		cLayout = new CardLayout();
		setLayout(cLayout);
		add(new MainPanel());
		add(new search_Panel(this, cLayout, connection, dbm));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(520, 420);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	class MainPanel extends JPanel {// ���� �г�  // ��ư��ġ ���ڰ��ϴ°� �𸣰���
		
		public MainPanel() {
			setLayout(new BorderLayout());
			setResizable(false);
			
			//���(center)
			JPanel centerPanel = new JPanel();
			centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
			
			add(centerPanel, BorderLayout.CENTER);
			//
			
			//�Ʒ� ��ư
			//JPanel southPanel = new JPanel(new GridLayout(1, 4));
			JPanel btnPanel =  new JPanel();
			//btnPanel.setLayout(new GridLayout(1, 4));
			btnPanel.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints(); 
			//gbc.fill=GridBagConstraints.BOTH;
						
			btnslr = new JButton("���ǽ�");
			btnlib = new JButton("������");
			btnrest = new JButton("�Ĵ�");
			btnser =new JButton("��ȸ");
			
			btnslr.addActionListener(new MainPanelListener());
			btnlib.addActionListener(new MainPanelListener());
			btnrest.addActionListener(new MainPanelListener());
			btnser.addActionListener(new MainPanelListener());
			
			btnPanel.add(btnslr);
			btnPanel.add(btnlib);
			btnPanel.add(btnrest);
			btnPanel.add(btnser);
			
			//southPanel.add(btnPanel);
			add(btnPanel, BorderLayout.SOUTH);
			//
		}
	}
	

	public void paint(Graphics g) {//�̹��� �׸���
		g.drawImage(background, 0, 0, null);//background�� �׷���
		}
	
	private class MainPanelListener implements ActionListener { // ��ư ������
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			switch(name) {
				case "��ȸ":
					cLayout.next(getContentPane()); // ��ȸ ȭ������ �Ѿ
					break;
			}
		}
	}
		
	
	public static void main(String[] args) {
		new mainTest(); 
	}
}
