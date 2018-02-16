package Graph;

import java.util.*;
import Node.*;

public class MultiTrackChecking {
	
	public static void multiTrackChecking(LinkedList<Node> a, String Source, String Destination, double Value) {
		boolean sama = false;
		if(a.isEmpty()) {
			a.add(new Node(Source, Destination, Value));
		}
		else {
			for(int i = 0; i < a.size();i++) {
				if((Source.equals(a.get(i).Source) && Destination.equals(a.get(i).Destination))||(Source.equals(a.get(i).Destination) && Destination.equals(a.get(i).Source))) {
					sama = true;
					if(Value < a.get(i).Value) {
						a.get(i).Value = Value;
					}
					break;
				}
				else {
					sama = false;
				}
		
			}
			if(!sama) {
				a.add(new Node(Source, Destination, Value));
			}
		}
		
		
		
	}
	
}
