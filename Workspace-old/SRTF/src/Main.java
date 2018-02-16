import java.util.*;

public class Main {

	public static void main(String[] args) {
		LinkedList<Node>process = new LinkedList<Node>();
		Scanner scan = new Scanner(System.in);
		System.out.print("Masukan Jumlah Proses : ");
		int jml = scan.nextInt();
		System.out.println("====================Masukkan Proses====================== ");
		System.out.println("(Nama ArriveTime BurstTime, ex : P1 0 3)");
		for(int i = 0 ; i < jml ; i++) {
			System.out.print("Masukkan Proses : ");
			process.add(new Node(scan.next(),scan.nextInt(),scan.nextInt()));
		}
		process.sort(new ArrivalTimeComparator());
		SRTF.StartScheduling(process);
		

	}

}
class ArrivalTimeComparator implements Comparator<Node>{

	@Override
	public int compare(Node arg0, Node arg1) {
		return arg0.getArrivalTime() >= arg1.getArrivalTime() ? 1 : -1;
	}
	
}