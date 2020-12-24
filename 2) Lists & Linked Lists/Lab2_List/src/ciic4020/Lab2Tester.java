package ciic4020;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ciic4020.linkedlist.DoublyLinkedList;
import ciic4020.linkedlist.LinkedList;
import ciic4020.list.ArrayList;

public class Lab2Tester {

	private ArrayList<String> l_1, l_2, l_3;
	private LinkedList<String> sl_1, sl_2, sl_3;
	private DoublyLinkedList<String> dl_1, dl_2, dl_3;
	private int DEFAULT_SIZE = 7;

	@Before
	public void setUp() throws Exception {
		l_1  = new ArrayList<>(DEFAULT_SIZE);
		l_2  = new ArrayList<>(DEFAULT_SIZE);
		l_3  = new ArrayList<>(DEFAULT_SIZE);
		sl_1 = new LinkedList<>();
		sl_2 = new LinkedList<>();
		sl_3 = new LinkedList<>();
		dl_1 = new DoublyLinkedList<>();
		dl_2 = new DoublyLinkedList<>();
		dl_3 = new DoublyLinkedList<>();

		load_default_1(l_1);
		load_default_1(sl_1);
		load_default_1(dl_1);
		load_default_2(l_2);
		load_default_2(sl_2);
		load_default_2(dl_2);
		load_default_3(l_3);
		load_default_3(sl_3);
		load_default_3(dl_3);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testTotalCount() {
		List<String>[] lists = new List[6];
		lists[0] = l_1;
		lists[1] = l_2; 
		lists[2] = sl_1;
		lists[3] = sl_2;
		lists[4] = dl_3;
		lists[5] = l_3;
		assertTrue("Should return 4" , Main.totalCount("Ian", lists) == 4); //WAS CHANGED TO Main.totalCount() because method total count is in Main.java
		assertTrue("Should return 6" , Main.totalCount("Tim", lists) == 6);
		assertTrue("Should return 2" , Main.totalCount("Lil", lists) == 2);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testReplace() {
		int result_1, result_2, expCount;
		List<String>[] lists = new List[6];
		lists[0] = l_1;
		lists[1] = l_2; 
		lists[2] = sl_1;
		lists[3] = sl_2;
		lists[4] = dl_1;
		lists[5] = dl_2;
		String[] lNames = {"ArrayList", "SLL", "DLL"};
		
		for (int i = 0; i < lists.length; i += 2) {
			result_1 = lists[i].replaceAll("Ian", "Bob");
			expCount = 1;
			assertTrue(lNames[i/2] + ") Ian should no longer be in the list", lists[i].firstIndex("Ian") == -1 && !lists[i].contains("Ian"));
			assertTrue(lNames[i/2] + ") Bob should now be in the list", lists[i].contains("Bob"));
			assertTrue(lNames[i/2] + ") Should have made " + expCount + " replacement(s)", result_1 == expCount);
			result_2 = lists[i+1].replaceAll("Tim", "Kimberly");
			expCount = 3;
			assertFalse(lNames[i/2] + ") Tim should no longer be in the list", lists[i+1].firstIndex("Tim") == -1 && lists[i+1].contains("Tim"));
			assertTrue(lNames[i/2] + ") Kimberly should now be in the list", lists[i].contains("Kimberly"));
			assertTrue(lNames[i/2] + ") Should have made " + expCount + " replacement(s)", result_2 == expCount);			
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testReverse() {
		List<String>[] lists = new List[3];
		lists[0] = l_1;
		lists[1] = sl_1;
		lists[2] = dl_1;
		String[] lNames = {"ArrayList", "SLL", "DLL"};

		for (int i = 0; i < lists.length; i++) {
			List<String> result_1 = lists[i].reverse();
			assertTrue(lNames[i] + ") The amount of elements have changed", result_1.size() == lists[i].size());
			for (String s : result_1)
				assertTrue(lNames[i] + ") Element is not in original list", lists[i].contains(s));
			for (int j = 0; j < lists[i].size(); j++)
				assertTrue(lNames[i] + ") Elements in inverted positions are not the same", lists[i].get(lists[i].size() - 1 - i).equals(result_1.get(i)));
		}
	}

	@Test
	public void testDoublyLinkedList() {
		sl_1.remove(2);
		dl_1.remove(2);
		sl_2.removeAll("Tim");
		dl_2.removeAll("Tim");
		for (int i = 0; i < sl_1.size(); i++) {
			assertTrue("Elements are not equal in the same index (1)", sl_1.get(i).equals(dl_1.get(i)));
		}
		for (int i = 0; i < sl_2.size(); i++) {
			assertTrue("Elements are not equal in the same index (2)", sl_2.get(i).equals(dl_2.get(i)));
		}
		
		dl_3.remove("Tom");
		
		assertFalse("It should not contain Tom", dl_3.contains("Tom")); 

	}
	
	/////////////////////////////////////////////
	//DEFAULT LOADERS
	private void load_default_1(List<String> l) {
		l.add("Mark");
		l.add("Henry");
		l.add("John");
		l.add("Kimberly");
		l.add("John");
		l.add("Hideo");
		l.add("Ian");
	}
	private void load_default_2(List<String> l) {
		l.add("Trevor");
		l.add("Henry");
		l.add("Tim");
		l.add("Kimberly");
		l.add("Tim");
		l.add("Tim");
		l.add("Ian");
	}
	private void load_default_3(List<String> l) {
		l.add("James");
		l.add("Albert");
		l.add("Kevin");
		l.add("Tom");
		l.add("Roger");
		l.add("Juan");
		l.add("Lil");
	}
}
