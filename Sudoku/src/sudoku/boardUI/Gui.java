import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

public class Gui {

    Gui gui;
    JPanel board;
    JPanel subBoard[][];
    GridLayout layout;
    JLabel square[][];
    Border big;
    Border small;

    public void load()
    {

        gui = new Gui();
        gui.setUp();
        gui.buildBoard();

    }

    private void setUp() {

        layout = new GridLayout( 3, 3);
        board = new JPanel(layout);
        subBoard = new JPanel[3][3];
        square = new JLabel[9][9];

    }

    private void buildBoard()
    {

        // set up board
        board.setVisible(true);

        int mod = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // add subBoards to board
                board.add(subBoard[i][j]);
                subBoard[i][j].setLayout(layout);

                // add textfields to each subBoard
                subBoard[i][j].add(square[i + mod][j + mod]);

            }
            mod += 3;

        }
    }

}