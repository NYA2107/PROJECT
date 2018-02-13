
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Operation {
	
	private LinkedList<Node> charFrequency;
	private Scanner in;
	private String text;
	private Tree tree;
	
	public String getText() {
		return text;
	}
	
	public Operation() {
		this.text = "";
		in = new Scanner(System.in);
		charFrequency = new LinkedList<Node>();
	}
	
	public void inputByText() throws FileNotFoundException {
		System.out.print("\t\tInput File Location : ");
		String location = in.next();
		File read = new File(location);
		try {
			Scanner fileReader = new Scanner(read);
			while(fileReader.hasNextLine()) {
				text += fileReader.nextLine() + "\n";
			}
			fileReader.close();
		
		} catch (Exception e) {
			System.out.println("\t\tFile not found !");
			return;
		}
		countFrequencyEachChar();
		buildTree();
	}
	
	public void inputByManual() {
		System.out.print("\t\tInput String : ");
		text = in.nextLine();
		countFrequencyEachChar();
		buildTree();
	}
	
	public void showText() {
		System.out.println(text);
	}
	
	public void showHuffmanCode() {
		tree.printTree();
	}
	
	public void testString() {
		System.out.println("\t\tSimulation Menu");
		System.out.print("\t\tInput Text : ");
		String tempString = in.nextLine();
		System.out.println("\t\tResult : ");
		System.out.println("\t\t" + Encode.encode(tempString, tree));
	}
	
	private void countFrequencyEachChar() {
		StringBuilder tempString = new StringBuilder(text);
		for(int i = 0 ; i < tempString.length() ; i++) {
			Character ch = tempString.charAt(i);
			int freq = CountFrequency.count(ch, tempString);
			charFrequency.add(new Node(ch.toString(),freq));
			i--;
		}
	}
	
	private void buildTree() {
		tree = new Tree(charFrequency);
	}
}
