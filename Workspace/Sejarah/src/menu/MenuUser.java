package menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tampilkan.searchorganisasi;
import tampilkan.searchperistiwa;
import tampilkan.searchtokoh;

public class MenuUser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MenuUser frame = new MenuUser();
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
	public MenuUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 135);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Tokoh", "Peristiwa", "Organisasi" }));
		comboBox.setBounds(32, 55, 378, 20);
		contentPane.add(comboBox);

		JButton btnNext = new JButton("NEXT");
		btnNext.setBackground(new Color(0, 102, 153));
		btnNext.setForeground(Color.WHITE);
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("Tokoh")) {
					dispose();
					searchtokoh.main();
				} else if (comboBox.getSelectedItem().equals("Peristiwa")) {
					dispose();
					searchperistiwa.main();
				} else if (comboBox.getSelectedItem().equals("Organisasi")) {
					dispose();
					searchorganisasi.main();
				}
			}
		});
		btnNext.setBounds(323, 89, 89, 23);
		contentPane.add(btnNext);

		JButton btnNewButton = new JButton("X");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu.main(null);
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setForeground(SystemColor.window);
		btnNewButton.setBackground(new Color(0, 102, 102));
		btnNewButton.setBounds(414, 0, 46, 23);
		contentPane.add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 153));
		panel.setBounds(0, 0, 460, 23);
		contentPane.add(panel);

		JLabel lblSearchBerdasarkan = new JLabel("SEARCH BERDASARKAN");
		lblSearchBerdasarkan.setForeground(Color.WHITE);
		panel.add(lblSearchBerdasarkan);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"F:\\Workspace\\Sejarah\\img\\Konachan.com - 234396 aircraft aqua_eyes aqua_hair bai_yemeng clouds hat hatsune_miku long_hair pantyhose shorts signed sky twintails vocaloid wet.jpg"));
		label.setBounds(0, 21, 460, 114);
		contentPane.add(label);

	}

}
