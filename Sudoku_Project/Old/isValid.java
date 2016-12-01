private boolean isValid(row, col, check)
{
    for(int x = 0; x < WIDTH; x++)
    {
        for(int y = 0; y < HEIGHT; y++)
        {
            if(board[x][y] == HOLE)
            {
                for (int temp = 1; temp <= 9; temp++)
                {
                    if(x == row && y == col && temp == check)
                    {
                        temp++
                    }
                    if(temp < 10 && validMove(x, y, temp))
                    {
                        board[x][y] = temp;
                        if(isValid(row, col, check))
                        {
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