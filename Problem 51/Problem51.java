import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each
 * other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate
 * a queen and an empty space, respectively.
 *
 * Example 1:
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 *
 * Example 2:
 * Input: n = 1
 * Output: [["Q"]]
 *
 * Constraints:
 * 1 <= n <= 9
 */
public class Problem51 {

    /**
     * Method to solve n-queens problem using constraints and backtracking approach
     *
     * Time complexity: O(N!)
     * Note: i guess we could save on time consumption if we use individual int[] arrays for rows, columns, diagonals
     * -- instead of single double matrix to represent board.
     * Also, that would do away with the step of correcting marks of previous row's queens.
     *
     * @param n
     * @return
     */
    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        String[][] board = new String[n][n];
        backtrack(result, board, 0, n);
        return result;
    }

    /**
     * The approach involves putting restrictions after each queen placement. One puts a queen on the board and that
     * immediately excludes one column, one row and two diagonals for the further queens placement. That propagates
     * constraints and helps to reduce the number of combinations to consider.
     *
     * 1. Start from the first row = 0.
     *
     * 2. Iterate over the columns and try to put a queen in each column.
     *
     * 3. If square (row, column) is not under attack
     *      Place the queen in (row, column) square.
     *      Exclude one row, one column and two diagonals from further consideration.
     * 4. If all rows are filled up row == N
     *      That means that we find out one more solution.
     * 5. Else
     *      Proceed to place further queens backtrack(row + 1).
     * 6. Now backtrack : remove the queen from (row, column) square.
     *
     * @param result
     * @param board
     * @param row
     * @param n
     */
    private static void backtrack(List<List<String>> result, String[][] board, int row, int n) {
        if (row == n) {
            //add elements of board into result
            addToResult(result, board);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (board[row][col] != null && board[row][col].equals("*")) {
                continue;
            }
            markSpaces(board, row, col, "*");
            board[row][col] = "Q";
            backtrack(result, board, row + 1, n);
            markSpaces(board, row, col, ".");
            correctPreviousMarks(board, row);
        }
    }

    /**
     * Method to mark all the elements for the given row, column, as well as diagonals in both directions with the
     * given mark
     *
     * @param board
     * @param row
     * @param col
     * @param mark
     */
    private static void markSpaces(String[][] board, int row, int col, String mark) {
        int n = board.length;
        for (int k = 0; k < n; k++) {
            board[row][k] = mark;
            board[k][col] = mark;
        }

        int i = row, j = col;
        while (i < n && j < n) {
            board[i][j] = mark;
            i += 1;
            j += 1;
        }
        i = row; j = col;

        while (i >= 0 && j < n) {
            board[i][j] = mark;
            i -= 1;
            j += 1;
        }
        i = row; j = col;

        while (i >= 0 && j >= 0) {
            board[i][j] = mark;
            i -= 1;
            j -= 1;
        }
        i = row; j = col;

        while (i < n && j >= 0) {
            board[i][j] = mark;
            i += 1;
            j -= 1;
        }
        board[row][col] = mark;
    }

    /***
     * Method to correct asterix marks due to queen's positions in previous rows
     *
     * @param board
     * @param row
     */
    private static void correctPreviousMarks(String[][] board, int row) {
        int n = board.length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != null && board[i][j].equals("Q")) {
                    markSpaces(board, i, j, "*");
                    board[i][j] = "Q";
                }
            }
        }
    }

    /**
     * Add all elements of the given board into the result as a list
     *
     * @param result
     * @param board
     */
    private static void addToResult(List<List<String>> result, String[][] board) {
        List<String> list = new ArrayList<>();
        for (String[] rows : board) {
            StringBuilder sb = new StringBuilder();
            for (String col : rows) {
                if (col.equals("Q")) { sb.append(col); }
                else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        result.add(list);
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int n = 4;

        System.out.println(solveNQueens(n));
    }
}
