package zad1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Datoteka {
	String fName;
	FileInputStream in;
	FileOutputStream out;

	public Datoteka (String fName) {
		this.fName = fName;
	}

	public void zapishi(String text) throws IOException {
		out = new FileOutputStream(fName);
		for (int i = 0; i < text.length(); i++) {
			out.write(text.charAt(i));
		}
	}
	
	public void prochitaj () throws IOException {
		in = new FileInputStream(fName);
		int c;
		while ((c = in.read()) != -1) {
			System.out.print((char) c);
		}
		in.close();
	}
}