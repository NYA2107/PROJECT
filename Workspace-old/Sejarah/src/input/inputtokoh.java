package input;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
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

import com.mysql.jdbc.Statement;

import menu.Koneksi;
import menu.MenuAdmin;

public class inputtokoh extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textNama;
	private JTextField textKategori;
	private JTextField textKelahiran;
	private JTextField textKematian;
	private JTextField textAsal;
	String Query = "";
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
					inputtokoh frame = new inputtokoh();
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
	public inputtokoh() {
		try {
			con = k.koneksiDB();
			stm = (Statement) con.createStatement();
		} catch (SQLException e) {
			System.out.println();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 491);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "ID Tokoh", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(83, 102, 294, 43);
		contentPane.add(panel);
		panel.setLayout(null);

		textID = new JTextField();
		textID.setBounds(6, 16, 282, 20);
		panel.add(textID);
		textID.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Nama Tokoh",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(83, 145, 294, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textNama = new JTextField();
		textNama.setBounds(6, 16, 282, 20);
		panel_1.add(textNama);
		textNama.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kategori Tokoh",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(84, 190, 294, 43);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		textKategori = new JTextField();
		textKategori.setBounds(6, 16, 282, 20);
		panel_2.add(textKategori);
		textKategori.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tanggal Kelahiran (YYYY-MM-DD)",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(84, 234, 294, 43);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		textKelahiran = new JTextField();
		textKelahiran.setBounds(6, 16, 282, 20);
		panel_3.add(textKelahiran);
		textKelahiran.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tanggal Kematian (YYYY-MM-DD)",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(85, 280, 294, 43);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		textKematian = new JTextField();
		textKematian.setBounds(6, 16, 282, 20);
		panel_4.add(textKematian);
		textKematian.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Asal Tokoh",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(85, 324, 294, 43);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		textAsal = new JTextField();
		textAsal.setBounds(6, 16, 282, 20);
		panel_5.add(textAsal);
		textAsal.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Gender", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBounds(86, 365, 294, 43);
		contentPane.add(panel_6);
		panel_6.setLayout(null);

		JComboBox comboGender = new JComboBox();
		comboGender.setModel(new DefaultComboBoxModel(new String[] { "Laki-Laki", "Perempuan" }));
		comboGender.setBounds(6, 16, 282, 20);
		panel_6.add(comboGender);

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textKematian.getText().isEmpty()) {
					Query = "INSERT INTO `tokoh` (`kode_tokoh`, `nama_tokoh`, `kategori_tokoh`, `gender`, `kelahiran`, `asal_tokoh`) VALUES ('"
							+ textID.getText() + "', '" + textNama.getText() + "', '" + textKategori.getText() + "', '"
							+ comboGender.getSelectedItem() + "', '" + textKelahiran.getText() + "', '"
							+ textAsal.getText() + "');";

				} else {
					Query = "INSERT INTO `tokoh` (`kode_tokoh`, `nama_tokoh`, `kategori_tokoh`, `gender`, `kelahiran`,`kematian`, `asal_tokoh`) VALUES ('"
							+ textID.getText() + "', '" + textNama.getText() + "', '" + textKategori.getText() + "', '"
							+ comboGender.getSelectedItem() + "', '" + textKelahiran.getText() + "','"
							+ textKematian.getText() + "', '" + textAsal.getText() + "');";

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
		btnSubmit.setBounds(188, 428, 89, 23);
		contentPane.add(btnSubmit);

		JButton btnNewButton = new JButton("X");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 102, 102));
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuAdmin.main();
			}
		});
		btnNewButton.setBounds(433, 0, 43, 23);
		contentPane.add(btnNewButton);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(0, 102, 153));
		panel_7.setBounds(0, 0, 476, 23);
		contentPane.add(panel_7);

		JLabel lblInsertTokoh = new JLabel("INSERT TOKOH");
		lblInsertTokoh.setForeground(Color.WHITE);
		panel_7.add(lblInsertTokoh);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"F:\\Workspace\\Sejarah\\img\\Konachan.com - 234396 aircraft aqua_eyes aqua_hair bai_yemeng clouds hat hatsune_miku long_hair pantyhose shorts signed sky twintails vocaloid wet.jpg"));
		lblNewLabel.setBounds(0, 4, 476, 487);
		contentPane.add(lblNewLabel);

	}
}