// Pseduo Code:
//
// 	Task: 	
// 			Write a simple program that takes values from the user and outputs the factorial of that value.
// 			Use a recursive function to calculate the factorial. 
//
// 	Definition of Factorial:
// 			- The factorial of a non-negative integer n, denoted by n!, is the product of all positive integers less than or equal to n.
// 				- 0! = 1; 1! = 1
//
// 			- In order to calculate the factorial we will use the equation:
// 							n! = n * (n - 1)!
//				
// 				Example:	3! = 3 * 2!
// 							2! = 2 * 1!
// 							1! = 1
// 						By substituting the terms we get 3! = 3 * 2 * 1 = 6
//
// 	Procedure:
// 		Create Variables:
// 			0. Create two integer variable (num, ans) and one character variable (rept)
// 				-	Assign rept value to 'y'
//
// 		Take User Input:
// 			1. The program will begin to loop while " rept == 'y' "
// 				- This loop will contain all of the remaining processes
// 				- This is so the user can eventually choose to exit or repeat the program
//
// 			2. Next the program will request the value to be calculated
// 				- This value will be assigned to num
//
// 			3. Then the program will check that: num >= 0
// 				- while num is less than 0, the user will be asked to enter a new value
//
// 		Calculate the Factorial:
// 			4. It will then pass the value of num to the factorial method
//
// 			5. nb will be assigned the value passed to the method
//
// 			6. The return value of the method will depend on two cases
//
// 			Case 1: nb <= 1
// 				For this case the method will return the integer value 1
//
// 			Case 2: nb > 1
// 				In this case the method will return the value:
// 					nb * (nb - 1)!
//				
// 				In order to calculate (nb - 1) the method will call another instance of the factorial method
//			
// 			Example: nb = 3
// 				0. factorial(3) = 3 * factorial(2)
// 				1. factorial(2) = 2 * factorial(1)
// 				2. factorial(1) = 1
// 				3. factorial(3) = 3 * 2 * 1 = 6
//
// 			7.	ans will then be assigned return value of the initial factorial calculation
//
// 			8. The program will then output the value inputed and its factoral
//
// 			9. The user will then be asked if they would like to repeat or quit the program
//

import java.util.Scanner;

public class Factorial
{
	public static int factorial(int nb)
	{
		if (nb <= 1)
		{
			return 1;
		}
		
		return (nb * factorial(nb - 1));
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int num, ans;
		char rept = 'y';
		
		do{
			System.out.println("Please enter a number:");
			num = input.nextInt();

			while(num < 0 || num > 12)
			{
				System.out.println("Error you have entered a negative number or a number that is out of range.");
				System.out.println("Please enter a number between 0 - 12:");
				num = input.nextInt();
			}	

			ans = factorial(num);

			System.out.println( num + "! = " + ans);

			System.out.println("Enter \"y\" to repeat, or any other character to quit");
			rept = input.next().charAt(0);

			input.nextLine();	//	This line gets rid of the End Of Line token

		}while (rept == 'y' || rept == 'Y');
	}
}