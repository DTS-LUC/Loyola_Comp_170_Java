import java.util.Scanner;

public class dream {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		String color, food, animal, name;
		
		System.out.println("Hello, please enter your favorite color ");
		color = input.nextString();
		
		System.out.println("Hello, please enter your favorite food ");
		food = input.nextString();
		
		System.out.println("Hello, please enter your favorite animal ");
		animal = input.nextString();
		
		System.out.println("Hello, please enter the name of a relative or friend ");
		name = input.nextString();
		
		System.out.println("I had a dream that " + name + " ate a " + color + " " + animal + " and said it tasted like " + food +"!")
	}
}
