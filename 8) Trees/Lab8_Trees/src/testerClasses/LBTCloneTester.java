package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedBinaryTree;
import treeInterfaces.Position;

public class LBTCloneTester {

	public static void main(String[] args) throws CloneNotSupportedException {
		
	///*EXCERSICE 8*////////////////////////////////////////////////////////
		LinkedBinaryTree<String> rootOnly = new LinkedBinaryTree<>(), 				
				oneChild = new LinkedBinaryTree<>(),
				twoChild = new LinkedBinaryTree<>(),
				emptyTree = new LinkedBinaryTree<>();
		
		LinkedBinaryTree<Integer> multipleChild = new LinkedBinaryTree<>();
		
		multipleChild = Utils.buildExampleTreeAsLinkedBinaryTree();
		
		Utils.displayTree("The multipleChild tree is: ", multipleChild);
		Utils.displayTree("Cloned mutipleChilds is: ", multipleChild.clone());
		System.out.println("--------------------------------------------");
		
		rootOnly.addRoot("CIIC3011");
		Utils.displayTree("Root Only Tree is: ", rootOnly);
		Utils.displayTree("Cloned Root Only Tree is: ", rootOnly.clone());

		System.out.println("--------------------------------------------");
		
		Position<String> ocP = oneChild.addRoot("CIIC4010");
		oneChild.addLeft(ocP, "CIIC4020");
		
		Utils.displayTree("1 Childen Only Tree is: ", oneChild);
		Utils.displayTree("Cloned 1 Children Only Tree is: ", oneChild.clone());
		
		System.out.println("--------------------------------------------");

		Position<String> tcP = twoChild.addRoot("CIIC3011");
		twoChild.addLeft(tcP, "CIIC3075");
		twoChild.addRight(tcP, "CIIC4010");
		Utils.displayTree("2 Childen Only Tree is: ", twoChild);
		Utils.displayTree("Cloned 2 Children Only Tree is: ", twoChild.clone());
		
		System.out.println("--------------------------------------------");

		Utils.displayTree("Empty Tree is: ", emptyTree);
		Utils.displayTree("Cloned Empty Tree is: ", emptyTree.clone());
	///*EXCERSICE 8*////////////////////////////////////////////////////////

	}

}
