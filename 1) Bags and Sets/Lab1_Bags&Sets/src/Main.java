import ciic4020.set.Set;
import ciic4020.set.StaticSet;

public class Main {

	public static void main(String[] args) {

		Set<String> S1 =  new StaticSet<String>(5);
		Set<String> S2 =  new StaticSet<String>(5);
		Set<String> S3 =  new StaticSet<String>(5);

		S1.add("Juano");
		S1.add("Bienve");
		S1.add("Seguel");
		S1.add("Kejie");
		S1.add("Wilson");

		S2.add("B1");
		S2.add("B2");
		S2.add("Juano");
		S2.add("B4");
		S2.add("B5");

		S3.add("Juano");
		S3.add("S2");
		S3.add("S3");
		S3.add("S4");
		S3.add("S5");

		Object[] sets = new Object[3];
		sets[0] = S1;
		sets[1] = S2;
		sets[2] = S3;
		System.out.println(checkDisjoint(sets));



	}

	public static boolean checkDisjoint(Object[] sets) {


		/* (((S1^S2)^S3)^S4) approach
		 * result = S1
		 * i = 1
		 * while result is not empty and i < sets length
		 * 		if loop finds first instance of empty intersection
		 * 			return true
		 * 		if not, add the intersection to result to keep searching
		 *		increment i 
		 *if it breaks out of loop, return false
		 */		


		Set<Integer> result = ((Set<Integer>) sets[0]); //Save first set to start search

		int i = 1; //index to traverse sets

		while (!result.isEmpty() && i < sets.length) { //While it hasn't found first instance of empty intersection 
//																&& it hasn't finished traversing array
			
			if (result.intersection(((Set<Integer>)sets[i])).isEmpty()) { //Check if the intersection of the set you saved with the next one is empty
				return true;
			}

			result = result.intersection(((Set<Integer>)sets[i])); //if it isn't, save that intersection to check the next intersection
			i++;		

		}
		
		return false; //if it breaks out of the loop, it never found an empty intersection
	}

}
