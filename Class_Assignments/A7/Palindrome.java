//	Task:
//		To determine if the given string is a palindrome.
//
//	Steps:
//		0.	Take a string from the user's keyboard, using the scanner object
// 		1.	Truncate string at '.'
//		2.	Remove any non letter chracters
//		3.	Check the length of string, and save it to an integer variable
//		4.	Convert the string to a char array
//		5.	Send the char array and string length to the 'isPalindrome' method
//
//				a.	The method will first declare an int 'x' and intialize it to 0
//				b.	Then it will declare an int and intialize it to 1 - the string length
//						- We do this since the array starts at 0
//				c.	The program will then enter a loop while x < y
//				d.	Next we will compare the character at x to the character at y
//				e0.	If they are the same we add 1 to x and subtract 1 from y
//				e1.	If they are the not the same return false
//				f.	Once x !< y the method will return true
//
//		6.	The program will then output to the user whether or not the the string was a palindrome
//		7.	Finally the program will ask the user if they would like to repeat, or quit, the program

import java.util.Scanner;
import java.lang.*;
import java.io.*;

public class Palindrome
{

	public static boolean isPalindrome(char[] a, int used)
	{	
		int x = 0;
		int y = used - 1;

		while(x < y)
		{
			if (a[x] == a[y])
			{
				x++;
				y--;
			}
			else
			{
				return false;
			}
		}

		return true;

	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		String a;
		char rept = 'y';
		int len;

		do{
			System.out.println("Please type a palindrome!");
			a = input.nextLine();

			a = a.split("\\.")[0];
			a = a.replaceAll("[\\W]","");
			a = a.toLowerCase();
			len = a.length();

			char[] pal = a.toCharArray();

			if ( isPalindrome(pal, len))
			{
				System.out.println("This string is a palindrome!");
			}
			else
			{
				System.out.println("This string is not a palindrome.");
			}

			System.out.println("Enter \"y\" to repeat, or any other character to quit");
			rept = input.next().charAt(0);

			input.nextLine();	//	This line gets rid of the End Of Line token

		} while(rept == 'y' || rept == 'Y');
	}
}










