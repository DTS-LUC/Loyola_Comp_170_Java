import java.util.Scanner;

public class largest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] num = new int[10]; // 1. Create an array that will take 10 integer values

        int largest = -2147483648; // 2. Assigin largest the smallest possible value for

        System.out.println("Please input 10 numbers "); // 3. Prompt user to fill array
        for(int c = 0; c < num.length; c++){
            num[c] = input.nextInt();
        } // 4. Use for loop to gather data (10 integer values)

        for(int i = 0; i < num.length; i++) {

            if(num[i] > largest) {
                largest = num[i];
            }
        } // 5. Run algorithmn for finding largest number; The algorithmn runs through the enter set of
          // data and compares each value to the value it has stored as the current largest value
        System.out.println("Largest number in array is : " + largest); // Display largest value
    }
}
