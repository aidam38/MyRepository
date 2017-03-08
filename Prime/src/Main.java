
public class Main {
	public static void main(String[] args) {
		int number = 1000000001;
		float d = 2;
		int f[] = new int[256];
		int i = 0;
		float div;
		while (d <= (number / (float) 2) + 1) {
			div = number / d;
			if (Math.round(div) == div) {
				f[i] = (int) d;
				i++;
				if (isPrime((int) div)) {
					f[i] = (int) div;
					break;
				} else
					number = (int) div;
				d = 1;

			}
			d++;
		}

		for (int j = 0; j < f.length; j++) {
			if (f[j] != 0)
				System.out.println(f[j]);
		}
	}

	public static boolean isPrime(int n) {
		float d = 2;
		while (d <= n / (float) 2) {
			float div = n / d;
			d++;
			if (Math.round(div) == div) {
				return false;
			}
		}
		return true;
	}
}
