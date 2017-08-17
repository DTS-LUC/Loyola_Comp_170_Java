// The address on Pennsylvania is a four-digit
// number where:
// • All four digits are different
// • The digit in the thousands place is three times the digit in the tens place
// • The number is odd
// • The sum of the digits is 27
// Declare 4 integers to represent each digit (d0 - d3)
// Assign each digit to zero
// Test if any of the digits equal each other
// Next test if the Thousands place is three times the tens place
// Check if the last digit is even
// Finally add all the digits together to make sure they add to 27
// 	If any of these tests fail, add 1 to d3; if d3 is greater than 9, reset d3 to 0 and add 1 to d2
//		if d2 is greater than 9 reset d2 to 0 and add 1 to d1; if d1 is greater than 9 add 1 to d0
//		and reset d1 to 0;
// The loops will re-run until all the tests are true.

import java.util.*;

public class holyDigits{
	public static void main(String[] args) {
		int d0, d1, d2, d3;
		d0 = 0;
		
		while (d0 <= 9) {
			d1 = 0;

			while (d1 <= 9){
				d2 = 0;

				while (d2 <= 9){
					d3 = 0;

					while (d3 <= 9
						){
						if (d0 != d1 && d0 != d2 && d0 != d3 && d1 != d2 && d1 != d3 && d2 != d3){
							if (d0 == (3 * d2)){
								if (d3 % 2 == 1){
									if ((d0 + d1 + d2 + d3) == 27){
										System.out.println("The address is " + d0 + d1 + d2 + d3 + " Pennsylvania Avenue");
										return;
									}
								}
							}
						}
						d3++;
					}
					d2++;
				}
				d1++;
			}
			d0++;
		}
		return;	
	}
}