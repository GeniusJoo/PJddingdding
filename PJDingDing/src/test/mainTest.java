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

public class mainTest extends JFrame{// mysql 연결하기 위한 클래스
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/school_information?chracterEncoding=UTF-8&serverTimezone=UTC";
	static final String USERNAME = "root"; // mysql아이디
	static final String PASSWORD = "dhsmf"; // mysql비번
	private Connection connection;
	private DBM dbm;
	
	CardLayout cLayout;
	JButton btnslr, btnlib, btnrest, btnser;
	
	public static Connection makeConnection() { //db 커넥션 객체 생성
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		} catch(SQLException sqlException) {
			sqlException.getStackTrace();
			System.exit(1);
		}
		return conn;
	}
	
	private Image background=new ImageIcon(mainTest.class.getResource("../image/map.png")).getImage(); // 그림 가져오기
	
	public mainTest() {// 테스트용 생성자
		connection = makeConnection(); //커넥션 생성
		dbm=new DBM(connection);//db 커넥션 객체 전달, 모든 쿼리문은 DBM에서 작동하게 함
		
		// db 활용 예시 주석 지워가며 하면됨
		//dbm.sl_search("5700"); //강의실 서치하여 출력 입력내용 : 강의실번호 // 서치 내용 바꿀수있음
		//int a = dbm.sl_ap("60000005", "5700");// 강의실 예약자 등록 입력내용 : 학생번호, 강의실번호
		//System.out.println(a); // 입력성공하면 1// 입력성공테스트
		//dbm.sl_search("5700"); // 입력성공확인 출력
		
		//int c = dbm.newstudent("차요한", "60142342", "1234");// 학생정보등록 입력내용 학생이름, 학생아이디, 학생비밀번호
		//System.out.println(c);
		//int b=dbm.login("60142342", "1234");// 로그인 입력내용 : 학생아이디 , 비번
		//System.out.println(b);// 출력이 1이면 성공, 0이면 비번틀림, -1이면 아이디 없음, -2면 db오류
		
		//dbm.lib_search("1"); // "1"번자리 확인
		//int d = dbm.lib_ap("60142342", "010000", "3");// 학생번호, 시간(00시,00분,00초), 자리번호
		//System.out.println(d);// 성공하면 1
		
		//sdbm.allroom();//강의실 전체출력
		//dbm.all_library();// 도서관 전체출력
		//dbm.allstudent();// 학생정보 전체출력
		
		//프레임 생성
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
	
	class MainPanel extends JPanel {// 메인 패널  // 버튼위치 예쁘게하는거 모르겠음
		
		public MainPanel() {
			setLayout(new BorderLayout());
			setResizable(false);
			
			//가운데(center)
			JPanel centerPanel = new JPanel();
			centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
			
			add(centerPanel, BorderLayout.CENTER);
			//
			
			//아래 버튼
			//JPanel southPanel = new JPanel(new GridLayout(1, 4));
			JPanel btnPanel =  new JPanel();
			//btnPanel.setLayout(new GridLayout(1, 4));
			btnPanel.setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints(); 
			//gbc.fill=GridBagConstraints.BOTH;
						
			btnslr = new JButton("강의실");
			btnlib = new JButton("도서관");
			btnrest = new JButton("식당");
			btnser =new JButton("조회");
			
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
	

	public void paint(Graphics g) {//이미지 그리기
		g.drawImage(background, 0, 0, null);//background를 그려줌
		}
	
	private class MainPanelListener implements ActionListener { // 버튼 리스너
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			switch(name) {
				case "조회":
					cLayout.next(getContentPane()); // 조회 화면으로 넘어감
					break;
			}
		}
	}
		
	
	public static void main(String[] args) {
		new mainTest(); 
	}
}
