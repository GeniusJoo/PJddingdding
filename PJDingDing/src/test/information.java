package test;

import java.util.ArrayList;

import javax.swing.JButton;

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
	
	public TreeNode Tree() {
		TreeNode root = new TreeNode("root");
		
		TreeNode EB5 = root.addChildNode("5���а�");// 5���а�
		TreeNode EB1 = root.addChildNode("1���а�");// 3���а�
		
		TreeNode floor51 = EB5.addChildNode("1��"); // 5�� ����
		TreeNode floor52 = EB5.addChildNode("2��");
		TreeNode floor53 = EB5.addChildNode("3��");
		
		TreeNode Y5101 = floor51.addChildNode("Y5101:�����۾���"); // 5��1��
		TreeNode Y5107 = floor51.addChildNode("Y5107:�Թ������2");
		TreeNode Y5110 = floor51.addChildNode("Y5110:�Թ������1");
		
		TreeNode Y5221 = floor52.addChildNode("Y5221:��û����"); // 5��2��
		TreeNode Y5235 = floor52.addChildNode("Y5235:��û����");
		TreeNode Y5243 = floor52.addChildNode("Y5243:�л�ȸ��");
		
		TreeNode Y5319 = floor53.addChildNode("Y5319:����������"); // 5��3��
		TreeNode Y5329 = floor53.addChildNode("Y5329:���������");
		TreeNode Y5337 = floor53.addChildNode("Y5337:�������");
		
		TreeNode floor11 = EB1.addChildNode("1��"); // 1�� ����
		TreeNode floor12 = EB1.addChildNode("2��");
		TreeNode floor13 = EB1.addChildNode("3��");
		
		TreeNode Y114 = floor11.addChildNode("Y114:��ȸ��"); // 3�� 1��
		TreeNode Y115 = floor11.addChildNode("Y115:�кν����");
		TreeNode Y131 = floor11.addChildNode("Y131:������ �л�ȸ��");
		
		TreeNode Y201 = floor12.addChildNode("Y201:��ǻ�ͽǽ���"); // 3��2��
		TreeNode Y219 = floor12.addChildNode("Y219:���뿬����");
		TreeNode Y224 = floor12.addChildNode("Y224:ĸ���������");
		
		TreeNode Y314 = floor13.addChildNode("Y314:������ȯ���˸ſ�����"); // 3��3��
		TreeNode Y321 = floor13.addChildNode("Y321:�������ý��ۿ�����");
		TreeNode Y325 = floor13.addChildNode("Y325:�������п�����");
		
		
		return root;
	}
	
	public TreeNode[] reTree(TreeNode i[], int j) {
		int k = i[j].getChildNodeArray().size();
		TreeNode s[]= new TreeNode[k];
		
		for(int a=0 ; a<i[j].getChildNodeArray().size() ; a++) {
				s[a]=i[j].getChildNodeArray().get(a);
		}
		return s;
	}
	
	public JButton[] reButton(TreeNode a[], int b) {
		
		JButton bk[]=new JButton[a[b].getChildNodeArray().size()];
		
		for(int i =0; i<a[b].getChildNodeArray().size();i++) {
			bk[i]= new JButton(a[b].getChildNodeArray().get(i).getNodeName());
		}
		return bk;
	}
	
}

