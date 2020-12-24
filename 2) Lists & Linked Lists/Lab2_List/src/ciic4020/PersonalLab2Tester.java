package ciic4020;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import ciic4020.linkedlist.DoublyLinkedList;
import ciic4020.linkedlist.LinkedList;
import ciic4020.list.ArrayList;

public class PersonalLab2Tester {

	private int DEFAULT_SIZE = 7;
	private List<String> arrayList, arrayList3, arrayList2, 
						linkedList, linkedList2, linkedList3, 
						doublyLinkedList, doublyLinkedList2, doublyLinkedList3;
	
	@Before
	public void setUp() throws Exception {
	
		arrayList = new ArrayList<String>(DEFAULT_SIZE);
		arrayList2 = new ArrayList<String>(DEFAULT_SIZE);
		arrayList3= new ArrayList<String>(DEFAULT_SIZE);
		
		linkedList = new LinkedList<String>();
		linkedList2 = new LinkedList<String>();
		linkedList3 = new LinkedList<String>();
		
		doublyLinkedList = new DoublyLinkedList<String>();
		doublyLinkedList2 = new DoublyLinkedList<String>();
		doublyLinkedList3 = new DoublyLinkedList<String>();
		
		loadDefaultArrayList((ArrayList<String>) arrayList);
		loadDefaultArrayList2((ArrayList<String>) arrayList2);
		loadDefaultArrayList3((ArrayList<String>) arrayList3);
		
		loadDefaultLinkedList((LinkedList<String>) linkedList);
		loadDefaultLinkedList2((LinkedList<String>) linkedList2);
		loadDefaultLinkedList3((LinkedList<String>) linkedList3);
		
		loadDefaultDoublyLinkedList((DoublyLinkedList<String>) doublyLinkedList);
		loadDefaultDoublyLinkedList2((DoublyLinkedList<String>) doublyLinkedList2);
		loadDefaultDoublyLinkedList3((DoublyLinkedList<String>) doublyLinkedList3);
		
	}
	
	
	@Test
	public void testTotalCount() {
		
		List<String>[] alTest = new List[3];
		List<String>[] llTest = new List[3];
		List<String>[] dllTest = new List[3];
		
		List<String> list1 = arrayList;
		List<String> list2 = arrayList2;
		List<String> list3 = arrayList3;

		List<String> list4 = linkedList;
		List<String> list5 = linkedList2;
		List<String> list6 = linkedList3;
		
		List<String> list7 = doublyLinkedList;
		List<String> list8 = doublyLinkedList2;
		List<String> list9 = doublyLinkedList3;
		
		alTest[0] = list1;
		alTest[1] = list2;
		alTest[2] = list3;
		
		llTest[0] = list4;
		llTest[1] = list5;
		llTest[2] = list6;
		
		dllTest[0] =list7;
		dllTest[1] =list8;
		dllTest[2] =list9;
		
		int testAL = Main.totalCount("JuanO", alTest);
		int testLL = Main.totalCount("JoseMelendez", llTest);
		int testDLL = Main.totalCount("Bienve", dllTest);
		
		assertTrue("Result should be 6 " + "but result was " + testAL , testAL == 6);
		assertTrue("Result should be 8 " + "but result was " + testLL , testLL == 8);
		assertTrue("Result should be 3 " + "but result was " + testDLL , testDLL == 3);

	}
	
	@Test
	public void testReplaceAll() {
		
		List<String> list1 = arrayList2;
		List<String> list2 = linkedList2;
		List<String> list3 = doublyLinkedList3;
		
		int testAL = list1.replaceAll("JuanO", "JoseMelendez");
		int testLL = list2.replaceAll("JoseMelendez", "Wilson");
		int testDLL = list3.replaceAll("Bienve", "Schutz");
		
		assertTrue("Result should be 3 " + "instead got " + testAL, testAL == 3);
		assertTrue("Result should be 2 " + "instead got " + testLL, testLL == 2);
		assertTrue("Result should be 2 " + "instead got " + testDLL, testDLL == 1);	
	
	}
	
