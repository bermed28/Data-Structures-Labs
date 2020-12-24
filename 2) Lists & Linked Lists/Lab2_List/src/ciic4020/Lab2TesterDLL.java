/* Change package name accordingly -- JOL */
package ciic4020;

//import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/* I recommend having everything in a single project.  For example, I copied interfaces and classes into ciic4020.lab2 -- JOL */
import ciic4020.linkedlist.*;


public class Lab2TesterDLL {
	
	private List<String> l_1;
	private List<String> l_2;
	private List<String> l_3;
	
	private List<String> dl_1;
	private List<String> dl_2;
	private List<String> dl_3;
	
	@Before
	public void setUp() throws Exception{
		
		l_1 = new LinkedList<String>();
		l_2 = new LinkedList<String>();
		l_3 = new LinkedList<String>();
		
		dl_1 = new DoublyLinkedList<String>();
		dl_2 = new DoublyLinkedList<String>();
		dl_3 = new DoublyLinkedList<String>();
		
		l_1.add("Mark");
		l_1.add("Henry");
		l_1.add("John");
		l_1.add("Kimberly");
		l_1.add("John");
		l_1.add("Hideo");
		l_1.add("Ian");
		
		l_2.add("Trevor");
		l_2.add("Henry");
		l_2.add("Tim");
		l_2.add("Kimberly");
		l_2.add("Tim");
		l_2.add("Tim");
		l_2.add("Ian");
		
		l_3.add("James");
		l_3.add("Albert");
		l_3.add("Kevin");
		l_3.add("Tom");
		l_3.add("Roger");
		l_3.add("Juan");
		l_3.add("Lil");
		
		dl_1.add("Jil");
		dl_1.add("Ned");
		dl_1.add("Bob");
		dl_1.add("Jil");
		dl_1.add("Amy");
		dl_1.add("Kim");
		
		dl_2.add("Kim");
		dl_2.add("Ron");
		dl_2.add("Ron");
		dl_2.add("Jil");
		dl_2.add("Ron");
		dl_2.add("Ron");
		
		dl_3.add("Amy");
		dl_3.add("Kim");
		dl_3.add("Ron");
		dl_3.add("Jil");
		dl_3.add("Amy");
		dl_3.add("Ned");
	}
	
	@Test
	public void testReplace() {
		int result = l_1.replaceAll("John", "Bob");
		assertTrue("It should return 2.", result == 2);
		assertTrue("The List should contain Bob.", l_1.contains("Bob") == true);
		assertTrue("There is no John.", l_1.contains("John") != true);
	}
	
	
	@Test
	public void add() {
		dl_1.add("Amy");
		assertTrue("Amy is the last one.", dl_1.lastIndex("Amy") == dl_1.size()-1);
	}
	
	@Test
	public void addAtIndex() {
		dl_3.add(2,"Xi");
		assertTrue("Xi should be at index 2.", dl_3.firstIndex("Xi") == 2);
	}
	
	@Test
	public void isEmpty() {
		dl_1.clear();
		assertTrue("List is empty.", dl_1.isEmpty() == true);
		assertTrue("List is not empty.", dl_2.isEmpty() == false);
	}
	
	@Test
	public void remove() {
		assertTrue("Jil was removed.", dl_1.remove("Jil") == true);
		dl_2.remove("Ron");
		assertTrue("Last index should be 4.", dl_2.lastIndex("Ron") == 4);
	}
	
	@Test
	public void removeAtIndex() {
		String temp = dl_1.get(3);
		dl_1.remove(3);
		assertTrue("The size after remove must be 5.", dl_1.size() == 5);
		assertTrue("Now at index 3 must be Amy", dl_1.get(3).equals("Amy") == true);
		assertTrue("The element removed was Jil.", temp.equals("Jil"));
	}
	
	@Test
	public void removeAll() {
		assertTrue("Result should be 4.", dl_2.removeAll("Ron") == 4);
	}
	
	@Test
	public void getAtIndex() {
		String temp = dl_1.get(3);
		assertTrue("The String must be Jil.", temp.equals("Jil"));
	}
	
	@Test
	public void setObjectAtIndex() {
		dl_1.set(2, "Janice");
		String temp = "Janice";
		assertTrue("Janice is at position 2.", dl_1.get(2).equals(temp));
		assertTrue("It is not the element before.", !dl_1.get(2).equals("Bob"));
	}
	
	@Test
	public void first() {
		assertTrue("The first object must be Kim.", dl_2.first().equals("Kim") == true);
	}
	
	@Test
	public void last() {
		assertTrue("The Last object must be Ned", dl_3.last().equals("Ned") == true);
	}
	
	@Test
	public void firstIndex() {
		assertTrue("The first index should be 2.", dl_1.firstIndex("Bob") == 2);
		assertTrue("The first index should be 3.", dl_2.firstIndex("Jil") == 3);
		assertTrue("The first index should be 0.", dl_3.firstIndex("Amy") == 0);
	}
	
	@Test
	public void lastIndex() {
		assertTrue("The last index should be 5.", dl_2.lastIndex("Ron") == 5);
		assertTrue("The last index should be 5.", dl_3.lastIndex("Ned") == 5);
		assertTrue("The last index should be 3.", dl_1.lastIndex("Jil") == 3);
	}
	
	@Test
	public void size() {
		assertTrue("The size must be 6.", dl_1.size() == 6);
		dl_2.remove(0);
		dl_2.remove(0);
		assertTrue("After 2 removes size must be 4.", dl_2.size() == 4);
	}
	
	@Test
	public void contains() {
		assertTrue("This list should contain Amy", dl_1.contains("Amy") == true);
		
	}
	
	@Test
	public void clear() {
		dl_1.clear();
		assertTrue("This list should be empty.", dl_1.size() == 0);
	}
	
}
