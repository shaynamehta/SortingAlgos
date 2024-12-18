package defaultt;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 5000; 
		int[] data = new int[n];
		
		for (int i = 0 ; i < data.length ; i++) {
			
			data[i] = (int)(Math.random()*(10065));
		}

		//print before sorting
		System.out.println(Arrays.toString(data));
		long start = System.nanoTime();
		bubbleSort(data);
		System.out.println("Total time to sort with Bubble Sort: " + (System.nanoTime() - start));
		long starttime = System.nanoTime();
		insertionSort(data);
		System.out.println("Total time to sort with Insertion Sort: " + (System.nanoTime() - starttime));
		long timer = System.nanoTime();
		selectionSort(data);
		System.out.println("Total time to sort with Selection Sort: " + (System.nanoTime() - timer));
		System.out.println(Arrays.toString(data));
	}
	
	
	public static void bubbleSort(int[] data) { //unoptimized
		
		
		
		//write a piece of code that will check consecutive pairs in data
		//and swaps the value if they're out of order
		boolean swapped = true;
		for (int pass = 0 ; pass < data.length && swapped ; pass++) {
		
			swapped = false;
			//this is one pass
			for (int i = 0; i < data.length -1 ; i++) {
			
				if (data[i] >= data[i+1]) {
				
					int temp = data[i];
					data[i] = data[i+1];
					data[i+1] = temp;
					swapped = true;
				}
				
					
			}
		
		}
		
	}
	
	public static void selectionSort(int[] data) {
		for (int j = 0; j < data.length - 1; j++)
        {
            int minIndex = j;
            for (int k = j + 1; k < data.length; k++)
            {
                if (data[k] < data[minIndex])
                {
                    minIndex = k;
                }
            }
            int temp = data[j];
            data[j] = data[minIndex];
            data[minIndex] = temp;
        }
		
	}
	
	public static void insertionSort(int[] elements)
    {
        for (int j = 1; j < elements.length; j++)
        {
            int temp = elements[j];
            int possibleIndex = j;
            while (possibleIndex > 0 && temp < elements[possibleIndex - 1])
            {
                elements[possibleIndex] = elements[possibleIndex - 1];
                possibleIndex--;
            }
            elements[possibleIndex] = temp;
        }
    }
}
