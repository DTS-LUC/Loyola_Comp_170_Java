// Declare variables: balance, rate, repeat, annual, monthly, daily
// Assign variable repeat to 'y'
// Create do while loop, which loops while repeat = 'y'
// Obtain values for balance and rate from user
// Perform annual calculation by multiplying rate by balance once
// Perform monthly calculation by multiplying balnce by rate/12 12 times
// Perform daily calculation by multiplying balance by rate/365 365 times
// Print values of annual, monthly and daily
// Ask user if they would like to run the program again
// Repeat program until user chooses to exit


import java.util.Scanner;
import java.lang.*;
import java.text.DecimalFormat;

public class interest {
	public static double roundTwoDecimals(double d) {
 		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(d));
	}

	public static double year(double balance, double rate){
		double y = balance;

		y += balance * rate;
		y = roundTwoDecimals(y);
		return (y);
	}

	public static double month(double balance, double rate){
		double m = balance;
		
		for (int c = 0; c < 12; c++) {
			m += m * (rate/12);
		}

		m = roundTwoDecimals(m);
		return m;
	}

	public static double day(double balance, double rate){
		double d = balance;
		
		for (int j = 0; j < 365; j++) {
			d += d * (rate/365);
		}

		d = roundTwoDecimals(d);
		return d;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DecimalFormat formatter = new DecimalFormat("#.##");

		double balance, rate, annual, monthly, daily;

		char repeat = 'y';

		do {
			System.out.println("Please enter the balance to be calculated ");
			balance = input.nextDouble();

			System.out.print("Please enter the rate to be calculated: %");
			rate = input.nextDouble();
			rate = rate / 100;

			annual = year(balance, rate);
			monthly = month(balance, rate);
			daily = day(balance, rate);

			

			System.out.println("The balance after one year with an annual rate will be: $" + annual);
			System.out.println("The balance after one year with a monthly rate will be: $" + monthly);
			System.out.println("The balance after one year with a daily rate will be: $" + daily);
			System.out.println("Would you like to run the program again? ( Enter 'y' to run again, or any other letter to quit");
			repeat = input.next().charAt(0);
			repeat = Character.toLowerCase(repeat);

		} while (repeat == 'y');
	}
}