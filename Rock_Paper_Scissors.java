//

import java.util.*;
import java.lang.*;

public class Rock_Paper_Scissors{
	public static int valid(char p1, char p2){
		
		if (p1 == 'r' || p1 == 'p' || p1 == 's') {
			
			if (p2 == 'r' || p2 == 'p' || p2 == 's') {
				return 1;
			}
			else{
				return 0;
			}	
		}
		else{
				return 0;
			}

	}
	public static void winner(char p1, char p2){
		if (p1 == 'r') {
			if (p2 == 's'){
				System.out.println("Player 1's rock beat player 2's scissor.");
			}
			if (p2 == 'p'){
				System.out.println("Player 1's rock lost to player 2's paper.");
			}
			if (p2 == 'r'){
				System.out.println("Player 1's rock tied with player 2's rock.");
			}
		}
		if (p1 == 'p') {
			if (p2 == 's'){
				System.out.println("Player 1's paper lost to player 2's scissor.");
			}
			if (p2 == 'p'){
				System.out.println("Player 1's paper tied with player 2's paper.");
			}
			if (p2 == 'r'){
				System.out.println("Player 1's paper beat player 2's rock.");
			}
		}
		if (p1 == 's') {
			if (p2 == 's'){
				System.out.println("Player 1's scissor tied with player 2's scissor.");
			}
			if (p2 == 'p'){
				System.out.println("Player 1's scissor beat player 2's paper.");
			}
			if (p2 == 'r'){
				System.out.println("Player 1's scissor lost to player 2's rock.");
			}
		}
		return;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		char p1, p2, lP1, lP2;
		int winner;

		System.out.println("Player 1 please choose your move ");
		p1 = input.next().charAt(0);

		System.out.println("Player 2 please choose your move ");
		p2 = input.next().charAt(0);

		p1 = Character.toLowerCase(p1);
		p2 = Character.toLowerCase(p2);

		if(valid( p1, p2) == 1){
			winner(p1, p2);
		}
		else{
			System.out.println("Invalid move.");
		}
	}
}