import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Uprava {

	String in = null;
	String out = null;
	String dir = null;

	
	
	Scanner scn;

	public Uprava() {
		System.out.println("ahoj");

		scn = new Scanner(System.in);
		System.out.println(
				"Umístìte prosím soubor do složky C:\\SoutezVProgramovani2017\\2 - Úprava textu\\ \nZadejte název soubou (i s pøíponou): ");
		dir = scn.nextLine();
		in = readFile("C:\\SoutezVProgramovani2017\\2 - Úprava textu\\" + dir);
		System.out.println("\nVìtu: \n\n" + in);
		// Mezera za jednopísmennám slovem
		String[] slova = in.split(" ");
		for (int i = 0; i < slova.length; i++) {
			if (slova[i].length() == 1 && slova[i].charAt(0) > 96 && slova[i].charAt(0) < 123) {
				out = in.replace(" " + slova[i] + " ", " " + slova[i] + "~");
				in = out;
			}
		}

		// Mezera mezi øadovou èíslovkou a slovem zaèínajícím na malé písmeno
		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) == ' ') {
				if (in.charAt(i - 1) == '.' && in.charAt(i - 2) > 47 && in.charAt(i - 2) < 58 && in.charAt(i + 1) > 96
						&& in.charAt(i + 1) < 123) {
					String temp = in.substring(i - 2, i + 2);
					out = in.replace(temp, temp.replace(" ", "~"));
					in = out;
				}
			}
		}
		System.out.println("\njsem upravil na: \n\n" + out);
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
		for (int i = 0; i < 256; i++) {
			System.out.print(i + ": " + (char) i + ", ");
		}
		System.out.println();
		new Uprava();
	}

}
