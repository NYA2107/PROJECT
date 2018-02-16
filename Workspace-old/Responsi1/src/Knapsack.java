
import java.util.*;


public class Knapsack {
	public void knapsack(List<Node> list, int max) {
		int curr = 0;
		int i = 0;
		List<Node> newlist = new LinkedList<Node>();
		newlist.clear();
		for (Node a : list) {
			if(a.hasilTest<= max - curr) {
				newlist.add(list.get(i));
				curr = curr + a.hasilTest;
			}
			i++;
		}
		//PRINT
		System.out.println("===================ACCEPTED===================");
		System.out.println("+--------------------------------------------+");
		System.out.println("|         Nama       |   Usia   | Hasil Test |");
		System.out.println("+--------------------------------------------+");
		for (Node v1 : newlist) {
			System.out.printf("|%-20s|%-10s|%-12s|\n",v1.nama,v1.usia,v1.hasilTest);
		}
		System.out.println("+--------------------------------------------+");
		System.out.println("==============================================");
	}
}
