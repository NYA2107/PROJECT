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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import menu.Koneksi;
import menu.MenuAdmin;

public class penghubungprimer extends JFrame {

	private JPanel contentPane;
	public static Connection con = null;
	public static Statement stm = null;
	public static ResultSet sql = null;
	Koneksi k = new Koneksi();
	private JTextField textPendiri;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					penghubungprimer frame = new penghubungprimer();
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
	public penghubungprimer() {

		try {
			con = k.koneksiDB();
			stm = (Statement) con.createStatement();
		} catch (SQLException e) {
			System.out.println();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 300);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tokoh", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 71, 201, 43);
		contentPane.add(panel);
		panel.setLayout(null);

		JComboBox comboTokoh = new JComboBox();
		comboTokoh.setBounds(6, 16, 189, 20);
		panel.add(comboTokoh);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Peristiwa",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(6, 118, 201, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JComboBox comboPeristiwa = new JComboBox();
		comboPeristiwa.setBounds(6, 16, 189, 20);
		panel_1.add(comboPeristiwa);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Organisasi",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(6, 165, 201, 43);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JComboBox comboOrganisasi = new JComboBox();
		comboOrganisasi.setBounds(6, 16, 189, 20);
		panel_2.add(comboOrganisasi);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Organisasi",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(239, 71, 201, 43);
		contentPane.add(panel_3);

		JComboBox comboOrganisasi1 = new JComboBox();
		comboOrganisasi1.setBounds(6, 16, 189, 20);
		panel_3.add(comboOrganisasi1);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pendiri", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(239, 118, 201, 43);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		textPendiri = new JTextField();
		textPendiri.setBounds(6, 16, 189, 20);
		panel_4.add(textPendiri);
		textPendiri.setColumns(10);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		LinkedList<String> tokoh = new LinkedList();
		LinkedList<String> peristiwa = new LinkedList();
		LinkedList<String> organisasi = new LinkedList();

		cekid("SELECT * FROM tokoh ", tokoh, 1);
		cekid("SELECT * FROM peristiwa", peristiwa, 1);
		cekid("SELECT * FROM organisasi", organisasi, 1);

		for (String a : tokoh) {
			comboTokoh.addItem(a);
		}
		for (String a : peristiwa) {
			comboPeristiwa.addItem(a);

		}
		for (String a : organisasi) {
			comboOrganisasi.addItem(a);
			comboOrganisasi1.addItem(a);
		}

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JButton btnHubungkan = new JButton("HUBUNGKAN");
		btnHubungkan.setBackground(new Color(0, 102, 153));
		btnHubungkan.setForeground(Color.WHITE);
		btnHubungkan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// comboPeristiwa - comboOrganisasi - comboTokoh

				String sql = "insert into berhubungan(P_KodePeristiwa,O_KodeOrganisasi,TO_KodeTokoh) VALUES ('"
						+ comboPeristiwa.getSelectedItem() + "','" + comboOrganisasi.getSelectedItem() + "','"
						+ comboTokoh.getSelectedItem() + "') ";
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
		btnHubungkan.setBounds(10, 222, 194, 23);
		contentPane.add(btnHubungkan);

		JButton button = new JButton("HUBUNGKAN");
		button.setBackground(new Color(0, 102, 153));
		button.setForeground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboOrganisasi1.getSelectedItem().equals("") || textPendiri.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "DATA MASIH KOSONG");

				} else {
					String sql = "insert into pendiri_organisasi (O_KodeOrg,pendiri) VALUES ('"
							+ comboOrganisasi1.getSelectedItem() + "','" + textPendiri.getText() + "') ";
					try {
						java.sql.Connection conn = k.koneksiDB();
						java.sql.PreparedStatement pst = conn.prepareStatement(sql);
						pst.execute();
						JOptionPane.showMessageDialog(null, "INPUT SUKSES");

					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "INVALID INPUT");
					}

				}

			}
		});
		button.setBounds(246, 185, 194, 23);
		contentPane.add(button);

		JButton btnNewButton = new JButton("HAPUS");
		btnNewButton.setBackground(new Color(0, 102, 153));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String sql = "DELETE FROM berhubungan WHERE TO_KodeTokoh ='" + comboTokoh.getSelectedItem()
						+ "'AND O_KodeOrganisasi = '" + comboOrganisasi.getSelectedItem() + "'AND P_KodePeristiwa = '"
						+ comboPeristiwa.getSelectedItem() + "'; ";

				try {
					java.sql.Connection conn = k.koneksiDB();
					java.sql.PreparedStatement pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "RELASI DIHAPUS");

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "INVALID INPUT");
				}
			}
		});
		btnNewButton.setBounds(10, 252, 194, 23);
		contentPane.add(btnNewButton);

		JButton button_1 = new JButton("HAPUS");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (comboOrganisasi1.getSelectedItem().equals("") || textPendiri.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "DATA MASIH KOSONG");
				} else {
					String sql = "DELETE FROM pendiri_organisasi WHERE O_KodeOrg ='"
							+ comboOrganisasi1.getSelectedItem() + "'AND pendiri = '" + textPendiri.getText() + "'; ";

					try {
						java.sql.Connection conn = k.koneksiDB();
						java.sql.PreparedStatement pst = conn.prepareStatement(sql);
						pst.execute();
						JOptionPane.showMessageDialog(null, "RELASI DIHAPUS");

					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "INVALID INPUT");
					}
				}

			}
		});
		button_1.setBackground(new Color(0, 102, 153));
		button_1.setForeground(Color.WHITE);
		button_1.setBounds(246, 222, 194, 23);
		contentPane.add(button_1);

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
		btnX.setBounds(401, 0, 48, 23);
		contentPane.add(btnX);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 102, 153));
		panel_5.setBounds(0, 0, 449, 23);
		contentPane.add(panel_5);

		JLabel lblHubungkanData = new JLabel("HUBUNGKAN DATA");
		lblHubungkanData.setForeground(Color.WHITE);
		panel_5.add(lblHubungkanData);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"F:\\Workspace\\Sejarah\\img\\Konachan.com - 234396 aircraft aqua_eyes aqua_hair bai_yemeng clouds hat hatsune_miku long_hair pantyhose shorts signed sky twintails vocaloid wet.jpg"));
		label.setBounds(0, 0, 449, 300);
		contentPane.add(label);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
