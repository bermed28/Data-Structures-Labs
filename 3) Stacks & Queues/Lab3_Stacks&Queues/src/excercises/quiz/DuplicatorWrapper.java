package excercises.quiz;
import java.io.PrintStream;

public class DuplicatorWrapper {

	public interface Stack<E> {
		public int size();
		public boolean isEmpty();
		public E top();
		public E pop();
		public void push(E e);
		public void clear();
		public void print(PrintStream out);
	}

	
	public static void main(String[] args) {
		Stack<String> test = new SingleLinkedStack();
		test.push("Bob");
		test.push("Ned");
		test.push("Joe");
		
		Stack<String> test1 = duplicator(test);
		
		System.out.println(test1.top());

	}
	public static class SingleLinkedStack<E> implements Stack<E> {

		// node class
		@SuppressWarnings("hiding")
		private  class Node<E> {
			private E element;
			private Node<E> next;

			@SuppressWarnings("unused")
			public Node(E element, Node<E> next) {
				super();
				this.element = element;
				this.next = next;
			}
			public Node() {
				super();
			}
			public E getElement() {
				return element;
			}
			public void setElement(E element) {
				this.element = element;
			}
			public Node<E> getNext() {
				return next;
			}
			public void setNext(Node<E> next) {
				this.next = next;
			}

		}

		private Node<E> header;
		private int currentSize;

		public SingleLinkedStack(){
			this.header = new Node<>();
			this.currentSize =0;
		}

		@Override
		public int size() {
			return this.currentSize;
		}

		@Override
		public boolean isEmpty() {
			return this.size() == 0;
		}

		@Override
		public E top() {
			if (this.isEmpty())
				return null;
			else
				return this.header.getNext().getElement();
		}

		@Override
		public E pop() {
			if (this.isEmpty())
				return null;
			else {
				E result = this.header.getNext().getElement();
				Node<E> temp = this.header.getNext();
				this.header.setNext(temp.getNext());
				temp.setNext(null);
				temp.setElement(null);
				this.currentSize--;
				return result;
			}
		}

		@Override
		public void push(E e) {
			Node<E> newNode = new Node<>();
			newNode.setElement(e);
			newNode.setNext(this.header.getNext());
			this.header.setNext(newNode);
			this.currentSize++;
		}

		@Override
		public void clear() {
			while (this.pop() != null);
		}

		@Override
		public void print(PrintStream out) {
			Node<E> temp = this.header.getNext();
			while(temp != null) {
				out.println(temp.getElement());
				temp = temp.getNext();
			}

		}
	}	

	public static Stack<String> duplicator(Stack<String> S) {
			Stack<String> result = new SingleLinkedStack<String>();	
			String[] vals = new String[S.size()];
			
			int i = 0;
			while(!S.isEmpty()) {
				String val = S.pop();
				vals[i] = val;
				i++;
				
			}
			
			for (int j = vals.length -1; j >= 0; j--) {
				S.push(vals[j]);
				result.push(vals[j]);
			}
			return result;
	}
}