package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedTree;

public class ExampleTreeBuilder1 {

	public static void main(String[] args) {
		LinkedTree<Integer> t = Utils.buildExampleTreeAsLinkedTree(); 

		// display content as a tree
		Utils.displayTree("The tree is: ", t); 
	}

}