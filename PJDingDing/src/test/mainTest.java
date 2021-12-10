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
	
	public mainTest() {// 테스트용 생성자
		
		//배열생성
		//강의실 배열은 건물 수대로 건물은 3~4개, 학교->건물->층수->강의실->강의실정보 순으로 트리 제작
		information info = new information();
		info.Treeset();
		info.student_infoset();
		//학생정보는 학생이름, 번호, 비밀번호로 10명정도
		//도서관정보는 자리, 예약자, 남은시간 으로 20자리 정도
		
		//편의시설 정보 추가 시간 남을 경우
		
		//프레임 생성
		setTitle("요정띵띵이");
		
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
	
	class MainPanel extends JPanel {// 메인 패널  // 버튼위치 예쁘게하는거 모르겠음
		
		public MainPanel() {
			setLayout(new BorderLayout());
			//setResizable(false);
			
			//가운데(center)
			JPanel centerPanel = new JPanel();
			centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
			
			JLabel picLabel = new JLabel(background1);
			picLabel.setAlignmentX(picLabel.LEFT_ALIGNMENT);
			centerPanel.add(picLabel, centerPanel);
			
			add(centerPanel, BorderLayout.CENTER);
			//
			
			//아래 버튼
			JPanel btnPanel =  new JPanel();
			btnPanel.setLayout(new GridLayout(1, 4));
						
			btnslr = new JButton("강의실");
			btnlib = new JButton("도서관");
			btnrest = new JButton("식당");
			btnser =new JButton("조회");
			
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
	
	
	private class MainPanelListener implements ActionListener { // 버튼 리스너
		@Override
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			switch(name) {
				case "조회":
					cLayout.show(getContentPane(), "search");
					break;
				case "식당":
					cLayout.show(getContentPane(), "cafeteria");
					break;
				case "강의실":
					cLayout.show(getContentPane(), "classroom");
					break;
				case "도서관":
					cLayout.show(getContentPane(), "library");
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		new mainTest(); 
				
	}
}
