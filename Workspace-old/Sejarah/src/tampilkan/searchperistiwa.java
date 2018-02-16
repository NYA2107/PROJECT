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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import menu.Koneksi;
import menu.MenuUser;

public class searchperistiwa extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtsearch;
	private JTextField textField;
	private DefaultTableModel model;
	JComboBox comboBox, comboID;

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
					searchperistiwa frame = new searchperistiwa();
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
	public searchperistiwa() {

		try {
			con = k.koneksiDB();
			stm = (Statement) con.createStatement();
		} catch (SQLException e) {
			System.out.println();
		}

		setResizable(false);
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
		scrollPane.setBounds(10, 166, 1029, 394);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		String Query = "select * from peristiwa";
		tampilkantable(Query);

		txtsearch = new JTextField();
		txtsearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtsearch.setBounds(397, 51, 407, 20);
		contentPane.add(txtsearch);
		txtsearch.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setBounds(397, 100, 407, 20);
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "ID Peristiwa", "Nama Peristiwa",
				"Kategori Peristiwa", "Lokasi Peristiwa", "Tahun Peristiwa (YYYY)", "Bulan Peristiwa (MM)",
				"Tanggal Peristiwa (DD)", "Format Tanggal Lengkap (YYYY-MM-DD)" }));

		LinkedList<String> a = new LinkedList();
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(0, 102, 153));
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String base = (String) comboBox.getSelectedItem();
				if (base.equals("Nama Peristiwa")) {
					String Query = "select * from peristiwa where nama_peristiwa like " + "'%" + txtsearch.getText()
							+ "%'";
					tampilkantable(Query);
				} else if (base.equals("Kategori Peristiwa")) {
					String Query = "select * from peristiwa where kategori_peristiwa like " + "'%" + txtsearch.getText()
							+ "%'";
					tampilkantable(Query);
				} else if (base.equals("Lokasi Peristiwa")) {
					String Query = "select * from peristiwa where lokasi_peristiwa like " + "'%" + txtsearch.getText()
							+ "%'";
					tampilkantable(Query);

				} else if (base.equals("Tahun Peristiwa (YYYY)")) {
					String Query = "select * from peristiwa where waktu_peristiwa like " + "'" + txtsearch.getText()
							+ "______'";
					tampilkantable(Query);

				} else if (base.equals("Bulan Peristiwa (MM)")) {
					String Query = "select * from peristiwa where waktu_peristiwa like " + "'_____"
							+ txtsearch.getText() + "___'";
					tampilkantable(Query);

				} else if (base.equals("ID Peristiwa")) {
					String Query = "select * from peristiwa where kode_peristiwa like '%" + txtsearch.getText() + "%'";
					tampilkantable(Query);

				} else if (base.equals("Tanggal Peristiwa (DD)")) {
					String Query = "select * from peristiwa where waktu_peristiwa like " + "'________"
							+ txtsearch.getText() + "'";
					tampilkantable(Query);

				} else if (base.equals("Format Tanggal Lengkap (YYYY-MM-DD)")) {
					String Query = "select * from peristiwa where waktu_peristiwa = '" + txtsearch.getText() + "'";
					tampilkantable(Query);

				}
			}
		});
		btnSearch.setBounds(638, 131, 89, 23);
		contentPane.add(btnSearch);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnSearch.setBorder(emptyBorder);

		JButton btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setForeground(Color.WHITE);
		btnReset.setBackground(new Color(0, 102, 153));
		btnReset.setBorder(emptyBorder);
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String Query = "select * from peristiwa";
				tampilkantable(Query);
				txtsearch.setText("");
			}
		});
		btnReset.setBounds(479, 131, 89, 23);
		contentPane.add(btnReset);

		JLabel lblTelusurLebihLanjut = new JLabel("TELUSURI");
		lblTelusurLebihLanjut.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelusurLebihLanjut.setForeground(new Color(0, 102, 153));
		lblTelusurLebihLanjut.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelusurLebihLanjut.setBounds(1049, 390, 135, 20);
		contentPane.add(lblTelusurLebihLanjut);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(1049, 415, 135, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnSearch_1 = new JButton("SEARCH");
		btnSearch_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String Query = "select * from peristiwa where kode_peristiwa = '" + textField.getText() + "'";
				String QueryEmpty = "select * from peristiwa";
				cekid(Query, a);
				if (a.isEmpty()) {
					tampilkantable(QueryEmpty);
					JOptionPane.showMessageDialog(null, "ID TIDAK DITEMUKAN");

				} else {
					tampilkantable(QueryEmpty);
					JOptionPane.showMessageDialog(null, "ID DITEMUKAN, PERMINTAAN ANDA AKAN DIPROSES");
					dispose();
					desperistiwa.munculkan(textField.getText());
					a.clear();
				}

			}
		});
		btnSearch_1.setForeground(Color.WHITE);
		btnSearch_1.setBackground(new Color(0, 102, 153));
		btnSearch_1.setBounds(1075, 446, 89, 23);
		contentPane.add(btnSearch_1);
		btnSearch_1.setBorder(emptyBorder);

		JLabel lblNewLabel = new JLabel("CARI BERDASARKAN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(397, 82, 407, 20);
		contentPane.add(lblNewLabel);

		// LinkedList<String> b = new LinkedList();
		// comboIDh(Query, b);
		// comboID = new JComboBox();
		// comboID.setBounds(130, 100, 111, 20);
		// contentPane.add(comboID);
		// for (String p : b) {
		// comboID.addItem(p);
		// }

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1194, 29);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblPencarianBerdasarkanPeristiwa = new JLabel("PENCARIAN BERDASARKAN PERISTIWA");
		lblPencarianBerdasarkanPeristiwa.setHorizontalAlignment(SwingConstants.CENTER);
		lblPencarianBerdasarkanPeristiwa.setForeground(Color.WHITE);
		lblPencarianBerdasarkanPeristiwa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPencarianBerdasarkanPeristiwa.setBounds(10, 0, 1174, 29);
		panel.add(lblPencarianBerdasarkanPeristiwa);

		JButton btnX = new JButton("X");
		btnX.setFocusPainted(false);
		btnX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuUser.main();
			}
		});
		btnX.setBackground(SystemColor.controlDkShadow);
		btnX.setForeground(Color.WHITE);
		btnX.setBounds(1145, 0, 49, 29);
		btnX.setBorder(emptyBorder);
		panel.add(btnX);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"E:\\Konachan.com - 234396 aircraft aqua_eyes aqua_hair bai_yemeng clouds hat hatsune_miku long_hair pantyhose shorts signed sky twintails vocaloid wet.jpg"));
		label.setBounds(0, 0, 1194, 572);
		contentPane.add(label);

		// tampilkantable();
	}

	public void tampilkantable(String Query) {

		model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("ID");
		model.addColumn("Nama Peristiwa");
		model.addColumn("Kategori Persitiwa");
		model.addColumn("Waktu Peristiwa");
		model.addColumn("Lokasi Peristiwa");

		try {

			String sql = Query;
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				model.addRow(new Object[] { rs.getString("kode_peristiwa"), rs.getString("nama_peristiwa"),
						rs.getString("kategori_peristiwa"), rs.getString("waktu_peristiwa"),
						rs.getString("lokasi_peristiwa"),

				});

			}
			table.setModel(model);

		}

		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "FAILED TO LOAD DATABASE", "Warning", 2);
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(43);
		table.getColumnModel().getColumn(1).setPreferredWidth(259);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(259);

	}

	public void cekid(String Query, LinkedList<String> a) {

		try {

			String sql = Query;
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				a.add(rs.getString("kode_peristiwa"));

			}

		}

		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "FAILED TO LOAD DATABASE", "Warning", 2);
		}

	}

	// public void comboIDh(String Query, LinkedList<String> a) {
	//
	// try {
	//
	// String sql = Query;
	// PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
	// ResultSet rs = pst.executeQuery();
	//
	// while (rs.next()) {
	//
	// a.add(rs.getString("kode_peristiwa"));
	//
	// }
	//
	// }
	//
	// catch (SQLException e) {
	// JOptionPane.showMessageDialog(null, "FAILED TO LOAD DATABASE", "Warning", 2);
	// }
	//
	// }
}
