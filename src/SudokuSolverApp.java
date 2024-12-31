import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class SudokuSolverApp
{
    JFrame frame;
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

        frame = new JFrame("Sudoku Solver");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        frame.setResizable(false);
        Container pane = frame.getContentPane();
        frame.setVisible(true);
    }
}