import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class GnomeSort {
    public static void main(String[] args) throws FileNotFoundException {
        Sorts gnomeSort = new Sorts();
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
        gnomeSort.gnomeSort(arrayToOrder);
        for (int i=0; i<arrayToOrder.length;i++){
            System.out.println(arrayToOrder[i]);
        }
    }
}
