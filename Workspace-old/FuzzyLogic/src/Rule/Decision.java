package Rule;

import java.util.LinkedList;

import javax.swing.JLabel;

import Main.popup;
import Node.*;
public class Decision {
	public static void decision(double z, LinkedList<Input> a) {
		String hasil = Double.toString(z);
		
		if ( z <= 0.4){
			System.out.println("LEVEL 3 : " + z );
			popup.tablehasil("LEVEL 3", z);
		}
		else if (z > 0.4 && z < 0.7) {
			System.out.println("LEVEL 2 : " + z );
			
			popup.tablehasil("LEVEL 2", z);
		}
		else if (z >= 0.7 && z <= 1) {
			System.out.println("LEVEL 1 : " + z );
			
			popup.tablehasil("LEVEL 1", z);
		}
		
	}
}
