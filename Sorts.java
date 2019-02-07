/* 
Saul Contreras
Michele Benvenuto

Hoja de Trabajo 3

"""Esta clase incluye todos los metodos sorts investigados, cada uno 
con su respectiva referencia"""*/

class Sorts{

	/*-- Gnome Sort, tomado de Algorithm Implementation/Sorting/Gnome sort https://en.wikibooks.org/wiki/Algorithm_Implementation/Sorting/Gnome_sort --*/
	public static int[] gnomeSort( int[] theArray ) { 
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
	      return theArray;
	   }

	 /*Merge Sort, tomado de Merge Sort in Java  https://www.baeldung.com/java-merge-sort*/
	public static int[] mergeSort(int[] a) {
		n = a.length;
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

	    int left = mid;
	    int right = n-mid;
	 
	  	int i=0,j=0,k=0;
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
	 	return a;

	}

}