package sudoku;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;


public class Cell extends JTextField implements KeyListener
{
	public static final Color OPEN_CELL_BGCOLOR = Color.YELLOW;
	public static final Color CLOSED_CELL_BGCOLOR = new Color(240, 240, 240);
	public static final Color VALID_CELL_BGCOLOR = Color.GREEN;
	public static final Color INVALID_CELL_BGCOLOR = Color.RED;
	public static final Font FONT_NUMBERS = new Font("Lucida Grande", 1, 48);
        
        int x;      // X position in game.
        int y;      // Y position in game.
        boolean checkedValue;

	public Cell()
	{
            setFont(FONT_NUMBERS);
            setHorizontalAlignment(CENTER);
            setText("");
            setEditable(false);
            setBackground(OPEN_CELL_BGCOLOR);
            setSize(65, 65);
            this.addKeyListener(this);
    }
 
        public void setXY(int newX, int newY)
        {
            x = newX;
            y = newY;
        }
	
        public void setCellValue(int value, int type)
	{
            if(value == 0)
            {
                setText("");
//                    setEditable(true);
                setBackground(OPEN_CELL_BGCOLOR);
            }
            else if(type == 2)
            {
                setText(value + "");
                setBackground(CLOSED_CELL_BGCOLOR);
            }
            else if(type == 0)
            {
                    setText(value + "");
                    setBackground(VALID_CELL_BGCOLOR);
            }
            else
            {
                    setText(value + "");
                    setBackground(INVALID_CELL_BGCOLOR);
            }
            checkedValue = true;
	}

    public int getCellValue()
	{
		int value;
		value = Integer.parseInt(getText());
		return value;
	}
    

    public void keyTyped(KeyEvent e){
    }

    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_0:
                setText("");
                break;
            case KeyEvent.VK_1:
                setText("1");
                break;
            case KeyEvent.VK_2:
                setText("2");
                break;
            case KeyEvent.VK_3:
                setText("3");
                break;
            case KeyEvent.VK_4:
                setText("4");
                break;
            case KeyEvent.VK_5:
                setText("5");
                break;
            case KeyEvent.VK_6:
                setText("6");
                break;
            case KeyEvent.VK_7:
                setText("7");
                break;
            case KeyEvent.VK_8:
                setText("8");
                break;
            case KeyEvent.VK_9:
                setText("9");
                break;
            default:
                setText("");
                break;
        }
        checkedValue = true;
    }

    public void keyReleased(KeyEvent e) {
    }
}