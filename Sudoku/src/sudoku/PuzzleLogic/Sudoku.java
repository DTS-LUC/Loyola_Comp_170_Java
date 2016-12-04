/**
 *
 * @author Donald Stolz
 */

package sudoku;

import java.util.*;

public class Sudoku
{
    Scanner input = new Scanner(System.in);
    Random rdm = new Random();
    SudokuBoard game;
    
    // Constructor creates new game
    public Sudoku()
    {
        game = new SudokuBoard(); 
    }
    
    // Creates new board. Takes argument "char difficulty"
    public void createBoard(char difficulty)
    {
        int holes;
        holes = rdm.nextInt(37) + 27;   // Random number 27 - 64
        
        switch (difficulty)
        {
            case 'e':
                holes = rdm.nextInt(9) + 27;    // 27 - 36 
                game.createBoard(holes);
                break;
            case 'm':
                holes = rdm.nextInt(13) + 36;    // 36 - 49
                game.createBoard(holes);
                break;
            case 'h':
                holes = rdm.nextInt(14) + 50;    // 50 - 64
                game.createBoard(holes);
                break;
            default:
                game.createBoard(holes);
                break;
        }        
    }
    
    // Prints board on stdout
    public void printBoard()
    {
        game.printBoard();
    }
    
    // Prints solution on stdout
    public void printSolution()
    {
        game.printSolution();
    }

    //Initial Main method for standard out.
//    public static void main(String[] args)
//    {       
//        Sudoku nextGame = new Sudoku();
//        
//        nextGame.createBoard('e');
//        nextGame.printSolution();
//        nextGame.printBoard();
//        
//    }
    
}
