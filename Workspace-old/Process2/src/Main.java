import java.util.*;


public class Main {

	public static void main(String[] args) {
		
		LinkedList<Node> p = new LinkedList<Node>();
		//LinkedList<Node> l = new LinkedList<Node>();
		
		
		FIFO fi = new FIFO();
		SJF sjf = new SJF();
		int sizeBT = 0;
		int sizeProcess= 0;
		
		
		Scanner scan = new Scanner(System.in);
		
		/*System.out.print("Masukkan jumlah proses : ");
		sizeProcess = scan.nextInt();
		System.out.println("Masukkan namaProses burstTime arrivalTime : ");
		System.out.println("(ex: P1 2 5)");
		for(int i = 0; i < sizeProcess;i++) {
			System.out.print("Masukkan proses : ");
			p.add(new Node(scan.next(), scan.nextInt(), scan.nextInt()));
		}*/
		
		p.add(new Node("P1" , 4 , 2));
		p.add(new Node("P2", 2 , 0));
		p.add(new Node("P3", 1 , 2));
//		p.add(new Node("P4", 8 , 5));
//		p.add(new Node("P5", 7, 9));
		
		//p = l;
		//Find total size of BT
		for(Node a : p) {
			sizeBT += a.BT;
			sizeProcess++;
			
		}
		
		
		//FIFO
		System.out.println("==================================FIFO===============================");
		Collections.sort(p, new SortAT());
		//System.out.println(p.get(0).AT);
		fi.fifo(p, sizeBT);
		Print.print(p, sizeBT+p.get(0).P);
		
		//SJF
		System.out.println("==================================SJF================================");
		//Collections.sort(p, new SortAT());
		sjf.sjf(p, sizeBT, sizeProcess);
		Print.print(p, sizeBT+p.get(0).P);
		
		
	}

}
