import java.io.*;
import java.util.*;


public class SequentialAcces {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("||==================||");
			System.out.println("|| Sequential Acces ||");
			System.out.println("||------------------||");
			System.out.println("||1. Read File      ||");
			System.out.println("||2. Write File     ||");
			System.out.println("||3. Exit           ||");
			System.out.println("||==================||");
			System.out.print("Pilih : ");
			int key = in.nextInt();
			switch (key) {
			case 1:
				readSequentialAcces(in);
				break;
			case 2:
				writeSequentialAcces(in);
				break;
			case 3:
				in.close();
				System.out.println("Exiting..");
				System.exit(0);
			default:
				System.out.println("Invalid input !");
				break;
			}
		}while(true);
	}
	
	private static void readSequentialAcces(Scanner in) throws IOException {
		System.out.print("Masukan alamat file : ");
		in.nextLine();
		String location = in.nextLine();
		try {
			FileInputStream fis = new FileInputStream(location);
			int content;
			while((content = fis.read()) != -1) {
				System.out.print((char)content);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Tidak Ditemukan");
		}
		System.out.println();
		
	}
	
	private static void writeSequentialAcces(Scanner in){
		System.out.print("Masukan Lokasi penyimpanan file : ");
		in.nextLine();
		String location = in.nextLine();
		try {
			File file = new File(location);
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			
			System.out.print("Masukan String yang akan di tulis pada file : ");
			String content = in.nextLine();
			byte[] bytesArray = content.getBytes();
			
			for(int i = 0 ; i < bytesArray.length ; i++) {
				fos.write(bytesArray[i]);
			}
			
			fos.close();
		} catch (Exception e) {
			System.out.println("Lokasi tidak Ditemukan");
		}
		System.out.println();
	}

}
