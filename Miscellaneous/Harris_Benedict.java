import java.util.Scanner;

public class Harris_Benedict {
	
	public static void main(String[] args){
	
		Scanner input = new Scanner(System.in);
		
		int		weight, height, age;
		double	cMan, cWoman;
		
		System.out.println("Please enter your weight");
		weight = input.nextInt();
		
		System.out.println("Please enter your height");
		height = input.nextInt();
		
		System.out.println("Please enter your age");
		age = input.nextInt();
		
		cMan = 66 + (6.3 * weight) + (12.9 * height) - (6.8 * age);
		cWoman = 655 + (4.3 * weight) + (4.7 * height) - (4.7 * age);
		
		System.out.println("The number of chocolate bars you should eat as a Man: " + cMan + " or as a Woman: " + cWoman);
	
	}
}