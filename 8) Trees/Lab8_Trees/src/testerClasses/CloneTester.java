package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedBinaryTree;
import treeClasses.LinkedTree;
import treeInterfaces.Position;

public class CloneTester {

	public static void main(String[] args) throws CloneNotSupportedException {
		
	///*EXCERSICE 7*/////////////////////////////////////////////////////////
		LinkedTree<String> rootOnly = new LinkedTree<>(), 				
							oneChild = new LinkedTree<>(),
							twoChild = new LinkedTree<>(),
							emptyTree = new LinkedTree<>(),
							multipleChild = new LinkedTree<>();
		
		Position<String> p = multipleChild.addRoot("CIIC3011"); 	
		multipleChild.addChild(p, "CIIC3081"); 
		p = multipleChild.addChild(p, "CIIC4010"); 
		Position<String> p1 = multipleChild.addChild(p, "CIIC4020"); 
		p1 = multipleChild.addChild(p1, "CIIC4082"); 
		multipleChild.addChild(p1, "CIIC4050"); 
		p1 = multipleChild.addChild(p1, "INSO4101"); 
		p1=multipleChild.addChild(p1, "INSO4115"); 
		multipleChild.addChild(p1, "INSO4116"); 
		multipleChild.addChild(p1, "INSO4117"); 
		p1 = multipleChild.addChild(p, "INEL3105"); 
		multipleChild.addChild(p, "CIIC4025");
		multipleChild.addChild(p1, "INEL4115"); 
		multipleChild.addChild(p1, "INEL4102"); 
		multipleChild.addChild(p1, "FISI3172"); 
		p1 = multipleChild.addChild(multipleChild.root(), "CIIC3075");
		p = p1; 
		p1 = multipleChild.addChild(p1, "MATE3031"); 
		p1 = multipleChild.addChild(p1, "MATE3032"); 
		p1 = multipleChild.addChild(p1, "MATE3063"); 
		multipleChild.addChild(p, "MATE4145"); 
		
		Utils.displayTree("The multipleChild tree is: ", multipleChild);
		Utils.displayTree("Cloned mutipleChilds is: ", multipleChild.clone());
		System.out.println("--------------------------------------------");
		
		rootOnly.addRoot("CIIC3011");
		Utils.displayTree("Root Only Tree is: ", rootOnly);
		Utils.displayTree("Cloned Root Only Tree is: ", rootOnly.clone());

		System.out.println("--------------------------------------------");
		
		Position<String> ocP = oneChild.addRoot("CIIC4010");
		oneChild.addChild(ocP, "CIIC4020");
		
		Utils.displayTree("1 Childen Only Tree is: ", oneChild);
		Utils.displayTree("Cloned 1 Children Only Tree is: ", oneChild.clone());
		
		System.out.println("--------------------------------------------");

		Position<String> tcP = twoChild.addRoot("CIIC3011");
		twoChild.addChild(tcP, "CIIC3075");
		twoChild.addChild(tcP, "CIIC4010");
		Utils.displayTree("2 Childen Only Tree is: ", twoChild);
		Utils.displayTree("Cloned 2 Children Only Tree is: ", twoChild.clone());
		
		System.out.println("--------------------------------------------");

		Utils.displayTree("Empty Tree is: ", emptyTree);
		Utils.displayTree("Cloned Empty Tree is: ", emptyTree.clone());
		///*EXCERSICE 7*/////////////////////////////////////////////////////////
		
	}

}
