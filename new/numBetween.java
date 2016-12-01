import java.util.*;

public class numBetween
{

		public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		int n1, n2, ans;
		
		System.out.println("Hi! I will calculate the number of integers between two other integers");
		
		System.out.println("Enter the first number:");
		n1 = keyboard.nextInt();
		
		System.out.println("Enter the second number");
		n2 = keyboard.nextInt();
		
		ans = (n2 - n1) + 1;
		
		System.out.println("The number of integers that lie between " +n1+ " and " +n2+ " is " +ans);
	}
}