package excercises;

import interfaces.Queue;

public class SinglyLinkedQueue<E> implements Queue<E> {

	private Node head, tail;
	private int currentSize;
	
	private class Node {
		private E value;
		private Node next;
		
		public Node(E value, Node next) {
			this.value = value;
			this.next = next;
		}
		
		public Node(E value) {
			this(value, null); // Delegate to other constructor
		}
		
		public Node() {
			this(null, null); // Delegate to other constructor
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
		
		public void clear() {
			value = null;
			next = null;
		}				
	} // End of Node class

	public SinglyLinkedQueue() {
		this.head = this.tail = null;
		this.currentSize = 0;
		
	}
	@Override
	public void enqueue(E e) {
		Node newNode = new Node(e, null);
		
		if (head == null) {
			head = tail = newNode;
			tail.setNext(null);
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		
		currentSize++;
	}

	@Override
	public E dequeue() {
		if(isEmpty()) return null;
		
		Node rmNode = head;
		E value = rmNode.getValue();
		head =head.getNext();
		rmNode.clear();
		currentSize--;
		
		return value;
		
	}

	@Override
	public E front() {
		if(isEmpty()) return null;
		return head.getValue();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public void clear() {
		while(!isEmpty())
			dequeue();
	}

	@Override
	public int size() {
		return currentSize;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		E[] result = (E[]) new Object[this.currentSize];
		
		int i = 0;		
		Node curNode = head;
		while (curNode != null) {
			result[i++] = curNode.getValue();
			curNode = curNode.getNext();
		}
		
		return result;
	}

}
