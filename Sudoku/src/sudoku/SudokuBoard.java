/**
 *
 * @author Donald Stolz
 */

package sudoku;

import java.util.*;

class SudokuBoard
{
    public static final int GRID_WIDTH = 9;
	public static final int GRID_HEIGHT = 9;
	public static final int HOLE = 0;
	SudokuSolution solution;
	Random rdm;
	int[][]	board;



	//	Constructor.  Resets board & solution to zero.
	public SudokuBoard()
	{
        rdm = new Random();
		board = new int[GRID_WIDTH][GRID_HEIGHT];
		solution = new SudokuSolution();
	}

	//	Method for creating playable board.		Takes blanks parameter
	//		Starts by creating solution
	//		The board is then assigned the solution
	//		The createBlanks method is then called
	//		The completed board is then returned
	public int[][] createBoard(int blanks)
	{
		board = new int[GRID_WIDTH][GRID_HEIGHT];
		
		newSolution();
		createBlanks(blanks);

		return board;
	}

	public void newSolution()
	{
		solution.makeNewSolution();

		for (int x = 0; x < 9; x++)
		{
			for (int y = 0; y < 9; y++)
			{
				board[x][y] = solution.getValue(x,y);
			}
		}
	}

	public void createBlanks(int blanks)
	{
		int row;
		int col;

		int placed = 0;

		while(placed < blanks)
		{
			row =  
			col = rdm.nextInt(8);

			if(board[row][col] != HOLE)
			{
				if(testHole(row, col))
				{
					board[row][col] = HOLE;
					placed++;
				}
			}
		}
	}

	public boolean testHole(int row, int col)
	{
		int prevVal;

		prevVal = board[row][col];
		board[row][col] = HOLE;
		
		if(isValid(row, col, prevVal))
		{
			board[row][col] = prevVal;
			return false;
		}

		return true;
	}

	private boolean isValid(int row, int col, int check)
	{
		for(int x = 0; x < GRID_WIDTH; x++)
		{
		    for(int y = 0; y < GRID_HEIGHT; y++)
		    {
				if(board[x][y] == HOLE)
				{
					for (int temp = 1; temp <= 9; temp++)
					{
						if(x == row && y == col && temp == check)
						{
							temp++;
						}
								if(temp < 10 && validMove(x, y, temp))
								{
									board[x][y] = temp;
								
									if(isValid(row, col, check))
									{
										board[x][y] = HOLE;
										return true;
									}
								}
					}
					
					board[x][y] = HOLE;
					return false;
				}
			}
		}
		return true;
	}

	private boolean validMove(int row, int col, int numCheck)
	{
		int rowStart;
		int colStart;

		rowStart = (row / 3) * 3;
		colStart = (col / 3) * 3;

		if(numCheck > 9 || numCheck < 1)
		{
			return false;
		}

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

	public boolean setValue(int row, int col, int value)
	{
		if(validMove(row, col, value))
		{
			board[row][col] = value;
			return true;
		}

		return false;
	}

	public int getValue(int row, int col)
	{
		return board[row][col];
	}


	// Prints Board on stdout
	public void printBoard()
	{
	    for(int i = 0; i < 9; i++)
	    {
	        for(int j = 0; j < 9; j++)
	        {
	            System.out.print(board[i][j] + "  ");
	        }
	        System.out.println();
	    }
	    System.out.println();
	}
        
        // Prints Solution on stdout
	public void printSolution()
	{
		solution.printSolution();
	}

        /*
            public static void main(String[] args)
            {
                SudokuBoard sg = new SudokuBoard();
        
                sg.createBoard(33);
                sg.printBoard();
            }
        */
}
