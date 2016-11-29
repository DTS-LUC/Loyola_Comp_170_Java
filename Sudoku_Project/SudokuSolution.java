import java.util.*;
import java.text.*;


//The SudokuBoard class creates a random standard (9x9)
//Sudoku board through the use of backtracking techniques.


public class SudokuSolution
{

	public static final int WIDTH = 9;
	public static final int HEIGHT = 9;




	//	Constructor.  Resets board & solution to zero.
	public SudokuSolution()
	{
		solution = new int[WIDTH][HEIGHT];
	}

	public int[][] makeNewSolution()
	{
		solution = new int[WIDTH][HEIGHT];

		fillCell(0,0);
		return solution;
	}



	public boolean fillCell(int x, int y)
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
	        if(validMove(x, y, toCheck[i]))
	        {
	            solution[x][y] = toCheck[i];
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
	    solution[x][y] = 0;
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
			if(numCheck == solution[row][i])	//	Check no repeats in row
			{
				return false;
			}

			if(numCheck == solution[i][col])	//	Check no repeats in column
			{
				return false;
			}

			if (solution[rowStart + (i % 3)][colStart + (i / 3)] == numCheck)	//	Check for no repeats in box
			{
				return false;
			}
		}

		return true;
	}


	// Prints Solution on stdout
	public void printSolution()
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
				System.out.print(solution[i][j] + "  ");
			System.out.println();
		}
		System.out.println();
	}

	public int getValue(int row, int col)
	{
		return solution[row][col];
	}


	// public static void main(String[] args)
	// {
	// 	SudokuSolution sg = new SudokuSolution();
	// 	sg.makeNewSolution();
	// 	sg.printSolution();
	// }

	int[][]	solution;
}