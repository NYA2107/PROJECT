package Graph;

import java.util.*;

import Node.*;

public class Sort {
	
	public static void sort(LinkedList<Node> a) {
		Collections.sort(a, new Sorting());
	}
	
	
	
}


class Sorting implements Comparator<Node>{
    
    public int compare(Node a, Node b){
        return (int) (a.Value - b.Value);
    }
}