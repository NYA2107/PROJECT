package Graph;
import java.util.*;
import Node.*;


public class Prim {
	
	public static void prim(LinkedList<Node> a) {
		LinkedList<Node> hasil = new LinkedList<Node>();
		LinkedList<Node> titik = new LinkedList<Node>();
		boolean sourceSama = false;
		boolean destinationSama = false;
		int i = 0;
		
		while(!a.isEmpty()) {
		
			if(hasil.isEmpty()) {
				hasil.add(a.get(i));
				titik.add(new Node(a.get(i).Source));
				titik.add(new Node(a.get(i).Destination));
				a.remove(i);
			}
			else {
				for(int j = 0 ; j < titik.size()  ; j++) {
					
					if(a.get(i).Source.equals(titik.get(j).Point) ) {
						sourceSama = true;
						break;
					}
					else {
						sourceSama = false;
					}
				}
				for(int g = 0 ; g < titik.size(); g++) {
					if(a.get(i).Destination.equals(titik.get(g).Point) ) {
						destinationSama = true;
						break;
					}
					else {
						destinationSama = false;
					}
				}
				
				if(sourceSama && !destinationSama) {
					hasil.add(a.get(i));
					titik.add(new Node(a.get(i).Destination));
					a.remove(i);
					i = 0;
				}
				else if(!sourceSama && destinationSama) {
					hasil.add(a.get(i));
					titik.add(new Node(a.get(i).Source));
					a.remove(i);
					i = 0;
					
				}
				
				else if(sourceSama && destinationSama) {
					a.remove(i);
					i = 0;
				}
				
				else if(!sourceSama && !destinationSama) {
					i++;
				}
			
				
			}
		}
		
		a.addAll(hasil);
		
	}
	
}
