import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Bunky {

	Scanner scn;
	String dir;

	String[] in;
	int[] bunky;
	int out = 0;

	public Bunky() {
		// Na�ten� ze souburu a ulo�en� do ��seln�ho pole
		scn = new Scanner(System.in);
		System.out.println(
				"Um�st�te pros�m soubor do slo�ky C:\\SoutezVProgramovani2017\\3 - V�zna�n� ��sla\\ \nZadejte n�zev soubou (i s p��ponou): ");
 
		System.out.println("ahoj");
		dir = scn.nextLine();

		in = readFile("C:\\SoutezVProgramovani2017\\4 - Bun��n� genealogie\\" + dir).split(" ");
		bunky = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			//TODO: Check for right format of the file
			bunky[i] = Integer.parseInt(in[i]);
		}
		

		// Postupn� p�i��t�n� po�tu bun�k
		for (int i = 0; i < bunky.length; i++) {
			for (int j = 0; j <= bunky[i]; j++) {
				out += Math.pow(2, j);
			}
		}
		System.out.println("Po�et v�choz�ch + po�et v�ech bun�k vznikl� d�len�m je " + out);
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
		new Bunky();
	}

}
