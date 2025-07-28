package javaCalculator;

import java.util.*;


public class Calculator {
	
	//first i ll write simple methods for each operation of my calculator
	public static double add (double a, double b) {
		return a+b;
	}
	
	public static double subtract (double a , double b) {
		return a-b;
	}
	
	public static double multiply (double a, double b) {
		return a*b;
	}
	
	public static double divide (double a, double b) {
		return a/b;
	}
	
	public static double squared (double a) {
		return a*a;
	}
	
	public static double squareRoot (double a) {
		return Math.sqrt(a);
	}
	
	
	//method for reading numbers from the user (to not be repeated multiple times in main)
	public static double readNumbers (Scanner inObj ,String text) {
		
		double number = 0;
	    boolean inputIsValid = false; //to correct wrong input

	    while (!inputIsValid) {
	        System.out.println(text + " "); // Use the message passed to the method
	        try {
	            number = inObj.nextDouble();
	            inObj.nextLine(); // Consume the newline character (/n) that remains in the buffer
	            inputIsValid = true;
	        } catch (InputMismatchException e) {
	        	//if user doesn't type a double
	            System.out.println("Wrong input! Please enter a valid number!");
	            inObj.nextLine(); // // I clear my buffer so i can read the next double
	        }
	    }
	    return number; // Return the valid number
	}
	
	
	//******* MAIN METHOD *******
	public static void main(String[] args) {
		
		//I create the objects I'll need
		
		double number1=0;
		double number2=0;
		
		String operation = "";
		
		double result= 0;
		
		boolean inputIsValid; //used to check if the input is correct
		
		//i 'll use it to check if any illegal operation happens(e.g.divide by zero)
		//so i wont print the result
		boolean calculationError = false; 
		
		Scanner input = new Scanner(System.in);
		
		// I 'll read the first number
		number1 = readNumbers(input, "Please enter the first number:");
		
		
		//TODO: i have to select the correct methods (add , subtract ect)
		
		//first i ll read the correct operation from the user
		inputIsValid = false;
		
		while(!inputIsValid) {
			
			System.out.println("select operation(+,-,*,/,^2,sqrt):");
			
			// i use toLowerCase() method so that the SQRT also works
			operation = input.nextLine().toLowerCase();
			
			if(operation.equals("+")||operation.equals("-")||operation.equals("*")||
			   operation.equals("/")||operation.equals("^2")||operation.equals("sqrt")) {
				
				inputIsValid= true;
				
			}else {
				
				System.out.println("Operation not valid! /n Please use one of the : +, -, *, /, ^2, sqrt");
			}
		}
		
		//now i 'll call the correct method according to the users input
		if (operation.equals("+")||operation.equals("-")||operation.equals("*")||
			   operation.equals("/")) {
			
			// i read the second number
			number2 = readNumbers(input, "Please enter the second number:");
			
			switch (operation){
				
			case "+":
				result = add(number1, number2);
				break;
			
			case "-": 
				result = subtract(number1, number2);
				break;
			
			case "*":
				result = multiply(number1, number2);
				break;
			
			case "/":
				// i have to make sure we don't divide by zero
				if(number2!=0) {
					result = divide(number1, number2);
				}
				else {
					System.out.println("Error: Cannot divide by zero!");
					calculationError = true;
				}
				break;
				
			}
				
		}else {
			switch (operation) {
			
			case "^2": 
				result = squared(number1);
				break;
			
			case "sqrt": 
				if (number1 >= 0) {
					result = squareRoot(number1);
				}
				else {
					System.out.println("Error: Cannot find square root of a negative!");
					calculationError = true;
				}
				break;
			}
		}
		
		//if no calculation error happened print the result
		if(!calculationError) {
			System.out.println( "The result is " + result );
		}
		
		input.close();

		//System.out.println("The program has ENDED successfully!");
		
	}

}
