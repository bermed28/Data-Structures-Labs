package treeClasses;

import java.util.ArrayList;
import treeInterfaces.BinaryTree;
import treeInterfaces.Position;

/**
 * Partial implementation of the BinaryTree ADT.
 * 
 * @author pedroirivera-vega
 *
 * @param <E> The generic data type of elementsin the heap
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements
		BinaryTree<E> {

	@Override
	public Iterable<Position<E>> children(Position<E> p)
			throws IllegalArgumentException {
		ArrayList<Position<E>> list = new ArrayList<>(); 
		if (this.hasLeft(p)) list.add(this.left(p)); 
		if (this.hasRight(p)) list.add(this.right(p));
		
		return list;
	}

	@Override
	public int numChildren(Position<E> p) throws IllegalArgumentException {
		int count = 0; 
		if (this.hasLeft(p)) count++; 
		if (this.hasRight(p)) count++; 
		return count;
	}

	@Override
	public boolean hasLeft(Position<E> p) throws IllegalArgumentException {
		return this.left(p) != null;
	}

	@Override
	public boolean hasRight(Position<E> p) throws IllegalArgumentException {
		return this.right(p) != null;
	}

	@Override
	public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
		Position<E> parent = this.parent(p); 
		if (parent == null) 
			return null; 
		if (this.left(parent) == p)
			return this.right(parent); 
		return this.left(parent);
	}
	

	
	// The following part has to do with Exercise 3. 
	
	protected void recDisplay(Position<E> r, 
			int[] control, int level) 
	{
		// ADD CODE to override this method as specified in Exercise 3
		printPrefix(level, control);                                     
		System.out.println();                                            
		printPrefix(level, control); 
		if(control[level] == 0)
			System.out.println("__ROOT("+r.getElement()+")");
		else if(control[level] == 1) 
			System.out.println("__R("+r.getElement()+")");
		else 
			System.out.println("__L("+r.getElement()+")");                 
		control[level]--;                                                
		int nc = this.numChildren(r);                                 
		control[level+1] = nc;                                           
		for (Position<E>  p : this.children(r)) {                     
			recDisplay(p, control, level+1);                             
		}  
	}
	


	// The following part has to do with Exercise 5.
	/**/
	// internal method to construct the Iterable<Position<E>> object. 
	// based on in-order traversal. 
	protected void fillIterable(Position<E> r, ArrayList<Position<E>> pList) { 
		if (hasLeft(r)) 
			fillIterable(left(r), pList); 
		pList.add(r); 
		if (hasRight(r)) 
			fillIterable(right(r), pList); 
	}
    /**/


}
