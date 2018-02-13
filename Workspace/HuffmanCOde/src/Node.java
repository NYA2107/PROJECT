

public class Node {
	
	private String data;
	private int value;
	private String code;
	private Node left,right;
	
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}
	public String getData() {
		return data;
	}
	public int getValue() {
		return value;
	}
	public boolean isLeaf() {
		return left==null && right==null ? true : false;
	}
	
	public Node(String data,int value) {
		this.data = data;
		this.value= value;
	}
	
	public Node(String data,int value,Node left,Node right) {
		this.data = data;
		this.value= value;
		this.left = left;
		this.right = right;
	}
}
