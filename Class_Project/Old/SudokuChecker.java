import java.util.*;
import java.text.*;

// The Sudoku Checker class implemnts a solver to check if the
//		given 2d array is a valid Sodoku

public class SudokuChecker
{
	public static final int WIDTH = 9;
	public static final int HEIGHT = 9;

	int[][]	boardCheck;

	public SudokuChecker()
	{
		boardCheck = new int[WIDTH][HEIGHT];
	}

	public boolean validSudoku(int[][] board, int row, int col)
	{
		int numPossible;
		numPossible = 0;

		for(int x = 0; x < 9; x++)
		{
			for(int y = 0; y < 9; y++)
			{
				boardCheck[x][y] = board[x][y];
			}
		}

		for(int i = 1; i <= 9; i++)
		{
			boardCheck[row][col] = i;
			if(canSolve(row, col))
			{
				for(int x = 0; x < 9; x++)
				{
					for(int y = 0; y < 9; y++)
					{
						boardCheck[x][y] = board[x][y];
					}
				}
				numPossible++;
			}

		}

		if(numPossible == 1)
		{
			return true;
		}

		return false;
	}

	public boolean canSolve(int row, int col)
	{
		int i;
		boolean possible;

		possible = false;
		if (row < 9 && col < 9)
		{
			if (boardCheck[row][col] != 0)
			{
				if ((col + 1) < 9)
				{
					return (canSolve(row, col + 1));
				}
				else if ((row + 1) < 9)
				{
					return (canSolve(row + 1, 0));
				}
				else
				{
					return true;
				}
			}
			else
			{
				i = 0;
				possible = findDigit(i, row, col);
			}
		}
		return possible;
	}

	public boolean	findDigit(int i, int row, int col)
	{
		while (i < 9)
		{
			if (validMove(row, col, i + 1))
			{
				boardCheck[row][col] = i + 1;
				if ((col + 1) < 9)
				{
					if (canSolve(row, col + 1))
						return true;
					else
						boardCheck[row][col] = 0;
				}
				else if ((row + 1) < 9)
				{
					if (canSolve(row + 1, 0))
						return true;
					else
						boardCheck[row][col] = 0;
				}
				else
					return true;
			}
			i++;
		}
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
			if(numCheck == boardCheck[row][i])	//	Check no repeats in row
			{
				return false;
			}

			if(numCheck == boardCheck[i][col])	//	Check no repeats in column
			{
				return false;
			}

			if (boardCheck[rowStart + (i % 3)][colStart + (i / 3)] == numCheck)	//	Check for no repeats in box
			{
				return false;
			}
		}

		return true;
	}
}




