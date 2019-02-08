import java.io.*;
import java.util.Scanner;
public class RadixSort {
    public static void main(String[] args) throws FileNotFoundException {
        Sorts radixSort = new Sorts();
        int [] arrayToOrder = new int[3000];

        File f = new File("datos.txt");

        Scanner scan = new Scanner(f);
        int counter = 0;
        while (scan.hasNextLine()){
            String numberToAdd= scan.next();
            try{
                int currentNumber =Integer.parseInt(numberToAdd);
                arrayToOrder[counter]=currentNumber;
                counter+=1;
            }catch (NumberFormatException nfe){
                System.out.println("Este Archivo tiene algo que no es un numero");
            }
        }

        radixSort.radixSort(arrayToOrder,arrayToOrder.length);

        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("datos.txt"), "utf-8"));
            for (int i=0; i<arrayToOrder.length;i++){
                writer.write(arrayToOrder[i]+" ");
            }
        } catch (IOException ex) {
            // Report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }
}
