package Main;
import Node.*;
import Graph.*;

import java.util.*;


public class Main {

	public static void main(String[] args) {
		LinkedList<Node> input = new LinkedList<Node>();
		Scanner scan = new Scanner(System.in);
		String Source = "";
		String Destination = "";
		double Value = 0;
		
		System.out.print("Masukkan Jumlah Vertex : ");
		int VertexSize = scan.nextInt();
		
		for(int i = 0 ; i < VertexSize ; i++) {
		
		System.out.print("Asal : ");
		Source = scan.next();
		System.out.print("Tujuan : ");
		Destination = scan.next();
		System.out.print("Waktu Yang Dibutuhkan : ");
		Value = scan.nextInt();
		System.out.println();
		MultiTrackChecking.multiTrackChecking(input, Source, Destination, Value);
		}
		
		Sort.sort(input);
		Prim.prim(input);
		
		
		System.out.println("+==============================================================+");
		System.out.println("|        ASAL        |       TUJUAN       |    WAKTU TEMPUH    |");
		System.out.println("+==============================================================+");
		for(Node p : input) {
//			System.out.println("Asal : " + p.Source + "\t"
//					+ 	       "Tujuan : " + p.Destination + "\t\t"
//							+  "Waktu Yang dibutuhkan : " + p.Value);
			System.out.printf("|%-20s|%-20s|%-20s|\n",p.Source,p.Destination,p.Value);
		}
		System.out.println("+==============================================================+");
		
		
		scan.close();

		
	}

}
