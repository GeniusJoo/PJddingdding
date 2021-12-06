package test;

import java.util.ArrayList;

import javax.swing.JButton;

public class information {
	static TreeNode root;
	static ArrayList<stu>[] st = new ArrayList[10];
	ArrayList[] library_info() { // 도서관 자리
		
		ArrayList<lib>[] lt = new ArrayList[25];
		
		for(int j=0;j<25;j++) {
			lib s = new lib(j);
			lt[j] = new ArrayList<lib>();
			lt[j].add(s);
		}
		
		return lt;
	}
	class lib{ // 리스트 안 내용
		int number; // 좌석번호
		int name; // 좌석 예약자
		int time; //좌석시간
		int orr; //좌석 예약 완료
		public lib() {}
		public lib(int a) {
			number = a+1;
			name = 0;
			time = 0;
			orr =-1;
		}
	}
	
	void student_infoset(){ // 학생정보
		
		stu s0 = new stu(60000000, "차요한","1234");
		st[0] = new ArrayList<stu>();
		st[0].add(s0); 
		
		stu s1 = new stu(60000001, "홍길동","1234");
		st[1] = new ArrayList<stu>();
		st[1].add(s1); 
		
		stu s2 = new stu(60000002, "서승근","1234");
		st[2] = new ArrayList<stu>();
		st[2].add(s2); 
		
		stu s3 = new stu(60000003, "최선진","1234");
		st[3] = new ArrayList<stu>();
		st[3].add(s3); 
		
		stu s4 = new stu(60000004, "성범우","1234");
		st[4] = new ArrayList<stu>();
		st[4].add(s4); 
		
		stu s5 = new stu(60000005, "고동연","1234");
		st[5] = new ArrayList<stu>();
		st[5].add(s5); 
		
		stu s6 = new stu(60000006, "장석호","1234");
		st[6] = new ArrayList<stu>();
		st[6].add(s6); 
		
		stu s7 = new stu(60000007, "문영기","1234");
		st[7] = new ArrayList<stu>();
		st[7].add(s7); 
		
		stu s8 = new stu(60000008, "권석환","1234");
		st[8] = new ArrayList<stu>();
		st[8].add(s8); 
		
		stu s9 = new stu(60000009, "윤영환","1234");
		st[9] = new ArrayList<stu>();
		st[9].add(s9); 
	}
	
	class stu{
		int number; // 학생번호
		String name; // 학생이름
		String pass; //학생 패스워드
		int orr;
		String clorr;// 강의실 예약여부

		public stu(int a, String b, String c) {
			number = a;
			name = b;
			pass = c;
			orr=30;
			clorr="";
		}
	}
	public ArrayList<stu>[] student_info() {
		return st;
	}
	
	public void updateStu(int num, ArrayList<stu> s) {
		st[num].addAll(s);
	}
	
