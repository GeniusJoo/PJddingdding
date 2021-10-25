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

// 식당패널
public class cafeteria_Panel extends JPanel {
	JFrame mainframe;
	JScrollPane graphScroll;
	
	Image background = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\rest.jpg").getImage(); // 지워도 됨
    ImageIcon background1 = new ImageIcon(background);
    Image originImg = background1.getImage(); 
    Image changedImg= originImg.getScaledInstance(500, 300, Image.SCALE_SMOOTH );
    ImageIcon Icon = new ImageIcon(changedImg);
    JPanel centerPanel = new JPanel();

	public cafeteria_Panel(JFrame mainframe, CardLayout cLayout) {
		this.mainframe= mainframe; 
		
		setLayout(new BorderLayout());
		//////////////////////////////////////////
		// NORTH: menu 메뉴바 테스트 샘플
		Menu menu = new Menu();
		menu.addMenu("User");
		menu.getMenu().setMnemonic(KeyEvent.VK_1);
		menu.addMenuItem("나가기", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("강의실", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("도서실", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("식당", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("조회", KeyEvent.VK_E, new UserPanelListener());
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
		
		JButton btnBack = new JButton("뒤로가기");
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane()));
		JButton btnse = new JButton("검색"); // 검색 버튼
		Choice ch1 = new Choice(); // 월별 초이스 
		for(int i =1 ; i<=12 ;i++) {
			ch1.add(i+"월");
		}
		JLabel lb1 = new JLabel("날짜");
		
		btnse.addActionListener(new ActionListener(){ // 월별 사진 바꾸기
			String month = ch1.getSelectedItem();
			public void actionPerformed(ActionEvent e) {
				month = ch1.getSelectedItem();
				switch(month) {
					case "1월":
						ImageIcon img1 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\1.png");
						picLabel.setIcon(img1);
						break;
					case "2월":
						ImageIcon img2 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\2.png");
						picLabel.setIcon(img2);
						break;
					case "3월":
						ImageIcon img3 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\3.png");
						picLabel.setIcon(img3);
						break;
					case "4월":
						ImageIcon img4 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\4.png");
						picLabel.setIcon(img4);
						break;
					case "5월":
						ImageIcon img5 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\3.png");
						picLabel.setIcon(img5);
						break;
					case "6월":
						ImageIcon img6 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\4.png");
						picLabel.setIcon(img6);
						break;
					case "7월":
						ImageIcon img7 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\1.png");
						picLabel.setIcon(img7);
						break;
					case "8월":
						ImageIcon img8 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\1.png");
						picLabel.setIcon(img8);
						break;
					case "9월":
						ImageIcon img9 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\1.png");
						picLabel.setIcon(img9);
						break;
					case "10월":
						ImageIcon img10 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\1.png");
						picLabel.setIcon(img10);
						break;
					case "11월":
						ImageIcon img11 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\1.png");
						picLabel.setIcon(img11);
						break;
					case "12월":
						ImageIcon img12 = new ImageIcon("C:\\Users\\USER\\git\\PJddingdding\\PJDingDing\\src\\image\\1.png");
						picLabel.setIcon(img12);
						break;
					default:
						break;
				}
			}
		});
		
		// south추가
		buttonPanel.add(lb1);
		buttonPanel.add(ch1);
		buttonPanel.add(btnse);
		buttonPanel.add(btnBack);
		southPanel.add(buttonPanel);
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
	}
	

	private class UserPanelListener implements ActionListener { //버튼 리스너
		public void actionPerformed(ActionEvent e) {
			String name = e.getActionCommand();
			switch(name) {
				case "exit":
					break;	
			}
		}
	}
}
