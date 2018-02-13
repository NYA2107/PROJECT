package Variable;

import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Node.*;
import Rule.*;

public class HasilVariable {
	
	public static void hasilVariable(double intensitas, double penampang, double mukaair, DefaultTableModel model){
		
		LinkedList<Fungsi> hasilVar = new LinkedList<Fungsi>();
		
		double kiriIntensitas = Intensitas.kiriIntensitas(intensitas);
		double tengahIntensitas = Intensitas.tengahIntensitas(intensitas);
		double kananIntensitas = Intensitas.kananIntensitas(intensitas);
		
		double kiriPenampang = Penampang.kiriPenampang(penampang);
		double tengahPenampang = Penampang.tengahPenampang(penampang);
		double kananPenampang = Penampang.kananPenampang(penampang);
		
		double kiriTinggiMukaAir = TinggiMukaAir.kiriTinggiMukaAir(mukaair);
		double tengahTinggiMukaAir = TinggiMukaAir.tengahTinggiMukaAir(mukaair);
		double kananTinggiMukaAir = TinggiMukaAir.kananTinggiMukaAir(mukaair);
		
		//index ke 0 = Intensitas
		//index ke 1 = Tinggi Muka Air
		//index ke 2 = Penampang
		
		hasilVar.add(new Fungsi(kiriIntensitas, tengahIntensitas, kananIntensitas));
		hasilVar.add(new Fungsi(kiriTinggiMukaAir, tengahTinggiMukaAir, kananTinggiMukaAir));
		hasilVar.add(new Fungsi(kiriPenampang, tengahPenampang, kananPenampang));
		
		System.out.println("Hasil Perhitungan Variable");
		System.out.println("                        kiri\ttengah\tkanan");
		System.out.println("Intensitas \t : \t" + hasilVar.get(0).kiri + "\t" + hasilVar.get(0).tengah + "\t" + hasilVar.get(0).kanan);
		System.out.println("Muka Air \t : \t" +hasilVar.get(1).kiri + "\t" + hasilVar.get(1).tengah + "\t" + hasilVar.get(1).kanan);
		System.out.println("Penampang \t : \t" +hasilVar.get(2).kiri + "\t" + hasilVar.get(2).tengah + "\t" + hasilVar.get(2).kanan);
		
		
		Rule.Rules(hasilVar, model);
		
		
		
	}
}
