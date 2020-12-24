package labUtils;

import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;
import treeInterfaces.Tree;

public class Utils {
	public static <E> void displayTree(String msg, Tree<E> t) { 
		System.out.println("\n\n" + msg); 
		t.display(); 
	}

	public static <E> void displayTreeElements(String msg, Tree<E> t) {
		System.out.println("\n\n" + msg); 
		for (E element : t)
			System.out.println(element); 
		
	}
	
	public static LinkedTree<Integer> buildExampleTreeAsLinkedTree() { 
		LinkedTree<Integer> t = new LinkedTree<>(); 
		// ADD CODE AS SPECIFIED IN EXERCISE 1
		Position<Integer> p = t.addRoot(4); 
		Position<Integer> p1 =  t.addChild(p, 9);
		t.addChild(p1, 7);
		t.addChild(p1, 10);
		p1 =  t.addChild(p, 20);
		p1 =  t.addChild(p1, 15);
		t.addChild(p1, 12);
		Position<Integer> p2 =  t.addChild(p1, 17);
		t.addChild(p2, 19);
		p2 = t.addChild(p1, 21);
		Position<Integer> p3 = t.addChild(p2, 40);
		t.addChild(p3, 30);
		t.addChild(p3, 45);
		
		
		return t; 
	}
	
	public static LinkedBinaryTree<Integer> buildExampleTreeAsLinkedBinaryTree() { 
		LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>(); 
		// ADD CODE AS SPECIFIED IN EXERCISE 2
		Position<Integer> root = t.addRoot(4);
		Position<Integer> left = t.addLeft(root, 9);
		Position<Integer> right = t.addRight(root, 20);
		t.addLeft(left, 7);
		t.addRight(left, 10);
		left = t.addLeft(right, 15);
		t.addLeft(left, 12);
		left = t.addRight(left, 17);
		t.addLeft(left, 19);
		right = t.addRight(right, 21);
		right = t.addLeft(right, 40);
		t.addLeft(right, 30);
		t.addRight(right, 45);
		
		
		

	
		return t; 
	}


}
