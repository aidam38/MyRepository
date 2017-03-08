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
		// Na�ten� ze souburu a ulo�en� do ��seln�ho pole
		scn = new Scanner(System.in);
		System.out.println(
				"Um�st�te pros�m soubor do slo�ky C:\\SoutezVProgramovani2017\\3 - V�zna�n� ��sla\\ \nZadejte n�zev soubou (i s p��ponou): ");

		dir = scn.nextLine();

		in = readFile("C:\\SoutezVProgramovani2017\\3 - V�zna�n� ��sla\\" + dir).split(" ");

		pole = new int[in.length];
		poleSNulami = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			pole[i] = Integer.parseInt(in[i]);
			poleSNulami[i] = Integer.parseInt(in[i]);
		}

		// Nahrazen� v�ech duplicitn�ch ��sel nulami
		// a ulo�en� do pole poleSNulami
		for (int i = 0; i < pole.length; i++) {
			for (int j = i + 1; j < pole.length; j++) {
				if (poleSNulami[i] == poleSNulami[j]) {
					poleSNulami[j] = 0;
				}
			}
		}
		// Vytvo�en� pole bez duplicit i nul
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

		// Vyps�n� pole bez duplicit
		System.out.println("\nZde m��ete vid�t pole ��sel bez duplicit: ");
		for (int i = 0; i < poleBezDupl.length; i++) {
			System.out.print(poleBezDupl[i] + " ");
		}

		// a)

		// Se�azen� pole bez duplicit podle velikost od nejv�t��ho po nejmen��
		// pomoc� BUBBLE ALGORITMU
		for (int i = 0; i < poleBezDupl.length - 1; i++) {
			int a = poleBezDupl[i];
			int b = poleBezDupl[i + 1];

			if (a < b) {
				poleBezDupl[i] = b;
				poleBezDupl[i + 1] = a;
				i = -1;
			}
		}

		// Vyps�n� pole bez duplicit se�azen�ho podle velikosti
		System.out.println("\nPole bez duplicit se�azn� podle velikosti: ");
		for (int i = 0; i < poleBezDupl.length; i++) {
			System.out.print(poleBezDupl[i] + " ");
		}

		tretiNejvetsiCislo = poleBezDupl[2];
		System.out.println("\n\n ad a) T�et� nejv�t�� r�zn� ��slo je : " + tretiNejvetsiCislo);

		// b)
		boolean jeTam = false;
		for (int i = 0; i < poleBezDupl.length; i++) {
			if (poleBezDupl[i] == 2) {
				System.out.println(
						"\n ad b) Sud� prvo��slo bez duplicit existuje jen jedin� a\n mezi t�mito v�zna�n�mi ��sly se nach�z� a je to 2.");
				jeTam = true;
				break;
			}
		}
		if (!jeTam)
			System.out.println("\n ad b) ��dn� sud� prvo��slo se v t�chto v�zna�n�ch ��slech nenach�z�.");

		// c)

		// Vytvo�en� poleRozdilu
		poleRozdilu = new int[pole.length - 1];
		poleRozdiluPodleVel = new int[pole.length - 1];

		System.out.println("\nPole rozd�l�: ");
		for (int i = 0; i < poleRozdilu.length; i++) {
			poleRozdilu[i] = Math.abs(pole[i] - pole[i + 1]);
			poleRozdiluPodleVel[i] = Math.abs(pole[i] - pole[i + 1]);

			System.out.print(poleRozdilu[i] + " ");
		}

		// Se�azen� poleRozdilu podle velikosti od nejmen��ho po nejv�t�t��
		// pomoc� BUBBLE ALGORITMU

		for (int i = poleRozdiluPodleVel.length - 2; i >= 0; i--) {
			int a = poleRozdiluPodleVel[i];
			int b = poleRozdiluPodleVel[i + 1];

			if (a > b) {
				poleRozdiluPodleVel[i] = b;
				poleRozdiluPodleVel[i + 1] = a;
				i = poleRozdiluPodleVel.length - 1;
			}
		}
		System.out.println("\nPole rozd�l� se�azen�ch podle velikosti: ");
		for (int i = 0; i < poleRozdiluPodleVel.length; i++) {
			System.out.print(poleRozdiluPodleVel[i] + " ");
		}
		// Hled�n� kde se nejmen�� rozd�l vyskytl
		for (int i = 0; i < poleRozdilu.length; i++) {
			if (poleRozdilu[i] == poleRozdiluPodleVel[0]) {
				System.out.println(
						"\n\n ad c) Dv� nejbli��� po sob� jdouc� ��sla jsou: " + pole[i] + ", " + +pole[i + 1]);
			}
		}
	}

	// Metoda pro na�ten� z textov�ho souboru
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
