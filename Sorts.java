/* 
Saul Contreras
Michele Benvenuto

Hoja de Trabajo 3

"""Esta clase incluye todos los metodos sorts investigados, cada uno 
con su respectiva referencia"""*/


/*
	A continuación se muestra la implementación de cada metodo
		//prueba.gnomeSort(array)
		//prueba.mergeSort(array,array.length);//segundo parametro longitud del array.
		//prueba.quickSort(array,0,(array.length-1));//setudno parametro es el primer indice, y el tercero el ultimo indice
		//prueba.radixSort(array,array.length);//segundo parametro longitud del array
		//prueba.shellSort(array);

	Esta es la manera de mostrarlo al usuario
		//System.out.println(Arrays.toString(array));

*/
import java.util.Arrays;
class Sorts{

	/*-- Gnome Sort, tomado de Algorithm Implementation/Sorting/Gnome sort https://en.wikibooks.org/wiki/Algorithm_Implementation/Sorting/Gnome_sort --*/
	public void gnomeSort( int[] theArray ) { 
	      for ( int index = 1; index < theArray.length; ) { 
	         if ( theArray[index - 1] <= theArray[index] ) { 
	            ++index; 
	         } else { 
	            int tempVal = theArray[index]; 
	            theArray[index] = theArray[index - 1]; 
	            theArray[index - 1] = tempVal; 
	            --index; 
	            if ( index == 0 ) { 
	               index = 1; 
	            }           
	         } 
	      } 
	    }


	 /*Obtendio de Merge Sort in Java https://www.baeldung.com/java-merge-sort*/
	 public static void mergeSort(int[] a, int n) {
	    if (n < 2) {
	        return;
	    }
	    int mid = n / 2;
	    int[] l = new int[mid];
	    int[] r = new int[n - mid];
	 
	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);
	 
	    merge(a, l, r, mid, n - mid);
	}

	 /*Obtendio de Merge Sort in Java https://www.baeldung.com/java-merge-sort*/
	public static void merge(
		
		int[] a, int[] l, int[] r, int left, int right) {
	  
	    int i = 0, j = 0, k = 0;
	    while (i < left && j < right) {
	        if (l[i] <= r[j]) {
	            a[k++] = l[i++];
	        }
	        else {
	            a[k++] = r[j++];
	        }
	    }
	    while (i < left) {
	        a[k++] = l[i++];
	    }
	    while (j < right) {
	        a[k++] = r[j++];
		}
	}

	/*tomado de Quicksort Algorithm Implementation in Java https://www.baeldung.com/java-quicksort*/
	public void quickSort(int arr[], int begin, int end) {
		if (begin < end) {
		    int partitionIndex = partition(arr, begin, end);

		    quickSort(arr, begin, partitionIndex-1);
		    quickSort(arr, partitionIndex+1, end);
		}
	}

	/*tomado de Quicksort Algorithm Implementation in Java https://www.baeldung.com/java-quicksort*/
	private int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);
	 
	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;
	 
	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }
	 
	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = swapTemp;
	    return i+1;
	}

	/*tomado de Radix Sort https://www.javatpoint.com/radix-sort*/
	private static int largest(int a[]){     
        int larger=a[0], i;   
        for(i=1;i<10;i++)  
        {  
            if(a[i]>larger)  
            larger = a[i];  
        }  
        return larger;  
    }  

    /*Tomado de Java Program for Radix Sort https://www.geeksforgeeks.org/java-program-for-radix-sort/*/
    private static int getMax(int arr[], int n){ 
        int mx = arr[0]; 
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
                mx = arr[i]; 
        return mx; 
    } 
  

    /*Tomado de Java Program for Radix Sort https://www.geeksforgeeks.org/java-program-for-radix-sort/*/
    private static void countSort(int arr[], int n, int exp){ 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            count[ (arr[i]/exp)%10 ]++; 
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
            count[ (arr[i]/exp)%10 ]--; 
        } 
  
        // Copy the output array to arr[], so that arr[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
    } 
  
    
    /*Tomado de Java Program for Radix Sort https://www.geeksforgeeks.org/java-program-for-radix-sort/*/
    public static void radixSort(int arr[], int n){ 
        // Find the maximum number to know number of digits 
        int m = getMax(arr, n); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; m/exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 

     public static void shellSort(int A[]){
	   int salto, aux, i;
	   boolean cambios;
	   for(salto=A.length/2; salto!=0; salto/=2){
           cambios=true;
           while(cambios){ // Mientras se intercambie algún elemento
               cambios=false;
               for(i=salto; i< A.length; i++){// se da una pasada
                   if(A[i-salto]>A[i]){ // y si están desordenados
                     aux=A[i]; // se reordenan
                     A[i]=A[i-salto];
                     A[i-salto]=aux;
                     cambios=true; // y se marca como cambio.
                   }
                }
            }
		}
	}
}