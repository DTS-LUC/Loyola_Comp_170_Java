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

	public void setCellValue(int value, boolean valid, int cellNum)
	{
		userCell[cellNum].setCellValue(value, valid);
	}

	public int getCellValue(int cellNum)
	{
		return userCell[cellNum].getCellValue();
	}

	public void setInitialCellValue(int value, int cellNum)
	{
		userCell[cellNum].setInitialCellValue(value);
	}
}