

import java.util.*;

public class Tree {
	
	private Node root;
	
	public Node getRoot() {
		return root;
	}
	
	public Tree(LinkedList<Node>data) {
		buildTree(data);
		startCodeEachLeaf(root,"");
	}
	
	private void buildTree(LinkedList<Node>data) {
		while(data.size() > 1) {
			data.sort(new ValueComparator());
			Node left = data.poll();
			Node right = data.poll();
			String tempData = left.getData() + right.getData();
			int tempValue = left.getValue() + right.getValue();
			data.addFirst(new Node(tempData,tempValue,left,right));
		}
		root = data.poll();
	}
	
	private void startCodeEachLeaf(Node curr,String result) {
		if(curr.isLeaf()) {
			curr.setCode(result);
			return;
		}
		startCodeEachLeaf(curr.getLeft(),result + '1');
		startCodeEachLeaf(curr.getRight(),result + '0');
		
	}
	
	
	public void printTree() {
		System.out.println("||=========||============||============||");
		System.out.println("||  Char   || Frequency  ||     Code   ||");
		System.out.println("||=========||============||============||");
		inOrder(root);
		System.out.println("||=========||============||============||");
		System.out.println();
	}
	
	private void inOrder(Node curr) {
		if(curr == null) {
			return;
		}
		inOrder(curr.getLeft());
		if(curr.isLeaf()) {
			String enterTemp = curr.getData().contains("\n") ? "(enter)" : curr.getData();
			System.out.printf("||%-9s||%-12d||%-12s||\n",enterTemp,curr.getValue(),curr.getCode());
		}
		inOrder(curr.getRight());
	}
}

class ValueComparator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		return o1.getValue() <= o2.getValue() ? -1 : 1;
	}
	
}