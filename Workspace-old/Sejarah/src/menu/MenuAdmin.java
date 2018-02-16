package menu;

import java.awt.Color;
import java.awt.EventQueue;
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

import delete.delete;
import input.inputera;
import input.inputkeputusan;
import input.inputorganisasi;
import input.inputperistiwa;
import input.inputtempat;
import input.inputtokoh;
import input.penghubungprimer;
import update.updateera;
import update.updatekeputusan;
import update.updateorganisasi;
import update.updateperistiwa;
import update.updatetempat;
import update.updatetokoh;

public class MenuAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MenuAdmin frame = new MenuAdmin();
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
	public MenuAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboInput = new JComboBox();
		comboInput.setModel(new DefaultComboBoxModel(new String[] { "Tokoh", "Peristiwa", "Tempat Bersejarah",
				"Organisasi", "Era", "Keputusan", "Relasi" }));
		comboInput.setBounds(21, 60, 287, 20);
		contentPane.add(comboInput);

		JButton btnInput = new JButton("INPUT");
		btnInput.setForeground(Color.WHITE);
		btnInput.setBackground(new Color(0, 102, 153));
		btnInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (comboInput.getSelectedItem().equals("Tokoh")) {
					dispose();
					inputtokoh.main();
				} else if (comboInput.getSelectedItem().equals("Peristiwa")) {
					dispose();
					inputperistiwa.main();
				} else if (comboInput.getSelectedItem().equals("Tempat Bersejarah")) {
					dispose();
					inputtempat.main();
				} else if (comboInput.getSelectedItem().equals("Organisasi")) {
					dispose();
					inputorganisasi.main();
				} else if (comboInput.getSelectedItem().equals("Era")) {
					dispose();
					inputera.main();
				} else if (comboInput.getSelectedItem().equals("Keputusan")) {
					dispose();
					inputkeputusan.main();
				} else if (comboInput.getSelectedItem().equals("Relasi")) {
					dispose();
					penghubungprimer.main();
				}
			}
		});
		btnInput.setBounds(21, 91, 89, 23);
		contentPane.add(btnInput);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(0, 102, 153));
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboInput.getSelectedItem().equals("Tokoh")) {
					dispose();
					updatetokoh.main();
				} else if (comboInput.getSelectedItem().equals("Peristiwa")) {
					dispose();
					updateperistiwa.main();
				} else if (comboInput.getSelectedItem().equals("Tempat Bersejarah")) {
					dispose();
					updatetempat.main();
				} else if (comboInput.getSelectedItem().equals("Organisasi")) {
					dispose();
					updateorganisasi.main();
				} else if (comboInput.getSelectedItem().equals("Era")) {
					dispose();
					updateera.main();
				} else if (comboInput.getSelectedItem().equals("Keputusan")) {
					dispose();
					updatekeputusan.main();
				} else if (comboInput.getSelectedItem().equals("Relasi")) {
					dispose();
					penghubungprimer.main();
				}

			}
		});
		btnUpdate.setBounds(120, 91, 89, 23);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(new Color(0, 102, 153));
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				delete.main();
			}
		});
		btnDelete.setBounds(219, 91, 89, 23);
		contentPane.add(btnDelete);

		JButton btnX = new JButton("X");
		btnX.setForeground(Color.WHITE);
		btnX.setBackground(new Color(0, 102, 102));
		btnX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu.main(null);
			}
		});
		btnX.setBounds(279, 0, 50, 23);
		contentPane.add(btnX);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"F:\\Workspace\\Sejarah\\img\\Konachan.com - 234396 aircraft aqua_eyes aqua_hair bai_yemeng clouds hat hatsune_miku long_hair pantyhose shorts signed sky twintails vocaloid wet.jpg"));
		label.setBounds(0, 0, 329, 152);
		contentPane.add(label);
	}

}
