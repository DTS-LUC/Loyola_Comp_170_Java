import java.util.*;
import java.lang.*;

public class Rock_Paper_Scissors{
	public static int winner(char p1, char p2){
		int winner = 0;

	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		char p1, p2, lP1, lP2;
		int winner;

		System.out.println("Player 1 please choose your move");
		p1 = input.nextChar();

		System.out.println("Player 2 please choose your move");
		p2 = input.nextChar();

		p1 = Character.toLowerCase(p1);
		p2 = Character.toLowerCase(p2);

		winner = winner(lP1, lP2);

		if (winner == 1){
			System.out.println("Player 1 beat player 2")
		}

	}
}