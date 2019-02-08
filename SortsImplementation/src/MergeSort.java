import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) throws FileNotFoundException {
        Sorts mergeSort = new Sorts();
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
        mergeSort.mergeSort(arrayToOrder,arrayToOrder.length);
        for (int i=0; i<arrayToOrder.length;i++){
            System.out.println(arrayToOrder[i]);
        }
    }
}
