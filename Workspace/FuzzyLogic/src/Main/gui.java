//package Main;
//
//import java.awt.BorderLayout;
//import Variable.*;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JTextField;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.Toolkit;
//import java.awt.Color;
//import javax.swing.ImageIcon;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class gui extends JFrame {
//
//	private JPanel contentPane;
//	private JTextField txtintensitas;
//	private JTextField txtpenampang;
//	private JTextField txtmukaair;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					gui frame = new gui();
//					frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public gui() {
//		
//	
//		setResizable(false);
//		setForeground(new Color(0, 128, 128));
//		setTitle("PROGRAM STATUS BENCANA BANJIR");
//		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\MEOLD.jpg"));
//		
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		setBounds(100, 100, 421, 244);
//		contentPane = new JPanel();
//		contentPane.setBackground(new Color(47, 79, 79));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		
//		contentPane.setLayout(null);
//		
//		JLabel lblIntensitas = new JLabel("Intensitas");
//		lblIntensitas.setForeground(Color.WHITE);
//		lblIntensitas.setBounds(10, 21, 186, 14);
//		contentPane.add(lblIntensitas);
//		
//		txtintensitas = new JTextField();
//		txtintensitas.setBounds(10, 40, 186, 20);
//		contentPane.add(txtintensitas);
//		txtintensitas.setColumns(10);
//		
//		JLabel lblLuasPenampang = new JLabel("Luas Penampang");
//		lblLuasPenampang.setForeground(Color.WHITE);
//		lblLuasPenampang.setBounds(10, 71, 186, 14);
//		contentPane.add(lblLuasPenampang);
//		
//		txtpenampang = new JTextField();
//		txtpenampang.setBounds(10, 89, 186, 20);
//		contentPane.add(txtpenampang);
//		txtpenampang.setColumns(10);
//		
//		JLabel lblTinggiMukaAir = new JLabel("Tinggi Muka Air");
//		lblTinggiMukaAir.setForeground(Color.WHITE);
//		lblTinggiMukaAir.setBounds(10, 121, 186, 14);
//		contentPane.add(lblTinggiMukaAir);
//		
//		txtmukaair = new JTextField();
//		txtmukaair.setBounds(10, 137, 186, 20);
//		contentPane.add(txtmukaair);
//		txtmukaair.setColumns(10);
//		
//		JLabel lblhasil = new JLabel("");
//		lblhasil.setForeground(new Color(0, 0, 0));
//		lblhasil.setBounds(218, 0, 197, 215);
//		contentPane.add(lblhasil);
//		
//		JButton hitung = new JButton("Calculate");
//		hitung.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				masuk(txtintensitas, txtpenampang, txtmukaair, lblhasil);				
//			}
//		});
//		hitung.setBounds(10, 168, 89, 23);
//		contentPane.add(hitung);
//		
//		JLabel label_1 = new JLabel("");
//		label_1.setIcon(new ImageIcon("E:\\Konachan.com - 238172 brown_eyes cropped green_hair kagematsuri long_hair night original scarf seifuku.jpg"));
//		label_1.setBounds(0, 0, 209, 215);
//		contentPane.add(label_1);
//		
//		
//	}
//	
//	public static void masuk(JTextField a, JTextField b, JTextField c, JLabel lblhasil) {
//		double i = Double.parseDouble(a.getText());
//		double p = Double.parseDouble(b.getText());
//		double m = Double.parseDouble(c.getText());
//		HasilVariable.hasilVariable(i, p, m, lblhasil);
//	}
//}
