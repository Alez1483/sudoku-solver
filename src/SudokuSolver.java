public class SudokuSolver
{
    private int[][][] possibilities = new int[9][9][9]; //very wasteful for now
    private SudokuBoard board;

    public SudokuSolver(SudokuBoard board)
    {
        this.board = board;

        for (int x = 0; x < 9; x++)
        {
            for (int y = 0; y < 9; y++)
            {
                int[] digits = possibilities[x][y];

                for (int i = 0; i < 9; i++)
                {
                    digits[i] = i + 1;
                }
            }
        }
    }

    public int[] getDigits(int x, int y)
    {
        return possibilities[x][y];
    }
}
