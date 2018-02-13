package input;

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

public class inputperistiwa extends JFrame {

	private JPanel contentPane;
	private JTextField textKode;
	private JTextField textNama;
	private JTextField textKategori;
	private JTextField textWaktu;
	private JTextField textLokasi;
	private JTextArea textDeskripsi;
	private JButton btnSubmit;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	public static Connection con = null;
	public static Statement stm = null;
	public static ResultSet sql = null;
	Koneksi k = new Koneksi();
	private JScrollPane scrollPane;
	private JLabel label;
	private JButton btnX;
	private JPanel panel_7;
	private JLabel lblInsertPeristiwa;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					inputperistiwa frame = new inputperistiwa();
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
	public inputperistiwa() {
		try {
			con = k.koneksiDB();
			stm = (Statement) con.createStatement();
		} catch (SQLException e) {
			System.out.println();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 457);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kode Peristiwa",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(22, 108, 317, 43);
		contentPane.add(panel);
		panel.setLayout(null);

		textKode = new JTextField();
		textKode.setBounds(6, 16, 305, 20);
		panel.add(textKode);
		textKode.setColumns(10);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nama Peristiwa",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(22, 155, 317, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textNama = new JTextField();
		textNama.setBounds(6, 16, 305, 20);
		panel_1.add(textNama);
		textNama.setColumns(10);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kategori Peristiwa",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(22, 207, 317, 43);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		textKategori = new JTextField();
		textKategori.setBounds(6, 16, 305, 20);
		panel_2.add(textKategori);
		textKategori.setColumns(10);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Waktu Peristiwa",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(22, 258, 317, 43);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		textWaktu = new JTextField();
		textWaktu.setBounds(6, 16, 305, 20);
		panel_3.add(textWaktu);
		textWaktu.setColumns(10);

		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lokasi Peristiwa",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(22, 305, 317, 43);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		textLokasi = new JTextField();
		textLokasi.setBounds(6, 16, 305, 20);
		panel_4.add(textLokasi);
		textLokasi.setColumns(10);

		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Era", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(22, 354, 317, 43);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JComboBox comboEra = new JComboBox();
		comboEra.setBounds(6, 16, 305, 20);
		panel_5.add(comboEra);

		panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Deskripsi",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(362, 106, 347, 291);
		contentPane.add(panel_6);
		panel_6.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 16, 335, 268);
		panel_6.add(scrollPane);

		textDeskripsi = new JTextArea();
		scrollPane.setViewportView(textDeskripsi);

		LinkedList<String> era = new LinkedList();
		cekid("select * from era", era, 1);
		for (String a : era) {
			comboEra.addItem(a);
		}

		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBackground(new Color(0, 102, 153));
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String sql = "insert into peristiwa(kode_peristiwa,E_KodeEra,nama_peristiwa,deskripsi,kategori_peristiwa,waktu_peristiwa,lokasi_peristiwa) VALUES ('"
						+ textKode.getText() + "','" + comboEra.getSelectedItem() + "','" + textNama.getText() + "','"
						+ textDeskripsi.getText() + "','" + textKategori.getText() + "','" + textWaktu.getText() + "','"
						+ textLokasi.getText() + "'); ";
				try {
					java.sql.Connection conn = k.koneksiDB();
					java.sql.PreparedStatement pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "INPUT SUKSES");

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT");
				}
			}
		});
		btnSubmit.setBounds(118, 413, 89, 23);
		contentPane.add(btnSubmit);

		btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuAdmin.main();
			}
		});
		btnX.setBackground(new Color(0, 102, 102));
		btnX.setForeground(Color.WHITE);
		btnX.setBounds(686, 0, 47, 23);
		contentPane.add(btnX);

		panel_7 = new JPanel();
		panel_7.setBackground(new Color(0, 102, 153));
		panel_7.setBounds(0, 0, 733, 23);
		contentPane.add(panel_7);

		lblInsertPeristiwa = new JLabel("INSERT PERISTIWA");
		lblInsertPeristiwa.setForeground(Color.WHITE);
		panel_7.add(lblInsertPeristiwa);

		label = new JLabel("");
		label.setIcon(new ImageIcon(
				"F:\\Workspace\\Sejarah\\img\\Konachan.com - 234396 aircraft aqua_eyes aqua_hair bai_yemeng clouds hat hatsune_miku long_hair pantyhose shorts signed sky twintails vocaloid wet.jpg"));
		label.setBounds(0, 0, 733, 457);
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
