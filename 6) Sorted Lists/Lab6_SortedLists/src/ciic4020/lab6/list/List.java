package ciic4020.lab6.list;

public interface List<E> {

	public void add(E obj);
	public void add(int index, E obj) throws IndexOutOfBoundsException;
	public boolean remove(E obj);
	public E remove(int index) throws IndexOutOfBoundsException;
	public int removeAll(E obj);
	public E get(int index) throws IndexOutOfBoundsException;
	public E set(int index, E obj) throws IndexOutOfBoundsException;
	public E first();
	public E last();
	public int firstIndex(E obj);
	public int lastIndex(E obj);
	public int size();
	public boolean isEmpty();
	public boolean contains(E obj);
	public void clear();
	public E[] toArray();
}