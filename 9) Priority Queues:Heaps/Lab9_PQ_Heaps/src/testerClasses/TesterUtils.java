package testerClasses;

import priorityQueueInterfaces.PriorityQueue;

public class TesterUtils {
	public static <E> void displayArray(String msg, E[] arr) {
		System.out.println("\n"+msg); 
		for (int i=0; i<arr.length; i++)
			System.out.println("arr[" + i + "] = " + arr[i]); 
		
	}

	public  static <E> void what/*PriorityQueueSort*/(E[] arr, PriorityQueue<E, E> pq) {
		for (E n : arr)
			pq.insert(n, null); 

        // MISSING LINES HERE --- JUST 2 LINES
		//according to pseudocode we just add to the array the elms of the PQ in order 
		for (int i = 0; i < arr.length; i++) 
			arr[i] = pq.removeMin().getKey();
		
	}

}
