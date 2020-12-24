package ciic4020.linkedlist;

import ciic4020.List;

public interface ListFactory<E> {

	public List<E> newInstance(int initialCapacity);
	
	public List<E> newInstance();
}