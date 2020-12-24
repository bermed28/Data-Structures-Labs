package ciic4020.bag.test;

import java.util.Scanner;

import ciic4020.bag.Bag;
import ciic4020.bag.DynamicBag;
import ciic4020.bag.StaticBag;

public class BagTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("This program supports static (S) and dynamic (D) bags!");
		System.out.println("What type of bag do you wish to use (S/D): ");
		String input = in.nextLine();
		Bag theBag;
		
		if (input.equals("S")) {
			theBag = new StaticBag(7);
		} else if (input.equals("D")) {
			theBag = new DynamicBag(7);
		} else {
			in.close();
			throw new IllegalArgumentException("Option not recognized");
		}
		
		theBag.add("Bob");
		theBag.add("Jil");
		theBag.add("Ned");
		theBag.add("Bob");
		theBag.add("Ned");
		theBag.add("Bob");
		//theBag.add("Bob");
		//theBag.add("Bob");
		printBag(theBag);

		System.out.println("Is Bob member of the bag?: " + theBag.isMember("Bob"));
		System.out.println("Is Amy member of the bag?: " + theBag.isMember("Amy"));
		System.out.println("Copies of Bob in the Bag: "+ theBag.count("Bob"));
		System.out.println("Copies of Jil in the Bag: "+ theBag.count("Jil"));
		System.out.println("Copies of Ned in the Bag: "+ theBag.count("Ned"));
		theBag.eraseAll("Ned");
		System.out.println("Copies of Ned in the Bag: "+ theBag.count("Ned"));
		theBag.add("Bob");
		System.out.println("Copies of Bob in the Bag: "+ theBag.count("Bob"));
		System.out.println("Is the Bag empty: " + theBag.isEmpty());
		printBag(theBag);
		theBag.clear();
		System.out.println("Is the Bag empty: " + theBag.isEmpty());
		System.out.println("Elements:");
		printBag(theBag);

		System.out.println("Done!");
		in.close();
	}

	private static void printBag(Bag theBag) {
		for (Object obj : theBag)
			System.out.println(obj);
		System.out.println("Bag size: " + theBag.size());
	}
}
