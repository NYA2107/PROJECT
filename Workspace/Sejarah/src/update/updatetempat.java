package update;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import menu.Koneksi;
import menu.MenuAdmin;

public class updatetempat extends JFrame {

	private JPanel contentPane;
	public static Connection con = null;
	public static Statement stm = null;
	public static ResultSet sql = null;
	Koneksi k = new Koneksi();
	private JTextField textNama;
	private JTextField textLokasi;
	private JTextField textWaktu;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					updatetempat frame = new updatetempat();
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
	public updatetempat() {
		try {
			con = k.koneksiDB();
			stm = (Statement) con.createStatement();
		} catch (SQLException e) {
			System.out.println();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 410);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kode Tempat",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(41, 79, 421, 43);
		contentPane.add(panel);
		panel.setLayout(null);

		JComboBox comboKode = new JComboBox();
		comboKode.setBounds(6, 16, 409, 20);
		panel.add(comboKode);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nama Tempat",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(38, 128, 427, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textNama = new JTextField();
		textNama.setBounds(6, 16, 415, 20);
		panel_1.add(textNama);
		textNama.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lokasi", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(38, 175, 427, 43);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		textLokasi = new JTextField();
		textLokasi.setBounds(6, 16, 415, 20);
		panel_2.add(textLokasi);
		textLokasi.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Waktu Dibuat",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(38, 222, 427, 43);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		textWaktu = new JTextField();
		textWaktu.setBounds(6, 16, 415, 20);
		panel_3.add(textWaktu);
		textWaktu.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kode Peristiwa",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(38, 280, 427, 43);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JComboBox comboPeristiwa = new JComboBox();
		comboPeristiwa.setBounds(6, 16, 415, 20);
		panel_5.add(comboPeristiwa);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Deskripsi Tempat",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(504, 76, 291, 249);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 279, 226);
		panel_4.add(scrollPane);

		JTextArea textDeskripsi = new JTextArea();
		scrollPane.setViewportView(textDeskripsi);

		LinkedList<String> peristiwa = new LinkedList();
		LinkedList<String> tempat = new LinkedList();

		cekid("SELECT * FROM peristiwa;", peristiwa, 1);
		cekid("SELECT * FROM tempat_bersejarah;", tempat, 1);

		for (String a : peristiwa) {
			comboPeristiwa.addItem(a);
		}
		for (String a : tempat) {
			comboKode.addItem(a);
		}

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBackground(new Color(0, 102, 153));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "UPDATE tempat_bersejarah SET nam_tempat = '" + textNama.getText() + "', lokasi_tempat = '"
						+ textLokasi.getText() + "', waktu_dibuat = '" + textWaktu.getText() + "', deskripsi_tempat = '"
						+ textDeskripsi.getText() + "', P_KodePeristiwa = '" + comboPeristiwa.getSelectedItem() + "' "
						+ "WHERE kode_tempat = '" + comboKode.getSelectedItem() + "' ";
				try {
					java.sql.Connection conn = k.koneksiDB();
					java.sql.PreparedStatement pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "DATA BERHASIL DIUBAH");

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "GAGAL UPDATE DATA");
				}
			}
		});
		btnNewButton.setBounds(199, 351, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnX = new JButton("X");
		btnX.setBackground(new Color(0, 102, 102));
		btnX.setForeground(Color.WHITE);
		btnX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuAdmin.main();
			}
		});
		btnX.setBounds(829, 0, 47, 23);
		contentPane.add(btnX);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"F:\\Workspace\\Sejarah\\img\\Konachan.com - 234396 aircraft aqua_eyes aqua_hair bai_yemeng clouds hat hatsune_miku long_hair pantyhose shorts signed sky twintails vocaloid wet.jpg"));
		label.setBounds(0, 0, 876, 410);
		contentPane.add(label);

	}

	public void cekid(String Query, LinkedList<String> a, int i) {

		try {

			String sql = Query;
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				a.add(rs.getString(i));

			}

		}

		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "FAILED TO LOAD DATABASE", "Warning", 2);
		}
	}

}
