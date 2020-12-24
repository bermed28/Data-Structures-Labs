package ciic4020.lab5.strategiesClasses;

import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSort<E> extends AbstractSortingStrategy<E> {

	public SelectionSort(Comparator<E> cmp) { 
		super("SelectionSort", cmp); 
	}
	
	@Override
	public void sortList(ArrayList<E> dataSet) {
		int n = dataSet.size(); 
		/* TODO ADD CODE HERE FOLLOWING PSEUDOCODE
		 * 
		 * Use a simple for loop to find the smallest value in the desired range
		 * 
		 * To compare two values in dataSet, use something like:
		 *    if (cmp.compare(dataSet.get(j), dataSet.get(sm)) < 0)
		 * To swap, use something like:
		 *    SortingUtils.swapListElements(dataSet, sm, i); 
		 *    assuming that sm and i are indexes within dataSet.
		 */

	    for (int i = 0; i < n - 1; i++) {
	      int minPos = i;
	      for (int j = i + 1; j < n; j++) {
	        if (cmp.compare(dataSet.get(j), dataSet.get(minPos)) < 0) {
	          minPos = j;
	        }
	      }
	      SortingUtils.swapListElements(dataSet, i, minPos);
	    }
	}

}