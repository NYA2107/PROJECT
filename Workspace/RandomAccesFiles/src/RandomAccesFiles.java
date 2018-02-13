import java.io.*;
import java.util.*;

public class RandomAccesFiles {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("||==============||");
			System.out.println("|| Random Acces ||");
			System.out.println("||--------------||");
			System.out.println("||1. Write Data ||");
			System.out.println("||2. Exit       ||");
			System.out.println("||==============||");
			System.out.print("Pilih : ");
			int key = in.nextInt();
			switch (key) {
			case 1:
				writeRandomAcces(in);
				break;
			case 2:{
				System.out.println("Exiting..");
				in.close();
				System.exit(0);
			}
			default:
				break;
			}
		}while(true);
	}
	
	private static void writeRandomAcces(Scanner in) {
		System.out.print("\tMasukan lokasi penyimpanan file : ");
		in.nextLine();
		String location = in.nextLine();
		try {
			File file = new File(location);
			if(file.exists()) {
				file.createNewFile();	
			}
			RandomAccessFile raf = new RandomAccessFile(file,"rw");
			int max = (int)raf.length();
			
			do {				
				System.out.println("\t||=================||");
				System.out.println("\t||1. Inputkan Data ||");
				System.out.println("\t||2. Kembali       ||");
				System.out.println("\t||=================||");
				System.out.print("\tPilih : ");
				switch (in.nextInt()) {
				case 1:{
					System.out.print("\t\tMasukan string yang akan diinputkan         : ");
					in.nextLine();
					String tempString = in.nextLine();
					System.out.print("\t\tTentukan posisi penyimpanan pada file (int) : ");
					int tempInt = in.nextInt();
					
					if(tempInt > max) {
						
						fillFile(raf,tempInt,max);
						max = tempInt;
					}
					
					raf.seek((int)tempInt);
					raf.write(tempString.getBytes());
					System.out.println("\t\tSucces");
					break;
				}
				case 2:{
					raf.close();
					return;
				}
				default:
					System.out.println("Invalid Input !");
					break;
				}
			}while(true);
		} catch (Exception e) {
			System.out.println("Lokasi Tidak Ditemukan !");
		}
	}
	
	private static void fillFile(RandomAccessFile raf,int newMax,int oldMax) {
		for(int i = oldMax ; i < newMax ; i++) {
			String temp = " ";
			try {
				raf.write(temp.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
