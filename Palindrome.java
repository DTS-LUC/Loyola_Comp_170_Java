//	Task:
//		To determine if the given string is a palindrome.
//
//	Steps:
//		1.	Take a string from the user's keyboard, using the scanner object
// 		2.	Truncate string at '.'
//		3.	Remove any non letter chracters
//		4.	Check length of string, and save it to an integer
//		5.	Compare first character to last character, then the 2nd character with the 2nd to last...
//				-The loop will know to run until character x >= character y
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

			System.out.println(a + "	" + len);
			System.out.println("Enter \"y\" to repeat, or any other character to quit");
			rept = input.next().charAt(0);

			input.nextLine();	//	This line gets rid of ???? character things

		} while(rept == 'y' || rept == 'Y');
	}
}










