package com.PriorityQ;

import java.util.*;


class node{
	int prioritas;
	String nama;
	
}


public class Main {
	
	static void insert(){
	int a = 0;
	
	Scanner scanner = new Scanner(System.in);
	System.out.println("Masukkakn jumlah data : ");
	int panjang = scanner.nextInt();
	node array[] = new node[panjang];
		while(a < panjang) {
			node apa = new node();
			System.out.println("masukkan prioritas :");
			apa.prioritas = scanner.nextInt();
			System.out.println("masukkan nama :");
			apa.nama = scanner.next();
			array[a] = apa;
			a++;
		}
	a = 0;
		while(a < panjang) {
			System.out.println(a + " : " + array[a].prioritas + "--" + array[a].nama );
			a++;
		}
	
	}
	
	public static void main(String[] args) {
		
		
		insert();
		

	}

}
