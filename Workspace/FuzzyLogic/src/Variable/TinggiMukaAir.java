package Variable;

public class TinggiMukaAir {
	public static double kiriTinggiMukaAir(double x) {
		double hasil = 0;
		
		if(x >= 50 && x <= 140) {
			hasil =  1;
		}
		else if(x > 140 && x < 160) {
			hasil = (160 - x) / 20;
		}
		else if (x >= 160) {
			hasil = 0;
		}
		
		return hasil;
	}
	
	public static double tengahTinggiMukaAir(double x) {
		double hasil = 0;
		
		if(x >= 140 && x <= 160) {
			hasil = (x - 140) / 20;
		}
		else if(x > 160 && x <=180) {
			hasil = 1;
		}
		else if(x > 180 && x < 200) {
			hasil = (200 - x) / 20;
		}
		else if(x >= 200) {
			hasil = 0;
		}
		
		return hasil;
	}
	
	public static double kananTinggiMukaAir(double x) {
		double hasil = 0;
		
		if(x >= 180 && x < 200) {
			hasil =  (x - 180) / 20;
		}
		else if(x >= 200 && x <= 250) {
			hasil = 1;
		}
		else if (x > 250) {
			hasil = 0;
		}
		
		return hasil;
	}




}
