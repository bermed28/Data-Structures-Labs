package ciic4020.linkedlist.sampleTest;

import ciic4020.linkedlist.LinkedListFactory;
import ciic4020.List;
import ciic4020.linkedlist.ListFactory;

public class ListTest {

	public static void main(String[] args) {
		ListFactory<String> factory = new LinkedListFactory<String>();
		List<String> theList = factory.newInstance();
		
		System.out.println("Testing Add");
		theList.add("Ron");
		theList.add("Jil");
		theList.add("Ned");
		printList(theList);
		
		theList.add(1, "Li");
		System.out.println("First element: " + theList.first());
		theList.add(2, "Apu");
		theList.add(theList.size(), "Xi");
		System.out.println("Last element: " + theList.last());

		printList(theList);
		
		theList.add("Ron");
		theList.add(theList.size(),"Ron");
		System.out.println("Before removing Ron");
		
		printList(theList);
		theList.removeAll("Ron");
		System.out.println("After removing all instances of Ron");
		printList(theList);
		
		theList.add(1, "Amy");
		theList.add("Amy");
		theList.add("Moe");
		System.out.println("Before removing Amy");
		printList(theList);
		theList.remove("Amy");
		System.out.println("After removing Amy");
		printList(theList);
		
		System.out.println("Is Apu in the list: " + theList.contains("Apu"));
		theList.remove(1);
		System.out.println("Is Apu in the list: " + theList.contains("Apu"));

		theList.add(1, "Apu");
		theList.add("Apu");
		System.out.println("First index of Apu in the list: " + theList.firstIndex("Apu"));
		System.out.println("Last index of Apu in the list: " + theList.lastIndex("Apu"));
		printList(theList);
		
		System.out.println("Value of element at position 2: " + theList.get(2));
		theList.set(2, "Cal");
		System.out.println("Value of element at position 2 after set: " + theList.get(2));
		printList(theList);
		
		System.out.println("Testing Reverse:");
		theList = theList.reverse();
		printList(theList);
		
	}

	private static void printList(List<String> theList) {
		System.out.println("List size: " + theList.size());
		for (String s : theList)
			System.out.println(s);;
	}
}