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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import menu.Koneksi;
import menu.MenuAdmin;

public class updateera extends JFrame {

	private JPanel contentPane;
	private JTextField textNama;
	private JTextField textMulai;
	private JTextField textAkhir;
	public static Connection con = null;
	public static Statement stm = null;
	public static ResultSet sql = null;
	Koneksi k = new Koneksi();
	private JComboBox comboKode;
	private JPanel panel;
	private JLabel label;
	private JButton btnX;
	private JPanel panel_4;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					updateera frame = new updateera();
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
	public updateera() {
		try {
			con = k.koneksiDB();
			stm = (Statement) con.createStatement();
		} catch (SQLException e) {
			System.out.println();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 323);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kode Era", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(58, 60, 419, 43);
		contentPane.add(panel);
		panel.setLayout(null);

		comboKode = new JComboBox();
		comboKode.setBounds(6, 16, 407, 20);
		panel.add(comboKode);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nama Era", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(57, 104, 421, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textNama = new JTextField();
		textNama.setBounds(6, 16, 409, 20);
		panel_1.add(textNama);
		textNama.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Waktu Mulai (YYYY)",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(57, 151, 421, 43);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		textMulai = new JTextField();
		textMulai.setBounds(6, 16, 409, 20);
		panel_2.add(textMulai);
		textMulai.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Waktu Akhir (YYYY)",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(57, 196, 421, 43);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		textAkhir = new JTextField();
		textAkhir.setBounds(6, 16, 409, 20);
		panel_3.add(textAkhir);
		textAkhir.setColumns(10);

		LinkedList<String> era = new LinkedList();

		cekid("SELECT * FROM era;", era, 1);

		for (String a : era) {
			comboKode.addItem(a);
		}

		JButton btnSubmit = new JButton("UPDATE");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(new Color(0, 102, 153));
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "UPDATE era SET nama_era = '" + textNama.getText() + "',waktu_mulai = '"
						+ textMulai.getText() + "', waktu_akhir = '" + textAkhir.getText() + "' WHERE kode_era = '"
						+ comboKode.getSelectedItem() + "';";

				try {
					java.sql.Connection conn = k.koneksiDB();
					java.sql.PreparedStatement pst = conn.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "DATA BERHASIL DI UBAH");

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "GAGAL UPDATE");
				}
			}
		});
		btnSubmit.setBounds(222, 263, 89, 23);
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
		btnX.setBounds(493, 0, 50, 23);
		contentPane.add(btnX);

		panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 102, 153));
		panel_4.setBounds(0, 0, 543, 23);
		contentPane.add(panel_4);

		label = new JLabel("");
		label.setIcon(new ImageIcon(
				"F:\\Workspace\\Sejarah\\img\\Konachan.com - 234396 aircraft aqua_eyes aqua_hair bai_yemeng clouds hat hatsune_miku long_hair pantyhose shorts signed sky twintails vocaloid wet.jpg"));
		label.setBounds(0, 0, 543, 323);
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
