import java.util.*;

public class Painting{
	
	public static double promptDouble(){
		double x;
		Scanner input = new Scanner(System.in);
		x = input.nextDouble();
		return x;
	}
	public static double walls(double x, double y, double z){
		double wallMath;
		wallMath = (2 * (x + y)) * z;
		return wallMath;
	}
	public static double cieling(double a, double b){
		double cielingMath;
		cielingMath = a * b;
		return cielingMath;
	}
	public static void main(String[] args){
		System.out.println("Calculation of paint requirements");

		double length, width, height, wallArea, cielingArea;
		height = 8.0;

		System.out.println("Enter room length");
		length = promptDouble();

		System.out.println("Enter room width");
		width = promptDouble();

		wallArea = walls(length, width, height);
		cielingArea = cieling(length, width);

		System.out.println("The area of the wall is " + wallArea + " square feet.");
		System.out.println(" ");
		System.out.println("The area of the ceiling is " + cielingArea + "square feet");
	}
}