import java.util.*;

public class Node {
	
	public int weight;
	public int value;
	public String name;
	
	Node(String name, int weight, int value) {
		this.weight = weight;
		this.value = value;
		this.name = name;
	}
}

//Comparator (positive and 0 = not swap, negative = swap)
class Sortbyweight implements Comparator<Node>{
    
    public int compare(Node a, Node b){
        return a.weight - b.weight;
    }
}
class Sortbyvalue implements Comparator<Node>{
    
    public int compare(Node a, Node b){
        return b.value - a.value;
    }
}

class Sortbydensity implements Comparator<Node>{
  
     public int compare(Node a, Node b){
        return (b.value/b.weight) - (a.value/a.weight);
     }
}

