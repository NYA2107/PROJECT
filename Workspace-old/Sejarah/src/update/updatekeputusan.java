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

public class updatekeputusan extends JFrame {

	private JPanel contentPane;
	public static Connection con = null;
	public static Statement stm = null;
	public static ResultSet sql = null;
	Koneksi k = new Koneksi();
	private JTextField textNama;
	private JTextField textWaktu;
	private JButton btnNewButton;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextArea textIsi;
	private JPanel panel_4;
	private JScrollPane scrollPane;
	private JComboBox comboKode;
	private JPanel panel;
	private JLabel label;
	private JButton btnX;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					updatekeputusan frame = new updatekeputusan();
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
	public updatekeputusan() {
		try {
			con = k.koneksiDB();
			stm = (Statement) con.createStatement();
		} catch (SQLException e) {
			System.out.println();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 352);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kode Keputusan",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(31, 81, 469, 43);
		contentPane.add(panel);
		panel.setLayout(null);

		comboKode = new JComboBox();
		comboKode.setBounds(6, 16, 457, 20);
		panel.add(comboKode);
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nama Keputusan",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(32, 128, 471, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textNama = new JTextField();
		textNama.setBounds(6, 16, 459, 20);
		panel_1.add(textNama);
		textNama.setColumns(10);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Waktu Pengesahan",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(32, 177, 471, 43);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		textWaktu = new JTextField();
		textWaktu.setBounds(6, 16, 459, 20);
		panel_2.add(textWaktu);
		textWaktu.setColumns(10);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kode Peristiwa",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(32, 229, 471, 43);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JComboBox comboPeristiwa = new JComboBox();
		comboPeristiwa.setBounds(6, 16, 459, 20);
		panel_3.add(comboPeristiwa);

		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Isi Keputusan",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(523, 65, 322, 208);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 310, 185);
		panel_4.add(scrollPane);

		textIsi = new JTextArea();
		scrollPane.setViewportView(textIsi);

		LinkedList<String> peristiwa = new LinkedList();
		LinkedList<String> keputusan = new LinkedList();

		cekid("SELECT * FROM peristiwa;", peristiwa, 1);
		cekid("SELECT * FROM keputusan;", keputusan, 2);

		for (String a : peristiwa) {
			comboPeristiwa.addItem(a);
		}
		for (String a : keputusan) {
			comboKode.addItem(a);
		}

		btnNewButton = new JButton("UPDATE");
		btnNewButton.setBackground(new Color(0, 102, 153));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String sql = "UPDATE keputusan SET P_Kode_Peristiwa = '" + comboPeristiwa.getSelectedItem()
						+ "', nama_keputusan = '" + textNama.getText() + "', isi_keputusan = '" + textIsi.getText()
						+ "',waktu_pengesahan = '" + textWaktu.getText() + "' " + "WHERE kode_keputusan = '"
						+ comboKode.getSelectedItem() + "';";

				try {
					java.sql.Connection conn = k.koneksiDB();
					java.sql.PreparedStatement pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "DATA BERHASIL DIPERBARUI");

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "GAGAL UPDATE DATA");
				}
			}
		});
		btnNewButton.setBounds(221, 297, 89, 23);
		contentPane.add(btnNewButton);

		btnX = new JButton("X");
		btnX.setForeground(Color.WHITE);
		btnX.setBackground(new Color(0, 102, 102));
		btnX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuAdmin.main();
			}
		});
		btnX.setBounds(831, 0, 46, 23);
		contentPane.add(btnX);

		label = new JLabel("");
		label.setIcon(new ImageIcon(
				"F:\\Workspace\\Sejarah\\img\\Konachan.com - 234396 aircraft aqua_eyes aqua_hair bai_yemeng clouds hat hatsune_miku long_hair pantyhose shorts signed sky twintails vocaloid wet.jpg"));
		label.setBounds(0, 0, 877, 352);
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
