package excercises;

import interfaces.Deque;

public class CircularDoublyLinkedQueue<E> implements Deque<E> {
	private Node header;
	private int currentSize;

	private class Node {
		private E value;
		private Node next, prev;

		public Node(E value, Node next, Node prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}

		public Node(E value) {
			this(value, null, null); // Delegate to other constructor
		}

		public Node() {
			this(null, null, null); // Delegate to other constructor
		}

		public E getValue() {
			return value;
		}

		public void setValue(E value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public void clear() {
			value = null;
			next = null;
		}				
	} // End of Node class

	//Constructor
	public CircularDoublyLinkedQueue() {
		header = new Node();
		header.setNext(header);
		header.setPrev(header);
		currentSize = 0;

	}
	@Override
	public int size() {
		return currentSize;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void clear() {
		while(!isEmpty())
			removeFirst();
	}

	@Override
	public E getFirst() {
		return header.getNext().getValue();

	}

	@Override
	public E getLast() {
		return header.getPrev().getValue();

	}

	@Override
	public void addLast(E element) throws IllegalArgumentException {
		Node newNode;
		if (isEmpty()) {
			newNode =  new Node(element, header, header);
			header.setNext(newNode);
			header.setPrev(newNode);
		} else {
			Node nextNode = header.getPrev();
			newNode = new Node(element, header, nextNode);
			header.setPrev(newNode);
			nextNode.setNext(newNode);
		}
		
		currentSize++;
	}

	@Override
	public void addFirst(E element) throws IllegalArgumentException {

		Node newNode; 
		if(isEmpty()) {
			newNode =  new Node(element, header, header);
			header.setNext(newNode);
			header.setPrev(newNode);
		} else {
			Node nextNode = header.getNext();
			newNode = new Node(element, nextNode, header);
			header.setNext(newNode);
			nextNode.setPrev(newNode);

		}
		currentSize++;
	}

	@Override
	public E removeLast() {
		Node rmNode, nextNode;
		E value = null;
		if(size() == 0) return value;
		
		if (size() == 1) {
			rmNode = header.getNext();
			value = rmNode.getValue();
			header.setNext(header);
			header.setPrev(header);
			rmNode.clear();
			rmNode = null;
		} else {
			rmNode = header.getPrev();
			value = rmNode.getValue();
			nextNode = rmNode.getPrev();
			
			
			nextNode.setNext(header);
			header.setPrev(nextNode);
			rmNode.clear();
			rmNode = null;
		}
		currentSize--;
		return value;
	}

	@Override
	public E removeFirst() {
		Node nextNode, rmNode;
		E value = null;
		if(size() == 0) return value;
		
		if (size() == 1) {
			rmNode = header.getNext();
			value = rmNode.getValue();
			
			header.setNext(header);
			header.setPrev(header);
			rmNode.clear();
			rmNode = null;
			
		} else {
			rmNode = header.getNext();
			nextNode = rmNode.getNext();
			
			value = rmNode.getValue();
			
			nextNode.setPrev(header);
			header.setNext(nextNode);
			rmNode.clear();
			rmNode = null;
		}
		currentSize--;
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		E[] result = (E[]) new Object[this.size()];
		int i = 0;
		Node curNode = header.getNext();
		while (curNode != header) {
			result[i++] = curNode.getValue();
			curNode = curNode.getNext();
		}
		return result;
	}

}
