package ciic4020.lab5.experimentClasses;

import java.io.FileNotFoundException;
import java.util.Comparator;

import ciic4020.lab5.strategiesClasses.BubbleSort;
import ciic4020.lab5.strategiesClasses.HeapSort;
import ciic4020.lab5.strategiesClasses.MergeSort;
import ciic4020.lab5.strategiesClasses.QuickSort;
import ciic4020.lab5.strategiesClasses.SelectionSort;
import ciic4020.lab5.strategiesClasses.InsertionSort;
import ciic4020.lab5.testerClasses.IntegerComparator1;

/**
 * 
 * @author pedroirivera-vega
 *
 */
public class ExperimentalTrials {

	public static void main(String[] args) {
		// Parm1: initial size
		// Parm2: trials per size
		// Parm3: incremental steps (size)
		// Parm4: last size to consider
		ExperimentController ec = new ExperimentController(50, 200, 50, 1000); 
		
		/**
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new SequentialFD<Integer>())); 
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new OrderedFD<Integer>())); 
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new MapFD<Integer>())); 
		**/
		
		/**/
		Comparator<Integer> comparator = new IntegerComparator1();
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new BubbleSort<Integer>(comparator))); 
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new HeapSort<Integer>(comparator))); 
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new SelectionSort<Integer>(comparator))); 
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new QuickSort<Integer>(comparator))); 
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new MergeSort<Integer>(comparator))); 
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new InsertionSort<Integer>(comparator))); 
		/**/


		ec.run();    // run the experiments on all the strategies added to the controller object (ec)
		
		// save the results for each strategy....
		try {
			ec.saveResults();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}

}