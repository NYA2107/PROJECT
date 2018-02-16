import java.util.*;

public class Main {

	public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	while(true) {
		System.out.println("Masukkan ukuran Heap : ");
		int allSize = scan.nextInt();
			if (allSize>=6) {
				Heap heap = new Heap(allSize);
					for(int a = 1 ; a<=allSize ; a++) {
						System.out.print("Masukkan data (prioritas diikuti oleh nama): ");
						heap.insert(scan.nextInt(), scan.next(), scan.nextInt());													
					}
				heap.print();
				break;
			}
			else {
				System.out.println("Data harus lebih dari 5");
			}
		}
	}
}
	
	


