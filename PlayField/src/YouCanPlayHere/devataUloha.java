package YouCanPlayHere;

import java.util.Scanner;

public class devataUloha {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		float x = Float.parseFloat(scn.next());
		float y = Float.parseFloat(scn.next());
		System.out.println((x - y) / (1 + x * y));
	}

}
