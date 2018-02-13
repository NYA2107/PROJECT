import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txtintensitas;
	private JTextField txtpenampang;
	private JTextField txtmukaair;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtintensitas = new JTextField();
		txtintensitas.setBounds(5, 37, 176, 20);
		contentPane.add(txtintensitas);
		
		
		txtpenampang = new JTextField();
		txtpenampang.setBounds(5, 68, 176, 20);
		contentPane.add(txtpenampang);
		
		
		txtmukaair = new JTextField();
		txtmukaair.setBounds(5, 99, 176, 20);
		contentPane.add(txtmukaair);
	
		
		JLabel lblhasil = new JLabel("");
		lblhasil.setBounds(220, 37, 204, 82);
		contentPane.add(lblhasil);
		
		JButton btnGas = new JButton("GAS");
		btnGas.setBounds(5, 130, 176, 23);
		contentPane.add(btnGas);
		
		H h = new H();
		h.masuk(txtintensitas, txtpenampang, txtmukaair);
		
		
	}
	public class H {
		public void masuk(JTextField a, JTextField b, JTextField c) {
			double t = Double.parseDouble(a.getText());
		}
	}
}
