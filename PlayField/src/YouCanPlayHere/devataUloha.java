package YouCanPlayHere;

import java.util.Scanner;
import static java.lang.Math.*;

public class devataUloha {
	static Scanner scn = new Scanner(System.in);
	static double x, y;

	public static void main(String[] args) {
		// x = Float.parseFloat(scn.next());
		// y = Float.parseFloat(scn.next());
		x = sqrt(6);
		y = 1.02062;
		double number = (x - y) / (1 + x * y);
		double number2 = (sqrt(6) / 6);
		System.out.println(number + "     " + (number < number2));
	}

}
