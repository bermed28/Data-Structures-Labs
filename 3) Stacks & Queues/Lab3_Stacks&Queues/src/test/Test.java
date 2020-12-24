package test;

import excercises.CircularDoublyLinkedQueue;
import excercises.SinglyLinkedQueue;

public class Test {


	public static void main(String[] args) {

		SinglyLinkedQueue<String> test1 = new SinglyLinkedQueue<>();

		test1.enqueue("This");
		test1.enqueue("is");
		test1.enqueue("a");
		test1.enqueue("Test");

//		while(!test1.isEmpty()) {
//			System.out.println(test1.dequeue());
//		}

		System.out.println("**********************************");
		Object[] test1_2 = test1.toArray();
		for (Object string : test1_2) {
			System.out.println(string);
		}
		
		
		System.out.println("****************************");

		CircularDoublyLinkedQueue<String> test2 = new CircularDoublyLinkedQueue<>();



		test2.addLast("This");
		test2.addLast("is");
		test2.addLast("a");
		test2.addLast("CDLQ");
		test2.addLast("Test");

//		while (!test2.isEmpty()) {
//			System.out.println(test2.removeFirst());
//		}
//
//		System.out.println();
//
//		test2.addFirst("This"); //back
//		test2.addFirst("is");
//		test2.addFirst("a");
//		test2.addFirst("CDLQ");
//		test2.addFirst("Test"); //front
//
//		while (!test2.isEmpty()) {
//			System.out.println(test2.removeLast());
//		}
		
		Object[] test2_2 = test2.toArray();
		for (Object object : test2_2) {
			System.out.println(object);
		}
	}
}
