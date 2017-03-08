import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cisla {

	int tretiNejvetsiCislo;

	Scanner scn;
	String dir;

	String[] in;
	int[] pole, poleSNulami, poleBezDupl, poleRozdilu, poleRozdiluPodleVel;

	public Cisla() {
		// Naètení ze souburu a uložení do èíselného pole
		scn = new Scanner(System.in);
		System.out.println(
				"Umístìte prosím soubor do složky C:\\SoutezVProgramovani2017\\3 - Význaèná èísla\\ \nZadejte název soubou (i s pøíponou): ");

		dir = scn.nextLine();

		in = readFile("C:\\SoutezVProgramovani2017\\3 - Význaèná èísla\\" + dir).split(" ");

		pole = new int[in.length];
		poleSNulami = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			pole[i] = Integer.parseInt(in[i]);
			poleSNulami[i] = Integer.parseInt(in[i]);
		}

		// Nahrazení všech duplicitních èísel nulami
		// a uložení do pole poleSNulami
		for (int i = 0; i < pole.length; i++) {
			for (int j = i + 1; j < pole.length; j++) {
				if (poleSNulami[i] == poleSNulami[j]) {
					poleSNulami[j] = 0;
				}
			}
		}
		// Vytvoøení pole bez duplicit i nul
		int velikostBezNul = 0;
		for (int i = 0; i < poleSNulami.length; i++) {
			if (poleSNulami[i] != 0)
				velikostBezNul++;
		}
		poleBezDupl = new int[velikostBezNul];
		int j = 0;
		for (int i = 0; i < poleSNulami.length; i++) {
			if (poleSNulami[i] != 0) {
				poleBezDupl[j] = poleSNulami[i];
				j++;
			}
		}

		// Vypsání pole bez duplicit
		System.out.println("\nZde mùžete vidìt pole èísel bez duplicit: ");
		for (int i = 0; i < poleBezDupl.length; i++) {
			System.out.print(poleBezDupl[i] + " ");
		}

		// a)

		// Seøazení pole bez duplicit podle velikost od nejvìtšího po nejmenší
		// pomocí BUBBLE ALGORITMU
		for (int i = 0; i < poleBezDupl.length - 1; i++) {
			int a = poleBezDupl[i];
			int b = poleBezDupl[i + 1];

			if (a < b) {
				poleBezDupl[i] = b;
				poleBezDupl[i + 1] = a;
				i = -1;
			}
		}

		// Vypsání pole bez duplicit seøazeného podle velikosti
		System.out.println("\nPole bez duplicit seøazné podle velikosti: ");
		for (int i = 0; i < poleBezDupl.length; i++) {
			System.out.print(poleBezDupl[i] + " ");
		}

		tretiNejvetsiCislo = poleBezDupl[2];
		System.out.println("\n\n ad a) Tøetí nejvìtší rùzné èíslo je : " + tretiNejvetsiCislo);

		// b)
		boolean jeTam = false;
		for (int i = 0; i < poleBezDupl.length; i++) {
			if (poleBezDupl[i] == 2) {
				System.out.println(
						"\n ad b) Sudé prvoèíslo bez duplicit existuje jen jediné a\n mezi tìmito význaènými èísly se nachází a je to 2.");
				jeTam = true;
				break;
			}
		}
		if (!jeTam)
			System.out.println("\n ad b) Žádné sudé prvoèíslo se v tìchto význaèných èíslech nenachází.");

		// c)

		// Vytvoøení poleRozdilu
		poleRozdilu = new int[pole.length - 1];
		poleRozdiluPodleVel = new int[pole.length - 1];

		System.out.println("\nPole rozdílù: ");
		for (int i = 0; i < poleRozdilu.length; i++) {
			poleRozdilu[i] = Math.abs(pole[i] - pole[i + 1]);
			poleRozdiluPodleVel[i] = Math.abs(pole[i] - pole[i + 1]);

			System.out.print(poleRozdilu[i] + " ");
		}

		// Seøazení poleRozdilu podle velikosti od nejmenšího po nejvìtìtší
		// pomocí BUBBLE ALGORITMU

		for (int i = poleRozdiluPodleVel.length - 2; i >= 0; i--) {
			int a = poleRozdiluPodleVel[i];
			int b = poleRozdiluPodleVel[i + 1];

			if (a > b) {
				poleRozdiluPodleVel[i] = b;
				poleRozdiluPodleVel[i + 1] = a;
				i = poleRozdiluPodleVel.length - 1;
			}
		}
		System.out.println("\nPole rozdílù seøazených podle velikosti: ");
		for (int i = 0; i < poleRozdiluPodleVel.length; i++) {
			System.out.print(poleRozdiluPodleVel[i] + " ");
		}
		// Hledání kde se nejmenší rozdíl vyskytl
		for (int i = 0; i < poleRozdilu.length; i++) {
			if (poleRozdilu[i] == poleRozdiluPodleVel[0]) {
				System.out.println(
						"\n\n ad c) Dvì nejbližší po sobì jdoucí èísla jsou: " + pole[i] + ", " + +pole[i + 1]);
			}
		}
	}

	// Metoda pro naètení z textového souboru
	BufferedReader reader;

	public String readFile(String dir) {
		String str = "";
		try {
			reader = new BufferedReader(new FileReader(new File(dir)));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			String nextLine = reader.readLine();
			while (nextLine != null) {
				str += nextLine.trim();
				nextLine = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static void main(String[] args) {
		new Cisla();
	}

}
