package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedBinaryTree;

public class ExampleTreeBuilder2 {

	public static void main(String[] args) {
		LinkedBinaryTree<Integer> t = Utils.buildExampleTreeAsLinkedBinaryTree(); 

		// display content as a tree
		Utils.displayTree("The tree is: ", t); 
	}

}