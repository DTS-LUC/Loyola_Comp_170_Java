	private boolean isValid(int row, int col, int check)
	{
		for(int x = 0; x < WIDTH; x++)
		{
		    for(int y = 0; y < HEIGHT; y++)
		    {
				if(boardTest[x][y] == HOLE)
				{
					for (int temp = 1; temp <= 9; temp++)
					{
						if(x == row && y == col && temp == check)
						{
							temp++;
							}
								if(temp < 10 && validMove(x, y, temp))
								{
								boardTest[x][y] = temp;
								
								if(isValid(row, col, check))
								{
									boardTest[x][y] = HOLE;
									return true;
								}
							}
						}
						boardTest[x][y] = HOLE;
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