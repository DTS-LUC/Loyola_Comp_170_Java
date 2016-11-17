// Task:
// 	Write a function called isNumbersPresent that returns a boolean value and takes two parameters.  The first parameter is an array of ints called numbers.   Each element can be positive, negative, or zero. The second parameter is an array of ints called guesses.  Each element of the second array is also an int.  The function checks to see if *all* of the ints in guesses (the second parameter) are present in numbers  (the first parameter)  If so, return true, otherwise false.

// Steps:
// 	1.	Create a for loop with a counter to increment 'guesses' compare against its length
// 	2.	Compare the initial value of 'guesses' with each value of 'numbers'
// 	3.	Increment the counter for 'gueses' if a match is found and repeat search, if not return false
// 	4.	If the program reaches the end of 'guesses' return true

import java.util.Scanner;
import java.lang.*;
import java.io.*;

public class isNumbersPresent
{
	public static boolean isNumbersPresent(int[] numbers, int[] guesses)
	{
		int boo;

		for (int x = 1; x < guesses[0]; x++)
		{
			boo = 1;
			for (int y = 0; y < numbers.length; y++)
			{
				if(guesses[x] == numbers[y])
				{
					boo = 0;
					break;
				}
			}
			if (boo != 0)
			{
				return false;	
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int[]	numbers = new int [8];
		int[]	guesses = new int [100];
		int 	nGuess;

		numbers[0] = 878;
		numbers[1] = 900;
		numbers[2] = 80;
		numbers[3] = 1;
		numbers[4] = 109;
		numbers[5] = -10;
		numbers[6] = 5;
		numbers[7] = 33;

		System.out.println("How many numbers would you like to guess?");
		nGuess = input.nextInt() + 1;
		if (nGuess < 0 || nGuess > 100)
		{
			System.out.println("Invalid number of guesses.");
			System.out.println("How many numbers would you like to guess?");
			nGuess = input.nextInt() + 1;
		}
		guesses[0] = nGuess;

		for (int q = 1; q < nGuess; q++)
		{
			System.out.println("Please enter a number:");
			guesses[q] = input.nextInt();	
		}
		guesses[0] = nGuess;
		if (isNumbersPresent(numbers, guesses))
		{
			System.out.println("Thank you! All of your numbers are present in my list.");
		}
		else
		{
			System.out.println("Not all of your numbers are present on my list.");
		}
	}
}





