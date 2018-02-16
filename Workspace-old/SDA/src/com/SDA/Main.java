/**
 * 
 */
package com.SDA;


public class Main {

	
	public static void main(String[] args) {
		
	}

}

class paijo{
	int a;
	String b;
	paijo kiri, kanan;
}

class perintah{
	static paijo root;
	
	
	public static void add(int c, String b) {
		paijo wadah = new paijo();
		wadah.a = c;
		wadah.b = b;
		root = Add(root, wadah);
	}
	
	private static paijo Add(paijo sakiki ,paijo temp) {
		
	}
	
}