package sudoku;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;


public class SudokuGUI extends JFrame
{
    public static final int GRID_HEIGHT = 9;
    public static final int GRID_WIDTH = 9;

    int selectedX;
    int selectedY;
    JPanel jPanelBoard = new JPanel();
    CellBox box[] = new CellBox[9];
    SudokuBoard puzzle;

    public SudokuGUI()
    {
        super("Stolz's Sudoku App");

        selectedX = 0;
        selectedY = 0;

        puzzle = new SudokuBoard();
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jPanelBoard.setLayout(new GridLayout(3, 3));
            for(int q = 0; q < 9; q++)
            {
                box[q] = new CellBox();
                jPanelBoard.add(box[q]);
            }

        add(jPanelBoard);
        setVisible(true);
    }

    public void newGame(int blanks)
    {
        puzzle.createBoard(blanks);
        fillBoard();
    }

    public void fillBoard()
    {
        int value;
        int cellNum;
        int row;
        int col;

        for(int b = 0; b < 9; b++)
        {
          cellNum = 0;
          for(int x = 0; x < 3; x++)
          {
            for(int y = 0; y < 3; y++)
            {
                if(b < 3)
                {
                    row = x;
                }
                else if(b < 6)
                {
                    row = x + 3;
                }
                else
                {
                    row = x + 6;
                }

                if((b % 3) == 0)
                {
                    col = y;
                }
                else if((b % 3) == 1)
                {
                    col = y + 3;
                }
                else
                {
                    col = y + 6;
                }
                value = puzzle.getValue( row, col);
                box[b].setInitial(value, 2, cellNum, row, col);
                cellNum++;
            }
          }
      }
    }
        
    public void setCell(int value)
    {
        int type;
        for(int b = 0; b < 9; b++)
        {
            for(int c = 0; c < 9; c++)
            {
                if(box[b].userCell[c].checkedValue)
                {
                    selectedX = box[b].userCell[c].x;
                    selectedY = box[b].userCell[c].y;
                }
            }
        }
        
        if(puzzle.setValue(selectedX, selectedY, value))
        {
            type = 0;
        }
        else
        {
            type = 1;
        }
    }

      

    public void printSolution()
    {
            puzzle.printSolution();
    }

    public void printBoard()
    {
            puzzle.printBoard();
    }
}