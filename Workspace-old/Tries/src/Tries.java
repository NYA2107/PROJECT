import java.util.LinkedList;

public class Tries {
	
	private Node root;
	
	/***************
	 * Constructor *
	 ***************/
	public Tries() {
		root = new Node(' ');
	}
	
	/**********
	 * Insert *
	 **********/
	public void insert(String word) {
		if(search(word) == true) {
			System.out.println("Kata yang dimasukan sudah ada pada tries ! ");
			return;
		}
		Node current = root;
		for(char ch : word.toCharArray()) {
			Node child = current.subNode(ch);
			if(child != null) {
				current = child;
			}
			else {
				current.childList.add(new Node(ch));
				current = current.subNode(ch);
			}
			current.count++;
		}
		current.isEnd = true;
	}
	
	
	/**********
	 * Search *
	 **********/
	public boolean search(String word) {
		Node current = root;
		for(char ch : word.toCharArray()) {
			if(current.subNode(ch) == null) {
				return false;
			}
			else {
				current = current.subNode(ch);
			}
		}
		if(current.isEnd == true) {
			return true;
		}
		
		return false;
	}
	
	
	/**********
	 * Delete *
	 **********/
	public void remove(String word) {
		if(search(word) == false) {
			System.out.println("\t ~ Kata " + word +" tidak ada dalam tries !");
			return;
		}
		Node current = root;
		String wd = word;
		for(char ch : word.toCharArray()) {
			Node child = current.subNode(ch);
			if(child.count == 1) {
				current.childList.remove(child);
				System.out.println("\t ~ Kata " + wd + " telah terhapus");
				return;
			}
			else {
				child.count--;
				current = child;
			}
		}
	}
	
	
	/*********
	 * Print *
	 *********/
	public void print() {
		printTries(root.childList,0);
		
	}
	private void printTries(LinkedList<Node> curr, int counter) {
		int loopCounter = 0;
		int spaceCounter = counter;
		for(Node temp : curr) {
			if(loopCounter >= 1 && curr != root.childList) {
				printSpace(spaceCounter);
			}
			if(temp.isEnd) {
				System.out.print("---->!"+temp.content+"!");
			}
			else if(!temp.isEnd){
				System.out.print("---->"+temp.content);
			}
			if(temp.isEnd) {
				System.out.println();
			}
			loopCounter += 1;
			printTries(temp.childList,spaceCounter+1);
		}
	}
	
	private void printSpace(int temp) {
		for(int i = 1 ; i <= temp ; i++) {
			System.out.print("      ");
		}
	}
	
	
	
}
