package Rule;

public class Z {

	public static double Level3(double a) {

		return 0.4 - (a * 0.2);

	}

	public static double Level2(double a) {

		return (0.7 - (a * 0.2)) + ((a * 0.2) + 0.2);

	}

	public static double Level1(double a) {
		return (a * 0.2) + 0.5;

	}

}
