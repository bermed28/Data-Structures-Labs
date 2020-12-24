package ciic4020.list;

import ciic4020.List;

public class ArrayListFactory<E> implements ListFactory<E> {

	private static final int DEFAULT_SIZE = 10;
	
	@Override
	public List<E> newInstance(int initialCapacity) {
		return new ArrayList<E>(initialCapacity);
	}

	@Override
	public List<E> newInstance() {
		return new ArrayList<E>(DEFAULT_SIZE);
	}

}