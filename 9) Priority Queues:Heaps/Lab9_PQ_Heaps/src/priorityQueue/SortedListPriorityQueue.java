package priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

import priorityQueueInterfaces.Entry;

/**
 * Implementation of a PriorityQueue based in an ArrayList<Entry<K, V>>.
 * @author pedroirivera-vega
 *
 * @param <K>
 * @param <V>
 */
public class SortedListPriorityQueue<K, V> extends AbstractListPriorityQueue<K, V> {
	public SortedListPriorityQueue(Comparator<K> cmp) { 
		super(cmp);
	}
	
	public SortedListPriorityQueue() { 
		super(); 
	}
	

	@Override
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
		super.validate(key);
		Entry<K,V> newest = new PQEntry<K,V>(key, value);
		if(!list.isEmpty()) {
			int curr = list.size()-1; 
			while (curr >= 0  && compare(list.get(curr), newest) > 0) 
				curr--; 
			list.add(curr + 1, newest);
		} 
		else
			list.add(0, newest); 
		
		return newest; 
	}

	@Override
	protected int minEntryIndex() {
		if(!this.isEmpty()) {
			int mpIndex = 0; 
			
			for (int i=1; i<list.size(); i++)
				if (compare(list.get(i), list.get(mpIndex)) < 0)
					mpIndex = i; 
			return mpIndex;
		}
		return -1;	
	}

}
