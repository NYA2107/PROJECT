package tampilkan;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import menu.Koneksi;

public class desperistiwa extends JFrame {

	private JPanel contentPane;
	public static Connection con = null;
	public static Statement stm = null;
	// public static ResultSet rs = null;
	Koneksi k = new Koneksi();
	JTextPane textDeskripsi;
	private JTable tabletokoh;
	private JTable tableorganisasi;
	private JTable tabletempat;
	private JTable tableera;
	private DefaultTableModel model;
	private JTable tablekeputusan;

	/**
	 * Launch the application.
	 */
	public static void munculkan(String id) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					desperistiwa frame = new desperistiwa(id);
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
	public desperistiwa(String id) {
		setResizable(false);
		try {
			con = k.koneksiDB();
			stm = (Statement) con.createStatement();
		} catch (SQLException e) {
			System.out.println();
		}
		LinkedList<String> a = new LinkedList();
		Border emptyBorder = BorderFactory.createEmptyBorder();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1193, 572);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 65, 280, 495);
		contentPane.add(scrollPane);

		textDeskripsi = new JTextPane();
		textDeskripsi.setEditable(false);
		scrollPane.setViewportView(textDeskripsi);

		getDes(a, id);
		textDeskripsi.setText(a.get(0) + "\n\n" + a.get(1));

		JScrollPane organisasiscr = new JScrollPane();
		organisasiscr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		organisasiscr.setBounds(323, 260, 402, 143);
		contentPane.add(organisasiscr);

		tableorganisasi = new JTable();
		organisasiscr.setViewportView(tableorganisasi);

		JScrollPane tempatscr = new JScrollPane();
		tempatscr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tempatscr.setBounds(751, 65, 432, 141);
		contentPane.add(tempatscr);

		tabletempat = new JTable();
		tempatscr.setViewportView(tabletempat);

		JScrollPane erascr = new JScrollPane();
		erascr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		erascr.setBounds(751, 263, 432, 141);
		contentPane.add(erascr);

		tableera = new JTable();
		erascr.setViewportView(tableera);

		JScrollPane tokohscr = new JScrollPane();
		tokohscr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tokohscr.setBounds(322, 65, 405, 146);
		contentPane.add(tokohscr);

		tabletokoh = new JTable();
		tokohscr.setViewportView(tabletokoh);

		JButton btnX = new JButton("X");
		btnX.setFocusPainted(false);
		btnX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				searchperistiwa.main();

			}
		});

		JScrollPane keputusanscr = new JScrollPane();
		keputusanscr.setBounds(324, 442, 401, 119);
		contentPane.add(keputusanscr);

		tablekeputusan = new JTable();
		keputusanscr.setViewportView(tablekeputusan);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(0, 0, 1169, 26);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblA = new JLabel(a.get(0));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblA.setForeground(Color.WHITE);
		lblA.setBounds(10, 0, 1184, 25);
		panel.add(lblA);
		btnX.setBackground(SystemColor.controlDkShadow);
		btnX.setForeground(Color.WHITE);
		btnX.setBounds(1152, 0, 42, 26);
		btnX.setBorder(emptyBorder);
		contentPane.add(btnX);

		JLabel lblTempatBersejarah = new JLabel("TEMPAT BERSEJARAH :");
		lblTempatBersejarah.setForeground(Color.WHITE);
		lblTempatBersejarah.setBounds(752, 49, 136, 14);
		contentPane.add(lblTempatBersejarah);

		JLabel lblKeputusan = new JLabel("KEPUTUSAN :");
		lblKeputusan.setForeground(Color.WHITE);
		lblKeputusan.setBounds(323, 425, 182, 14);
		contentPane.add(lblKeputusan);

		JLabel lblEraPeristiwa = new JLabel("ERA PERISTIWA :");
		lblEraPeristiwa.setForeground(Color.WHITE);
		lblEraPeristiwa.setBounds(752, 249, 206, 14);
		contentPane.add(lblEraPeristiwa);

		JLabel lblOrganisasiTerkait = new JLabel("ORGANISASI TERKAIT :");
		lblOrganisasiTerkait.setForeground(Color.WHITE);
		lblOrganisasiTerkait.setBounds(325, 238, 165, 14);
		contentPane.add(lblOrganisasiTerkait);

		JLabel lblTokohTerkait = new JLabel("TOKOH TERKAIT :");
		lblTokohTerkait.setForeground(Color.WHITE);
		lblTokohTerkait.setBounds(323, 49, 201, 14);
		contentPane.add(lblTokohTerkait);

		JLabel lblDeskripsiPeristiwa = new JLabel("DESKRIPSI PERISTIWA :");
		lblDeskripsiPeristiwa.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeskripsiPeristiwa.setForeground(Color.WHITE);
		lblDeskripsiPeristiwa.setBounds(10, 49, 152, 14);
		contentPane.add(lblDeskripsiPeristiwa);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(
				"E:\\Konachan.com - 237755 aqua_hair hatsune_miku long_hair microphone sishenfan skirt thighhighs twintails vocaloid.jpg"));
		lblBackground.setBounds(0, 0, 1194, 571);
		contentPane.add(lblBackground);

		tampilkantabletokoh(
				"SELECT DISTINCT tokoh.nama_tokoh, tokoh.asal_tokoh FROM berhubungan, tokoh where tokoh.kode_tokoh = berhubungan.TO_KodeTokoh AND P_KodePeristiwa = '"
						+ id + "' ;");
		tampilkantableorganisasi(
				"SELECT DISTINCT organisasi.nama_organisasi, organisasi.kategori_organisasi, organisasi.kode_organisasi FROM berhubungan, organisasi where organisasi.kode_organisasi = berhubungan.O_KodeOrganisasi AND P_KodePeristiwa = '"
						+ id + "' ;");
		tampilkantabletempat(
				"SELECT DISTINCT tempat_bersejarah.nam_tempat, tempat_bersejarah.lokasi_tempat FROM tempat_bersejarah, peristiwa where tempat_bersejarah.P_KodePeristiwa = peristiwa.kode_peristiwa AND P_KodePeristiwa = '"
						+ id + "' ;");
		tampilkantableera(
				"SELECT DISTINCT era.nama_era, era.waktu_mulai, era.waktu_akhir FROM peristiwa, era WHERE peristiwa.E_KodeEra = era.kode_era AND peristiwa.kode_peristiwa= '"
						+ id + "' ;");
		tampilkantablekeputusan(
				"SELECT DISTINCT keputusan.nama_keputusan, keputusan.waktu_pengesahan FROM peristiwa, keputusan WHERE peristiwa.kode_peristiwa = keputusan.P_Kode_Peristiwa AND peristiwa.kode_peristiwa ='"
						+ id + "';");

	}

	public void getDes(LinkedList a, String id) {

		try {
			String Query = "SELECT * FROM peristiwa where peristiwa.kode_peristiwa ='" + id + "';";
			java.sql.Connection conn = k.koneksiDB();
			java.sql.PreparedStatement pst = conn.prepareStatement(Query);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {// get first result
				a.add(rs.getString("nama_peristiwa"));
				a.add(rs.getString("deskripsi"));

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "TIDAK DAPAT MENAMPILKAN HASIL");
		}

	}

	public void tampilkantabletokoh(String Query) {

		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("NAMA TOKOH");
		model.addColumn("ASAL TOKOH");

		try {

			String sql = Query;
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("nama_tokoh"), rs.getString("asal_tokoh"),

				});

			}
			tabletokoh.setModel(model);

		}

		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "FAILED TO LOAD DATABASE", "Warning", 2);
		}

	}

	public void tampilkantableorganisasi(String Query) {

		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("KODE ORGANISASI");
		model.addColumn("KATEGORI");
		model.addColumn("NAMA ORGANISASI");

		try {

			String sql = Query;
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("kode_organisasi"), rs.getString("kategori_organisasi"),
						rs.getString("nama_organisasi"),

				});

			}
			tableorganisasi.setModel(model);

		}

		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "FAILED TO LOAD DATABASE", "Warning", 2);
		}

	}

	public void tampilkantableera(String Query) {

		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("NAMA ERA");
		model.addColumn("WAKTU MULAI");
		model.addColumn("WAKTU AKHIR");

		try {

			String sql = Query;
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("nama_era"), rs.getString("waktu_mulai"),
						rs.getString("waktu_akhir"),

				});

			}
			tableera.setModel(model);

		}

		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "FAILED TO LOAD DATABASE", "Warning", 2);
		}

	}

	public void tampilkantabletempat(String Query) {

		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("NAMA TEMPAT");
		model.addColumn("LOKASI TEMPAT");

		try {

			String sql = Query;
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("nam_tempat"), rs.getString("lokasi_tempat"),

				});

			}
			tabletempat.setModel(model);

		}

		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "FAILED TO LOAD DATABASE", "Warning", 2);
		}

	}

	public void tampilkantablekeputusan(String Query) {

		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("NAMA KEPUTUSAN");
		model.addColumn("WAKTU PENGESAHAN");

		try {

			String sql = Query;
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("nama_keputusan"), rs.getString("waktu_pengesahan"),

				});

			}
			tablekeputusan.setModel(model);

		}

		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "FAILED TO LOAD DATABASE", "Warning", 2);
		}

	}
}
