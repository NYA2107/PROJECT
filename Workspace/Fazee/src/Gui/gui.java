package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Gui.H;
import javax.swing.JLabel;

public class gui extends JFrame {

	private JPanel hitung;
	private JTextField a;
	private JTextField b;
	private JTextField c;
	private JButton btnHitung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		hitung = new JPanel();
		hitung.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(hitung);
		hitung.setLayout(null);
		
		a = new JTextField();
		a.setBounds(5, 5, 424, 20);
		hitung.add(a);
		a.setColumns(10);
		
		b = new JTextField();
		b.setBounds(5, 41, 424, 20);
		hitung.add(b);
		b.setColumns(10);
		
		c = new JTextField();
		c.setBounds(5, 121, 424, 20);
		hitung.add(c);
		c.setColumns(10);
		
		JLabel hasil = new JLabel("");
		hasil.setBounds(10, 152, 46, 14);
		hitung.add(hasil);
		
		
		btnHitung = new JButton("HITUNG");
		btnHitung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				H.H(a, b, c, hasil);
			}
		});
		btnHitung.setBounds(177, 72, 89, 23);
		hitung.add(btnHitung);
		
		
	}
}
