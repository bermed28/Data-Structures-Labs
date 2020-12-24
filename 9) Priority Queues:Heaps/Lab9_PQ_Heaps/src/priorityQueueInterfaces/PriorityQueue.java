package priorityQueueInterfaces;

/**
 * Priority Queue ADT
 * 
 * @author pedroirivera-vega
 *
 * @param <K> Type for the keys of the entries that will be stored
 * @param <V> Type for the values of the entries that will be stored
 */
public interface PriorityQueue<K, V> { 
	/** The size of the collection **/
	int size(); 
	
	/** Returns true if empty; false, otherwise. **/ 
	boolean isEmpty(); 

	/** Add a new entry (key, value) to the queue. 
	    @param key the key for the entry
	    @param value the value for the entry
	    @return Reference to the newly-created Entry object
	    @throw IllegalArgumentException if key parameter is invalid
	**/
	Entry<K, V> insert(K key, V value) throws IllegalArgumentException; 

	/** Accesses entry in the collection having highest priority 
	    (or minimum key, according to a particular order relation)
	    @return Reference to the entry with minimum key, or null if empty
	**/
	Entry<K, V> min(); 

	/** Removes entry in the collection having highest priority 
	   (or minimum key, according to a particular order relation)
	    @return Reference to the removed entry, or null if empty
	**/
	Entry<K, V> removeMin(); 
} 