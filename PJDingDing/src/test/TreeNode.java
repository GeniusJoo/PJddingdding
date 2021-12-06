package test;

import java.util.ArrayList;

public class TreeNode {
	private String nodeName; // ���� ����� �̸�
	private TreeNode parentNode; // �θ� ���
	private ArrayList<TreeNode> childNodeArray = new ArrayList<>();// �ڽ� array
	private String k;
	private String[] info;

	
	TreeNode(String nodeName) { // ��� ������
		this.nodeName = nodeName;
		parentNode = null;
	}
	
	public void setParentNode(TreeNode parentNode) { // �θ��� set
		this.parentNode = parentNode;
	}
	
	public TreeNode addChildNode(String nodeName) { // �����ڽĳ�� add �Լ�
		TreeNode childNode = new TreeNode(nodeName);
		childNode.setParentNode(this);
		getChildNodeArray().add(childNode);
		
		return childNode;		
	}
	
	public void searchAllTreeNode() { // ��� ��ü ���
		checkNowTreeInfo();

		for(int i=0 ; i<getChildNodeArray().size() ; i++) {
			TreeNode childNode = getChildNodeArray().get(i);
			childNode.searchAllTreeNode();
		}
	}
	
	public void checkNowTreeInfo() {
		System.out.println("-------------------��� ���� Ȯ��-------------------");
		
		if(parentNode != null)
			System.out.println("�θ� ��� : "+parentNode.getNodeName());
		else
			System.out.println("�θ� ��� : ����");
		
		System.out.println("���� ��� : "+nodeName);
		System.out.println("�ڽ� ��� ���� : "+getChildNodeArray().size());
		System.out.println("�ڽ� ��� ���");
		
		for(int i=0 ; i<getChildNodeArray().size(); i++) {
			TreeNode childNode = getChildNodeArray().get(i);
			System.out.print(i+":"+childNode.getNodeName()+"   ");
		}
		
		System.out.println("\n-----------------------------------------------\n");			
	}
	
	public String searchAllNode(String s) { // ��� ��ü ���
		int k = searchNode(s);
		if(k==1){
			return getNodeName();
		}else {
			for(int i=0 ; i<getChildNodeArray().size() ; i++) {
				TreeNode childNode = getChildNodeArray().get(i);
				String b = childNode.searchAllNode(s);
				if(b.equals("����")){
					
				}else {
					return childNode.getParentNode().getNodeName()+" -> "+b;
				}
			}
			return "����";
		}
	}
	
	public TreeNode findnode(String name) {
		int k= searchNode(name);
		if(k==1) {
			return this;
		}else {
			TreeNode b = null;
			for(int i=0 ; i<getChildNodeArray().size() ; i++) {
				TreeNode childNode = getChildNodeArray().get(i);
				b=childNode.findnode(name);
				if(b!=null){

					return b;
				}
			}

		}
		return null;
	}
	
	public String[] nodeString() { // ����̸����� ����Ʈ���� �迭ȭ �Ѵ�
		String [] a = null;
		ArrayList<String> members = new ArrayList<String>();
		members=Stringfind();
		int arrListSize = members.size();
		Stringfind();
		a=members.toArray(new String[arrListSize]);
		return a;
	}
	
	public ArrayList<String> Stringfind() {// ����̸��� ����Ʈ���Ѵ�
		ArrayList<String> members = new ArrayList<String>();
		members.add(nodeName);
		if(childNodeArray.isEmpty()) {
			return members;
		}else {
			for(int i=0 ; i<getChildNodeArray().size() ; i++) {
				TreeNode childNode = getChildNodeArray().get(i);
				members.addAll(childNode.Stringfind());
			}
			return members;
		}
	}
	
	public int searchNode(String s){ // ���� ��� �̸����� �Ǵ��Ѵ�
		if(s.equals(getNodeName())){
			return 1;
		}
		return 0;
	}
	
	public void setleafnode(String s){ // ���� ��忡 ������ �����Ѵ�
		if(childNodeArray.isEmpty()){
			k=s;
			info = k.split(",");
		}
	}
	
	public String[] getleafnode() {
		return info;
	}
	
	public String getNodeName() {
		return nodeName;
	}
	
	public TreeNode getParentNode() {
		return parentNode;
	}

	public ArrayList<TreeNode> getChildNodeArray() {
		return childNodeArray;
	}
}
