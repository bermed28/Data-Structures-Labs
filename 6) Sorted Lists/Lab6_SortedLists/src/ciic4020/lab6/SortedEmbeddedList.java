package ciic4020.lab6;

import ciic4020.lab6.list.LinkedList;
import ciic4020.lab6.list.List;

/**
 * @author Fernando J. Bermudez
 *
 */
public class SortedEmbeddedList<E extends Comparable<? super E>> extends AbstractSortedList<E> {

	/*************************************************************************
	 * IMPORTANT NOTE
	 * 
	 * We're initially using a LinkedList, but we could have used ArrayList.
	 * The point of this class is to delegate most of the work to the List,
	 * regardless of its implementation.
	 * You will later be asked about this class' performance according to the
	 * different possible implementations for the underlying List object.
	 ************************************************************************/
	private List<E> list;

	public SortedEmbeddedList() {
		list = new LinkedList<>();
	}

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		/* Do NOT use binary search here! */
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			if (e.compareTo(list.get(i)) >= 0) {
				//0,1,2,3,5
				index = i+1;
			}
		}
		
		list.add(index, e);
		

	}

	@Override
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		return list.remove(e);
	}

	@Override
	public E removeIndex(int index) {
		// TODO Auto-generated method stub
		return list.remove(index);
	}

	@Override
	public int firstIndex(E e) {
		// TODO Auto-generated method stub
		return list.firstIndex(e);
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return list.get(index);
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		/* Can't use list.toArray() because it returns Object[], not Comparable[] */
		E[] asArray = (E[]) new Comparable[size()]; // Cannot use Object here
		for (int i = 0; i < list.size(); i++)
			asArray[i] = list.get(i);
		return asArray;
	}

	/* To take full advantage of the embedded list, override the following methods.
	 * Most implementations should be EXTREMELY simple (delegate the work to the list) */

	public boolean contains(E e) {
		/* TODO ADD CODE HERE */
		return list.contains(e);
	}
	
	public boolean isEmpty() {
		/* TODO ADD CODE HERE */
		return list.isEmpty();
	}
	
	public void clear() {
		/* TODO ADD CODE HERE */
		list.clear();
	}
	
	public int size() {
		/* TODO ADD CODE HERE */
		return list.size();
	}

}