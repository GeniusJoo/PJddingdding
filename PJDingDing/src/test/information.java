package test;

import java.util.ArrayList;

public class information {
	ArrayList[] library_info() { // ������ �ڸ�
		ArrayList<lib>[] lt = new ArrayList[25];
		
		for(int j=0;j<25;j++) {
			lib s = new lib(j);
			lt[j] = new ArrayList<lib>();
			lt[j].add(s);
		}
		
		return lt;
	}
	class lib{ // ����Ʈ �� ����
		int number; // �¼���ȣ
		int name; // �¼� ������
		int time; //�¼��ð�
		int orr; //�¼� ���� �Ϸ� 
		public lib() {}
		public lib(int a) {
			number = a+1;
			name = 0;
			time = 0;
			orr =0;
		}
	}
	
	ArrayList[] student_info(){ // �л�����
		
		ArrayList<stu>[] st = new ArrayList[10];
		stu s0 = new stu(60000000, "������","1234");
		st[0] = new ArrayList<stu>();
		st[0].add(s0); 
		
		stu s1 = new stu(60000001, "ȫ�浿","1234");
		st[1] = new ArrayList<stu>();
		st[1].add(s1); 
		
		stu s2 = new stu(60000002, "���±�","1234");
		st[2] = new ArrayList<stu>();
		st[2].add(s2); 
		
		stu s3 = new stu(60000003, "�ּ���","1234");
		st[3] = new ArrayList<stu>();
		st[3].add(s3); 
		
		stu s4 = new stu(60000004, "������","1234");
		st[4] = new ArrayList<stu>();
		st[4].add(s4); 
		
		stu s5 = new stu(60000005, "����","1234");
		st[5] = new ArrayList<stu>();
		st[5].add(s5); 
		
		stu s6 = new stu(60000006, "�弮ȣ","1234");
		st[6] = new ArrayList<stu>();
		st[6].add(s6); 
		
		stu s7 = new stu(60000007, "������","1234");
		st[7] = new ArrayList<stu>();
		st[7].add(s7); 
		
		stu s8 = new stu(60000008, "�Ǽ�ȯ","1234");
		st[8] = new ArrayList<stu>();
		st[8].add(s8); 
		
		stu s9 = new stu(60000009, "����ȯ","1234");
		st[9] = new ArrayList<stu>();
		st[9].add(s9); 
		
		return st;
	}
	
	class stu{
		int number; // �л���ȣ
		String name; // �л��̸�
		String pass; //�л� �н�����
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

