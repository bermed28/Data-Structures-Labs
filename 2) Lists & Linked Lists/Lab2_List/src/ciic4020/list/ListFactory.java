package ciic4020.list;

import ciic4020.List;

public interface ListFactory<E> {

	public List<E> newInstance(int initialCapacity);
	
	public List<E> newInstance();
}