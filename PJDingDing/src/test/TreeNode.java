package test;

import java.util.ArrayList;

public class TreeNode {
	private String nodeName; // 현재 노드의 이름
	private TreeNode parentNode; // 부모 노드
	private ArrayList<TreeNode> childNodeArray = new ArrayList<>();// 자식 array
	private String k;
	private String[] info;

	
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
	
	public void searchAllTreeNode() { // 노드 전체 출력
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
	
	public String searchAllNode(String s) { // 노드 전체 출력
		int k = searchNode(s);
		if(k==1){
			return getNodeName();
		}else {
			for(int i=0 ; i<getChildNodeArray().size() ; i++) {
				TreeNode childNode = getChildNodeArray().get(i);
				String b = childNode.searchAllNode(s);
				if(b.equals("없음")){
					
				}else {
					return childNode.getParentNode().getNodeName()+" -> "+b;
				}
			}
			return "없음";
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
	
	public String[] nodeString() { // 노드이름들을 리스트에서 배열화 한다
		String [] a = null;
		ArrayList<String> members = new ArrayList<String>();
		members=Stringfind();
		int arrListSize = members.size();
		Stringfind();
		a=members.toArray(new String[arrListSize]);
		return a;
	}
	
	public ArrayList<String> Stringfind() {// 노드이름을 리스트로한다
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
	
	public int searchNode(String s){ // 같은 노드 이름인지 판단한다
		if(s.equals(getNodeName())){
			return 1;
		}
		return 0;
	}
	
	public void setleafnode(String s){ // 리프 노드에 정보를 저장한다
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
