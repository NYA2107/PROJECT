package Variable;


public class Penampang {
	
	public static double kiriPenampang(double x) {
		double hasil = 0;
		
		if(x >= 1 && x <= 15) {
			hasil =  1;
		}
		else if(x > 15 && x < 20) {
			hasil = (20 - x) / 5;
		}
		else if(x >= 20) {
			hasil = 0;
		}
		
		return hasil;
	}
	
	public static double tengahPenampang(double x) {
		double hasil = 0;
		
		if(x >= 15 && x <= 20) {
			hasil = (x - 15) / 5;
		}
		else if(x > 20 && x <=35) {
			hasil = 1;
		}
		else if(x > 35 && x < 40) {
			hasil = (40 - x) / 5;
		}
		else if(x >= 40) {
			hasil = 0;
		}
		
		return hasil;
	}
	
	public static double kananPenampang(double x) {
		double hasil = 0;
		
		if(x >= 35 && x < 40) {
			hasil =  (x - 35) / 5;
		}
		else if(x >= 40 && x < 55) {
			hasil = 1;
		}
		else if(x >= 5) {
			hasil = 0;
		}
		
		return hasil;
	}
}
