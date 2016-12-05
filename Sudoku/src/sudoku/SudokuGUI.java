import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class SudokuGUI extends JFrame
{
	JPanel jPanelBoard = new JPanel();
	CellBox box[] = new CellBox[9];

	public SudokuGUI()
	{
		super("Stolz's Sudoku App");
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

	public static void main(String[] args)
	{
		new SudokuGUI();
	}
}