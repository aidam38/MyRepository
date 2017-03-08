package YouCanPlayHere;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;

public class Filing {
	static Formatter x;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		try {
			PrintWriter writer = new PrintWriter("C:\\Test\\the-file-name.txt", "UTF-8");
			writer.println(scn.nextLine());
			writer.println(scn.nextLine());
			writer.close();
		} catch (IOException e) {
			// do something
		}
		try {
			BufferedReader red = new BufferedReader(new FileReader("C:\\Test\\the-file-name.txt"));
			try {
				System.out.println(red.readLine() + red.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
		}	

	}

}
