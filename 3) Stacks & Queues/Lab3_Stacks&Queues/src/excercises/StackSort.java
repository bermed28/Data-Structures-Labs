package excercises;

import dataStructures.ArrayList;
import java.util.Scanner;

import dataStructures.ArrayStack;
import interfaces.Stack;

public class StackSort {

	public static ArrayList<Integer> storedValues = new ArrayList<>(10);
	public static Stack<Integer> leftStack = new ArrayStack<>(10);
	public static Stack<Integer> rightStack = new ArrayStack<>(10);
	public static String value;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		stackSort(scan);

	}


	public static void stackSort(Scanner s) {
		System.out.println("Enter a number, press Enter to finish");

		
		 Scanner sc = new Scanner(System.in);

		    while(true){
		        String line = sc.nextLine();
		        if(line.equalsIgnoreCase("")){
		            break;
		        }
		        else{
		            
		            storedValues.add(Integer.valueOf(line));
		        } 
		    }

		    /*
		     * 			
		     *   0		2		
		     *  -3		12
		     * 	-5		18	
		     */
		for (Integer number : storedValues) {
			if (leftStack.isEmpty() || rightStack.isEmpty()) {
				if(leftStack.isEmpty())
					leftStack.push(number);
				else 
					rightStack.push(number);
				
			} else {
				if (leftStack.top() == number || rightStack.top() == number) {
					if(leftStack.top() == number)
						leftStack.push(number);
					else 
						rightStack.push(number);
				}
				else if(leftStack.top() < number) {
					if (rightStack.top() > number) {
						rightStack.push(number);
					} else {
						while(!rightStack.isEmpty() && rightStack.top() < number) 
							leftStack.push(rightStack.pop());
						rightStack.push(number);
					}
				
				} else if(number < rightStack.top()) {
					if (leftStack.top() < number) {
						leftStack.push(number);
					} else {
						while (!leftStack.isEmpty() && leftStack.top() > number) {
							rightStack.push(leftStack.pop());
						}
						leftStack.push(number);
					}
				}
				
			}
			
		}

	

		while(!leftStack.isEmpty())
			rightStack.push(leftStack.pop());
		
		System.out.println("Sorted Stack is: ");
		
		while (!rightStack.isEmpty()) 
			System.out.println(rightStack.pop());
		
	}


}
