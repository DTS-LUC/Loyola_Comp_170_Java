/**
 *
 * @author Donald Stolz
 */

package sudoku;

import java.util.*;

public class Sudoku
{
    public static void main(String[] args)
    {
    	Scanner input = new Scanner(System.in);
        int diffclt;

        SudokuGUI userBoard = new SudokuGUI();

        System.out.println("Enter number of holes to be created: ");
        diffclt = input.nextInt();


        userBoard.newGame(diffclt);
        userBoard.printBoard();
        userBoard.printSolution();
        

//        SudokuBoard nGame = new SudokuBoard();
//        nGame.createBoard(diffclt);
//        nGame.printBoard();
//        nGame.printSolution();

    }  
}