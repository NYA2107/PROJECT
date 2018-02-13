import java.util.*;

public class Main {

	public static void main(String[] args) {
	Node array = new Node();
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Masukkan ukuran Heap : ");
	int allSize = scan.nextInt();
	Heap heap = new Heap(allSize);
		for(int a = 1 ; a<=allSize ; a++) {
			System.out.print("Masukkan data : ");
			heap.insert(scan.nextInt(), scan.next());
			
				
		}
	heap.print();
	}
}
	
	


