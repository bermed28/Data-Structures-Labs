package excercises;
import java.util.Scanner;

import dataStructures.DoublyLinkedQueue;
import dataStructures.LinkedListStack;


public class Palindromes {

	public static void main(String[] args) {
		String str = "";
		Scanner scan = new Scanner(System.in);
		while(!str.equals("done")) {
			System.out.println("Enter the word you wish to check if it's a Palindrome: Type 'done' & press Enter to finish program");
			str = scan.nextLine();
			boolean bool = isPalindrome(str);
			if(!str.equals("done")) {
				if (bool ) {
					System.out.println("Is Palindrome");
				} else {
					System.out.println("Not a Palindrome");
				}
			} else {
				System.out.println("Thank you for using our program!");
			}
		}
	}
	
	public static boolean isPalindrome(String s) {
		/**
		 * First we remove any unnecessary cases from the string to be evaluated
		 */
		s = ignoreCase(s);
		if (s.isEmpty()) 
			return true;

		LinkedListStack<Character> stack = new LinkedListStack<Character>();
		DoublyLinkedQueue<Character> queue = new DoublyLinkedQueue<Character>();

		/**
		 * Next we create 1 stack and 1 queue for evaluation 
		 * and start iterating through our string.
		 * 
		 * Once we start, we push and enqueue each character of the string so 
		 * we can compare the string forwards and backwards (
		 * 
		 * (Remember: Stacks are LIFO, Queues are FIFO 
		 * so the stack and queue will add each char in the opposite 
		 * direction of each other)
		 * 
		 */
		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
			queue.enqueue(s.charAt(i));	
		}

		/**
		 * Now that we've added our string, it's time to compare.
		 * We do this by checking the front and top of the stack & queue, 
		 * while the stack & queue are not empty and the front and top are the same,
		 * we can conclude that so far the string is a palindrome so we can discard that character
		 * so we just remove it from both structures.
		 */
		while(stack.top() == queue.front() && !stack.isEmpty() && !queue.isEmpty()) {
			stack.pop();
			queue.dequeue();
		}
		
		/**
		 * If it breaks out of the while it means we either concluded that the string is or isn't a palindrome
		 * if the stack & queue are empty it means we traversed the whole string and each char is the same, meaning
		 * that the string is a palindrome. If they're not empty it emas that one char wasn't the same, so we conclude it 
		 * isn'a a palindrome
		 */
		return stack.isEmpty() && queue.isEmpty();
	}


	public static String ignoreCase(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				result += String.valueOf(s.charAt(i));

			}
		}
		result = result.toLowerCase();
		return result;
	}
}
