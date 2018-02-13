package com.responsi.program;
import java.util.List;
import java.util.Scanner;

import com.datastructures.disjointset.Bimap;
import com.datastructures.disjointset.DisjointSet;

public class Problem1 {
	
	Bimap<String, Integer> map;
	Scanner scan;	
	DisjointSet disjointSet;
	
	public Problem1() {
		disjointSet = new DisjointSet(10);
		map = new Bimap<>();
		scan = new Scanner(System.in);
	}
	
	public void run() {
		System.out.print("=== Problem 1 ===");
		do {
			menu();
			switch(scan.nextInt()) {
			case 1:
				input();
				break;
			case 2:
				union();
				break;
			case 3:
				findKordes();
				break;
			case 4:
				//scan.close();
				return;
			default:
				System.out.println("Invalid Input");
			}
			
		} while(true);
	}
	
	private void menu() {
		System.out.print(
			"\n==================\n"
			+ "|   PROBLEM 01   |\n"
			+ "|----------------|\n"
			+ "| 1. Input       |\n"
			+ "| 2. Union       |\n"
			+ "| 3. Find Kordes |\n"
			+ "| 4. Exit        |\n"
			+ "==================\n"
			+ "Pilih: ");
	}
	
	private void input() {
		map.clear();
		System.out.print(
				  "=== Input Set ===\n"
				+ "Masukan Jumlah Element: ");
		int size = scan.nextInt();
		for(int i = 0; i < size; i++) {
			System.out.println("[ Element " +(i + 1) +" ]");
			try {
				map.put(scan.next(), i);
			} catch (Exception e) {
				System.out.println("Set Tidak Menerima Duplikat");
				i--;
			}
		}
		disjointSet = new DisjointSet(size);
		System.out.println("Set Berhasil Dibuat");
		printSet();
	}
	
	private void union() {
		System.out.println("=== Union ===");
		if(map.isEmpty()) {
			System.out.println("Set masih kosong!");
			return;
		}
		System.out.print(
				  "Masukan Dua Element Untuk Digabungkan\n"
				+ "Parent: ");
		String parent = scan.next();
		if(!map.containsKey(parent)) {
			System.out.println("Error: Element " + parent +" tidak ada pada set");
			return;
		}
		System.out.print(
				  "Child : ");
		String child = scan.next();
		if(!map.containsKey(child)) {
			System.out.println("Error: Element " + child +" tidak ada pada set");
			return;
		}
		disjointSet.union(map.getValue(parent), map.getValue(child));
		printSet();
	}
	
	private void findKordes() {
		if(map.isEmpty()) {
			System.out.println("Set masih kosong!");
			return;
		}
		int[] kordes = disjointSet.getRoot();
		for(int i = 0; i < kordes.length; i++) {
			System.out.printf("KORDES %02d: %s\n", i+1, map.getKey(kordes[i]));
		}
		System.out.println();
		
	}
	
	private void printSet() {
		int[] rank = disjointSet.getRank();
		int[] parent = disjointSet.getParent();
		StringBuilder lineBreak = new StringBuilder();
		StringBuilder header = new StringBuilder();
		StringBuilder elementSB = new StringBuilder();
		StringBuilder parentSB = new StringBuilder();
		StringBuilder rankSB = new StringBuilder();
		header.append(   "==========");
		lineBreak.append("|--------|");
		elementSB.append("|Element |");
		parentSB.append("|Parrent |");
		rankSB.append("|Rank    |");
		for(int i = 0; i < disjointSet.size(); i++) {
			header.append("============");
			lineBreak.append("-----------|");
			
			elementSB.append(String.format(" %-9s |", map.getKey(i)));
			
			if(parent[i] == -1) {
				parentSB.append(String.format(" %-9s |", "root"));
			} else {
				parentSB.append(String.format(" %-9s |", map.getKey(parent[i])));
			}
			
			rankSB.append(String.format(" %-9d |", rank[i]));
			
		}
		
		System.out.println(
				header +"\n"
			   +elementSB +"\n"
			   +lineBreak +"\n"
			   +parentSB +"\n"
			   +lineBreak +"\n"
			   +rankSB +"\n"
			   +header +"\n");
	}	
	
}