	public void Treeset() { // 강의실 트리 생성
		root = new TreeNode("명지대학교 자연캠퍼스");
		
		TreeNode EB5 = root.addChildNode("5공학관");// 5공학관
		TreeNode EB1 = root.addChildNode("1공학관");// 3공학관
		
		TreeNode floor51 = EB5.addChildNode("5공_1층"); // 5공 층수
		TreeNode floor52 = EB5.addChildNode("5공_2층");
		TreeNode floor53 = EB5.addChildNode("5공_3층");
		
		TreeNode Y5101 = floor51.addChildNode("Y5101:대형작업실"); // 5공1층
		Y5101.setleafnode("Y5101:대형작업실,홍길동,안정장비착용, , "); // 각 강의실 정보 넣기
		TreeNode Y5107 = floor51.addChildNode("Y5107:입문설계실2");
		Y5107.setleafnode("YY5107:입문설계실2,홍길동,안정장비착용, , "); // 각 강의실 정보 넣기
		TreeNode Y5110 = floor51.addChildNode("Y5110:입문설계실1");
		Y5110.setleafnode("Y5110:입문설계실1,홍길동,안정장비착용, , "); // 각 강의실 정보 넣기
		
		TreeNode Y5221 = floor52.addChildNode("Y5221:시청각실"); // 5공2층
		Y5221.setleafnode("Y5221:시청각실,홍길동,안정장비착용, , ");
		TreeNode Y5235 = floor52.addChildNode("Y5235:시청각실");
		Y5235.setleafnode("Y5235:시청각실,홍길동,안정장비착용, , ");
		TreeNode Y5243 = floor52.addChildNode("Y5243:학생회실");
		Y5243.setleafnode("Y5243:학생회실,홍길동,안정장비착용, , ");
		
		TreeNode Y5319 = floor53.addChildNode("Y5319:공학인증실"); // 5공3층
		Y5319.setleafnode("Y5319:공학인증실,홍길동,안정장비착용, , ");
		TreeNode Y5329 = floor53.addChildNode("Y5329:교통안전실");
		Y5329.setleafnode("Y5329:교통안전실,홍길동,안정장비착용, , ");
		TreeNode Y5337 = floor53.addChildNode("Y5337:교통기기실");
		Y5337.setleafnode("Y5337:교통기기실,홍길동,안정장비착용, , ");
		
		TreeNode floor11 = EB1.addChildNode("1공_1층"); // 1공 층수
		TreeNode floor12 = EB1.addChildNode("1공_2층");
		TreeNode floor13 = EB1.addChildNode("1공_3층");
		
		TreeNode Y114 = floor11.addChildNode("Y114:학회실"); // 3공 1층
		Y114.setleafnode("Y114:학회실,홍길동,안정장비착용, , ");
		TreeNode Y115 = floor11.addChildNode("Y115:학부실험실");
		Y115.setleafnode("Y115:학부실험실,홍길동,안정장비착용, , ");
		TreeNode Y131 = floor11.addChildNode("Y131:공과대 학생회실");
		Y131.setleafnode("Y131:공과대 학생회실,홍길동,안정장비착용, , ");
		
		TreeNode Y201 = floor12.addChildNode("Y201:컴퓨터실습실"); // 3공2층
		Y201.setleafnode("Y201:컴퓨터실습실,홍길동,안정장비착용, , ");
		TreeNode Y219 = floor12.addChildNode("Y219:공대연구소");
		Y219.setleafnode("Y219:공대연구소,홍길동,안정장비착용, , ");
		TreeNode Y224 = floor12.addChildNode("Y224:캡스톤디자인");
		Y224.setleafnode("224:캡스톤디자인,홍길동,안정장비착용, , ");
		
		TreeNode Y314 = floor13.addChildNode("Y314:에너지환경촉매연구실"); // 3공3층
		Y314.setleafnode("Y314:에너지환경촉매연구실,홍길동,안정장비착용, , ");
		TreeNode Y321 = floor13.addChildNode("Y321:지능형시스템연구실");
		Y321.setleafnode("Y321:지능형시스템연구실,홍길동,안정장비착용, , ");
		TreeNode Y325 = floor13.addChildNode("Y325:반응공학연구실");
		Y325.setleafnode("Y325:반응공학연구실,홍길동,안정장비착용, , ");
		
	}
	
	public void updateTree(TreeNode A) {// 업데이트
		root=A;
	}
	
	public TreeNode Tree() { // 트리반환
		return root;
	}
	
	public TreeNode[] reTree(TreeNode i[], int j) { // 자식트리 반환
		int k = i[j].getChildNodeArray().size();
		TreeNode s[]= new TreeNode[k];
		
		for(int a=0 ; a<i[j].getChildNodeArray().size() ; a++) {
				s[a]=i[j].getChildNodeArray().get(a);
		}
		return s;
	}
	
	public JButton[] reButton(TreeNode a[], int b) { // 트리 수 만큼 버튼반환
		
		JButton bk[]=new JButton[a[b].getChildNodeArray().size()];
		
		for(int i =0; i<a[b].getChildNodeArray().size();i++) {
			bk[i]= new JButton(a[b].getChildNodeArray().get(i).getNodeName());
		}
		return bk;
	}
	
}

