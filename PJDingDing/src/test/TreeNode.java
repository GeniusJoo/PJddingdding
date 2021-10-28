package test;

import java.util.ArrayList;

public class TreeNode {
	private String nodeName; // 현재 노드의 이름
	private TreeNode parentNode; // 부모 노드
	private ArrayList<TreeNode> childNodeArray = new ArrayList<>();// 자식 array
	
	TreeNode(String nodeName) { // 노드 생성자
		this.nodeName = nodeName;
		parentNode = null;
	}
	
	public void setParentNode(TreeNode parentNode) { // 부모노드 set
		this.parentNode = parentNode;
	}
	
	public TreeNode addChildNode(String nodeName) { // 다중자식노드 add 함수
		TreeNode childNode = new TreeNode(nodeName);
		childNode.setParentNode(this);
		getChildNodeArray().add(childNode);
		
		return childNode;		
	}
	
	public void searchAllTreeNode() { // 노는 전체 출
		checkNowTreeInfo();

		for(int i=0 ; i<getChildNodeArray().size() ; i++) {
			TreeNode childNode = getChildNodeArray().get(i);
			childNode.searchAllTreeNode();
		}
	}
	
	public void checkNowTreeInfo() {
		System.out.println("-------------------노드 정보 확인-------------------");
		
		if(parentNode != null)
			System.out.println("부모 노드 : "+parentNode.getNodeName());
		else
			System.out.println("부모 노드 : 없음");
		
		System.out.println("현재 노드 : "+nodeName);
		System.out.println("자식 노드 갯수 : "+getChildNodeArray().size());
		System.out.println("자식 노드 명단");
		
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
