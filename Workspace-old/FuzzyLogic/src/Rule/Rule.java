package Rule;

import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Main.popup;
import Node.*;
import Print.*;

public class Rule {
	
	public static void Rules(LinkedList<Fungsi> a, DefaultTableModel model) {
		LinkedList<Input> hasilRule = new LinkedList<Input>();
		
		System.out.println("\nHASIL PERHITUNGAN RULE");
		//intensitas = 0 , tinggi muka air = 1, penampang = 2
		
		//1
		hasilRule.add(new Input(a.get(0).kiri, a.get(1).kanan, a.get(2).kanan, 
			      Math.min(a.get(0).kiri, Math.min(a.get(1).kanan, a.get(2).kanan)), 
				  Z.Level1(Math.min(a.get(0).kiri, Math.min(a.get(1).kanan, a.get(2).kanan)))));
		//2
		hasilRule.add(new Input(a.get(0).kiri, a.get(1).kanan, a.get(2).tengah, 
				  Math.min(a.get(0).kiri, Math.min(a.get(1).kanan, a.get(2).tengah)), 
				  Z.Level1(Math.min(a.get(0).kiri, Math.min(a.get(1).kanan, a.get(2).tengah)))));
		//3
		hasilRule.add(new Input(a.get(0).kiri, a.get(1).kanan, a.get(2).kiri, 
				  Math.min(a.get(0).kiri, Math.min(a.get(1).kanan, a.get(2).kiri)), 
				  Z.Level1(Math.min(a.get(0).kiri, Math.min(a.get(1).kanan, a.get(2).kiri)))));
		//4
		hasilRule.add(new Input(a.get(0).tengah, a.get(1).kanan, a.get(2).kanan, 
				  Math.min(a.get(0).tengah, Math.min(a.get(1).kanan, a.get(2).kanan)), 
				  Z.Level1(Math.min(a.get(0).tengah, Math.min(a.get(1).kanan, a.get(2).kanan)))));
		//5
		hasilRule.add(new Input(a.get(0).tengah, a.get(1).kanan, a.get(2).tengah, 
				  Math.min(a.get(0).tengah, Math.min(a.get(1).kanan, a.get(2).tengah)), 
				  Z.Level1(Math.min(a.get(0).tengah, Math.min(a.get(1).kanan, a.get(2).tengah)))));
		//6
		hasilRule.add(new Input(a.get(0).tengah, a.get(1).kanan, a.get(2).kiri, 
				  Math.min(a.get(0).tengah, Math.min(a.get(1).kanan, a.get(2).kiri)), 
				  Z.Level1(Math.min(a.get(0).tengah, Math.min(a.get(1).kanan, a.get(2).kiri)))));
		//7
		hasilRule.add(new Input(a.get(0).kanan, a.get(1).kanan, a.get(2).kanan, 
				  Math.min(a.get(0).kanan, Math.min(a.get(1).kanan, a.get(2).kanan)), 
				  Z.Level1(Math.min(a.get(0).kanan, Math.min(a.get(1).kanan, a.get(2).kanan)))));
		//8
		hasilRule.add(new Input(a.get(0).kanan, a.get(1).kanan, a.get(2).tengah, 
				  Math.min(a.get(0).kanan, Math.min(a.get(1).kanan, a.get(2).tengah)), 
				  Z.Level1(Math.min(a.get(0).kanan, Math.min(a.get(1).tengah, a.get(2).kanan)))));
		//9
		hasilRule.add(new Input(a.get(0).kanan, a.get(1).kanan, a.get(2).kiri, 
				  Math.min(a.get(0).kanan, Math.min(a.get(1).kanan, a.get(2).kiri)), 
				  Z.Level1(Math.min(a.get(0).kanan, Math.min(a.get(1).kanan, a.get(2).kiri)))));
		//10
		hasilRule.add(new Input(a.get(0).kiri, a.get(1).tengah, a.get(2).kanan, 
				  Math.min(a.get(0).kiri, Math.min(a.get(1).tengah, a.get(2).kanan)), 
				  Z.Level2(Math.min(a.get(0).kiri, Math.min(a.get(1).tengah, a.get(2).kanan)))));
		//11
		hasilRule.add(new Input(a.get(0).kiri, a.get(1).tengah, a.get(2).tengah, 
				  Math.min(a.get(0).kiri, Math.min(a.get(1).tengah, a.get(2).tengah)), 
				  Z.Level2(Math.min(a.get(0).kiri, Math.min(a.get(1).tengah, a.get(2).tengah)))));
		//12
		hasilRule.add(new Input(a.get(0).kiri, a.get(1).tengah, a.get(2).kiri, 
				  Math.min(a.get(0).kiri, Math.min(a.get(1).tengah, a.get(2).kiri)), 
				  Z.Level2(Math.min(a.get(0).kiri, Math.min(a.get(1).tengah, a.get(2).kiri)))));
		//13
		hasilRule.add(new Input(a.get(0).tengah, a.get(1).tengah, a.get(2).kanan, 
				  Math.min(a.get(0).tengah, Math.min(a.get(1).tengah, a.get(2).kanan)), 
				  Z.Level2(Math.min(a.get(0).tengah, Math.min(a.get(1).tengah, a.get(2).kanan)))));
		//14
		hasilRule.add(new Input(a.get(0).tengah, a.get(1).tengah, a.get(2).tengah, 
				  Math.min(a.get(0).tengah, Math.min(a.get(1).tengah, a.get(2).tengah)), 
				  Z.Level2(Math.min(a.get(0).tengah, Math.min(a.get(1).tengah, a.get(2).tengah)))));
		//15
		hasilRule.add(new Input(a.get(0).tengah, a.get(1).tengah, a.get(2).kiri, 
				  Math.min(a.get(0).tengah, Math.min(a.get(1).tengah, a.get(2).kiri)), 
				  Z.Level2(Math.min(a.get(0).tengah, Math.min(a.get(1).tengah, a.get(2).kiri)))));
		//16
		hasilRule.add(new Input(a.get(0).kanan, a.get(1).tengah, a.get(2).kanan, 
				  Math.min(a.get(0).kanan, Math.min(a.get(1).tengah, a.get(2).kanan)), 
				  Z.Level2(Math.min(a.get(0).kanan, Math.min(a.get(1).tengah, a.get(2).kanan)))));
		//17
		hasilRule.add(new Input(a.get(0).kanan, a.get(1).tengah, a.get(2).tengah, 
				  Math.min(a.get(0).kanan, Math.min(a.get(1).tengah, a.get(2).tengah)), 
				  Z.Level2(Math.min(a.get(0).kanan, Math.min(a.get(1).tengah, a.get(2).tengah)))));
		//18
		hasilRule.add(new Input(a.get(0).kanan, a.get(1).tengah, a.get(2).kiri, 
				  Math.min(a.get(0).kanan, Math.min(a.get(1).tengah, a.get(2).kiri)), 
				  Z.Level2(Math.min(a.get(0).kanan, Math.min(a.get(1).tengah, a.get(2).kiri)))));
		//19
		hasilRule.add(new Input(a.get(0).kiri, a.get(1).kiri, a.get(2).kanan, 
				  Math.min(a.get(0).kiri, Math.min(a.get(1).kiri, a.get(2).kanan)), 
				  Z.Level3(Math.min(a.get(0).kiri, Math.min(a.get(1).kiri, a.get(2).kanan)))));
		//20
		hasilRule.add(new Input(a.get(0).kiri, a.get(1).kiri, a.get(2).tengah, 
				  Math.min(a.get(0).kiri, Math.min(a.get(1).kiri, a.get(2).tengah)), 
				  Z.Level3(Math.min(a.get(0).kiri, Math.min(a.get(1).kiri, a.get(2).tengah)))));
		//21
		hasilRule.add(new Input(a.get(0).kiri, a.get(1).kiri, a.get(2).kiri, 
				  Math.min(a.get(0).kiri, Math.min(a.get(1).kiri, a.get(2).kiri)), 
				  Z.Level3(Math.min(a.get(0).kiri, Math.min(a.get(1).kiri, a.get(2).kiri)))));
		//22
		hasilRule.add(new Input(a.get(0).tengah, a.get(1).kiri, a.get(2).kanan, 
				  Math.min(a.get(0).tengah, Math.min(a.get(1).kiri, a.get(2).kanan)), 
				  Z.Level3(Math.min(a.get(0).tengah, Math.min(a.get(1).kiri, a.get(2).kanan)))));
		//23
		hasilRule.add(new Input(a.get(0).tengah, a.get(1).kiri, a.get(2).tengah, 
				  Math.min(a.get(0).tengah, Math.min(a.get(1).kiri, a.get(2).tengah)), 
				  Z.Level3(Math.min(a.get(0).tengah, Math.min(a.get(1).kiri, a.get(2).tengah)))));
		//24
		hasilRule.add(new Input(a.get(0).tengah, a.get(1).kiri, a.get(2).kiri, 
				  Math.min(a.get(0).tengah, Math.min(a.get(1).kiri, a.get(2).kiri)), 
				  Z.Level3(Math.min(a.get(0).tengah, Math.min(a.get(1).kiri, a.get(2).kiri)))));
		//25
		hasilRule.add(new Input(a.get(0).kanan, a.get(1).kiri, a.get(2).kanan, 
				  Math.min(a.get(0).kanan, Math.min(a.get(1).kiri, a.get(2).kanan)), 
				  Z.Level3(Math.min(a.get(0).kanan, Math.min(a.get(1).kiri, a.get(2).kanan)))));
		//26
		hasilRule.add(new Input(a.get(0).kanan, a.get(1).kiri, a.get(2).tengah, 
				  Math.min(a.get(0).kanan, Math.min(a.get(1).kiri, a.get(2).tengah)), 
				  Z.Level3(Math.min(a.get(0).kanan, Math.min(a.get(1).kiri, a.get(2).tengah)))));
		//27
		hasilRule.add(new Input(a.get(0).kanan, a.get(1).kiri, a.get(2).kiri, 
				  Math.min(a.get(0).kanan, Math.min(a.get(1).kiri, a.get(2).kiri)), 
				  Z.Level3(Math.min(a.get(0).kanan, Math.min(a.get(1).kiri, a.get(2).kiri)))));
		
		
		

		Print.printRule(hasilRule, model);
		
		hitungZ(hasilRule);
	}
	
	public static void hitungZ(LinkedList<Input> a) {
		double sumalphaZ = 0;
		double sumalpha = 0;
		double alphalvl2 = 0;
		double Z = 0;
		for (int i = 0 ; i < 27 ; i++) {
			sumalphaZ = sumalphaZ + (a.get(i).alpha * a.get(i).z);
			sumalpha = sumalpha + (a.get(i).alpha);
		}
		//9 - 17
		for(int i = 9; i <=17 ; i++) {
			alphalvl2 = alphalvl2 + (a.get(i).alpha);
		}
		
//		System.out.println("SUM Alpha : " + sumalpha);
//		System.out.println("SUM Alpha x z : " + sumalphaZ);
//		System.out.println("Alpha lvl2 : " + alphalvl2);
		
		//HASIL Z
		Z = sumalphaZ / (sumalpha + alphalvl2) ;
//		System.out.println(Z);
		
		Decision.decision(Z, a);
		
	}
	
}
