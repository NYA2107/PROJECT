package Kendaraan;

import java.util.Scanner;

class kendaraan{
	int roda;
	
	public void gas(){
		System.out.println("Gasss");	
	}
	public void rem() {
		System.out.println("Reeeem");	
	}
	public void parkir() {
		System.out.println("Parkirrr");
	}
}

class mobil extends kendaraan{
	
	mobil(){
		roda = 4;
	}
	public void gas(){
		System.out.println(roda);
		super.gas();
	}
	public void rem() {
		
	}
	public void parkir() {
		
	}
}

class motor extends kendaraan{
	motor(){
		roda = 2;
	}
	
	public void gas(){
		System.out.println(roda);
		super.rem();
	}
	public void rem() {
		
	}
	public void parkir() {
		
	}
}

class becak extends kendaraan{
	
	becak(){
		roda = 3;
	}
	
	public void gas(){
		System.out.println(roda);
		super.parkir();
	}
	public void rem() {
		
	}
	public void parkir() {
		
	}
}
public class main {

	public static void main(String[] args) {
		mobil mazda = new mobil();
		motor honda = new motor();
		becak albi = new becak();
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Masukkan banyak roda --- masukkan 5 untuk exit");
		int pilihRoda = scan.nextInt();
		
		switch(pilihRoda) {
			case 2:{
				honda.gas();
				System.out.println();
				break;
			}
			
			case 3:{
				albi.gas();
				System.out.println();
				break;
			}
			
			case 4:{
				mazda.gas();
				System.out.println();
				break;
			}
			case 5:{
				System.out.println("Byeeeeee");
				scan.close();
				System.exit(0);
				break;
			}
			default:{
				System.out.println("yang lain dong");
				System.out.println();
				break;
			}
			
		}
		}
		
	}

}
