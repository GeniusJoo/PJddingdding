package test;

import java.util.ArrayList;

public class information {
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
			orr =0;
		}
	}
	
	ArrayList[] student_info(){ // 학생정보
		
		ArrayList<stu>[] st = new ArrayList[10];
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
		
		return st;
	}
	
	class stu{
		int number; // 학생번호
		String name; // 학생이름
		String pass; //학생 패스워드
		int orr;
		 
		public stu() {}
		public stu(int a, String b, String c) {
			number = a;
			name = b;
			pass = c;
			orr=0;
		}
	}
}

