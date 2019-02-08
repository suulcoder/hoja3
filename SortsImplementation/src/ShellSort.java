import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ShellSort {
    public static void main(String[] args) throws FileNotFoundException {
        Sorts shellSort = new Sorts();
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
        shellSort.shellSort(arrayToOrder);
        for (int i=0; i<arrayToOrder.length;i++){
            System.out.println(arrayToOrder[i]);
        }
    }
}
