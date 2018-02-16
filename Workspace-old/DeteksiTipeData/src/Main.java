import java.util.*;//ini untuk import library Scanner(System.in)

public class Main {//ini class main
	
	//++------------------++
	//||IMAM NAJIBULLOH HR||
	//||M0516027          ||
	//++------------------++
	
	public static void main(String[] args) {//ini fungsi/method main
		Scanner scan = new Scanner(System.in);//ini buat deklarasi scanner
		while(true) {//ini while loop agar nge loop terus
		System.out.println("Masukkan angka");//ini cuma ngeprint
		float angka = scan.nextFloat();//ini mengisi variabel angka
		proses tipe = new proses();//ini buat membuat objek untuk memanggil fungsi di class proses
		
			tipe.jenis(angka);//memanggil fungsi di class proses yaitu fungsi/method proses, isi parameternya dari variabel angka
		}
	}

}

class proses{//ini class proses
	void jenis(float angka) {//ini method jenis parameternya float
		if(angka >= -128 && angka <= 127){//ini untuk Byte.. range nya -128 sampai 127
			System.out.println("Tipe data " + angka + " : Byte");//ini untuk ngeprint saja
		}
		else if((angka >=-32768 && angka <-128) || (angka>=128 && angka <= 32767)){//ini untuk Short.. range nya -32768 sampai 32767
			System.out.println("Tipe data " + angka + " : Short");//ini hanya nge print
		}
		else if((angka >= -2147483648 && angka <-32768) || (angka >= 32767 && angka <= 2147483647)) {//ini untuk Short.. range nya -2147483648 sampai 2147483647
			System.out.println("Tipe data " + angka + " : int");//ini hanya nge print
		}
		else if((angka >= -9223372036854775808L && angka <-2147483648) || (angka >= 2147483647  && angka <= 9223372036854775807L) ) {//ini untuk Short.. range nya -9223372036854775808 sampai 9223372036854775807
			System.out.println("Tipe data " + angka + " : long");
		}
	}
}

