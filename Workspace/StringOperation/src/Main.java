import java.util.*;

public class Main {

	public static void main(String[] args) {
		String text, by, replacement;
		Scanner scan = new Scanner(System.in);
		System.out.print("Masukan text     : ");
		text = scan.nextLine();
		System.out.print("Kata yang diganti: ");
		by = scan.nextLine();
		System.out.print("Kata pengganti   : ");
		replacement = scan.nextLine();
		System.out.println("Hasil : " + Operation.replace(text, by, replacement));

	}

}
