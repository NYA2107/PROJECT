
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SplayTree splayTree = new SplayTree();
		do {
			System.out.print("**PROGRAM MANAJEMEN DATA PASIEN**\n" +
							 "||1.Input Data Pasien          ||\n" + 
					         "||2.Akses Data Pasien          ||\n" +
						     "||3.Hapus Data Pasien          ||\n" +
					         "||4.Tampilkan Data Pasien      ||\n" +
						     "||5.Keluar                     ||\n" +
						     "*********************************\n" +
							 "Masukan Pilihan : ");
			int options = scan.nextInt();
			switch (options) {
			case 1:{
				System.out.println("---------Input--------");
				System.out.print("Masukan ID Pasien : ");
				Integer id = scan.nextInt();
				System.out.print("Masukan Nama Pasien : " + scan.nextLine());
				String name = scan.nextLine();
				splayTree.insert(id, name);
				System.out.println();
				break;
				
			}
			case 2:{
				System.out.println("---------Akses Data--------");
				System.out.print("Masukan ID Pasien : ");
				Integer id = scan.nextInt();
				splayTree.accesData(id);
				System.out.println();
				break;
			}
			case 3:{
				System.out.println("---------Hapus Data--------");
				System.out.print("Masukan ID Pasien : ");
				int id = scan.nextInt();
				splayTree.delete(id);
				System.out.println();
				break;
			}
			case 4:{
				System.out.println("---------Print--------");
				splayTree.print();
				System.out.println();
				break;
			}
			case 5:{
				System.out.println("EXIT !");
				scan.close();
				System.exit(0);
			}
			default:
				break;
			}
		}while(true);
	}

}
