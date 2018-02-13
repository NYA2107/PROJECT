//class ini digunakan sebagai wadah dari data yang akan dimasukkan

public class Node {
	private int a;//konsep encapsulasi menggunakan private acces modifier
	private int b;
	
	//dibawah ini merupakan setter getter dari kedua variabel diatas
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}

	//method untuk memasukkan data ke dalam parameter agar lebih mudah
	public Node(int a, int b) {
		this.a = a;
		this.b = b;
	}
}
