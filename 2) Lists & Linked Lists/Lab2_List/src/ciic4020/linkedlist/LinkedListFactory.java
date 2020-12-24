package ciic4020.linkedlist;

import ciic4020.*;

public class LinkedListFactory<E> implements ListFactory<E> {

	@Override
	public List<E> newInstance(int initialCapacity) {
		// We don't pre-allocate nodes, so initialCapacity isn't actually used
		return new LinkedList<E>();
	}

	@Override
	public List<E> newInstance() {
		return new LinkedList<E>();
	}

}