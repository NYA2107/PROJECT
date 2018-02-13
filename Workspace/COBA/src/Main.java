import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> a = new HashMap <Integer, String>();
		a.put(2, "C");
		a.put(1, "A");
		
	
		
		for(Integer s : a.keySet()) {
			System.out.println(s);
		}
	}

}
