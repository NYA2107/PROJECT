import java.io.File;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;


interface Rumus{//interface rumus
	
	int Hitung(int a, int b); //method Hitung yang memiliki 2 parameter int a dan b
	
}

class Luas implements Rumus{//class luas implements dari interface Rumus
	


	@Override
	public int Hitung(int a, int b) {//Penjabaran dari method Rumus
		// TODO Auto-generated method stub
		return a*b;//rumus luas
	}
	
}
class Keliling implements Rumus{//Hal ini merupakan pengulangan class Luas
	

	@Override
	public int Hitung(int a, int b) {
		// TODO Auto-generated method stub
		return (a+b)*2;//rumus keliling
	}
	
}





public class Main {

    public static void Print (LinkedList<Node> list, int dataLength) throws Exception {//exception
    	
    	Rumus luas = new Luas();//inisialisasi Polymorph untuk class Luas
		Rumus keliling = new Keliling();
	// Indicate that you are planning to use a file
	File fleExample = new File("Output.txt");//nama file yaitu Output.txt,
        // Create that file and prepare to write some values to it
        PrintWriter pwInput = new PrintWriter(fleExample);

        for(int i = 0; i < dataLength; i++) {//loop untuk menampilkan tabel data dan hasil
			
			System.out.printf( "\t|%14s|%12s|%10s|%11s|\n",((Node)list.get(i)).getA() ,((Node)list.get(i)).getB(), luas.Hitung(((Node)list.get(i)).getA(), 
					((Node)list.get(i)).getB()), keliling.Hitung(((Node)list.get(i)).getA(),((Node)list.get(i)).getB()));
			
			//output dibawah ini akan ditmpilkan di file
			pwInput.println("Sisi Pertama : " + list.get(i).getA());
			pwInput.println("Sisi Kedua : " + list.get(i).getB());
			pwInput.println("Hasil Luas : " + luas.Hitung(list.get(i).getA(),list.get(i).getB()));
			pwInput.println("Hasil Keliling : " + keliling.Hitung(list.get(i).getA(),list.get(i).getB()));
			pwInput.println("=========================================================================");
			pwInput.println("");
		//diatas merupakan implementasi penggunaan setter getter
		}

	
      
        pwInput.close();
        // For convenience, let the user know that the file has been created
   
    }
	
	
	

	public static void main(String[] args) throws Exception {
		LinkedList<Node> list = new LinkedList<Node>();
		Scanner scan = new Scanner(System.in);

		System.out.println("++======================================================================++");
		System.out.println("||                     K A L K U L A T O R  R U M U S                   ||");
		System.out.println("++======================================================================++");
		System.out.println("|| Kalkulator penghitung luas dan keliling persegi atau persegi panjang ||");
		System.out.println("++======================================================================++");
		System.out.println("||                             A U T H O R                              ||");
		System.out.println("++======================================================================++");
		System.out.println("||Nama : Imam Najibulloh HR                                             ||");
		System.out.println("||NIM  : M0516027                                                       ||");
		System.out.println("++======================================================================++");
		do {
		System.out.println("+=======================+\n" 
				+          "|1. Menghitung          |\n"
				+          "|2. Keluar              |\n"
				+          "+=======================+");
		System.out.print("Pilih Menu : ");
		int menu = scan.nextInt();
		switch(menu) {
			case 1 :{
				System.out.print("\tMasukkan banyak data yang akan dihitung : ");
				int dataLength = scan.nextInt();
				System.out.println("\t=============Masukkan Data===============");
				System.out.println("\t(Masukkan sisiPertama sisiKedua, ex : 12 3)");
				for(int i = 0; i < dataLength; i++) {//Loop untuk memasukkan data
					System.out.print("\tMasukkan data : ");
					list.add(new Node(scan.nextInt(),scan.nextInt()));//memasukkan data ke linkedlist dengan menggunakan add
				}
				System.out.println("\n\t+==================================================+");
				System.out.println("\t| Sisi Pertama | Sisi Kedua |   Luas   |  Keliling |");
				System.out.println("\t+==================================================+");
				Print(list, dataLength);
				System.out.println("\t+==================================================+\n\n");
				break;
	
			}
			case 2 : {
				System.exit(0);
				System.out.println("BYE BYE BYE BYE");
				break;
			}
		}
	}while(true);
		

	}
}
