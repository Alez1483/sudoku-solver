public class SudokuBoard
{
    public int[][] board = new int[9][9];

    //parses a board from string, supported formats below the class code
    //doesn't check for solvability, only for rule violations
    public SudokuBoard(String boardString)
    {
        int boardIndex = 0;
        //fills the board as long as there's characters, if there are too few characters, the rest will be empties
        for (int index = 0; index < boardString.length() && boardIndex < 81; index++)
        {
            char c = boardString.charAt(index);

            if (c >= '1' && c <= '9')
            {
                int xIdx = boardIndex % 9;
                int yIdx = 8 - boardIndex / 9;
                board[xIdx][yIdx] = c - '0'; //'1' yields integer 1 etc.
                boardIndex++;
                continue;
            }
            if (c == '.' || c == '0')
            {
                boardIndex++; //leave empties untouched (0 by default)
            }
        }

        if (!SudokuVerifier.isValid(this))
        {
            throw new IllegalArgumentException("Given Sudoku consists duplicates on rows, columns or subgrids");
        }
    }
}

/* the following string formats are supported:
(both are made of strings of numbers with special character as empty,
    the strings may include other characters like line breaks instead of being on one line)

1. zeros as places of empties, for example:
103050709
050709020
709020406
010305070
305070902
070902040
801030507
030507090
507090204

2. dots as places of empties, for example:
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

one could also mix zeros and dots as empties (but why do that?)
*/ 