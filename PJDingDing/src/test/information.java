package test;

import java.util.ArrayList;

import javax.swing.JButton;

public class information {
	static TreeNode root;
	static ArrayList<stu>[] st = new ArrayList[10];
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
			orr =-1;
		}
	}
	
	void student_infoset(){ // �л�����
		
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
	}
	
	class stu{
		int number; // �л���ȣ
		String name; // �л��̸�
		String pass; //�л� �н�����
		int orr;
		String clorr;// ���ǽ� ���࿩��

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
	
	public void Treeset() { // ���ǽ� Ʈ�� ����
		root = new TreeNode("�������б� �ڿ�ķ�۽�");
		
		TreeNode EB5 = root.addChildNode("5���а�");// 5���а�
		TreeNode EB1 = root.addChildNode("1���а�");// 3���а�
		
		TreeNode floor51 = EB5.addChildNode("5��_1��"); // 5�� ����
		TreeNode floor52 = EB5.addChildNode("5��_2��");
		TreeNode floor53 = EB5.addChildNode("5��_3��");
		
		TreeNode Y5101 = floor51.addChildNode("Y5101:�����۾���"); // 5��1��
		Y5101.setleafnode("Y5101:�����۾���,ȫ�浿,�����������, , "); // �� ���ǽ� ���� �ֱ�
		TreeNode Y5107 = floor51.addChildNode("Y5107:�Թ������2");
		Y5107.setleafnode("YY5107:�Թ������2,ȫ�浿,�����������, , "); // �� ���ǽ� ���� �ֱ�
		TreeNode Y5110 = floor51.addChildNode("Y5110:�Թ������1");
		Y5110.setleafnode("Y5110:�Թ������1,ȫ�浿,�����������, , "); // �� ���ǽ� ���� �ֱ�
		
		TreeNode Y5221 = floor52.addChildNode("Y5221:��û����"); // 5��2��
		Y5221.setleafnode("Y5221:��û����,ȫ�浿,�����������, , ");
		TreeNode Y5235 = floor52.addChildNode("Y5235:��û����");
		Y5235.setleafnode("Y5235:��û����,ȫ�浿,�����������, , ");
		TreeNode Y5243 = floor52.addChildNode("Y5243:�л�ȸ��");
		Y5243.setleafnode("Y5243:�л�ȸ��,ȫ�浿,�����������, , ");
		
		TreeNode Y5319 = floor53.addChildNode("Y5319:����������"); // 5��3��
		Y5319.setleafnode("Y5319:����������,ȫ�浿,�����������, , ");
		TreeNode Y5329 = floor53.addChildNode("Y5329:���������");
		Y5329.setleafnode("Y5329:���������,ȫ�浿,�����������, , ");
		TreeNode Y5337 = floor53.addChildNode("Y5337:�������");
		Y5337.setleafnode("Y5337:�������,ȫ�浿,�����������, , ");
		
		TreeNode floor11 = EB1.addChildNode("1��_1��"); // 1�� ����
		TreeNode floor12 = EB1.addChildNode("1��_2��");
		TreeNode floor13 = EB1.addChildNode("1��_3��");
		
		TreeNode Y114 = floor11.addChildNode("Y114:��ȸ��"); // 3�� 1��
		Y114.setleafnode("Y114:��ȸ��,ȫ�浿,�����������, , ");
		TreeNode Y115 = floor11.addChildNode("Y115:�кν����");
		Y115.setleafnode("Y115:�кν����,ȫ�浿,�����������, , ");
		TreeNode Y131 = floor11.addChildNode("Y131:������ �л�ȸ��");
		Y131.setleafnode("Y131:������ �л�ȸ��,ȫ�浿,�����������, , ");
		
		TreeNode Y201 = floor12.addChildNode("Y201:��ǻ�ͽǽ���"); // 3��2��
		Y201.setleafnode("Y201:��ǻ�ͽǽ���,ȫ�浿,�����������, , ");
		TreeNode Y219 = floor12.addChildNode("Y219:���뿬����");
		Y219.setleafnode("Y219:���뿬����,ȫ�浿,�����������, , ");
		TreeNode Y224 = floor12.addChildNode("Y224:ĸ���������");
		Y224.setleafnode("224:ĸ���������,ȫ�浿,�����������, , ");
		
		TreeNode Y314 = floor13.addChildNode("Y314:������ȯ���˸ſ�����"); // 3��3��
		Y314.setleafnode("Y314:������ȯ���˸ſ�����,ȫ�浿,�����������, , ");
		TreeNode Y321 = floor13.addChildNode("Y321:�������ý��ۿ�����");
		Y321.setleafnode("Y321:�������ý��ۿ�����,ȫ�浿,�����������, , ");
		TreeNode Y325 = floor13.addChildNode("Y325:�������п�����");
		Y325.setleafnode("Y325:�������п�����,ȫ�浿,�����������, , ");
		
	}
	
	public void updateTree(TreeNode A) {// ������Ʈ
		root=A;
	}
	
	public TreeNode Tree() { // Ʈ����ȯ
		return root;
	}
	
	public TreeNode[] reTree(TreeNode i[], int j) { // �ڽ�Ʈ�� ��ȯ
		int k = i[j].getChildNodeArray().size();
		TreeNode s[]= new TreeNode[k];
		
		for(int a=0 ; a<i[j].getChildNodeArray().size() ; a++) {
				s[a]=i[j].getChildNodeArray().get(a);
		}
		return s;
	}
	
	public JButton[] reButton(TreeNode a[], int b) { // Ʈ�� �� ��ŭ ��ư��ȯ
		
		JButton bk[]=new JButton[a[b].getChildNodeArray().size()];
		
		for(int i =0; i<a[b].getChildNodeArray().size();i++) {
			bk[i]= new JButton(a[b].getChildNodeArray().get(i).getNodeName());
		}
		return bk;
	}
	
}

