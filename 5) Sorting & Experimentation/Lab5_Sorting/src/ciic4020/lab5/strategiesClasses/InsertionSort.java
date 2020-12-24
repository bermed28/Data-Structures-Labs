package ciic4020.lab5.strategiesClasses;

import java.util.ArrayList;
import java.util.Comparator;

public class InsertionSort<E> extends AbstractSortingStrategy<E> {

	public InsertionSort(Comparator<E> cmp) { 
		super("InsertionSort", cmp); 
	}
	
	@Override
	public void sortList(ArrayList<E> dataSet) {
		int n = dataSet.size(); 

		/* TODO ADD CODE HERE FOLLOWING PSEUDOCODE (ALMOST VERBATIM) FROM LECTURE
		 * 
		 * To compare two values, use something like:
		 *    if (cmp.compare(dataSet.get(?), valToInsert) > 0)
		 */
		for (int i = 1; i < n; i++) {
			E valueToInsert = dataSet.get(i);
			int j = i - 1;
			while (j >= 0 && cmp.compare(dataSet.get(j), valueToInsert) > 0) {
				dataSet.set(j + 1,  dataSet.get(j));
				j--;
			}
			dataSet.set(j + 1, valueToInsert);
		}
	}

}