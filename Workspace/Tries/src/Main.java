

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Tries tries = new Tries();
		do {
			System.out.println("=========Trie Test=========");
	        System.out.println("||Menu :                 ||");
	        System.out.println("||1. Input kata          ||");
	        System.out.println("||2. Hapus kata          ||");
	        System.out.println("||3. Cari kata           ||");
	        System.out.println("||4. Print tries         ||");
	        System.out.println("||5. Exit                ||");
	        System.out.println("===========================");
	        System.out.print("Pilih : ");
	        int pilihan = scan.nextInt();
	        switch (pilihan) {
			case 1:
				System.out.println("   ======Menu Input======");
				System.out.print("Berapa kata yang akan anda input = ");
				int temp = scan.nextInt();
				for(int i = 0 ; i < temp ; i ++) {
					System.out.print("Masukan kata : ");
					tries.insert(scan.next());
				}
				System.out.println("\t ~ Data berhasil dimasukan ~ ");
				break;
			case 2:
				System.out.println("   ======Menu Hapus======");
				System.out.print("Masukan kata : ");
				tries.remove(scan.next());
				break;
			case 3:
				System.out.println("   ======Menu Cari======");
				System.out.print("Masukan kata : ");
				if(tries.search(scan.next())){
					System.out.println("\t ~Kata ditemukan !~");	
				}
				else {
					System.out.println("\t ~Kata tidak ditemukan !~");
				}
				break;
			case 4:
				System.out.println("   ======Menu Print======");
				tries.print();
				break;
			case 5:
				System.out.println("Exiting...1");
				scan.close();
				System.exit(0);
			default:
				System.out.println("Menu tidak ada");
				break;
			}
		}while(true);
	}

}
