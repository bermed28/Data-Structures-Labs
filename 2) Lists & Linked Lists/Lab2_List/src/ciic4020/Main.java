package ciic4020;

public class Main {

	public static void main(String[] args) {
	}
	
	public static int totalCount(String s, List<String>[] lists) {

		int result = 0;
		for (int i = 0; i < lists.length; i++) {
			for (String str : lists[i]) {
				if (str.equals(s)) {
					result++;
				}
			}
		}
		
		return result;

	}

}
