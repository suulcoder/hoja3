/* 
Saul Contreras
Michele Benvenuto

Hoja de Trabajo 3

"""Esta clase escribe un archivo con 3000 datos"""
*/

import java.util.Arrays;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

class Prueba{
	
	public static void main(String[] args) {
		Random rand = new Random();
		String out = "";
		for(int i=0;i<2999;i++){
			out = out + " ";
			int n = rand.nextInt(1000);
			out = out + Integer.toString(n);
		}

		Writer writer = null;

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("datos.txt"), "utf-8"));
		    writer.write(out);
		} catch (IOException ex) {
		    // Report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
		
	}
}
