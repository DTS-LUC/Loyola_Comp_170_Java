package sudoku;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class CellBox extends JPanel
{
	Cell userCell[] = new Cell[9];

	public CellBox()
	{
		setSize(200,200);
		setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

		setLayout(new GridLayout(3, 3));
		for(int i = 0; i < 9; i++)
		{
			userCell[i] = new Cell();
                        add(userCell[i]);
		}
	}
        
        public void setCell(int value, int type, int cellNum)
	{
            userCell[cellNum].setCellValue(value, type);
	}
          
	public void setInitial(int value, int type, int cellNum, int x, int y)
	{
            userCell[cellNum].setCellValue(value, type);
            userCell[cellNum].setXY(x, y);
	}

	public int getCellValue(int cellNum)
	{
		return userCell[cellNum].getCellValue();
	}
}