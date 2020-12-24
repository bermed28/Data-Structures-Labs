package priorityQueueInterfaces;

/**
 * ADT specification of Entry. An entry is a pair of fields:
 * one representing a key (of type K) and one representing a data value
 * (of type V) that is associated with the particular key.
 */ 

public interface Entry<K, V> { 
	/** Accesses the key of the entry.
	    @return reference to the key of the entry. 
	**/ 
	K getKey(); 

	/** Accesses the value of the entry. 
	    @return reference to the value of the entry. 
	**/
	V getValue(); 
}