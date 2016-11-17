import java.util.*;

public class birthdaywizard
{

		public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		int birth, n, year;
		
		System.out.println("Hi!");
		System.out.println("What is your year of birth?");
		
		birth = keyboard.nextInt();
		
		System.out.println("Which bithday should I calculate?");
		
		n = keyboard.nextInt();
		
		year = birth + n;
		
		System.out.println("Your " + n + " bithday will occur in " + year);
	
	}
}