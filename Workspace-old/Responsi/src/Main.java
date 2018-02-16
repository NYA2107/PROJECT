import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Heap heap = new Heap(3);
		
		for(int a = 1 ; a<=3 ; a++) {
			System.out.print("Masukkan data (nama usia hasilTest): ");
			heap.insert(scan.next(), scan.nextInt(), scan.nextInt());													
		}
		heap.mindel();
		
	}

}

