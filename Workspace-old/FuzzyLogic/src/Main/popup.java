package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Node.Input;
import Variable.HasilVariable;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

public class popup extends JFrame {

	private static JPanel contentPane;
	private JTable table;
	private static JTable tablehasil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					popup frame = new popup();
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
	public popup() {
		setTitle("PROGRAM STATUS BENCANA BANJIR");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String Sintensitas = JOptionPane.showInputDialog("Masukkan Intensitas (1 - 50)");
		 String Spenampang = JOptionPane.showInputDialog("Masukkan Luas Penampang (1 - 55)");
		 String Smukaair = JOptionPane.showInputDialog("Masukkan Tinggi Muka Air (1 - 250)");
		 
		 Double intensitas = Double.parseDouble(Sintensitas);
		 Double penampang = Double.parseDouble(Spenampang);
		 Double mukaair = Double.parseDouble(Smukaair);
		 if((intensitas < 1 || mukaair < 50) || penampang < 1) {
			 JOptionPane.showMessageDialog(null, "Input diluar batas, Coba Lagi");
			 tampilkankosong();
			}
			else if((intensitas > 50 || mukaair > 250) || penampang > 55) {
				JOptionPane.showMessageDialog(null, "Input diluar batas, Coba Lagi");
				tampilkankosong();
			}
			else {
				tampilkantable(intensitas, penampang, mukaair);
				tablehasil("",0.0);
			}
		 
       
		
		
		 
		 JButton btnHitungLagi = new JButton("CALCULATE");
		 btnHitungLagi.setForeground(new Color(255, 255, 255));
		 btnHitungLagi.setBackground(new Color(47, 79, 79));
		 btnHitungLagi.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		
		 		 String Sintensitas = JOptionPane.showInputDialog("Masukkan Intensitas (1 -  50)");
				 String Spenampang = JOptionPane.showInputDialog("Masukkan Luas Penampang (1 - 55)");
				 String Smukaair = JOptionPane.showInputDialog("Masukkan Tinggi Muka Air (50 - 250)");
				 
				 Double intensitas = Double.parseDouble(Sintensitas);
				 Double penampang = Double.parseDouble(Spenampang);
				 Double mukaair = Double.parseDouble(Smukaair);
				 if((intensitas < 1 || mukaair < 50) || penampang < 1) {
					 JOptionPane.showMessageDialog(null, "Input diluar batas, Coba Lagi");
					 tampilkankosong();
					}
					else if((intensitas > 50 || mukaair > 250) || penampang > 55) {
						JOptionPane.showMessageDialog(null, "Input diluar batas, Coba Lagi");
						tampilkankosong();
					}
					else {
						tampilkantable(intensitas, penampang, mukaair);
						
					}
				 
				 
		 	}
		 });
		 btnHitungLagi.setBounds(24, 34, 151, 56);
		 contentPane.add(btnHitungLagi);
		 
		 JLabel lblHasilPerhitunganSetiap = new JLabel("HASIL PERHITUNGAN SETIAP RULE : ");
		 lblHasilPerhitunganSetiap.setForeground(new Color(255, 255, 255));
		 lblHasilPerhitunganSetiap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblHasilPerhitunganSetiap.setBounds(24, 101, 254, 14);
		 contentPane.add(lblHasilPerhitunganSetiap);
		 
		 JLabel label = new JLabel("");
		 label.setIcon(new ImageIcon("E:\\Konachan.com - 238172 brown_eyes cropped green_hair kagematsuri long_hair night original scarf seifuku.jpg"));
		 label.setBounds(0, 0, 805, 598);
		 contentPane.add(label);
		 
	}
	
	public void tampilkantable(Double intensitas, Double penampang, Double mukaair) {
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 126, 760, 461);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setBorder(new CompoundBorder(null, new BevelBorder(BevelBorder.RAISED, new Color(0, 139, 139), null, null, null)));
		table.setShowHorizontalLines(false);
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(47, 79, 79));
		scrollPane.setViewportView(table);
		
		
		
		
		DefaultTableModel model = new DefaultTableModel() {
		
			public boolean isCellEditable(int Row, int Column) {
				return false;
			}
		
		};
		
		model.addColumn("NO");
		model.addColumn("INTENSITAS");
		model.addColumn("TINGGI MUKA AIR");
		model.addColumn("LUAS PENAMPANG");
		model.addColumn("ALPHA");
		model.addColumn("W");
		
		HasilVariable.hasilVariable(intensitas, penampang, mukaair, model);
		table.setModel(model);
		
	}
	
	public static void tablehasil(String level, Double hasil) {
		JScrollPane scrollPanehasil = new JScrollPane();
		scrollPanehasil.setBounds(185, 34, 599, 56);
		contentPane.add(scrollPanehasil);
		
		tablehasil = new JTable();
		tablehasil.setShowHorizontalLines(false);
		tablehasil.setForeground(new Color(255, 255, 255));
		tablehasil.setBackground(new Color(47, 79, 79));
		DefaultTableModel model1 = new DefaultTableModel() {
			
			public boolean isCellEditable(int Row, int Column) {
				return false;
			}
		
		};
		
		model1.addColumn("LEVEL");
		model1.addColumn("TINGKATAN");
				
		model1.addRow(new Object[]{level, hasil});
		scrollPanehasil.setViewportView(tablehasil);
		tablehasil.setModel(model1);
	}
	
	public void tampilkankosong() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 126, 760, 461);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setBorder(new CompoundBorder(null, new BevelBorder(BevelBorder.RAISED, new Color(0, 139, 139), null, null, null)));
		table.setShowHorizontalLines(false);
		table.setForeground(new Color(255, 255, 255));
		table.setBackground(new Color(47, 79, 79));
		scrollPane.setViewportView(table);
		
		
		
		
		DefaultTableModel model = new DefaultTableModel() {
		
			public boolean isCellEditable(int Row, int Column) {
				return false;
			}
		
		};
		
		model.addColumn("NO");
		model.addColumn("INTENSITAS");
		model.addColumn("TINGGI MUKA AIR");
		model.addColumn("LUAS PENAMPANG");
		model.addColumn("ALPHA");
		model.addColumn("W");
		table.setModel(model);
		
		JScrollPane scrollPanehasil = new JScrollPane();
		scrollPanehasil.setBounds(185, 34, 599, 56);
		contentPane.add(scrollPanehasil);
		
		tablehasil = new JTable();
		tablehasil.setShowHorizontalLines(false);
		tablehasil.setForeground(new Color(255, 255, 255));
		tablehasil.setBackground(new Color(47, 79, 79));
		DefaultTableModel model1 = new DefaultTableModel() {
			
			public boolean isCellEditable(int Row, int Column) {
				return false;
			}
		
		};
		
		model1.addColumn("LEVEL");
		model1.addColumn("TINGKATAN");
		
		model1.addRow(new Object[]{"NULL", "NULL"});
		
		tablehasil.setModel(model1);
	}
	
}





