package excercises;

import java.util.Scanner;
import dataStructures.ArrayStack;
import interfaces.Stack;

public class Fully_Paren {

	private static final int DEFAULT_SIZE = 10;
	public static Stack<Integer> operands = new ArrayStack<>(DEFAULT_SIZE);
	public static Stack<Character> postfixStorage = new ArrayStack<>(DEFAULT_SIZE); //Stack that will hold our operators and parens for postfix conversion
	private static Integer[] variableValues = new Integer[26];
	private static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		fullyParens();

	}

	public static void fullyParens() {
		System.out.println("Enter expressions to evaluate, press Enter to finish");
		String postfixExp = "";
		Scanner sc = new Scanner(System.in);
		while (true) {
			String line = sc.nextLine();
			if (line.equalsIgnoreCase("")) {
				break;
			} else {
				//We check what type of expression is being read
				if (line.contains("=")) {
					//If it's a variable assignment (e.g. A=3), we save the index of said variable from the position of the alphabet
					//After that, we just save the value it was assigned to it by the user
					try {
						int index = ALPHABET.indexOf(line.charAt(0));
						variableValues[index] = Integer.valueOf(line.substring(line.indexOf('=') + 1));

					}catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Input entered Incorrectly, enter input in this format: CAPITAL_LETTER=#");
					}

				}
				//If its an operation, we gotta do a bit more work
				if (line.contains(":")) {
					try {

						/**
						 * First we save the variable to store the result of the operation inside var
						 * then we take the rest of the operation and convert it to postFix notation (see converToPostfix() for more)
						 */
						String var = line.substring(0, line.indexOf(':'));
						line = line.substring(line.indexOf(':') + 1);
						postfixExp = convertToPostfix(line);
						//If the method returns "is Invalid, just tell the user it was invalid, if not we start evaluating the expression
						//If you notice we disregard parens in our evaluation, because convertToPostfix we takes care of the task of verifying if the parens are balanced
						if(!postfixExp.contains("is Invalid")) {

							/**
							 * In here, we check if the char were looking at is either an operand (Variable [letter]) 
							 * or an operator (addition, subtraction, division, mult)
							 */
							for (int i = 0; i < postfixExp.length(); i++) {

								//If it's an operand, find the value of that variable inside our variable storing array & push it to the operand stack 
								if(ALPHABET.contains(String.valueOf(postfixExp.charAt(i)))){
									int index = ALPHABET.indexOf(postfixExp.charAt(i));
									operands.push(Integer.valueOf(variableValues[index]));
								}


								//If its an operator we check which operator it is
								if (isOperator(postfixExp.charAt(i))) {
									int operation = 0;
									//If it's a sum or a mult, we just do the operation immediately by summing or mult the first two pops of the stack
									if (postfixExp.charAt(i) == '+') {
										operation = operands.pop() + operands.pop();
									}

									/**
									 * If it's a subtraction or division, we save the first and second pop of he stack and we subtract/divide 
									 * in the order they were pushed 
									 * e.g. S = {4,2}
									 * 
									 * op1 = 2;
									 * op2 = 4;
									 * 
									 * operation = 4-2 = 2 OR operation = 4/2 = 2
									 * 
									 * 4/2 != 2/4 OR 4-2 != 2-4
									 */
									if (postfixExp.charAt(i) == '-') {
										int op1 = operands.pop();
										int op2 = operands.pop();
										operation = op2 - op1;
									}

									if (postfixExp.charAt(i) == '*') {
										operation = operands.pop() * operands.pop();
									}
									if (postfixExp.charAt(i) == '/') {
										int op1 = operands.pop();
										int op2 = operands.pop();
										operation = op2 / op1;
									}

									//Once we did our operation, just push the result back to the operand stack
									operands.push(operation);
								}

							}
							/**
							 * Once we finish the operation, 
							 * we check the index of the variable we saved in var 
							 * and store that operation in the position of var inside our array
							 * 
							 * (e.g. 	A=2
							 * 			A=[A*A]
							 * 			Then index = 0, given it's the first letter in the alphabet, so it's index is 0,
							 * 			then variableValues[index] = A*A = 2*2 = 4
							 */

							int index = ALPHABET.indexOf(var);
							variableValues[index] = operands.pop();


						} else {
							System.out.println(var + ":" + postfixExp);
						}
					}catch(Exception e) {
						/**
						 * If an IndexOutOfBounds occurs, it means that the user did not enter the correct format of input.
						 * This means that the ALPHABET.indexOf() returned -1, so to avoid the program from crashing, 
						 * we just alert the user and continue looking for input
						 */
						System.out.println("Expression is Invalid or Input entered correctly. Format is: CAPITAL_LETTER:(EXPRESSION)");
						System.out.println("Make sure you only use variables you have entred previously in input");
						continue;
					}

				}


			}
		}
		//Here we just print the values of the inputs given into a small table-like print
		System.out.println("The final symbol table is: \n");
		System.out.println("Variable \t" + "Value");
		for (int i = 0; i < variableValues.length; i++) {
			if (variableValues[i] != null) {
				System.out.println(ALPHABET.charAt(i) + "\t\t" +  variableValues[i]);
			}
		}
	}

	public static String convertToPostfix(String infix) {
		String postfix = "";//Resulting string with our operation to be evaluated

		/**
		 * If the string has balanced parentheses (check hasBalancedParens() for more), 
		 * then we convert the infix operation to postFix disregarding parentheses
		 */
		if(hasBalancedParens(infix)) {
			for (int i = 0; i < infix.length(); i++) {
				//If it's an operand append it to the string
				if (Character.isLetter(infix.charAt(i))) {
					postfix += infix.charAt(i);

				} else if (isOperator(infix.charAt(i))) {
					/**
					 * If it's a operator, we have to verify that:
					 * 		1) The operator/parens stack (postfixStorage) is not empty
					 * 		2) If the top of the stack isn't an opening parens (meaning we have an operator at the top)
					 * 		3) That the operator we're looking at has/doesn't have a higher precedence than the 
					 * 		   operator at the top of the stack
					 * While these 3 conditions are true, we just add to our resulting string the top operator on the stack by popping it
					 * 
					 * after that, we just push the next operator/parens (we don't know if it's one or the other) in the string to the stack
					 */
					while (!postfixStorage.isEmpty() && !isOpeningParens(postfixStorage.top())
							&& hasHigherPrecedence(postfixStorage.top(), infix.charAt(i))) {
						postfix += postfixStorage.pop();
					}
					postfixStorage.push(infix.charAt(i));

					//If it's an opening parens, push it to the stack
				} else if (isOpeningParens(infix.charAt(i))) {
					postfixStorage.push(infix.charAt(i));
				} else if (isClosingParens(infix.charAt(i))) {

					/**
					 * If it's a closing parens we have to check if the parens/operator stack isn't empty 
					 * and if the top of the stack isn't an opening parens (because if it is, it means that the expression isn't balanced)
					 * 
					 * while these conditions are true, we just add to the resulting string the top of the stack by popping it
					 */
					while (!postfixStorage.isEmpty() && !isOpeningParens(postfixStorage.top())) {
						postfix += postfixStorage.pop();
					}
					postfixStorage.pop();
				}
			}
			//After all that is done, we just add what's left in the stack to the resulting string & we return it
			while (!postfixStorage.isEmpty())
				postfix += postfixStorage.pop();
			return postfix;
		} else {
			//If the parens are not balanced, just return the parameter saying it's invalid
			return infix + " is Invalid";
		}
	}

	private static boolean hasHigherPrecedence(Character operatorOnTop, char curOperator) {
		/**
		 * PEMDAS
		 * 
		 * Mult. and division have a higher precedence than sum or subtraction, 
		 * so we got to check this every time we see two operators in a row to see which one gets used first
		 * 
		 */
		if(operatorOnTop == '*' || operatorOnTop == '/' && curOperator == '+' || curOperator == '-'){
			return true;
		}
		return false;

	}

	private static boolean isOpeningParens(char c) {
		return c == '(' ||  c == '{' || c == '[';
	}

	private static boolean isClosingParens(char c) {
		return c == ')' || c == ']' || c == '}';
	}

	private static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	public static boolean hasBalancedParens(String parens) {

		/*
		 * Here we check if the given expression has balanced parens (e.g ([A(B+C)/D] * E) is a balanced expression)
		 */
		Stack<Character> stack = new ArrayStack<>(parens.length());

		for (int i = 0; i < parens.length(); i++) {
			//If it's a letter or an operator, we can ignore it
			if(!Character.isLetter(parens.charAt(i)) && !isOperator(parens.charAt(i))){
				//If it's an opening parens, push it to the stack
				if(parens.charAt(i) == '(' || parens.charAt(i) == '{' || parens.charAt(i) == '[') {
					stack.push(parens.charAt(i));
				} else {
					//If the stack isn't empty check the next char
					if(!stack.isEmpty()) {
						//If it's a closing parens, we check the top of the stack to see if it matches the closing one we found
						//if it matched, pop the opening parens out of the stack an continue searching
						if(parens.charAt(i) == ')') {
							if (stack.top() == '(') {
								stack.pop();
								continue;
							}
						}
						else if(parens.charAt(i) == '}') {
							if (stack.top() == '{') {
								stack.pop();
								continue;
							}
						}
						if(parens.charAt(i) == ']') {
							if (stack.top() == '[') {
								stack.pop();
								continue;
							}
						}
					}
					//If it doesn't match it's not balanced 
					return false;
				}
			}
		}
		//If the string doesn't contain at least one parens, it's not considered a fully parenthesized expression so it's invalid
		if(containsParens(parens)) {
			/**
			 * If it does contain at least one , we check if the stack is empty
			 * If it's empty it means the evaluation was successful and it's balanced. If not, then it's an invalid expression because there
			 * are still parens inside the stack
			 */
			return stack.isEmpty();
		} else {
			return false;
		}
	}

	private static boolean containsParens(String parens) {
		return parens.contains(")") || parens.contains("(") || parens.contains("]")
				|| parens.contains("[") || parens.contains("}") || parens.contains("{");
	}
}
