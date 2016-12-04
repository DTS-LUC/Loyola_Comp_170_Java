/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Don Stolz
 */

import java.util.Scanner;

public class Sudoku {
    
    public static void main(String[] args)
    {
    	Scanner input = new Scanner(System.in);
		int diffclt;

		System.out.println("Enter number of holes to be created: ");
		diffclt = input.nextInt();

		SudokuBoard nGame = new SudokuBoard();
		nGame.createBoard(diffclt);
		nGame.printBoard();
		nGame.printSolution();

    }
    
    
}
