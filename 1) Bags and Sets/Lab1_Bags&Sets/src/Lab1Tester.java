

//REMOVE PACKAGE DECLARATION IF NEEDED
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ciic4020.bag.Bag;
import ciic4020.bag.DynamicBag;
import ciic4020.bag.StaticBag;
import ciic4020.set.DynamicSet;
import ciic4020.set.Set;
import ciic4020.set.StaticSet;

public class Lab1Tester {
	
	private Bag bag_d, bag_s;
	private Set<String> set_d, set_s;
	private int DEFAULT_SIZE = 7;

	@Before
	public void setUp() throws Exception {
		bag_d = new DynamicBag(DEFAULT_SIZE);
		bag_s = new StaticBag(DEFAULT_SIZE);
		set_d = new DynamicSet<String>(DEFAULT_SIZE);
		set_s = new StaticSet<String>(DEFAULT_SIZE);

		load_default_bag_2(bag_d);
		load_default_bag(bag_s);
		load_default_set_2(set_d);
		load_default_set(set_s);
	}

	@Test
	public void testMoreFrequent() {
		Bag b_1 = bag_s.moreFrequentThan("James");
		assertTrue("Resulting bag must be empty", b_1.isEmpty());
		b_1 = bag_s.moreFrequentThan("");
		assertTrue("Resulting bag must have all the individual names", b_1.isMember("James") &&
																	   b_1.isMember("Rick") &&
																	   b_1.isMember("Dio") &&
																	   b_1.isMember("Carl"));
		b_1 = bag_s.moreFrequentThan("Dio");
		assertTrue("Resulting bag must only contain James", b_1.size() == 1 && b_1.isMember("James"));
	}
	
	@Test
	public void testEquals() {
		 Set<String> s_1 = set_d;
		 Set<String> s_2 = set_s;
		 Set<String> s_3 = new StaticSet<>(DEFAULT_SIZE);
		 Set<String> s_4 = new StaticSet<>(DEFAULT_SIZE);
		 load_default_set(s_3);
		 load_default_set_2(s_4);

		 assertFalse("Sets are not equal", s_1.equals(s_2));
		 assertTrue("Sets are equal", s_1.equals(s_4));
		 assertTrue("Sets are equal", s_2.equals(s_3));

	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testDisjoint() {
		/* Below we use StaticSet, but could have also used DynamicSet instead */
		Set<Integer>[] sets = new StaticSet[4];
		Set<Integer> s_1 = new StaticSet<Integer>(DEFAULT_SIZE);
		Set<Integer> s_2 = new StaticSet<Integer>(DEFAULT_SIZE);
		Set<Integer> s_3 = new StaticSet<Integer>(DEFAULT_SIZE);
		Set<Integer> s_4 = new StaticSet<Integer>(DEFAULT_SIZE);
		
		for (int i = 3; i < 10; i+=3)
			s_1.add(i);
		for (int i = 2; i < 10; i+=2)
			s_2.add(i);
		for (int i = 2; i < 10; i+=4)
			s_3.add(i);
		for (int i = 1; i < 10; i+=2)
			s_4.add(i);
		
		sets[0] = s_1;
		sets[1] = s_2;
		sets[2] = s_3;
		sets[3] = s_1; // repeat set to avoid empty intersection

		boolean check = Main.checkDisjoint(sets);
		assertTrue("Currently there are no disjointed sets", check == false);
		sets[3] = s_4;
		check = Main.checkDisjoint(sets);
		assertTrue("Currently there are disjointed sets", check == true);
	}


	@Test
	public void testSingleton() {
		Set<String> s_1 = new DynamicSet<>(DEFAULT_SIZE);
		Set<String> s_2 = new DynamicSet<>(DEFAULT_SIZE);
		Set<String> s_3 = new DynamicSet<>(DEFAULT_SIZE);
		Set<String> s_4 = new DynamicSet<>(DEFAULT_SIZE);
		
		load_default_set(s_1);
		load_default_set_2(s_2);
		load_default_set_3(s_3);
		load_default_set_4(s_4);
		
		Set<Set<String>> singl_1 = s_1.singletonSets();
		assertTrue("Should have same size",  singl_1.size() == s_1.size());
		for (Set<String> set : singl_1) {
			assertTrue("Singleton should have only 1 element", set.size() == 1);
			for (String subElement : set) {
				assertTrue("Singleton element not in original set", s_1.isMember(subElement));
				s_1.remove(subElement);
			}
		}
		assertTrue("Should be now empty", s_1.isEmpty());
	}
	
	//BAG-BUILDERS (TRY NOT TO TAMPER IT TOO MUCH)
	private void load_default_bag(Bag b) {
		b.add("James");
		b.add("Rick");
		b.add("Dio");
		b.add("James");
		b.add("James");
		b.add("Dio");
		b.add("Carl");

	}private void load_default_bag_2(Bag b) {
		b.add("James");
		b.add("Rick");
		b.add("Dio");
		b.add("Carl");
		b.add("James");
		b.add("Rick");
		b.add("Carl");

	}
	//SET-BUILDERS
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void load_default_set(Set s) {
		s.clear();
		s.add("James");
		s.add("Rick");
		s.add("Dio");
		s.add("Carl");
		s.add("Jorge");
		s.add("Pedro");
		s.add("Ramon");
		
	}@SuppressWarnings({ "rawtypes", "unchecked" })
	private void load_default_set_2(Set s) {
		s.clear();
		s.add("James");
		s.add("Rick");
		s.add("Dio");
		s.add("Carl");
		s.add("Raul");
		s.add("Rodrigo");
		s.add("Ramon");
	}@SuppressWarnings({ "rawtypes", "unchecked" })
	private void load_default_set_3(Set s) {//if used it supposed to be disjointed
		s.clear();
		s.add("Freddy");
		s.add("Roger");
		s.add("Albert");
		s.add("Thomas");
		s.add("Tego");
		s.add("Benito");
		s.add("Rey");
	}@SuppressWarnings({ "rawtypes", "unchecked" })
	private void load_default_set_4(Set s) {
		s.clear();
		s.add("James");
		s.add("Kathy");
		s.add("Dio");
		s.add("Carl");
		s.add("Raul");
		s.add("Liz");
		s.add("Eliut");
	}
}