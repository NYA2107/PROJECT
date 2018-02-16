package Aye;


class variable{
	private String ket;
	private int hasil;
	
	public String getKet() {
		return ket;
	}
	public void setKet(String ket) {
		this.ket = ket;
	}
	public int getHasil() {
		return hasil;
	}
	public void setHasil(int hasil) {
		this.hasil = hasil;
	}
	
	
	
}

interface Keterangan{
	void keterangan(String ket);
}

interface Rumus{
	void rumus(int a, int b);
}

class Matematika implements Rumus, Keterangan{

	@Override
	public void keterangan(String ket) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rumus(int a, int b) {
		// TODO Auto-generated method stub
		
	}
	
}

class BangunDatar extends Matematika{
	@Override
	public void keterangan(String ket) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rumus(int a, int b) {
		// TODO Auto-generated method stub
		
	}
}



