import java.awt.print.Printable;
import java.util.*;

//PROGRAM INI UNTUK PROSES YANG DATANG DENGAN WAKTU DATANG = 0

public class Main {

	public static void main(String[] args) {
		
		List<Node> p = new LinkedList<Node>();
		List<Node> j = new LinkedList<Node>();
		
		FIFO fi = new FIFO();
		int sizeBT = 0;
		
		p.add(new Node("P1" , 4));
		p.add(new Node("P2", 6));
		p.add(new Node("P3", 1));
		p.add(new Node("P4", 8));
		
		for(Node a : p) {
			sizeBT += a.BT;
			
		}
		
		//FIFO
		System.out.println("==================FIFO===================");
		fi.fifo(p, sizeBT);
		Print.print(p, sizeBT);
		System.out.println();
		Print.hitung(p, p.size());
		
		//SJF
		System.out.println("==================SJF===================");
		j = p;
		Collections.sort(j, new SortBT());
		fi.fifo(j, sizeBT);
		Print.print(j, sizeBT);
		System.out.println();
		Print.hitung(j, j.size());
	}

}
