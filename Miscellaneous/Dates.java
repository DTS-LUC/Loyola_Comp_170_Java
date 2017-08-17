// Read a string from the user using the scanner object
// Test whether the string is contains a vald format
// Display the valid date if it is valid, and display an error if it is not

// Check if its length is exactly 10. If not, it is not valid. 
// Check if charAt 2 and 4 are the '/' character. If there are not, then you know it is invalid. 
// Get the year from the end with the substring method, using the indices 6 and 9. 
// Check if year is valid. 
// Get the month with the substring method. 
// Check if the month is valid.
// Check if the year is a leap year or not.
// Check if the day is valid.

// m m / d d / y y y y
// 0 1 2 3 4 5 6 7 8 9

import java.util.*;
import java.lang.*;

public class Dates{

	public static int valid (String date){
		if (date.length() != 10){
			System.out.println("Your date was not entered in the required format");
			return 0;
		}

		if (date.charAt(2) != '/' || date.charAt(5) != '/'){
			System.out.println("Your date was not entered in the required format");
			return 0;
		}

		String y = date.substring(6, 10);
		int year = Integer.parseInt(y);

		if (year < 0 || year > 3000){
			System.out.println("Your date does not contain a valid year");
			return 0;
		}

		String m = date.substring(0, 2);
		int month = Integer.parseInt(m);

		if (month < 1 || month > 12){
			System.out.println("Your date does not contain a valid month");
			return 0;
		}

		String d = date.substring(3, 5);
		int day = Integer.parseInt(d);

		if (day < 0 || day > 31){
			System.out.println("Your date does not contain a valid day");
			return 0;
		}

        if ((day > 30) && (month == 4 || month == 6 || month == 9 || month == 11)){
            System.out.println("Your date does not contain a valid day for that month");
            return 0;
        }
		
		if ((month == 2) && (year % 4 == 0) && (day > 28)){
			System.out.println("Your date does not contain a valid day for that month, since it is not a leap year");
			return 0;
        }
        else if (month == 2 && day > 29) {
        	System.out.println("Your date does not contain a valid day for that month");
        	return 0;
        }
        else{
        	return 1;
        }
	}

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.println("Please input a valid date.");
		String date = input.nextLine();

		if (valid(date) == 1) {
			System.out.println( date + " is a valid date");	
		}

	}
}