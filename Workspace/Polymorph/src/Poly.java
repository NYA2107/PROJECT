class segiEmpat{
	
	public String jenis(){
		return "";
	}
	public int luas(int a, int b) {
		
		return a*b;
	}
	public int keliling(int a, int b) {
		return a*2+b*2;
	}
	
}

class persegi extends segiEmpat{
	public String jenis(){
		return "PERSEGI";
	}
	public int luas(int a, int b) {
		
		return a*a;
	}
	public int keliling(int a, int b) {
		return a*2;
	}
}

class persegiPanjang extends segiEmpat{
	
	public String jenis(){
		return "PERSEGI PANJANG";
	}
}

public class Poly {

	public static void main(String[] args) {	
		
		
	}

}

//ANGKA AWAL
//BEDA
//JUMLAH ANGKA DALAM DERET
//ARITMATIK DAN GEOMETRIK
