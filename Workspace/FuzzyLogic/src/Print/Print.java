package Print;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import Node.*;

public class Print {
	
	public static void printRule(LinkedList<Input> p, DefaultTableModel model) {
		int nomer = 1;
		System.out.println("++====+==============+===================+==================+===========+=========++");
		//System.out.println("+----+--------------+-------------------+------------------+-----------+---------+");
		System.out.println("|| NO |  INTENSITAS  |  TINGGI MUKA AIR  |  LUAS PENAMPANG  |   ALPHA   |    W    ||");
		System.out.println("++----+--------------+-------------------+------------------+-----------+---------++");
		for(Input b : p) {
			System.out.printf("||%-4s|%-14f|%-19f|%-18f|%-11f|%-9f||\n",nomer,b.intensitas,b.mukaAir,b.penampang,b.alpha,b.z);
			model.addRow(new Object[]{nomer,b.intensitas,b.mukaAir,b.penampang,b.alpha,b.z });
			//System.out.println(nomer+ ". \t " + b.intensitas + "\t" + b.mukaAir + "\t" + b.penampang + ", \t alpha : \t" + b.alpha + ", \t z : \t" + b.z);
			nomer++;
		}
		System.out.println("++====+==============+===================+==================+===========+=========++");
		//System.out.println("+----+--------------+-------------------+------------------+-----------+---------+");
		
		
	
		
	}
}
