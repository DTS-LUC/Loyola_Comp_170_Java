import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {

		//Add scanner to allow the program to take input from the users keyboard
		Scanner input = new Scanner(System.in); 
		
		//Ask the user for input
		System.out.println("Hello, please enter your exam score");
		//Store user input from scanner
		double exam = input.nextDouble();

		//Verify proper range for an exam score
		while (exam > 100 || exam < 0) {
			System.out.println("Invalid input! Please enter a value between 0 & 100");
			exam = input.nextDouble();
		}
		
		//Create a variable for how the user did
		String result;

		//Compare the exam score, to find out how they did
		if (exam >= 90) {
			result = "Awesome!";
		}
		else if (exam >= 80) {
			result = "Pretty good.";
		}
		else if (exam > = 70) {
			result = "Not so great...";
		}
		else {
			result = "Awful...";
		}

		//Output the user score and result
		System.out.println("My exam one score was %" + exam + " and I did " + result);
	}
	
}
