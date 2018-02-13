
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		LinkedList<Node>process = new LinkedList<Node>();
		int jumlahProses = 0;
		
//		process.add(new Node("P1",0,3,3));
//		process.add(new Node("P2",1,6,4));
//		process.add(new Node("P3",3,1,9));
//		process.add(new Node("P4",2,2,7));
//		process.add(new Node("P5",4,4,8));
		Scanner scan = new Scanner(System.in);
		System.out.print("Masukkan Jumlah Proses : ");
		jumlahProses = scan.nextInt();
		System.out.println("====================Masukkan Proses====================== ");
		System.out.println("(Nama ArriveTime BurstTime Priority, ex : P1 0 3 4)");
		for(int i = 0; i < jumlahProses ; i++) {
			System.out.print("Masukkan Proses : ");
			process.add(new Node(scan.next(), scan.nextInt(), scan.nextInt(), scan.nextInt()));
		}
		
		
		Priority.StartScheduling(process);
	}

}

