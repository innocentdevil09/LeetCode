/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 *
 * Constraints:
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution.
 */
public class Problem37 {

    private static final int LENGTH_OF_BOARD = 9;

    /**
     * Method to solve the given sudoku board. The time complexity of this approach is O(9 ^ m) where m is the number
     * of blanks in the given sudoku board.
     *
     * @param board
     * @return
     */
    private static boolean solveSudoku(char[][] board) {
        for (int i = 0; i < LENGTH_OF_BOARD; i++) {
            for (int j = 0; j < LENGTH_OF_BOARD; j++) {
                if (board[i][j] != '.') { continue; }

                for (char c = '1'; c <= '9'; c++) {
                    if (isValidSudoku(board, i, j, c)) {
                        board[i][j] = c;
                        if (solveSudoku(board)) {
                            return true;
                        }
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    /**
     * Method to validate if the given character c is a valid input for sudoku in the given row & col combination.
     * As usual, we check if the same integer already exists in the provided row, provided col and the subBox
     * containing the row/col combination.
     *
     * @param board
     * @param row
     * @param col
     * @param c
     * @return
     */
    private static boolean isValidSudoku(char[][] board, int row, int col, char c) {
        for (int i = 0; i < LENGTH_OF_BOARD; i++) {
            if (board[row][i] == c) { return false; }
            if (board[i][col] == c) { return false; }

            int subBoxRow = (row/3) * 3 + i/3;
            int subBoxCol = (col/3) * 3 + i%3;
            if (board[subBoxRow][subBoxCol] == c) { return false; }
        }
        return true;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(solveSudoku(board));
        for (char[] row : board) {
            for (char col : row) {
                System.out.print(col + " | ");
            }
            System.out.print("\n");
        }
    }
}