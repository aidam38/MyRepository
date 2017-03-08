import static java.lang.Math.*;

public class Fig3_4 {

	public Fig3_4() {
		int p = 0;
		double l;
		int[] triAndSquareNumbers = new int[256];
		int[] whichLItWas = new int[256];
		int[] whichKItWas = new int[256];
		for (int k = 0; k < 100000; k++) {
			l = sqrt(((k * (k + 1)) / (double) 2));
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
						whichKItWas[i]+"th triangular number and " + 
							whichLItWas[i] + "th square number.");
		}
	}

	public static void main(String[] args) {
		new Fig3_4();
	}

}
