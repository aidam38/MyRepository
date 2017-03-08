import static java.lang.Math.*;

public class Fig4_5 {

	public Fig4_5() {
		int p = 0;
		double l;
		int[] triAndSquareNumbers = new int[256];
		int[] whichLItWas = new int[256];
		int[] whichKItWas = new int[256];
		for (int k = 0; k < 100000; k++) {
			l = sqrt(((k * (3*k - 1)) / (double) 2));
			if (round(l) == l && p < 256) {
				triAndSquareNumbers[p] = (int) pow(l, 2);
				whichLItWas[p]=(int)l;
				whichKItWas[p]=k;
				p++;
			}
		}
		for (int i = 0; i < triAndSquareNumbers.length; i++) {
			if (triAndSquareNumbers[i] != 0)
				System.out.println(triAndSquareNumbers[i] + "; " + 
						whichKItWas[i]+"th square number and " + 
							whichLItWas[i] + "th pentagonal number.");
		}
	}

	public static void main(String[] args) {
		new Fig4_5();
	}

}
