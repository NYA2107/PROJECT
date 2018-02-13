package com.responsi.program;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import com.algorithms.backtracking.Maze;
import com.algorithms.huffman.HuffmanCode;
import com.algorithms.huffman.HuffmanTree;

public class Program {
	
	private static Scanner scan;
	Problem1 p1;
	Problem2 p2;
	
	public Program() {
		scan = new Scanner(System.in);
		p1 = new Problem1();
		p2 = new Problem2();
	}
	
	public void run() {
		do {
			menu();
			switch(scan.nextInt()) {
			case 1:
				p1.run();
				break;
			case 2:
				p2.run();
				break;
			case 3:
				exit();
			default:
				System.out.println("Invalid Input");
			}
		} while(true);
	}
	
	private void menu() {
		System.out.print(
				"\n=================\n"
				+ "|    RESPONSI   |\n"
				+ "|---------------|\n"
				+ "| 1. Problem 1  |\n"
				+ "| 2. Problem 2  |\n"
				+ "| 3. Exit       |\n"
				+ "=================\n"
				+ "Pilih: ");
	}
	
	private void exit() {
		System.out.println("< Exit >");
		scan.close();
		System.out.println("Program Terminated");
		System.exit(0);
	}
	
}
