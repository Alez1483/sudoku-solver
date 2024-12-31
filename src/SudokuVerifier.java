public class SudokuVerifier
{
    //checks for rule violations, may or may not be solvable
    public static boolean isValid(int[][] board)
    {
        if (!areRowsValid(board))
        {
            return false;
        }
        if (!areColumnsValid(board))
        {
            return false;
        }
        return areSubGridsValid(board);
    }

    public static boolean isValid(SudokuBoard board)
    {
        return isValid(board.board);
    }

    //duplicates on rows?
    public static boolean areRowsValid(int[][] board)
    {
        DigitSetDuplicateChecker duplicateChecker = new DigitSetDuplicateChecker();        

        for (int rowIndex = 0; rowIndex < 9; rowIndex++)
        {
            for (int columnIndex = 0; columnIndex < 9; columnIndex++) 
            {
                duplicateChecker.add(board[columnIndex][rowIndex]);
            }
            if (duplicateChecker.hasDuplicates)
            {
                return false;
            }
            duplicateChecker.clear();
        }
        return true;
    }

    //duplicates on columns?
    public static boolean areColumnsValid(int[][] board)
    {
        DigitSetDuplicateChecker duplicateChecker = new DigitSetDuplicateChecker();        

        for (int columnIndex = 0; columnIndex < 9; columnIndex++)
        {
            int[] column = board[columnIndex];
            for (int digit: column) 
            {
                duplicateChecker.add(digit);
            }
            if (duplicateChecker.hasDuplicates)
            {
                return false;
            }
            duplicateChecker.clear();
        }
        return true;
    }

    //duplicates on subgrids?
    public static boolean areSubGridsValid(int[][] board)
    {
        DigitSetDuplicateChecker duplicateChecker = new DigitSetDuplicateChecker();        

        //iterate all subgrids
        for (int startColumn = 0; startColumn <= 6; startColumn += 3)
        {
            for (int startRow = 0; startRow <= 6; startRow += 3)
            {
                //iterate subgrid in range board[from startColumn to startColumn + 3][from startRow to startRow + 3]
                for (int columnIdx = startColumn; columnIdx < startColumn + 3; columnIdx++)
                {
                    for (int rowIdx = startRow; rowIdx < startRow + 3; rowIdx++)
                    {
                        duplicateChecker.add(board[columnIdx][rowIdx]);
                    }
                }
                if (duplicateChecker.hasDuplicates)
                {
                    return false;
                }
                duplicateChecker.clear();
            }
        }
        return true;
    }

    //stores digits of row/column/box and notifys if digit is added twice
    private static class DigitSetDuplicateChecker
    {
        //holds information of whether digit 1-9 is added already
        private boolean[] digitAdded = new boolean[9];
        private boolean hasDuplicates = false; 

        //returns true if digit is not yet added
        //adding multiple zeroes is fine though (empties)
        private boolean add(int digit)
        {
            if (digit == 0)
            {
                return true;
            }

            int index = digit - 1;
            if (digitAdded[index])
            {
                hasDuplicates = true;
                return false;
            }
            digitAdded[index] = true;
            return true;
        }

        private void clear()
        {
            hasDuplicates = false;
            for (int index = 0; index < 9; index++)
            {
                digitAdded[index] = false;
            }
        }
    }
}