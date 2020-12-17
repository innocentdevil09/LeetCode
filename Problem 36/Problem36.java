import java.util.HashMap;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following
 * rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 * Constraints:
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'
 */
public class Problem36 {

    /**
     * This approach involves creating arrays for rows & columns, and also dividing each subBox into 9 parts
     * alongwith their index. Doing so helps to resolve the problem in one pass over the board.
     *
     * @param board
     * @return
     */
    private static boolean validSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxIndexes = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxIndexes[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') { continue; }

                int num = (int) c;
                rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                columns[j].put(num, columns[j].getOrDefault(num, 0) + 1);

                int boxIndex = (i / 3) * 3 + (j / 3);
                boxIndexes[boxIndex].put(num, boxIndexes[boxIndex].getOrDefault(num, 0) + 1);
                if (rows[i].get(num) > 1 || columns[j].get(num) > 1 || boxIndexes[boxIndex].get(num) > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(validSudoku(board));
    }
}
