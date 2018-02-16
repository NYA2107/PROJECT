package tampilkan;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import menu.Koneksi;

public class desorganisasi extends JFrame {

	private JPanel contentPane;
	public static Connection con = null;
	public static Statement stm = null;
	// public static ResultSet rs = null;
	Koneksi k = new Koneksi();

	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {

					desorganisasi frame = new desorganisasi(id);
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
	public desorganisasi(String id) {
		try {
			con = k.koneksiDB();
			stm = (Statement) con.createStatement();
		} catch (SQLException e) {
			System.out.println();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 441);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		LinkedList<String> a = new LinkedList();
		getDes(a, id);

		JButton btnX = new JButton("X");
		btnX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				searchorganisasi.main();
			}
		});
		btnX.setBackground(new Color(0, 102, 102));
		btnX.setForeground(Color.WHITE);
		btnX.setBounds(408, 0, 45, 23);
		contentPane.add(btnX);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(0, 0, 453, 23);
		contentPane.add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 34, 400, 396);
		contentPane.add(scrollPane);

		JTextPane textDeskripsi = new JTextPane();
		scrollPane.setViewportView(textDeskripsi);
		textDeskripsi.setText(a.get(0) + "\n\n" + a.get(1));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"F:\\Workspace\\Sejarah\\img\\Konachan.com - 234396 aircraft aqua_eyes aqua_hair bai_yemeng clouds hat hatsune_miku long_hair pantyhose shorts signed sky twintails vocaloid wet.jpg"));
		label.setBounds(0, 0, 453, 441);
		contentPane.add(label);

	}

	public void getDes(LinkedList a, String id) {

		try {
			String Query = "SELECT * FROM organisasi where organisasi.kode_organisasi ='" + id + "';";
			java.sql.Connection conn = k.koneksiDB();
			java.sql.PreparedStatement pst = conn.prepareStatement(Query);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {// get first result
				a.add(rs.getString("nama_organisasi"));
				a.add(rs.getString("tujuan"));

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "TIDAK DAPAT MENAMPILKAN HASIL");
		}

	}
}
