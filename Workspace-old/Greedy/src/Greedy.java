import java.util.*;

public class Greedy {

	public static void Ulala(){
		List<Node> list = new LinkedList<Node>();
		int maxknap = 0;
		Scanner scan = new Scanner(System.in);
			
		do {
			System.out.println("+=============KNAPSACK PROBLEM=============+");
			System.out.println("|1. Input Data                             |\n"
					+ 		   "|2. Hasil Berdasarkan Value                |\n"
					+ 		   "|3. Hasil Berdasarkan Weight               |\n"
					+ 		   "|4. Hasil Berdasarkan Density              |\n"
					+ 		   "|5. Exit                                   |");
			System.out.println("+==========================================+");
			System.out.print("Pilih Menu : ");
			int menu = scan.nextInt();
			switch(menu) {
				case 1:{
						list.clear();
						System.out.println("\n+===============INPUT DATA================+");
						System.out.print("Masukkan Banyak Data :");
						int dataLength = scan.nextInt();
						System.out.print("Masukkan Kapasitas Knapsack : ");
						maxknap = scan.nextInt();
						System.out.println();
						int i = 0;
						System.out.println("--------------Masukkan Data----------------");
						System.out.println("Nama Weight Value (ex : KipasAngin 5 300) :");
						while(i < dataLength) {
							list.add(new Node(scan.next(),scan.nextInt(),scan.nextInt()));
							i++;
						}
						System.out.println("\n");
						break;
			    }
				case 2 : {
						System.out.println("");
						byValue(list, maxknap);
						System.out.println("");
						break;
				}
				case 3 :{
						System.out.println("");
						byWeight(list, maxknap);
						System.out.println("");
						break;
				}
				case 4 :{
					System.out.println("");
					byDensity(list, maxknap);
					System.out.println("");
					break;
				}
				case 5:{
					System.out.println("\nBYE BYE BYE BYE");
					System.exit(0);
					break;
				}
				default:{
					System.out.println("\nMasukkan Salah\n");
					break;
				}
			}
		}while(true);
		
	}

	
	public static void byValue(List<Node> list,int max) {
		int beratcurr = 0;
		int i = 0;
		Collections.sort(list, new Sortbyvalue());
		List<Node> newlist = new LinkedList<Node>();
		newlist.clear();
		for (Node a : list) {
			if(a.weight<= max - beratcurr) {
				newlist.add(list.get(i));
				beratcurr = beratcurr + a.weight;
			}
			i++;
		}
		System.out.println("=================BY VALUE===================");
		System.out.println("+------------------------------------------+");
		System.out.println("|     Nama Barang    |   Berat  |   Value  |");
		System.out.println("+------------------------------------------+");
		for (Node v1 : newlist) {
			System.out.printf("|%-20s|%-10s|%-10s|\n",v1.name,v1.weight,v1.value);
		}
		System.out.println("+------------------------------------------+");
	}
	
	public static void byWeight(List<Node> list, int max) {
		int beratcurr = 0;
		int i = 0;
		Collections.sort(list, new Sortbyweight());
		List<Node> newlist = new LinkedList<Node>();
		newlist.clear();
		for (Node a : list) {
			if(a.weight<= max - beratcurr) {
				newlist.add(list.get(i));
				beratcurr = beratcurr + a.weight;
			}
			i++;
		}
		System.out.println("=================BY WEIGHT==================");
		System.out.println("+------------------------------------------+");
		System.out.println("|     Nama Barang    |   Berat  |   Value  |");
		System.out.println("+------------------------------------------+");
		for (Node v1 : newlist) {
			System.out.printf("|%-20s|%-10s|%-10s|\n",v1.name,v1.weight,v1.value);
		}
		System.out.println("+------------------------------------------+");
	}
	public static void byDensity(List<Node> list, int max) {
		int beratcurr = 0;
		int i = 0;
		Collections.sort(list, new Sortbydensity());
		List<Node> newlist = new LinkedList<Node>();
		newlist.clear();
		for (Node a : list) {
			if(a.weight<= max - beratcurr) {
				newlist.add(list.get(i));
				beratcurr = beratcurr + a.weight;
			}
			i++;
		}
		System.out.println("=================BY DENSITY=================");
		System.out.println("+------------------------------------------+");
		System.out.println("|     Nama Barang    |   Berat  |   Value  |");
		System.out.println("+------------------------------------------+");
		for (Node v1 : newlist) {
			System.out.printf("|%-20s|%-10s|%-10s|\n",v1.name,v1.weight,v1.value);
		}
		System.out.println("+------------------------------------------+");
	}
	
}
