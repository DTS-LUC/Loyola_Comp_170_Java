import java.util.*;
import java.text.*;
/**
*The SudokuGenerator class creates a random standard (9x9)
*Sudoku board through the use of backtracking techniques.
*/
public class SudokuGenerator
{
	public static final int BOARD_WIDTH = 9;
	public static final int BOARD_HEIGHT = 9;
	
	/**
	 *Constructor.  Resets board to zeros
	 */
   public SudokuGenerator() {
   	board = new int[BOARD_WIDTH][BOARD_HEIGHT];
   }
	
	/**
	 *Driver method for nextBoard.
	 *@param  difficult the number of blank spaces to insert
	 *@return board, a partially completed 9x9 Sudoku board
	 */
	public int[][] nextBoard(int difficulty)
	{
		board = new int[BOARD_WIDTH][BOARD_HEIGHT];
		nextCell(0,0);
		return board;

	}
	
	/**
	 *Recursive method that attempts to place every number in a cell.
	 *
	 *@param x x value of the current cell
	 *@param y y value of the current cell
	 *@return  true if the board completed legally, false if this cell
	 *has no legal solutions.
	 */
	public boolean nextCell(int x, int y)
	{
		int nextX = x;
		int nextY = y;
		int[] toCheck = {1,2,3,4,5,6,7,8,9};
		Random r = new Random();
		int tmp = 0;
		int current = 0;
		int top = toCheck.length;

   		for(int i=top-1;i>0;i--)
		{
		    current = r.nextInt(i);
		    tmp = toCheck[current];
		    toCheck[current] = toCheck[i];
		    toCheck[i] = tmp;
    	}
		
		for(int i=0;i<toCheck.length;i++)
		{
			if(legalMove(x, y, toCheck[i]))
			{
				board[x][y] = toCheck[i];
				if(x == 8)
				{
					if(y == 8)
						return true;//We're done!  Yay!
					else
					{
						nextX = 0;
						nextY = y + 1;
					}
				}
				else
				{
					nextX = x + 1;
				}
				if(nextCell(nextX, nextY))
					return true;
			}
		}
		board[x][y] = 0;
		return false;
	}
	
	/**
	 *Given a cell's coordinates and a possible number for that cell,
	 *determine if that number can be inserted into said cell legally.
	 *
	 *@param x       x value of cell
	 *@param y       y value of cell
	 *@param current The value to check in said cell.
	 *@return        True if current is legal, false otherwise.
	 */
	private boolean legalMove(int x, int y, int current) {
		for(int i=0;i<9;i++) {
			if(current == board[x][i])
				return false;
		}
		for(int i=0;i<9;i++) {
			if(current == board[i][y])
				return false;
		}
		int cornerX = 0;
		int cornerY = 0;
		if(x > 2)
			if(x > 5)
				cornerX = 6;
			else
				cornerX = 3;
		if(y > 2)
			if(y > 5)
				cornerY = 6;
			else
				cornerY = 3;
		for(int i=cornerX;i<10 && i<cornerX+3;i++)
			for(int j=cornerY;j<10 && j<cornerY+3;j++)
				if(current == board[i][j])
					return false;
		return true;
	}
	/**
	 *Prints a representation of board on stdout
	 */
	public void print()
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
				System.out.print(board[i][j] + "  ");
			System.out.println();
		}
		System.out.println();
	}
	
	int[][] board;
	private int operations;
}