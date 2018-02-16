import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		List<Node> list = new LinkedList<Node>();
		Heap heap = new Heap();
		Knapsack knap = new Knapsack();
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("+======RESPONSI======+\n"
					+ 		   "|1.Input Data        |\n"
					+ 		   "|2.Tampilkan Sort    |\n"
					+ 		   "|3.Tampilkan Diterima|\n"
					+  		   "|4.Exit              |\n"
					+ 		   "+====================+\n"
					+  		   "Masukkan Pilihan : ");
			int menu = scan.nextInt();
			
			switch(menu) {
				case 1 :{
					/*
					list.add(new Node("Riko", 22, 83));
					list.add(new Node("Johan", 22, 76));
					list.add(new Node("Jabar", 26, 77));
					list.add(new Node("Shodiq", 23, 78));
					list.add(new Node("Maimunah", 23, 82));
					list.add(new Node("Anik", 26, 71));
					list.add(new Node("Qodir", 21, 75));
					list.add(new Node("Nonik", 22, 84));
					list.add(new Node("Devi", 23, 73));
					list.add(new Node("Dodo", 25, 81));//10*/
					
			
					list.clear();
					System.out.println("\n+===============INPUT DATA================+");
					System.out.print("Masukkan Banyak Data :");
					int dataLength = scan.nextInt();
					System.out.println();
					int i = 0;
					System.out.println("--------------Masukkan Data----------------");
					System.out.println("Nama Usia HasilTest (ex : Paijo 20 60) :");
					while(i < dataLength) {
						System.out.print("Masukkan Data :");
						list.add(new Node(scan.next(),scan.nextInt(),scan.nextInt()));
						i++;
					}//albertus.wirawan@student.uns.ac.id
					System.out.println("\n");
					
					
					break;
				}
				case 2 :{
					heap.sort(list);
					break;
				}
				case 3 :{
					knap.knapsack(list, 330);
					break;
				}
				case 4:{
					System.out.println("BYE BYE BYE");
					scan.close();
					System.exit(0);
				}
			}
		}while(true);
		
		
	}

}
