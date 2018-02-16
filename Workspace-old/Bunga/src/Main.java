import java.util.Scanner;
//saya membuat 2 interface. karena tujuan interface itu untuk menjembatani ketidakmampuan inheritance untuk memiliki
//lebih dari 1 induk. maka dibawah ini adalh contoh pemanfaatan interface.
interface Harga{//interface 1
	int harga(int a);
}

interface warna{//interface 2
	void setWarna(String Warna);
	String getWarna();
	
}

class mawar implements Harga, warna{//class implements dari kedua interface di atas.
	private String Warna;

	@Override
	public void setWarna(String Warna) {
		this.Warna = Warna;
	}
	@Override
	public String getWarna() {
		return Warna;
	}
	@Override
	public int harga(int a) {
		return 2000*a;
	}
	
}


class tulip implements Harga, warna{//class implements dari kedua interface di atas.

	private String Warna;
	
	
	@Override
	public void setWarna(String Warna) {
		this.Warna = Warna;
	}
	
	@Override
	public String getWarna() {
		return Warna;
	}
	@Override
	public int harga(int a) {
		return 3000*a;
	}
	
}



public class Main {

	public static void main(String[] args) {
		mawar a = new mawar();
		tulip b = new tulip();
		Scanner scan = new Scanner(System.in);
		System.out.print("+===========+ \n"
				+ 		   "|PILIH BUNGA|\n"
				+ 		   "+===========+\n"
				+ 		   "|1. Mawar   |\n"
				+ 		   "|2. Tulip   |\n"
				+          "+===========+ \n"
				+    	   "Pilihan : ");
	
		int pilBung = scan.nextInt();//user memilih mawar/tulip
		switch(pilBung) {
		case 1 :{
				scan.nextLine();
				System.out.print("\tTentukan Warna : ");
				a.setWarna(scan.nextLine());//user memasukkan warna
				System.out.print("\tTentukan Banyak Tangkai : ");
				int jumlah = scan.nextInt();//user memilih banyaknya tangki
				System.out.print("\n============Terimakasih============== \n"
						+ 		   "Bunga : Mawar \n"
						+ 		   "Warna : " + a.getWarna() + "\n"
						+          "Harga : " + a.harga(jumlah) + "\n"
						+ 		   "===============================");
				
			break;
		}
		case 2 :{
				scan.nextLine();
				System.out.print("\tTentukan Warna : ");
				b.setWarna(scan.nextLine());
				System.out.print("\tTentukan Banyak Tangkai : ");
				int jumlah = scan.nextInt();
				System.out.print("\n============Terimakasih============== \n"
						+ 		   "Bunga : Mawar \n"
						+ 		   "Warna : " + b.getWarna() + "\n"
						+          "Harga : " + b.harga(jumlah) + "\n"
						+  		   "=====================================");
				break;
		}
		default : {
			System.out.println("Inputan Salah... Buka Program Lagi...");
			break;
		}
		}
		
		
	}

}
