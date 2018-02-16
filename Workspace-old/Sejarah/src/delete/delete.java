package delete;

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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import menu.Koneksi;
import menu.MenuAdmin;

public class delete extends JFrame {

	private JPanel contentPane;
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
					delete frame = new delete();
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
	public delete() {
		try {
			con = k.koneksiDB();
			stm = (Statement) con.createStatement();
		} catch (SQLException e) {
			System.out.println();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 410);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tokoh", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(45, 52, 280, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JComboBox comboTokoh = new JComboBox();
		comboTokoh.setBounds(6, 16, 268, 20);
		panel_1.add(comboTokoh);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Peristiwa",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(45, 97, 280, 43);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JComboBox comboPeristiwa = new JComboBox();
		comboPeristiwa.setBounds(6, 16, 268, 20);
		panel_2.add(comboPeristiwa);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Organisasi",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(45, 140, 280, 43);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JComboBox comboOrganisasi = new JComboBox();
		comboOrganisasi.setBounds(6, 16, 268, 20);
		panel_3.add(comboOrganisasi);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Keputusan",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(45, 186, 280, 43);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		JComboBox comboKeputusan = new JComboBox();
		comboKeputusan.setBounds(6, 16, 268, 20);
		panel_4.add(comboKeputusan);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tempat Besejarah",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(45, 228, 280, 43);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JComboBox comboTempat = new JComboBox();
		comboTempat.setBounds(6, 16, 268, 20);
		panel_5.add(comboTempat);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Era", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(45, 275, 280, 43);
		contentPane.add(panel_6);
		panel_6.setLayout(null);

		JComboBox comboEra = new JComboBox();
		comboEra.setBounds(6, 16, 268, 20);
		panel_6.add(comboEra);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(45, 320, 280, 43);
		contentPane.add(panel_7);
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pendiri Organisasi",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_7.setLayout(null);

		JComboBox comboPendiri = new JComboBox();
		comboPendiri.setBounds(6, 16, 268, 20);
		panel_7.add(comboPendiri);

		LinkedList<String> tokoh = new LinkedList();
		LinkedList<String> peristiwa = new LinkedList();
		LinkedList<String> keputusan = new LinkedList();
		LinkedList<String> era = new LinkedList();
		LinkedList<String> tempat = new LinkedList();
		LinkedList<String> organisasi = new LinkedList();
		LinkedList<String> pendiri = new LinkedList();

		cekid("select * from tokoh;", tokoh, 1);
		cekid("select * from peristiwa;", peristiwa, 1);
		cekid("select * from keputusan;", keputusan, 2);
		cekid("select * from era;", era, 1);
		cekid("select * from tempat_bersejarah;", tempat, 1);
		cekid("select * from organisasi;", organisasi, 1);
		cekid("select * from pendiri_organisasi;", pendiri, 2);

		for (String a : tokoh) {
			comboTokoh.addItem(a);
		}
		for (String a : peristiwa) {
			comboPeristiwa.addItem(a);
		}
		for (String a : keputusan) {
			comboKeputusan.addItem(a);
		}
		for (String a : era) {
			comboEra.addItem(a);
		}
		for (String a : tempat) {
			comboTempat.addItem(a);
		}
		for (String a : organisasi) {
			comboOrganisasi.addItem(a);
		}
		for (String a : pendiri) {
			comboPendiri.addItem(a);
		}

		JButton btnTokoh = new JButton("HAPUS");
		btnTokoh.setForeground(Color.WHITE);
		btnTokoh.setBackground(new Color(0, 102, 153));
		btnTokoh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "delete from tokoh where kode_tokoh = '" + comboTokoh.getSelectedItem() + "';";

				try {
					java.sql.Connection conn = k.koneksiDB();
					java.sql.PreparedStatement pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "DATA BERHASIL DI HAPUS");

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "GAGAL MENGHAPUS");
				}
			}
		});
		btnTokoh.setBounds(356, 67, 89, 23);
		contentPane.add(btnTokoh);

		JButton btnPeristiwa = new JButton("HAPUS");
		btnPeristiwa.setForeground(Color.WHITE);
		btnPeristiwa.setBackground(new Color(0, 102, 153));
		btnPeristiwa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "delete from peristiwa where kode_peristiwa = '" + comboPeristiwa.getSelectedItem() + "';";

				try {
					java.sql.Connection conn = k.koneksiDB();
					java.sql.PreparedStatement pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "DATA BERHASIL DI HAPUS");

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "GAGAL MENGHAPUS");
				}
			}
		});
		btnPeristiwa.setBounds(356, 112, 89, 23);
		contentPane.add(btnPeristiwa);

		JButton button_1 = new JButton("HAPUS");
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(0, 102, 153));
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (comboOrganisasi.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "DATA MASIH KOSONG");
				} else {
					String sql = "delete from organisasi where kode_organisasi = '" + comboOrganisasi.getSelectedItem()
							+ "';";

					try {
						java.sql.Connection conn = k.koneksiDB();
						java.sql.PreparedStatement pst = conn.prepareStatement(sql);
						pst.execute();
						JOptionPane.showMessageDialog(null, "DATA BERHASIL DI HAPUS");

					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "GAGAL MENGHAPUS");
					}
				}

			}
		});
		button_1.setBounds(356, 155, 89, 23);
		contentPane.add(button_1);

		JButton button_2 = new JButton("HAPUS");
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(0, 102, 153));
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "delete from keputusan where kode_keputusan = '" + comboKeputusan.getSelectedItem() + "';";

				try {
					java.sql.Connection conn = k.koneksiDB();
					java.sql.PreparedStatement pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "DATA BERHASIL DI HAPUS");

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "GAGAL MENGHAPUS");
				}

			}
		});
		button_2.setBounds(356, 201, 89, 23);
		contentPane.add(button_2);

		JButton button_3 = new JButton("HAPUS");
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(new Color(0, 102, 153));
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "delete from tempat_bersejarah where kode_tempat = '" + comboTempat.getSelectedItem()
						+ "';";

				try {
					java.sql.Connection conn = k.koneksiDB();
					java.sql.PreparedStatement pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "DATA BERHASIL DI HAPUS");

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "GAGAL MENGHAPUS");
				}
			}
		});
		button_3.setBounds(356, 243, 89, 23);
		contentPane.add(button_3);

		JButton button_4 = new JButton("HAPUS");
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(new Color(0, 102, 153));
		button_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "delete from era where kode_era = '" + comboEra.getSelectedItem() + "';";

				try {
					java.sql.Connection conn = k.koneksiDB();
					java.sql.PreparedStatement pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "DATA BERHASIL DI HAPUS");

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "GAGAL MENGHAPUS");
				}
			}
		});
		button_4.setBounds(356, 288, 89, 23);
		contentPane.add(button_4);

		JButton button_5 = new JButton("HAPUS");
		button_5.setForeground(Color.WHITE);
		button_5.setBackground(new Color(0, 102, 153));
		button_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "delete from pendiri_organisasi where pendiri = '" + comboPendiri.getSelectedItem() + "';";

				try {
					java.sql.Connection conn = k.koneksiDB();
					java.sql.PreparedStatement pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "DATA BERHASIL DI HAPUS");

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "GAGAL MENGHAPUS");
				}
			}
		});
		button_5.setBounds(356, 332, 89, 23);
		contentPane.add(button_5);

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
		btnX.setBounds(456, 0, 47, 23);
		contentPane.add(btnX);

		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setBackground(new Color(0, 102, 153));
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				delete.main();
			}
		});
		btnRefresh.setBounds(131, 374, 89, 23);
		contentPane.add(btnRefresh);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(0, 0, 503, 23);
		contentPane.add(panel);

		JLabel lblHapusData = new JLabel("HAPUS DATA");
		lblHapusData.setForeground(Color.WHITE);
		panel.add(lblHapusData);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"F:\\Workspace\\Sejarah\\img\\Konachan.com - 234396 aircraft aqua_eyes aqua_hair bai_yemeng clouds hat hatsune_miku long_hair pantyhose shorts signed sky twintails vocaloid wet.jpg"));
		lblNewLabel.setBounds(0, 0, 503, 420);
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