	@Test
	public void testReverse() {
		List<String> list1 = arrayList;
		List<String> list2 = linkedList;
		List<String> list3 = doublyLinkedList;
		
		List<String> revList1 = list1.reverse();
		List<String> revList2 = list2.reverse();
		List<String> revList3 = list3.reverse();
		
		List<String> testAL = new ArrayList<String>(DEFAULT_SIZE);
		List<String> testLL = new LinkedList<String>();
		List<String> testDLL = new DoublyLinkedList<String>();
		
	
		testAL.add("Manuel");
		testAL.add("Arzuaga");
		testAL.add("Pedro");
		testAL.add("JuanO");
		testAL.add("Wilson");
		testAL.add("Bienve");
		testAL.add("JuanO");
			
		
		testLL.add("Manuel");
		testLL.add("JoseMelendez");
		testLL.add("Pedro");
		testLL.add("JoseMelendez");
		testLL.add("Wilson");
		testLL.add("Bienve");
		testLL.add("JoseMelendez");
		
		testDLL.add("Manuel");
		testDLL.add("Arzuaga");
		testDLL.add("Pedro");
		testDLL.add("JuanO");
		testDLL.add("Wilson");
		testDLL.add("Bienve");
		testDLL.add("JuanO");
		
		/*
		 * MAKE SURE TO IMPLEMENT AN equals() METHOD IN ALL 3 LIST CLASSES (AL, LL, DLL) 
		 * THIS IS FOR THE test.equals(revList) COMPARES THE ELEMENTS ONE BY ONE INSTEAD
		 * OF COMPARING MEMORY SPACE
		 * 
		 */
		
		assertTrue("ArrayList should be reversed", testAL.equals(revList1));
		assertTrue("LinkedList should be reversed", testLL.equals(revList2));
		assertTrue("DoublyLinkedList should be reversed", testDLL.equals(revList3));
	}
	
	@Test
	public void testDoublyLinkedListRemoveAll() {
		int test1 = doublyLinkedList.removeAll("JuanO");
		int test2 = doublyLinkedList2.removeAll("Wilson");
		int test3 = doublyLinkedList3.removeAll("JuanO");

		assertTrue("Removed copies should be 2 " + " instead got " + test1, test1 == 2);
		assertTrue("Removed copies should be 1 " + " instead got " + test2, test2 == 1);
		assertTrue("Removed copies should be 2 " + " instead got " + test3, test3 == 2);
	}

	@Test
	public void testDoublyLinkedListRemoveObject() {
		boolean test1 = doublyLinkedList.remove("Bienve");
		boolean test2 = doublyLinkedList2.remove("Wilson");
		boolean test3 = doublyLinkedList3.remove("Pedro");
		
		assertTrue("Should have removed Bienve", test1 == true);
		assertTrue("Should have removed Wilson", test2 == true);
		assertTrue("Should have removed Pedro", test3 == true);

	}
	
	@Test
	public void testDoublyLinkedListRemoveAtIndex() {
		boolean test1 = doublyLinkedList.remove(5); //Manuel
		boolean test2 = doublyLinkedList2.remove(6); //Arzuaga
		boolean test3 = doublyLinkedList3.remove(2); //Bienve
		
		assertTrue("Should have removed Manual", test1 == true);
		assertTrue("Should have removed Arzuaga", test2 == true);
		assertTrue("Should have removed Bienve", test3 == true);
	}
	@Test
	public void testDoublyLinkedListAdd() {
		String str = "Added Element";
		String str2 = "Added another Element";
		String str3 = "Added one more Element";

		doublyLinkedList.add(str);
		doublyLinkedList2.add(str2);
		doublyLinkedList3.add(str3);
		
		assertTrue("Added Element is not in Linked List", doublyLinkedList.contains(str));
		assertTrue("Added Element is not in Linked List", doublyLinkedList2.contains(str2));
		assertTrue("Added Element is not in Linked List", doublyLinkedList3.contains(str3));
		
	}
	
