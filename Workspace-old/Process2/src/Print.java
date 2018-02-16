import java.util.*;

public class Print {

	
	public static void print(List<Node> p, int sizeBT) {
		System.out.println("+===================================================================+");
		System.out.println("|  Proses  |    AT    |    BT    |PROCESSED AT|    WT    |    TAT   |");
		System.out.println("+-------------------------------------------------------------------+");
		for(Node b : p) {
			System.out.printf("|%-10s|%-10s|%-10s|%-12s|%-10s|%-10s|\n",b.name,b.AT,b.BT,b.P,b.WT,b.TAT);
		}
		System.out.println("+===================================================================+\n");
		
		for(Node c : p) {
			System.out.print (c.name +"("+c.P+")" + "|");
			for (int d = 0; d< c.BT;d++) {
				System.out.print("-");
			}
			System.out.print ("|");
		}
		System.out.print("("+sizeBT+")\n\n");
		hitung(p , p.size());
	}
	
	public static void hitung(List<Node> p, int sizeP) {
		double AWT = 0;
		double ATAT = 0;
		for(Node a : p) {
			AWT += a.WT;
			ATAT += a.TAT;
		}
		AWT = AWT/sizeP;
		ATAT = ATAT/sizeP;
		System.out.println("Average Waiting Time : " + AWT);
		System.out.println("Average Turnaround Time : " + ATAT+"\n");
	}
}

