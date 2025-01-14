import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class SudokuSolverApp
{
    JFrame frame;
    private final int width = 500;
    private final int height = 500;
    private final int lineThickness = 1;
    public static void main(String[] args)
    {
        SudokuSolverApp app = new SudokuSolverApp();
        app.launch();
    }

    public void launch() 
    {
        String sudokuToSolve = """
        ,-----,-----,-----,
        |1 . 3|. 5 .|7 . 9|
        |. 5 .|7 . 9|. 2 .|
        |7 . 9|. 2 .|4 . 6|
        :----- ----- -----:
        |. 1 .|3 . 5|. 7 .|
        |3 . 5|. 7 .|9 . 2|
        |. 7 .|9 . 2|. 4 .|
        :----- ----- -----:
        |8 . 1|. 3 .|5 . 7|
        |. 3 .|5 . 7|. 9 .|
        |5 . 7|. 9 .|2 . 4|
        '-----'-----'-----'
        """;
        SudokuBoard board = new SudokuBoard(sudokuToSolve);
        SudokuSolver solver = new SudokuSolver(board);

        frame = new JFrame("Sudoku Solver");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setSize(new Dimension(width, height));
        //frame.setResizable(false);
        JPanel sudokuArea = new JPanel(null);
        sudokuArea.setSize(width, height);
        //frame.setContentPane(sudokuArea);
        frame.add(sudokuArea);
        frame.pack();
        

        for (int x = 0; x < 1; x++)
        {
            JPanel rectangle = new JPanel();
            rectangle.setBackground(Color.black);
            rectangle.setBorder(BorderFactory.createLineBorder(Color.green, lineThickness));
            rectangle.setBounds(250, 250, 100, 100);

            frame.add(rectangle);
        }

        frame.setVisible(true);
    }
}