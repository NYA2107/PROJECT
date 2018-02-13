package Encapsulation;


class Mahasiswa {
	private String jurusan;
	private String makul;
	private String nama;
	private String nim;
	
	// Setter
	public void setJurusan(String newValue) {
		jurusan = newValue;
	}
	
	public void setMakul(String newValue) {
		makul = newValue;
	}
	
	public void setNama(String newValue) {
		nama = newValue;
	}
	
	public void setNim(String newValue) {
		nim = newValue;
	}
	
	//Getter
	public String getJurusan() {
		return jurusan;
	}
	
	public String getMakul() {
		return makul;
	}
	
	public String getNama() {
		return nama;
	}
	
	public String getNim() {
		return nim;
	}
	
}


public class Encapsulation {

	public static void main(String[] args) {
		Mahasiswa mhs = new Mahasiswa();
		
			mhs.setJurusan("Informatika");
			mhs.setMakul("PBO");
			mhs.setNama("Keira Kagamire");
			mhs.setNim("M0516027");
		
			System.out.println(mhs.getJurusan()+"\n"+
					mhs.getMakul()+"\n"+
					mhs.getNama()+"\n"+
					mhs.getNim()+"\n");
	}

}
