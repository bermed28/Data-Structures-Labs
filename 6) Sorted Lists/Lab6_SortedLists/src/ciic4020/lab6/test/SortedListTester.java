package ciic4020.lab6.test;

import ciic4020.lab6.SortedArrayList;
import ciic4020.lab6.SortedLinkedList;
import ciic4020.lab6.SortedEmbeddedList;
import ciic4020.lab6.SortedList;

public class SortedListTester {

	public static void main(String[] args) {
		SortedList<String> sortedList = new SortedLinkedList<String>();
		//SortedList<String> sortedList = new SortedArrayList<String>(4);
		//SortedList<String> sortedList = new SortedEmbeddedList<String>();

		/* Test add */
		sortedList.add("Mel");
		sortedList.add("Ned");
		sortedList.add("Jil");
		sortedList.add("Ned");
		sortedList.add("Jil"); // Should trigger reAllocate if using ArrayList
		sortedList.add("Apu"); // Test adding at beginning
		sortedList.add("Tom"); // Test adding at end
		printList(sortedList);

		/* Uncomment to test get */

		System.out.println("-----------------------");
		for (int i = 0; i < sortedList.size(); i++)
			System.out.println("At position " + i + ": " + sortedList.get(i));
		// If you want, you can try get(-1) or get(10) to trigger the exception
		System.out.println("-----------------------");
		try {
			sortedList.get(-1);
		}catch(Exception e) {
			System.out.println("When calling an invalid index with sortedList.get(-1) we get: ");
			System.out.println(e);
		}
		
		System.out.println("-----------------------");
		try {
			sortedList.get(10);
		}catch(Exception e) {
			System.out.println("When calling an invalid index with sortedList.get(10) we get: ");
			System.out.println(e);
		}




		/* Uncomment to test firstIndex and contains */

		System.out.println("-----------------------");
		System.out.println("First index of Apu: " + sortedList.firstIndex("Apu"));
		System.out.println("First index of Jil: " + sortedList.firstIndex("Jil"));
		System.out.println("First index of Ned: " + sortedList.firstIndex("Ned"));
		System.out.println("First index of Tom: " + sortedList.firstIndex("Tom"));
		System.out.println("First index of Joe: " + sortedList.firstIndex("Joe"));
		System.out.println("List contains Apu? " + sortedList.contains("Apu"));
		System.out.println("List contains Joe? " + sortedList.contains("Joe"));



		/* Uncomment to test remove */

		System.out.println("-----------------------");
		System.out.println("Current list: ");
		printList(sortedList);
		sortedList.remove("Jil");
		sortedList.remove("Apu"); // Test removing at beginning
		sortedList.remove("Tom"); // Test removing at end
		System.out.println("After removing Jil, Apu, and Tom...");
		printList(sortedList);
		// Test add again, after having removed elements
		sortedList.add("Jil"); // Should be at the beginnin
		sortedList.add("Ned");
		sortedList.add("Xi"); // Should be at the end
		sortedList.add("Joe");
		System.out.println("After adding Jil, Ned, Xi, and Joe...");
		printList(sortedList);



		/* Uncomment to test remove by index */

		System.out.println("-----------------------");
		sortedList.removeIndex(3); // Removes Mel
		sortedList.removeIndex(4); // Removes Ned
		sortedList.removeIndex(5); // Removes Xi
		sortedList.removeIndex(0); // Removes Jil
		System.out.println("After removing indexes 3, 4, 5, and 0...");
		printList(sortedList);
		sortedList.add("Amy");
		sortedList.add("Qi");
		System.out.println("After adding Amy and Qi...");
		printList(sortedList);



		/* Uncomment to test isEmpty and clear */

		System.out.println("-----------------------");
		System.out.println("List is empty? " + sortedList.isEmpty());
		System.out.println("Clearing the list...");
		sortedList.clear();
		System.out.println("List is empty? " + sortedList.isEmpty());
		printList(sortedList);


		System.out.println("DONE");
	}

	private static void printList(SortedList<String> sl) {
		Object[] asArray = sl.toArray();
		if (!sl.isEmpty())
			System.out.print(sl.size() + " values: "); // Tests size()
		for (int i = 0; i < asArray.length; i++)
			System.out.print(((String) asArray[i]) + " ");
		System.out.print("\n");
	}

}