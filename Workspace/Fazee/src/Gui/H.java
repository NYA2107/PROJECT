package Gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class H {

	public static void H (JTextField a, JTextField b, JTextField c, JLabel hasil) {
		int q =0; q = Integer.parseInt(a.getText());
		int w = 0; w = Integer.parseInt(b.getText());
		int r = q + w;
		
		String e = Integer.toString(r);
		
		c.setText(e);
		hasil.setText(e);
		
	}
	
}
