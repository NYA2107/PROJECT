package EncapsulationTest;

import java.util.Scanner;

class Mahasiswa {
	//PUBLIC
	public String nama;
	
	//PRIVATE
	private String status;
	
	//SETTER for variable status
	public void setStatus(String newValue) {
		status = newValue;
	}
	
	//GETTER for variable status
	public String getStatus() {
		return status;
	}
}



public class Main {

	public static void main(String[] args) {
		
		//Scanner
		Scanner scan = new Scanner(System.in);
		
		//Instance for Mahasiswa Class
		Mahasiswa mhs = new Mahasiswa();
		
		
		
		System.out.println("Masukkan Nama : ");
		//Input/Scanner variable nama
		mhs.nama = scan.nextLine();
		System.out.println("Masukkan Status : ");
		//Input/Scanner for method setStatus(Parameter)
		mhs.setStatus(scan.nextLine());
		
		//Print
		System.out.println("+-------------------------------------------------------------+");
		System.out.println("|                            HASIL                            |");
		System.out.println("+-------------------------------------------------------------+");
		System.out.println("  Nama   : " + mhs.nama + "\n" +"  Status : " + mhs.getStatus());
		System.out.println("+-------------------------------------------------------------+");
		
		//Close Scanner
		scan.close();
		
	}

}
