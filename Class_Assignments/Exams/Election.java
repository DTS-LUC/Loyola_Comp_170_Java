//	Task:
//		Determine if a user is eligible to be a US Congressperson or a US senator.
//			The House of Representatives members must be at least 25 years of age and a citizen of the USA for at least 7 years.
//			The Senate members must be at least 30 years of age and a citizen of the USA for at least 9 years.
//
//	Steps:
//		0.	Ask the user for their age
//		1.	Store this value as an integer variable, age
//		2.	Ask the user for the number of years they have been a US citizen
//		3.	Store this value as an integer variable, yearsC
//		4.	Send both values to the isEligible method
//
//				a.	The method will first determine if the user is old enough to run for senate and will next check if they have been a citizen for long enough
//					-	If they are eligible for the senate posistion, they are automatically eligible for House and the method will return 2
//				b.	If the age is not great enough to be a senate, next the method will check their age and years citizenship for House Representative eligibility
//					-	The program will return a 2, 1 or 0 value based on its evaluation (2 both, 1 house only, 0 neither)
//		5.	The program will then output to the user what positions they are eligible for

import java.util.Scanner;
import java.lang.*;
import java.io.*;

public class Election
{

	public static int isEligible(int age, int yearsC)
	{	
		

		if (age >= 30 && yearsC >= 9)
		{
			return 2;
		}
		else if (age >= 25 && yearsC >= 7)
		{
			return 1;
		}

		return 0;

	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int	age, yearsC, elgbl;

		System.out.println("Hello, please enter your age: ");
		age = input.nextInt();

		System.out.println("Please enter your years of US citizenship: ");
		yearsC = input.nextInt();

		elgbl = isEligible(age, yearsC);

		if ( elgbl == 2)
		{
			System.out.println("Congratulations you are eligible to run for both the Senate and the House of Representatives!");
		}
		else if (elgbl == 1)
		{
			System.out.println("Congratulations you are eligible to run for the House of Representatives!");
		}
		else
		{
			System.out.println("You are not eligible to run for the Senate or the House of Representatives.");
		}
	}
}