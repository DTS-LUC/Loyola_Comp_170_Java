import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Cell extends JTextField
{
	public static final Color OPEN_CELL_BGCOLOR = Color.YELLOW;
	public static final Color CLOSED_CELL_BGCOLOR = new Color(240, 240, 240);
	public static final Color VALID_CELL_BGCOLOR = Color.GREEN;
	public static final Color INVALID_CELL_BGCOLOR = Color.RED;
	public static final Font FONT_NUMBERS = new Font("Lucida Grande", 1, 48);

	public Cell()
	{
		setFont(FONT_NUMBERS);
        setHorizontalAlignment(CENTER);
        setText("0");
        setBackground(CLOSED_CELL_BGCOLOR);
        setEditable(true);
		setSize(65, 65);
	}

	public void makeEditable()
	{
		setText("");
		setEditable(true);
		setBackground(OPEN_CELL_BGCOLOR);
	}
	public void setInitialCellValue(int value)
	{	if(value == 0)
		{
			makeEditable();
		}
		else
		{
			setText(value + "");
		}
	}

	public void setCellValue(int value, boolean valid)
	{
		if(value == 0)
		{
			setText("");
		}
		else if(valid)
		{
			setBackground(VALID_CELL_BGCOLOR);
		}
		else
		{
			setBackground(VALID_CELL_BGCOLOR);
		}

	}

	public int getCellValue()
	{
		int value;
		value = Integer.parseInt(getText());
		return value;
	}
}