import java.awt.*;
import java.swing.*;

/**
 * The Sudoku game.
 * To solve the number puzzle, each row, each column, and each of the
 * nine 3×3 sub-grids shall contain all of the digits from 1 to 9
 */
public class PlayableBoard extends JFrame {
   // Name-constants for the game properties
   public static final int GRID_SIZE = 9;    // Size of the board
   public static final int SUBGRID_SIZE = 3; // Size of the sub-grid
   public static final int HOLE = 0;
 
   // Name-constants for UI control (sizes, colors and fonts)
   public static final int CELL_SIZE = 60;   // Cell width/height in pixels
   public static final int CANVAS_WIDTH  = CELL_SIZE * GRID_SIZE;
   public static final int CANVAS_HEIGHT = CELL_SIZE * GRID_SIZE; // Board width/height in pixels

   public static final Color OPEN_CELL_BGCOLOR = Color.GREEN;
   public static final Color OPEN_CELL_TEXT_YES = new Color(0, 255, 0);  // RGB
   public static final Color OPEN_CELL_TEXT_NO = Color.RED;
   public static final Color CLOSED_CELL_BGCOLOR = new Color(240, 240, 240); // RGB
   public static final Color CLOSED_CELL_TEXT = Color.BLACK;
   public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 20);
 
   // The game board composes of 9x9 JTextFields,
   // each containing String "1" to "9", or empty String
   private JTextField[][] userBoard = new JTextField[GRID_SIZE][GRID_SIZE];
   private SudokuBoard newBoard = new SudokuBoard();

   public Sudoku(int blanks)
   {
   		newBoard = new SudokuBoard(); //Create new board
   		newBoard.createBoard(blanks);

     	Container cp = getContentPane();
    	cp.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));  // 9x9 GridLayout
 
    	// Allocate a common listener as the ActionEvent listener for all the
    	//  JTextFields
    	InputListener listener = new InputListener();
 
    	// Construct 9x9 JTextFields and add to the content-pane
    	for (int row = 0; row < GRID_SIZE; ++row)
    	{
         for (int col = 0; col < GRID_SIZE; ++col)
         {
            userBoard[row][col] = new JTextField(); // Allocate element of array
            cp.add(userBoard[row][col]);            // ContentPane adds JTextField
            if (newBoard.getValue(row, col) == HOLE)
            {
               userBoard[row][col].setText("");     // set to empty string
               userBoard[row][col].setEditable(true);
               userBoard[row][col].setBackground(OPEN_CELL_BGCOLOR);
 
               // Add ActionEvent listener to process the input
               userBoard[row][col].addActionListener(listener);
            }
            else
            {
               userBoard[row][col].setText(newBoard.getValue(row, col) + "");
               userBoard[row][col].setEditable(false);
               userBoard[row][col].setBackground(CLOSED_CELL_BGCOLOR);
               userBoard[row][col].setForeground(CLOSED_CELL_TEXT);
            }
            // Beautify all the cells
            userBoard[row][col].setHorizontalAlignment(JTextField.CENTER);
            userBoard[row][col].setFont(FONT_NUMBERS);
         }
      }
 
      // Set the size of the content-pane and pack all the components
      //  under this container.
      cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
      pack();
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Handle window closing
      setTitle("Sudoku");
      setVisible(true);
   }

   private class InputListener implements ActionListener {
 
      @Override
      public void actionPerformed(ActionEvent e)
      {
         // All the 9*9 JTextFileds invoke this handler. We need to determine
         // which JTextField (which row and column) is the source for this invocation.
         int rowSelected = -1;
         int colSelected = -1;
 
         // Get the source object that fired the event
         JTextField source = (JTextField)e.getSource();
         // Scan JTextFileds for all rows and columns, and match with the source object
         boolean found = false;
         for (int row = 0; row < GRID_SIZE && !found; ++row) {
            for (int col = 0; col < GRID_SIZE && !found; ++col) {
               if (tfCells[row][col] == source)
               {
                  rowSelected = row;
                  colSelected = col;
                  found = true;  // break the inner/outer loops
               }
            }
         }
 
         /*
          * [TODO 5]
          * 1. Get the input String via tfCells[rowSelected][colSelected].getText()
          * 2. Convert the String to int via Integer.parseInt().
          * 3. Assume that the solution is unique. Compare the input number with
          *    the number in the puzzle[rowSelected][colSelected].  If they are the same,
          *    set the background to green (Color.GREEN); otherwise, set to red (Color.RED).
          */

 
         /* 
          * [TODO 6] Check if the player has solved the puzzle after this move.
          * You could update the masks[][] on correct guess, and check the masks[][] if
          * any input cell pending.
          */
      }
   }
}