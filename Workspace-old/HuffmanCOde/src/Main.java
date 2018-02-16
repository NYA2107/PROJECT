

import java.io.FileNotFoundException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		Operation operation = new Operation();
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~Huffman Code~~~~~~~");
			System.out.println("1. Input text");
			System.out.println("2. Show text");
			System.out.println("3. Show Huffman Code");
			System.out.println("4. Test String");
			System.out.println("5. Exit");
			System.out.print("Choose : ");
			int choose = in.nextInt();
			switch (choose) {
				case 1:{
					if(operation.getText().isEmpty()) {
						System.out.println("\t---Input Text---");
						System.out.println("\t1. File .txt");
						System.out.println("\t2. Manual");
						System.out.print("\tChoose : ");
						int choose2 = in.nextInt();
						switch (choose2) {
						case 1:
							operation.inputByText();
							System.out.println();
							break;	
						case 2:
							operation.inputByManual();
							break;
						default:
							System.out.println("\tWrong Input !");
							break;
						}
					}else {
						System.out.println("Text already inputed !");
					}
					System.out.println();
					break;
				}
				case 2:{
					if(operation.getText().isEmpty()) {
						System.out.println("Text not inputed yet !");
					}else {
						operation.showText();
					}
					System.out.println();
					break;
				}
				case 3:{
					if(operation.getText().isEmpty()) {
						System.out.println("Text not inputed yet !");
					}else {
						operation.showHuffmanCode();
					}
					System.out.println();
					break;
				}
				case 4:{
					if(operation.getText().isEmpty()) {
						System.out.println("Text not inputed yet !");

					}else {
						operation.testString();
					}
					System.out.println();
					break;
				}
				case 5:{
					System.out.println("Exiting....");
					in.close();
					System.exit(0);
					break;
				}
				default:{
					System.out.println("Wrong input !");
					System.out.println();
					break;
				}
			}
		}while(true);
	}
}
