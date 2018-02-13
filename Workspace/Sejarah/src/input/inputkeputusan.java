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

public class inputkeputusan extends JFrame {

	private JPanel contentPane;
	public static Connection con = null;
	public static Statement stm = null;
	public static ResultSet sql = null;
	Koneksi k = new Koneksi();
	private JTextField textKode;
	private JTextField textNama;
	private JTextField textWaktu;
	private JButton btnNewButton;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextArea textIsi;
	private JPanel panel_4;
	private JScrollPane scrollPane;
	private JLabel label;
	private JButton btnX;
	private JPanel panel_5;
	private JLabel lblInsertKeputusan;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					inputkeputusan frame = new inputkeputusan();
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
	public inputkeputusan() {
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
		panel.setBounds(32, 77, 471, 43);
		contentPane.add(panel);
		panel.setLayout(null);

		textKode = new JTextField();
		textKode.setBounds(6, 16, 459, 20);
		panel.add(textKode);
		textKode.setColumns(10);

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

		cekid("SELECT * FROM peristiwa;", peristiwa, 1);

		for (String a : peristiwa) {
			comboPeristiwa.addItem(a);
		}

		btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBackground(new Color(0, 102, 153));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String sql = "insert into keputusan(P_Kode_Peristiwa,kode_keputusan,nama_keputusan,isi_keputusan,waktu_pengesahan)VALUES('"
						+ comboPeristiwa.getSelectedItem() + "','" + textKode.getText() + "','" + textNama.getText()
						+ "','" + textIsi.getText() + "','" + textWaktu.getText() + "');";
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
		btnNewButton.setBounds(221, 297, 89, 23);
		contentPane.add(btnNewButton);

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
		btnX.setBounds(828, 0, 49, 23);
		contentPane.add(btnX);

		panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 102, 153));
		panel_5.setBounds(0, 0, 877, 23);
		contentPane.add(panel_5);

		lblInsertKeputusan = new JLabel("INSERT KEPUTUSAN");
		lblInsertKeputusan.setForeground(Color.WHITE);
		panel_5.add(lblInsertKeputusan);

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
