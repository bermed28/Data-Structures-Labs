package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedTree;
import treeInterfaces.Position;

public class TreeTester2 {

	public static void main(String[] args) throws CloneNotSupportedException {
		LinkedTree<String> t = new LinkedTree<>(), 
				              t1 = new LinkedTree<>(),
				              t2 = new LinkedTree<>(),
				              t3 = new LinkedTree<>(),
						      t4 = new LinkedTree<>(); 

		
		// add nodes and data to the tree
		Position<String> p = t.addRoot("ROOT"); 
		t.addChild(p, "Rosa"); 
		p = t.addChild(p, "Maria"); 
		Position<String> ptd = p;     // saved for future test of remove
		Position<String> p1 = t.addChild(p, "Juana"); 
		p1 = t.addChild(p1, "Lola"); 
		t.addChild(p1, "Pepote"); 
		p1 = t.addChild(p1, "Manolo"); 
		p1=t.addChild(p1, "Eligio"); 
		t.addChild(p1, "Eda"); 
		t.addChild(p1, "Deborah"); 
		p1 = t.addChild(p, "Pergamino"); 
		Position<String> ps1 = t.addChild(p, "Bienvenido");
		t.addChild(p1, "Manolin"); 
		t.addChild(p1, "Juaniquillo"); 
		Position<String> ps2=  t.addChild(p1, "Andres"); 
		p1 = t.addChild(t.root(), "Mariola");
		p = p1; 
		p1 = t.addChild(p1, "Leslo"); 
		p1 = t.addChild(p1, "Papin"); 
		p1 = t.addChild(p1, "Ana"); 
		t.addChild(p, "Elegancia"); 
		
		Utils.displayTree("Original t", t); 
		
		// make a clone of t
		t1 = t.clone(); 
		Utils.displayTree("Clone of t", t1); 
		
		String removedElement = t.remove(ptd);
		Utils.displayTree("Tree t after removing " + removedElement, t); //Internal node with children
		Utils.displayTree("Clone of t", t1); 
		
		ptd = ps1;
		Utils.displayTree("Tree t before removing ", t);
		String removedElement2 = t.remove(ptd);
		Utils.displayTree("Tree t after removing " + removedElement2, t); //Leaf
		
		
		ptd = p;
		String removedElement3 = t.remove(ptd);
		Utils.displayTree("Tree t after removing " + removedElement3, t); //Internal Node with children, part 2
		
		ptd = ps2;
		Utils.displayTree("Tree t before removing ", t);
		String removedElement4 = t.remove(ptd);
		Utils.displayTree("Tree t after removing " + removedElement4, t); //Leaf inside Internal Node
		
		Position<String> p2 = t2.addRoot("CIIC4020");
		Utils.displayTree("Root only Tree:", t2);
		String removedRoot = t2.remove(p2);
		Utils.displayTree("Root Only Tree after removing root: " + removedRoot, t2); //Root Only
		
		Position<String> p3 = t3.addRoot("CIIC4020");
		t3.addChild(p3, "ICOM4035");

		Utils.displayTree("1 Child Tree is: ", t3);
		String removedRoot1 = t3.remove(p3);
		Utils.displayTree("1 Child Tree after removing root " + removedRoot1 + ":", t3); //One Child Tree
		
		Position<String> p4 = t4.addRoot("CIIC4020");
		t4.addChild(p4, "ICOM4035");
		t4.addChild(p4, "CIIC4010");
		Utils.displayTree("2 Child Tree is: ", t4); //Two Child Tree
		try {
			t4.remove(p4);
		}catch(Exception e) {
			System.out.println("\nTrying to remove root in 2 Child Tree throws the following error: ");
			e.printStackTrace(System.out);
		}
		
		System.out.println("DONE!");
		

	}

}
