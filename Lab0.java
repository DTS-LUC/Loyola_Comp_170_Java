import java.util.Scanner;

public class Lab0 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hello, world!");
		System.out.println("Hello, Don!");
		System.out.println("Java seems easier than C");

		System.out.println("Enter a whole number: ");
		int num1 = input.nextInt();
		
		System.out.println("Enter another whole number: ");
		int num2 = input.nextInt();
		
		int sum = num1 + num2;
		System.out.print("The sum of those numbers is " + sum);
	}
	
}
