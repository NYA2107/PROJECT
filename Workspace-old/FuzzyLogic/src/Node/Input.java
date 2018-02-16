package Node;

public class Input {
	public double intensitas;
	public double mukaAir;
	public double penampang;
	public double alpha;
	public double z;
	
	public Input(double intensitas, double mukaAir, double penampang ) {
		this.intensitas = intensitas;
		this.mukaAir = mukaAir;
		this.penampang = penampang;
	}
	public Input(double intensitas, double mukaAir, double penampang, double alpha) {
		this.intensitas = intensitas;
		this.mukaAir = mukaAir;
		this.penampang = penampang;
		this.alpha = alpha;
	}
	public Input(double intensitas, double mukaAir, double penampang, double alpha, double z) {
		this.intensitas = intensitas;
		this.mukaAir = mukaAir;
		this.penampang = penampang;
		this.alpha = alpha;
		this.z = z;
	}

}
