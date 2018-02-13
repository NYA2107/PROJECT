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

public class updateorganisasi extends JFrame {

	private JPanel contentPane;
	private JTextField textNama;
	private JTextField textBerdiri;
	private JTextField textBerakhir;
	private JTextField textKategori;
	String Query;
	public static Connection con = null;
	public static Statement stm = null;
	public static ResultSet sql = null;
	Koneksi k = new Koneksi();
	private final JLabel lblNewLabel = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					updateorganisasi frame = new updateorganisasi();
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
	public updateorganisasi() {
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
		panel.setBounds(32, 83, 330, 43);
		contentPane.add(panel);
		panel.setLayout(null);

		JComboBox comboKode = new JComboBox();
		comboKode.setBounds(6, 16, 318, 20);
		panel.add(comboKode);

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

		LinkedList<String> organisasi = new LinkedList();

		cekid("SELECT * FROM organisasi;", organisasi, 1);
		for (String a : organisasi) {
			comboKode.addItem(a);
		}

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBackground(new Color(0, 102, 153));
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (textBerakhir.getText().isEmpty()) {
					Query = "UPDATE organisasi SET nama_organisasi = '" + textNama.getText() + "', tujuan = '"
							+ textTujuan.getText() + "', waktu_berdiri = '" + textBerdiri.getText()
							+ "', waktu_berakhir = NULL, kategori_organisasi = '" + textKategori.getText() + "' "
							+ "WHERE kode_organisasi = '" + comboKode.getSelectedItem() + "'";

				} else {
					Query = "UPDATE organisasi SET nama_organisasi = '" + textNama.getText() + "', tujuan = '"
							+ textTujuan.getText() + "', waktu_berdiri = '" + textBerdiri.getText()
							+ "', waktu_berakhir = '" + textBerakhir.getText() + "', kategori_organisasi = '"
							+ textKategori.getText() + "' " + "WHERE kode_organisasi = '" + comboKode.getSelectedItem()
							+ "'";

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
		btnX.setBackground(new Color(0, 102, 153));
		btnX.setForeground(Color.WHITE);
		btnX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuAdmin.main();
			}
		});
		btnX.setBounds(665, 0, 49, 23);
		contentPane.add(btnX);
		lblNewLabel.setIcon(new ImageIcon(
				"F:\\Workspace\\Sejarah\\img\\Konachan.com - 234396 aircraft aqua_eyes aqua_hair bai_yemeng clouds hat hatsune_miku long_hair pantyhose shorts signed sky twintails vocaloid wet.jpg"));
		lblNewLabel.setBounds(0, 0, 714, 380);
		contentPane.add(lblNewLabel);

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
