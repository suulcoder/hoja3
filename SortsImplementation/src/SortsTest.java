import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortsTest {

    Sorts prueba = new Sorts();
    int[] array = {0,3,5,2,4,1};
    //
    //
    //
    //


    @org.junit.jupiter.api.Test
    void gnomeSort() {
        prueba.gnomeSort(array);
        System.out.println(Arrays.toString(array));
        assertEquals("[0, 1, 2, 3, 4, 5]", Arrays.toString(array));
    }

    @org.junit.jupiter.api.Test
    void mergeSort() {
        prueba.mergeSort(array,array.length);//segundo parametro longitud del array.
        assertEquals("[0, 1, 2, 3, 4, 5]", Arrays.toString(array));
    }


    @org.junit.jupiter.api.Test
    void quickSort() {
        prueba.quickSort(array,0,(array.length-1));//setudno parametro es el primer indice, y el tercero el ultimo indice
        assertEquals("[0, 1, 2, 3, 4, 5]", Arrays.toString(array));
    }

    @org.junit.jupiter.api.Test
    void radixSort() {
        prueba.radixSort(array,array.length);//segundo parametro longitud del array
        assertEquals("[0, 1, 2, 3, 4, 5]", Arrays.toString(array));
    }

    @org.junit.jupiter.api.Test
    void shellSort() {
        prueba.shellSort(array);
        assertEquals("[0, 1, 2, 3, 4, 5]", Arrays.toString(array));
    }
}