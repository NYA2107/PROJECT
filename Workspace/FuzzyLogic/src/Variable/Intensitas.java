package Variable;


public class Intensitas {
	
	
	
	public static double kiriIntensitas(double x) {
		double hasil = 0;
		
		if(x >= 1 && x <= 5) {
			hasil =  1;
		}
		else if(x > 5 && x < 15) {
			hasil = (15 - x) / 10;
		}
		else if(x >= 15 ) {
			hasil = 0;
		}
		
		return hasil;
	}
	
	public static double tengahIntensitas(double x) {
		double hasil = 0;
		
		if(x >= 5 && x <= 15) {
			hasil = (x - 5) / 10;
		}
		else if(x > 15 && x <=20) {
			hasil = 1;
		}
		else if(x > 20 && x < 40) {
			hasil = (40 - x) / 20;
		}
		else if( x >= 40) {
			hasil = 0;
		}
		
		
		return hasil;
	}
	
	public static double kananIntensitas(double x) {
		double hasil = 0;
		
		if(x >= 20 && x < 40) {
			hasil =  (x - 20) / 20;
		}
		else if(x >= 40 && x <= 50) {
			hasil = 1;
		}
		else if(x > 50) {
			hasil = 0;
		}
		
		return hasil;
	}
}
