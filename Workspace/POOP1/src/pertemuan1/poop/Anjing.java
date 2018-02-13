package pertemuan1.poop;
import java.util.Scanner;

public class Anjing {
	int isiperut;
	String nama;
	Anjing (String nama_anjing){
		nama = nama_anjing;
		
	}
	
	public void minum () {
		isiperut = isiperut+1;
		System.out.println("Gluguk Gluguk..." );
		System.out.println(nama + " minum air");
		System.out.println("Perut terisi air : "+ isiperut + " liter");
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		System.out.println("masukkan nama anjing :");
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		Anjing statementinigaguna = new Anjing(a);
		while(true) {
		System.out.println("Masukkan perintah : ");
		System.out.println("1. Minum");
		System.out.println("2. Exit");
		int pilihan = scan.nextInt();
		
		if(pilihan == 1) {
		statementinigaguna.minum();
		
		}
		else if(pilihan == 2) {
		scan.close();
		System.exit(0);
		}
	}
	}
}
