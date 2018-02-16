import java.util.Comparator;

public class Node {
	
	String name;
	public int BT;
	public int WT;
	public int P;
	public int TAT;
	
	Node(String name, int BT){
		this.name = name;
		this.BT = BT;
	}

}
class SortBT implements Comparator<Node>{
    
    public int compare(Node a, Node b){
        return a.BT - b.BT;
    }
}