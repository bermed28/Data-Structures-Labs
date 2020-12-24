package ciic4020.lab7.map.studentRecord;

import ciic4020.lab7.linkedlist.List;
import ciic4020.lab7.map.HashTableSC;
import ciic4020.lab7.map.Map;
import ciic4020.lab7.map.SimpleHashFunction;

public class MapTest {

	public static void main(String[] args) {
		Map<String, Student> map = new HashTableSC<String, Student>(2, new SimpleHashFunction<String>());
		Map<Integer, Integer> m = new HashTableSC<Integer, Integer>(5, new SimpleHashFunction<Integer>());

		m.put(15, 15);
		m.put(16, 16);
		m.put(14, 14);
		m.put(4, 4);
		m.put(8, 8);
		
		m.print(System.out);

//		Student s1 = new Student("123", "Apu", "Smith", 18, 4.0, "San Juan");
//		Student s2 = new Student("647", "Xi",  "Li",    19, 2.0, "Mayaguez");
//		Student s3 = new Student("934", "Amy", "Wo",    22, 3.0, "Ponce");
//		Student s4 = new Student("12",  "Bo",  "Ron",   30, 1.0, "Aguadilla");
//
//		map.put(s1.getStudentID(), s1);
//		map.put(s2.getStudentID(), s2);
//		map.put(s3.getStudentID(), s3);
//		map.put(s4.getStudentID(), s4);
//		map.print(System.out);
//
//		System.out.println("\nAdding with same key (647)");
//		Student s5 = new Student("647", "Mi", "Mo", 31, 2.5, "Yauco");
//		map.put(s5.getStudentID(), s5);
//		map.print(System.out);
//		
//		System.out.println("\nElement with key 934: " + map.get("934"));
//		System.out.println("Element with key 92: " + map.get("92"));
//		System.out.println("Removing element with key 934: " + map.remove("934"));
//		System.out.println("After remove, get with key 934: " + map.get("934"));
//		
//		System.out.println("\nAdding element with key 111");
//		map.put("111", new Student("111", "Ron", "Clark", 19, 3.90, "Arecibo"));
//		map.print(System.out);
//		
//		System.out.println("\nPrinting keys");
//		printKeys(map.getKeys());
//		System.out.println("Printing values");
//		printValues(map.getValues());
//		
//		System.out.println("\nSize of map: " + map.size());
//		System.out.println("Map contains 111: " + map.containsKey("111"));
//		System.out.println("Map contains 934: " + map.containsKey("934"));
//		System.out.println("Map is empty: " + map.isEmpty());
//		System.out.println("Clearing the map...");
//		map.clear();
//		System.out.println("Map is empty: " + map.isEmpty());
//
//		System.out.println("Done!");
//	}
	}

	private static void printKeys(List<String> keys) {
		for (String s : keys)
			System.out.println(s);
	}

	private static void printValues(List<Student> values) {
		for (Student s : values)
			System.out.println(s);
	}
}