	@Test
	public void testDoublyLinkedListAddAtIndex() {
		Random rand = new Random();
		
		int randIndex1 = rand.nextInt(DEFAULT_SIZE - 1);
		int randIndex2 = rand.nextInt(DEFAULT_SIZE - 1);
		int randIndex3 = rand.nextInt(DEFAULT_SIZE - 1);
		
		String str = "Added Element";
		String str2 = "Added another Element";
		String str3 = "Added one more Element";

		doublyLinkedList.add(randIndex1, str);
		doublyLinkedList2.add(randIndex2, str2);
		doublyLinkedList3.add(randIndex3, str3);
		
		assertTrue("Added Element is not in Linked List at position indicated", doublyLinkedList.get(randIndex1).equals(str));
		assertTrue("Added Element is not in Linked List at position indicated", doublyLinkedList2.get(randIndex2).equals(str2));
		assertTrue("Added Element is not in Linked List at position indicated", doublyLinkedList3.get(randIndex3).equals(str3));
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	private void loadDefaultArrayList(ArrayList<String> l) {
		l.add("JuanO");
		l.add("Bienve");
		l.add("Wilson");
		l.add("JuanO");
		l.add("Pedro");
		l.add("Arzuaga");
		l.add("Manuel");
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	private void loadDefaultArrayList2(ArrayList<String> l) {
		l.add("JuanO");
		l.add("JuanO");
		l.add("Wilson");
		l.add("JuanO");
		l.add("Pedro");
		l.add("Arzuaga");
		l.add("Manuel");
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	private void loadDefaultArrayList3(ArrayList<String> l) {
		l.add("JuanO");
		l.add("Bienve");
		l.add("Wilson");
		l.add("JoseMelendez");
		l.add("Pedro");
		l.add("Arzuaga");
		l.add("Manuel");
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private void loadDefaultLinkedList(LinkedList<String> l) {
		l.add("JoseMelendez");
		l.add("Bienve");
		l.add("Wilson");
		l.add("JoseMelendez");
		l.add("Pedro");
		l.add("JoseMelendez");
		l.add("Manuel");
	}
	@SuppressWarnings({"rawtypes", "unchecked"})
	private void loadDefaultLinkedList2(LinkedList<String> l) {
		l.add("JoseMelendez");
		l.add("Bienve");
		l.add("JoseMelendez");
		l.add("JuanO");
		l.add("Pedro");
		l.add("Arzuaga");
		l.add("Manuel");
	}
	@SuppressWarnings({"rawtypes", "unchecked"})
	private void loadDefaultLinkedList3(LinkedList<String> l) {
		l.add("JuanO");
		l.add("Bienve");
		l.add("Wilson");
		l.add("JoseMelendez");
		l.add("JoseMelendez");
		l.add("JoseMelendez");
		l.add("Manuel");
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	private void loadDefaultDoublyLinkedList(DoublyLinkedList<String> l) {
		l.add("JuanO");
		l.add("Bienve");
		l.add("Wilson");
		l.add("JuanO");
		l.add("Pedro");
		l.add("Arzuaga");
		l.add("Manuel");
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	private void loadDefaultDoublyLinkedList2(DoublyLinkedList<String> l) {
		l.add("JuanO");
		l.add("Bienve");
		l.add("Wilson");
		l.add("JuanO");
		l.add("Pedro");
		l.add("Arzuaga");
		l.add("Manuel");
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	private void loadDefaultDoublyLinkedList3(DoublyLinkedList<String> l) {
		l.add("JuanO");
		l.add("Bienve");
		l.add("Wilson");
		l.add("JuanO");
		l.add("Pedro");
		l.add("Wilson");
		l.add("Manuel");
	}
}
