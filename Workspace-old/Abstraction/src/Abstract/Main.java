package Abstract;

interface spesifikasi{
	void setWarna(String warna);
	void getJenis(String jenis);
}

abstract class bunga implements spesifikasi{

	public int harga;
	abstract int setHarga(int tangkai);
	
	public void bayar() {
		System.out.println("Terimakasih sudah membeli :) ");
	}
	
}

class mawar extends bunga{
	mawar(int tangkai, String warna){
		super.harga = 2000;
	}
	
	@Override
	public void setWarna(String warna) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getJenis(String jenis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	int setHarga(int tangkai) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
