package code;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import net.miginfocom.swing.MigLayout;
import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

import java.util.*;


public class App extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JLabel lblBiaya, lblTanggal;
	private JTextField ID, Nama, Berat;
	private JComboBox kategori, layanan;
	
	public static Connection con = null;
	public static Statement stm = null;
	public static ResultSet sql = null;
	
	Koneksi k = new Koneksi();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		try {
			con = (Connection) k.koneksiDB();
			stm = (Statement) con.createStatement();
		} catch (SQLException e) {
		
		}
		
		setUndecorated(false);
		panel();
		textfield();
		label();
		combobox();
		tampilkanTable();
		button();
	}
	public void button() {
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				 beratActionPerformed(evt);
				try {
		            String sql = "insert into data_pelanggan values('"+ID.getText()+"','"+Nama.getText()+"','"+kategori.getSelectedItem()+"','"+layanan.getSelectedItem()+"','"+Berat.getText()+"','"+lblTanggal.getText()+"','"+lblBiaya.getText()+"');";
		            java.sql.Connection conn = (java.sql.Connection)k.koneksiDB();
		            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
		            pst.execute();
		            JOptionPane.showMessageDialog(null, "BERHASIL DISIMPAN");

		        }
		        catch (SQLException | HeadlessException e) {
		            JOptionPane.showMessageDialog(null, e);
		        }
		        tampilkanTable();
			}
		});
		btnSubmit.setBounds(532, 11, 210, 23);
		contentPane.add(btnSubmit);
		
		
		
		
		
		
		
		
		
	}
	public void panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 523); //(x,y,width,height)
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//ID
		JPanel panelID = new JPanel();
		panelID.setToolTipText("");
		panelID.setBorder(null);
		panelID.setBounds(10, 11, 168, 20);
		panelID.setBackground(new Color(95, 158, 160));
		contentPane.add(panelID);
		panelID.setLayout(null);
		
		JLabel lblIdCostumer = new JLabel("ID COSTUMER");
		lblIdCostumer.setBounds(81, 0, 77, 20);
		lblIdCostumer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdCostumer.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdCostumer.setForeground(new Color(255, 255, 255));
		panelID.add(lblIdCostumer);
		
		//NAMA
		JPanel panelNama = new JPanel();
		panelNama.setBorder(null);
		panelNama.setBounds(10, 33, 168, 20);
		panelNama.setBackground(new Color(95, 158, 160));
		contentPane.add(panelNama);
		panelNama.setLayout(null);
		
		JLabel lblNama = new JLabel("NAMA");
		lblNama.setBounds(125, 0, 33, 19);
		lblNama.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNama.setForeground(new Color(255, 255, 255));
		panelNama.add(lblNama);
		
		//KATEGORI
		JPanel panelKategori = new JPanel();
		panelKategori.setBorder(null);
		panelKategori.setBounds(10, 55, 168, 20);
		panelKategori.setBackground(new Color(95, 158, 160));
		contentPane.add(panelKategori);
		panelKategori.setLayout(null);
		
		JLabel lblKategori = new JLabel("KATEGORI");
		lblKategori.setBounds(101, 0, 57, 19);
		lblKategori.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKategori.setForeground(new Color(255, 255, 255));
		panelKategori.add(lblKategori);
		
		//LAYANAN
		JPanel panelLayanan = new JPanel();
		panelLayanan.setBorder(null);
		panelLayanan.setBounds(10, 77, 168, 20);
		panelLayanan.setBackground(new Color(95, 158, 160));
		contentPane.add(panelLayanan);
		panelLayanan.setLayout(null);
		
		JLabel lblJenisLayanan = new JLabel("JENIS LAYANAN");
		lblJenisLayanan.setBounds(73, 0, 85, 19);
		lblJenisLayanan.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJenisLayanan.setForeground(new Color(255, 255, 255));
		panelLayanan.add(lblJenisLayanan);
		
		//BERAT
		JPanel panelBerat = new JPanel();
		panelBerat.setBorder(null);
		panelBerat.setBounds(10, 99, 168, 20);
		panelBerat.setBackground(new Color(95, 158, 160));
		contentPane.add(panelBerat);
		panelBerat.setLayout(null);
		
		JLabel lblBerat = new JLabel("BERAT");
		lblBerat.setBounds(122, 0, 36, 19);
		lblBerat.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBerat.setForeground(new Color(255, 255, 255));
		panelBerat.add(lblBerat);
		
		
		//AMBIL
		JPanel panelAmbil = new JPanel();
		panelAmbil.setBounds(850, 331, 119, 111);
		panelAmbil.setBackground(new Color(95, 158, 160));
		contentPane.add(panelAmbil);
		panelAmbil.setLayout(null);
		
		JTextField Ambil = new JTextField();
		Ambil.setBounds(10, 46, 99, 20);
		panelAmbil.add(Ambil);
		
		JButton btnAmbil = new JButton("AMBIL");
		btnAmbil.setBounds(10, 77, 99, 23);
		panelAmbil.add(btnAmbil);
		
		//BIAYA
		lblBiaya = new JLabel("");
		lblBiaya.setForeground(new Color(255, 255, 255));
		lblBiaya.setBounds(532, 52, 210, 23);
		contentPane.add(lblBiaya);
		
		//TANGGAL
		lblTanggal = new JLabel("");
		lblTanggal.setForeground(new Color(255, 255, 255));
		lblTanggal.setBounds(532, 77, 210, 42);
		contentPane.add(lblTanggal);
		
	}
	public void textfield() {
		ID = new JTextField();		
		ID.setForeground(new Color(0, 0, 0));
		ID.setBounds(188, 11, 300, 20);
		contentPane.add(ID);
		
		Nama = new JTextField();
		Nama.setBounds(188, 33, 300, 20);
		contentPane.add(Nama);
		
		Berat = new JTextField();
		Berat.setBounds(188, 99, 225, 20);
		contentPane.add(Berat);
		

	}
	public void label() {
		
	}
	public void combobox() {

		
		
		kategori = new JComboBox<>(); 
		kategori.setBackground(new Color(255, 255, 255));
		kategori.setModel(new DefaultComboBoxModel(new String[] {"Full Laundry", "Hanya Cuci", "Hanya Gosok"}));
		kategori.setBounds(188, 55, 225, 20);
		contentPane.add(kategori);
		
		layanan = new JComboBox<>();
		layanan.setBackground(new Color(255, 255, 255));
		layanan.setModel(new DefaultComboBoxModel(new String[] {"Tidak Mandesak", "Reguler", "2 Hari Jadi"}));
		layanan.setBounds(188, 77, 225, 20);
		contentPane.add(layanan);
	}
	

	
	public void tampilkanTable() {
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 130, 826, 343);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		
		DefaultTableModel model = new DefaultTableModel() {
		
			public boolean isCellEditable(int Row, int Column) {
				return false;
			}
		
		};
		
		model.addColumn("ID");
		model.addColumn("Nama");
		model.addColumn("Kategori");
		model.addColumn("Jenis Layanan");
		model.addColumn("Berat");
		model.addColumn("Tanggal");
		model.addColumn("Biaya");
		
		try{
//            con =(Connection)k.koneksiDB();   
//            stm = con.createStatement();
            sql = stm.executeQuery("select * from data_pelanggan");
            while(sql.next()){
                model.addRow(new Object[]{
                    sql.getString("id_customer"),
                    sql.getString("nama_customer"),
                    sql.getString("kategori"),
                    sql.getString("jenis_layanan"),
                    sql.getString("berat"),
                    sql.getString("tanggal_masuk"),
                    sql.getString("harga")
                });
            }
            table.setModel(DbUtils.resultSetToTableModel(sql));
            table.setModel(model);
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "TABEL TAK BISA DITAMPILKAN");
        }
		
		//table.setModel(model);
		
		
	}
	private void beratActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        Date date = new Date();                                                     // membuat objek date yang merujuk kepada Date.java
        DateFormat DATE = new SimpleDateFormat("dd-MM-YYYY");                       // membuat objek DATE merujuk pada SimpleDateFormat dengan tampilan tanggal-bulan-tahun
        DateFormat TIME = new SimpleDateFormat("HH:mm:ss");                         // membuat objek TIME merujuk pada SimpleDateFormat dengan tampilan jam:menit:detik
        Object jenisKategori = kategori.getSelectedItem();                          // untuk menangkap kategori.getSelectedItem ke objek jenisKategori
        Object jenisLayanan = layanan.getSelectedItem();                            // untuk menangkap layanan.getSelectedItem ke objek jenisLayanan
        String harga;
        String Tanggal = (DATE.format(date));
        String Waktu = (TIME.format(date));
        //String Tanggal = Integer.toString(waktu);
        try{
            int weight = Integer.parseInt(Berat.getText());
            if(jenisKategori.equals("Full Laundry")){
                if(jenisLayanan.equals("Tidak Mendesak")){
                    harga = Integer.toString(weight*2500);
                    lblBiaya.setText("Rp. "+ harga+ ",-");
                    //JOptionPane.showMessageDialog(null, kategori.getSelectedItem());
                }
                else if(jenisLayanan.equals("Reguler")){
                    harga = Integer.toString(weight*3000);
                    lblBiaya.setText("Rp. "+ harga+ ",-");
                }
                else if(jenisLayanan.equals("2 Hari Jadi")){
                    harga = Integer.toString(weight*4000);
                    lblBiaya.setText("Rp. "+ harga+ ",-");
                }
            }
            else if(jenisKategori.equals("Hanya Cuci")){
                if(jenisLayanan.equals("Tidak Mendesak")){
                    harga = Integer.toString(weight*1500);
                    lblBiaya.setText("Rp. "+ harga+ ",-");
                }
                else if(jenisLayanan.equals("Reguler")){
                    harga = Integer.toString(weight*2000);
                    lblBiaya.setText("Rp. "+ harga+ ",-");
                }
                else if(jenisLayanan.equals("2 Hari Jadi")){
                    harga = Integer.toString(weight*2500);
                    lblBiaya.setText("Rp. "+ harga+ ",-");
                }
            }
            else if(jenisKategori.equals("Hanya Gosok")){
                if(jenisLayanan.equals("Tidak Mendesak")){
                    harga = Integer.toString(weight*1800);
                    lblBiaya.setText("Rp. "+ harga+ ",-");
                }
                else if(jenisLayanan.equals("Reguler")){
                    harga = Integer.toString(weight*2300);
                    lblBiaya.setText("Rp. "+ harga+ ",-");
                }
                else if(jenisLayanan.equals("2 Hari Jadi")){
                    harga = Integer.toString(weight*2800);
                    lblBiaya.setText("Rp. "+ harga+ ",-");
                }
            }
            lblTanggal.setText(Tanggal);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "!! SALAH INPUT !!");
        }
    }   
}
