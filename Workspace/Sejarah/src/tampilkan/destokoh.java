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
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import menu.Koneksi;

public class destokoh extends JFrame {

	private JPanel contentPane;
	public static Connection con = null;
	public static Statement stm = null;
	// public static ResultSet rs = null;
	Koneksi k = new Koneksi();
	private JTable tableorganisasi;
	private DefaultTableModel model;
	private JTable tablePeristiwa;

	/**
	 * Launch the application.
	 */
	public static void munculkan(String id) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					destokoh frame = new destokoh(id);
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
	public destokoh(String id) {
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
		setBounds(100, 100, 954, 275);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		getDes(a, id);

		JScrollPane organisasiscr = new JScrollPane();
		organisasiscr.setBounds(20, 96, 402, 143);
		contentPane.add(organisasiscr);

		tableorganisasi = new JTable();
		organisasiscr.setViewportView(tableorganisasi);

		JButton btnX = new JButton("X");
		btnX.setFocusPainted(false);
		btnX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				searchtokoh.main();

			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(0, 0, 914, 26);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblA = new JLabel(a.get(0));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblA.setForeground(Color.WHITE);
		lblA.setBounds(0, 0, 914, 25);
		panel.add(lblA);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(480, 97, 445, 143);
		contentPane.add(scrollPane);

		tablePeristiwa = new JTable();
		scrollPane.setViewportView(tablePeristiwa);
		btnX.setBackground(SystemColor.controlDkShadow);
		btnX.setForeground(Color.WHITE);
		btnX.setBounds(912, 0, 42, 26);
		btnX.setBorder(emptyBorder);
		contentPane.add(btnX);

		JLabel lblPeristiwaTerkait = new JLabel("PERISTIWA TERKAIT :");
		lblPeristiwaTerkait.setForeground(Color.WHITE);
		lblPeristiwaTerkait.setBounds(480, 71, 165, 14);
		contentPane.add(lblPeristiwaTerkait);

		JLabel lblOrganisasiTerkait = new JLabel("ORGANISASI TERKAIT :");
		lblOrganisasiTerkait.setForeground(new Color(0, 102, 153));
		lblOrganisasiTerkait.setBounds(20, 71, 165, 14);
		contentPane.add(lblOrganisasiTerkait);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(
				"F:\\Workspace\\Sejarah\\img\\Konachan.com - 234396 aircraft aqua_eyes aqua_hair bai_yemeng clouds hat hatsune_miku long_hair pantyhose shorts signed sky twintails vocaloid wet.jpg"));
		lblBackground.setBounds(0, 0, 1194, 275);
		contentPane.add(lblBackground);

		tampilkantableorganisasi(
				"SELECT organisasi.nama_organisasi, organisasi.kategori_organisasi FROM berhubungan, organisasi where organisasi.kode_organisasi = berhubungan.O_KodeOrganisasi AND TO_KodeTokoh = '"
						+ id + "' ;");
		tampilkantableperistiwa(
				"SELECT peristiwa.nama_peristiwa, peristiwa.kategori_peristiwa FROM berhubungan, peristiwa where peristiwa.kode_peristiwa = berhubungan.P_KodePeristiwa AND TO_KodeTokoh = '"
						+ id + "' ;");

	}

	public void getDes(LinkedList a, String id) {

		try {
			String Query = "SELECT * FROM tokoh where tokoh.kode_tokoh ='" + id + "';";
			java.sql.Connection conn = k.koneksiDB();
			java.sql.PreparedStatement pst = conn.prepareStatement(Query);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {// get first result
				a.add(rs.getString("nama_tokoh"));

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "TIDAK DAPAT MENAMPILKAN HASIL");
		}

	}

	public void tampilkantableperistiwa(String Query) {

		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("NAMA PERISTIWA");
		model.addColumn("KATEGORI PERISTIWA");

		try {

			String sql = Query;
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("nama_peristiwa"), rs.getString("kategori_peristiwa"),

				});

			}
			tablePeristiwa.setModel(model);

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

		model.addColumn("NAMA ORGANISASI");
		model.addColumn("KATEGORI ORGANISASI");

		try {

			String sql = Query;
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("nama_organisasi"), rs.getString("kategori_organisasi"),

				});

			}
			tableorganisasi.setModel(model);

		}

		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "FAILED TO LOAD DATABASE", "Warning", 2);
		}

	}

}
