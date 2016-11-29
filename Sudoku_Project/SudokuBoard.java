import java.util.*;
import java.text.*;


//The SudokuBoard class creates a random standard (9x9)
//Sudoku board through the use of backtracking techniques.


public class SudokuBoard
{

	public static final int WIDTH = 9;
	public static final int HEIGHT = 9;
	SudokuSolution sltn = new SudokuSolution();
	Random rdm = new Random();




	//	Constructor.  Resets board & solution to zero.
	public SudokuBoard()
	{
		board = new int[WIDTH][HEIGHT];
		sltn.makeNewSolution();
	}

	//	Method for creating playable board.		Takes blanks parameter
	//		Starts by creating solution
	//		The board is then assigned the solution
	//		The createBlanks method is then called
	//		The completed board is then returned
	public int[][] createBoard(int blanks)
	{
		board = new int[WIDTH][HEIGHT];
		
		newSolution();
		createBlanks(blanks);

		return board;
	}

	public void newSolution()
	{
		sltn.makeNewSolution();

		for (int x = 0; x < 9; x++)
		{
			for (int y = 0; y < 9; y++)
			{
				board[x][y] = sltn.getValue(x,y);
			}
		}
	}

	public void createBlanks( int blanks)
	{
		int row;
		int	col;
		int temp;
		int	placed = 0;

		while (placed < blanks)
		{
			placed++;

			row = rdm.nextInt(8);
			col = rdm.nextInt(8);

			temp = board[row][col];
			board[row][col] = 0;

			if (temp == 0)
			{
				board[row][col] = temp;
				placed--;
			}
			else if (oneSolution(temp, row, col) == false)
			{
				board[row][col] = temp;
				placed--;
			}
		}

		for(int x = 0; x < 9; x++)
		{
			for(int y = 0; y < 9; y++)
			{
				if(board[x][y] == 10)
				{
					board[x][y] = 0;
				}
			}
		}
	}



	public	boolean oneSolution(int temp, int row, int col)
	{
		int checkVal;

		checkVal = 1;

		while (checkVal <= 10)
		{
			board[row][col] = checkVal;

			if (checkVal != temp && possibleSudoku(row, col) == true)
			{
				return false;
			}
			checkVal++;
		}
		return true;
	}

	public boolean possibleSudoku(int row, int col)
	{

		for(int x = 0; x < 9; x++)
		{
			for(int y = 0; y < 9; y++)
			{
				if(board[x][y] == 0)
				{
					if(fillCell(x,y))
					{
						return false;
					}
					else
					{
						return true;
					}
				}
			}
		}
		return false;
	}



	public boolean fillCell(int x, int y)
	{
	    int nextX = x;
	    int nextY = y;
	    int[] toCheck = {1,2,3,4,5,6,7,8,9};

	    int tmp = 0;
	    int current = 0;
	    int top = toCheck.length;

	    for(int i=top-1;i>0;i--)
	    {
	        current = rdm.nextInt(i);
	        tmp = toCheck[current];
	        toCheck[current] = toCheck[i];
	        toCheck[i] = tmp;
	    }
	    
	    for(int i=0;i<toCheck.length;i++)
	    {
	        if(validMove(x, y, toCheck[i]))
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
	            if(fillCell(nextX, nextY))
	                return true;
	        }
	    }
	    board[x][y] = 0;
	    return false;
	}

	// validMove takes parameters row, col, and numCheck.
	//		This method returns true if there
	//		are no repeats in the row, column, or box.
	private boolean validMove(int row, int col, int numCheck)
	{
		int rowStart;
		int colStart;

		rowStart = (row / 3) * 3;
		colStart = (col / 3) * 3;

		for(int i = 0; i < 9; i++)
		{
			if(numCheck == board[row][i])	//	Check no repeats in row
			{
				return false;
			}

			if(numCheck == board[i][col])	//	Check no repeats in column
			{
				return false;
			}

			if (board[rowStart + (i % 3)][colStart + (i / 3)] == numCheck)	//	Check for no repeats in box
			{
				return false;
			}
		}

		return true;
	}

	public int getValue(int row, int col)
	{
		return board[row][col];
	}


	// Prints Board on stdout
	public void printBoard()
	{
	    for(int i=0;i<9;i++)
	    {
	        for(int j=0;j<9;j++)
	            System.out.print(board[i][j] + "  ");
	        System.out.println();
	    }
	    System.out.println();
	}

	public void printSolution()
	{
		sltn.printSolution();
	}

	// public static void main(String[] args)
	// {
	// 	SudokuBoard sg = new SudokuBoard();


	// 	sg.createBoard(40);
	// 	sg.printBoard();
	// }

	int[][]	board;
}