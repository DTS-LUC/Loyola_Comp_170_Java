import java.util.Scanner;

public class FahrenheitConversion {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		double	DegreesF, DegreesC;
		
		System.out.println("Hello, please enter a temperature in degrees Fahrenheit");
		DegreesF = input.nextDouble();
		
		DegreesC = 5 * (DegreesF - 32) / 9;
		System.out.println(DegreesF + " degrees Farenheit is " + DegreesC + " degress Celcius");
				
	}
}