package ciic4020.lab7.set;

import java.util.Iterator;

import ciic4020.lab7.linkedlist.List;
import ciic4020.lab7.map.HashTableSC;
import ciic4020.lab7.map.Map;
import ciic4020.lab7.map.SimpleHashFunction;
/**
 * Custom Implementation of a HashSet
 * This version of HashSet is backed by a Separate Chaining Hash Table
 * @author Fernando J. Bermudez - bermed28
 *
 * @param <E>
 */
public class HashSet<E> implements Set<E> {
	//Private Fields
	private Map<E, Object> hashtable;
	private static final int DEFAULT_SET_SIZE = 10;
	
	/*Constructs an empty HashSet with a given initial capacity*/
	public HashSet(int initialCapacity) {
		hashtable = new HashTableSC<E, Object>(initialCapacity, new SimpleHashFunction<E>());
	}
	
	/*Constructs an empty HashSet with a default initial capacity of ten*/
	public HashSet() {
		hashtable = new HashTableSC<E, Object>(DEFAULT_SET_SIZE, new SimpleHashFunction<E>());
	}
	@Override
	public Iterator<E> iterator() {
		return hashtable.getKeys().iterator();
	}

	/**
	 * Takes a given object that is not already in the set 
	 * and adds it to the HashSet according to the hashCode generated for the object
	 * 
	 * @param obj - Object to be added to set
	 * @return true or false, depending if the object was added to the set
	 */
	@Override
	public boolean add(E obj) {
		if(isMember(obj)) return false;
		hashtable.put(obj, new Object()); //We put as parameter for value a dummy object
		return true;
	}
	
	/**
	 * Returns true if the given object is a member (is included) of the HashSet
	 * @param obj - object to verify if is in set
	 */
	@Override
	public boolean isMember(E obj) {
		return hashtable.containsKey(obj);
	}

	/**
	 * Removes a given object from the set and returns true if the object was actually removed or not
	 * @param obj - object to remove
	 */
	@Override
	public boolean remove(E obj) {
		return hashtable.remove(obj) != null;
 	}

	
	/**
	 * Checks to see if set is empty
	 * @return true or false if the set is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return hashtable.isEmpty();
	}

	/**
	 * @return size of HashSet
	 */
	@Override
	public int size() {
		return hashtable.size();
	}

	/**
	 * Removes everything from HashSet until it is empty
	 */
	@Override
	public void clear() {
		hashtable.clear();
	}

	/**
	 * Returns a set with the all the elements from the target set and a given S2 combined
	 * @param S2 - the second set
	 * @return S3 - The set with the combined elements from the target set and S2
	 */
	@Override
	public Set<E> union(Set<E> S2) {
		Set<E> S3 = new HashSet<E>();
		// Copy S1
		for (E e : this)
			S3.add(e);
		
		// Copy elements of S2 not already in S1
		for (E e : S2)
			if (!S3.isMember(e))
				S3.add(e);
		

		return S3;
	}

	/**
	 * Returns a set with the non-common elements from the target set and a given S2
	 * @param S2 - the second set
	 * @return S3 - The set with the non-common elements from the target set and S2
	 */
	@Override
	public Set<E> difference(Set<E> S2) {
		Set<E> S3 = new HashSet<E>();
		for (E e : this)
			if (!S2.isMember(e))
				S3.add(e);
		
		return S3;	
	}

	/**
	 * Returns a set with the common elements from the target set and a given S2
	 * @param S2 - the second set
	 * @return S3 - The set with the common elements from the target set and S2
	 */
	@Override
	public Set<E> intersection(Set<E> S2) {
		return this.difference(this.difference(S2));
	}

	/**
	 * Returns true if S2 is a subset of the target set, otherwise it returns false
	 * @param S2 - the set to compare with 
	 */
	@Override
	public boolean isSubSet(Set<E> S2) {
		for (E e : this)
			if (!S2.isMember(e))
				return false;
		return true;
	}
	
}
