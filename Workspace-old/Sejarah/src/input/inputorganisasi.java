
package input;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.Statement;

import menu.Koneksi;
import menu.MenuAdmin;

public class inputorganisasi extends JFrame {

	private JPanel contentPane;
	private JTextField textKode;
	private JTextField textNama;
	private JTextField textBerdiri;
	private JTextField textBerakhir;
	private JTextField textKategori;
	String Query;
	public static Connection con = null;
	public static Statement stm = null;
	public static ResultSet sql = null;
	Koneksi k = new Koneksi();

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					inputorganisasi frame = new inputorganisasi();
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
	public inputorganisasi() {
		try {
			con = k.koneksiDB();
			stm = (Statement) con.createStatement();
		} catch (SQLException e) {
			System.out.println();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 380);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kode Organisasi",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(32, 87, 330, 43);
		contentPane.add(panel);
		panel.setLayout(null);

		textKode = new JTextField();
		textKode.setBounds(6, 16, 318, 20);
		panel.add(textKode);
		textKode.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nama Organisasi",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(32, 130, 330, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textNama = new JTextField();
		textNama.setBounds(6, 16, 318, 20);
		panel_1.add(textNama);
		textNama.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Waktu Berdiri",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(32, 172, 330, 43);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		textBerdiri = new JTextField();
		textBerdiri.setBounds(6, 16, 318, 20);
		panel_2.add(textBerdiri);
		textBerdiri.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Waktu Berakhir",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(32, 214, 330, 43);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		textBerakhir = new JTextField();
		textBerakhir.setBounds(6, 16, 318, 20);
		panel_3.add(textBerakhir);
		textBerakhir.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kategori Organisasi",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(32, 257, 330, 43);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		textKategori = new JTextField();
		textKategori.setBounds(6, 16, 318, 20);
		panel_4.add(textKategori);
		textKategori.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tujuan Organisasi",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(397, 85, 281, 215);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 269, 192);
		panel_5.add(scrollPane);

		JTextArea textTujuan = new JTextArea();
		scrollPane.setViewportView(textTujuan);

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(new Color(0, 102, 153));
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (textBerakhir.getText().isEmpty()) {
					Query = "INSERT INTO organisasi (kode_organisasi, nama_organisasi, tujuan, waktu_berdiri, kategori_organisasi) VALUES ("
							+ "'" + textKode.getText() + "','" + textNama.getText() + "','" + textTujuan.getText()
							+ "','" + textBerdiri.getText() + "','" + textKategori.getText() + "');";

				} else {
					Query = "INSERT INTO organisasi (kode_organisasi, nama_organisasi, tujuan, waktu_berdiri, kategori_organisasi, waktu_berakhir) VALUES ("
							+ "'" + textKode.getText() + "','" + textNama.getText() + "','" + textTujuan.getText()
							+ "','" + textBerdiri.getText() + "','" + textKategori.getText() + "','"
							+ textBerakhir.getText() + "');";

				}

				String sql = Query;
				try {
					java.sql.Connection conn = k.koneksiDB();
					java.sql.PreparedStatement pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "INPUT SUKSES");
					// PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
					// pst.executeQuery();

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT");
				}
			}
		});
		btnSubmit.setBounds(150, 329, 89, 23);
		contentPane.add(btnSubmit);

		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuAdmin.main();
			}
		});
		btnX.setBackground(new Color(0, 102, 102));
		btnX.setForeground(Color.WHITE);
		btnX.setBounds(668, 0, 46, 23);
		contentPane.add(btnX);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 102, 153));
		panel_6.setBounds(0, 0, 714, 23);
		contentPane.add(panel_6);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"F:\\Workspace\\Sejarah\\img\\Konachan.com - 234396 aircraft aqua_eyes aqua_hair bai_yemeng clouds hat hatsune_miku long_hair pantyhose shorts signed sky twintails vocaloid wet.jpg"));
		label.setBounds(0, 0, 714, 380);
		contentPane.add(label);
	}

}
