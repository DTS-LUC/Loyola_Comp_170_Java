

private boolean	isValid(int row, int col, int num)
{
	int row_start;
	int col_start;
	int i;

	row_start = row;
	col_start = col;
	i = 0;

	while (i < 9)
	{
		if (solution[row][i] == num)
		{
			return false;
		}

		if (solution[i][col] == num)
		{
			return false;
		}

		if (solution[row_start + (i % 3)][col_start + (i / 3)] == num)
		{
			return false;
		}
		i++;
	}
	return true;
}