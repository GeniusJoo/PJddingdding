package test;

import java.util.ArrayList;

public class TreeNode {
	private String nodeName; // ���� ����� �̸�
	private TreeNode parentNode; // �θ� ���
	private ArrayList<TreeNode> childNodeArray = new ArrayList<>();// �ڽ� array
	
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
	
	public void searchAllTreeNode() { // ��� ��ü ��
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
