import java.util.Comparator;

public class Node {
	
	String name;
	public int BT;
	public int WT;
	public int P;
	public int TAT;
	public int AT;
	Node(String name, int BT, int AT){
		this.name = name;
		this.BT = BT;
		this.AT = AT;
	}

}
class SortAT implements Comparator<Node>{
    
    public int compare(Node a, Node b){
        return a.AT - b.AT;
    }
}
class SortBT implements Comparator<Node>{
    
    public int compare(Node a, Node b){
        return a.BT - b.BT;
    }
}