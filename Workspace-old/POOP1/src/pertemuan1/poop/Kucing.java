package pertemuan1.poop;

public class Kucing {
	
	String nama;
	Kucing (String nama){
		this.nama = nama;
		
	}

	public void makan () {
		System.out.println("Nyam Nyam..." + nama);
	}
	
	public static void main(String[] args) {
		
		String nama = "Manis";
		Kucing Tom = new Kucing(nama);
		Tom.makan();
		
	}

}
