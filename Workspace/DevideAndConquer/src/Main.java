

import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws IOException {
		String location = "Data_Nilai_Peserta_ON_MIPA_Matematika.txt";
		File file = new File(location);
		Scanner in = new Scanner(System.in);
		Node[] data = new Node[101];
		int counter = 0;
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				String temp = sc.nextLine();
				if(temp.length() == 0) {
					continue;
				}
				String[] split = temp.split("\\,");
				data[counter] = new Node(split[0],Float.parseFloat(split[1]));
				counter++;
			}
			sc.close();
		}catch (Exception e) {
			System.out.println("File Not Found !");
		}
		
		do {
			System.out.println("||=====================||");
			System.out.println("|| Komparasi Algoritma ||");
			System.out.println("||=====================||");
			System.out.println("||1. Brute Force       ||");
			System.out.println("||2. Divide And Conquer||");
			System.out.println("||3. Exit              ||");
			System.out.println("||=====================||");
			System.out.print("Pilih : ");
			int key = in.nextInt();
			switch (key) {
				case 1:{
					bruteForceMenu(in,data);
					break;
				}
				case 2:{
					divideAndConquerMenu(in,data);
					break;
				}
				case 3:{
					System.out.println("Exiting....");
					System.exit(0);
					in.close();
				}
				default:{
					System.out.println("Invalid");
					break;
				}
			}
		}while(true);
	}
	
	public static void bruteForceMenu(Scanner in,Node[] data) {
		do {
			System.out.println("\t||=============||");
			System.out.println("\t|| Brute Force ||");
			System.out.println("\t||=============||");
			System.out.println("\t||1. Find Min  ||");
			System.out.println("\t||2. Find Max  ||");
			System.out.println("\t||3. Sorting   ||");
			System.out.println("\t||4. Exit      ||");
			System.out.println("\t||=============||");
			System.out.print("\tPilih : " );
			int key = in.nextInt();
			switch (key) {
				case 1 :{
					long start = System.nanoTime();
					Node temp = BruteForce.findMin(data);
					long end = System.nanoTime();
					System.out.println("\t~ Find Min Result ~");
					System.out.println("\t"+temp.getName() + " : " + temp.getScore());
					System.out.println("\tRunning Time : " + (end-start) + " Nano Second");
					break;
				}
				case 2:{
					long start = System.nanoTime();
					Node temp = BruteForce.findMax(data);
					long end = System.nanoTime();
					System.out.println("\t~ Find Max Result ~");
					System.out.println("\t"+temp.getName() + " : " + temp.getScore());
					System.out.println("\tRunning Time : " + (end-start) + " Nano Second");
					break;
				}
				case 3:{
					long start = System.nanoTime();
					BruteForce.sorting(data);
					long end = System.nanoTime();
					System.out.println("\t~ Sorting Result ~");
					for(int i = 0 ; i < data.length ; i++) {
						System.out.printf("\t"+(i+1)+". "+"%-40s : %5f\n",data[i].getName(),data[i].getScore());
					}
					System.out.println("\tRunning Time : " + (end-start) + " Nano Second");
					break;
				}
				case 4:{
					return;
				}
				default:
					System.out.println("Invalid");
					break;
			}
		}while(true);
	}
	
	public static void divideAndConquerMenu(Scanner in,Node[] data) {
		do {
			System.out.println("\t||==================||");
			System.out.println("\t|| Divide & Conquer ||");
			System.out.println("\t||==================||");
			System.out.println("\t||1. Find Min       ||");
			System.out.println("\t||2. Find Max       ||");
			System.out.println("\t||3. Sorting        ||");
			System.out.println("\t||4. Exit           ||");
			System.out.println("\t||==================||");
			System.out.print("\tPilih : " );
			int key = in.nextInt();
			switch (key) {
				case 1 :{
					long start = System.nanoTime();
					Node temp = DivideAndConquer.findMin(data);
					long end = System.nanoTime();
					System.out.println("\t~ Find Min Result ~");
					System.out.println("\t"+temp.getName() +" : " +temp.getScore());
					System.out.println("\tRunning Time : " + (end-start) +" Nano Second");
					break;
				}
				case 2:{
					long start = System.nanoTime();
					Node temp = DivideAndConquer.findMax(data);
					long end = System.nanoTime();
					System.out.println("\t~ Find Max Result ~");
					System.out.println("\t"+temp.getName() +" : " +temp.getScore());
					System.out.println("\tRunning Time : " + (end-start) +" Nano Second");
					break;
				}
				case 3:{
					long start = System.nanoTime();
					DivideAndConquer.sorting(data);
					long end = System.nanoTime();
					System.out.println("\t~ Sorting Result ~");
					for(int i = 0 ; i < data.length ; i++) {
						System.out.printf("\t"+(i+1)+". "+"%-40s : %5f\n",data[i].getName(),data[i].getScore());
					}
					System.out.println("\tRunning Time : " + (end-start) + " Nano Second");
					break;
				}
				case 4:{
					return;
				}
				default:
					System.out.println("Invalid");
					break;
			}
		}while(true);
	}
}
