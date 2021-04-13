import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example 1:
 *
 * Input: board = [['X','X','X','X'],['X','O','O','X'],['X','X','O','X'],['X','O','X','X']]
 * Output: [['X','X','X','X'],['X','X','X','X'],['X','X','X','X'],['X','O','X','X']]
 * Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board
 * are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be
 * flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 *
 * Example 2:
 * Input: board = [['X']]
 * Output: [['X']]
 *
 * Constraints:
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 */
public class Problem130 {

    /**
     * DFS traversal
     * Algo:
     * 1. Check all border slots in board containing char 'O' since they are not captured
     * 2. Run DFS traversal on all these boarder slots to mark all slots which are not captured since they are connected
     * 3. Update the board
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param board
     */
    private static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) { return; }
        int rows = board.length;
        int cols = board[0].length;

        List<int[]> list = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') {
                list.add(new int[]{r, 0});
            }
            if (board[r][cols - 1] == 'O') {
                list.add(new int[]{r, cols - 1});
            }
        }

        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') {
                list.add(new int[]{0, c});
            }
            if (board[rows - 1][c] == 'O') {
                list.add(new int[]{rows - 1, c});
            }
        }

        for (int[] pair : list) {
            if (board[pair[0]][pair[1]] == 'M') { continue; }
            dfs(board, pair[0], pair[1], rows, cols);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if (board[r][c] == 'M') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    /**
     * DFS traversal
     *
     * @param board
     * @param r
     * @param c
     * @param rows
     * @param cols
     */
    private static void dfs(char[][] board, int r, int c, int rows, int cols) {
        board[r][c] = 'M';
        if (r > 0 && board[r - 1][c] == 'O') {
            dfs(board, r - 1, c, rows, cols);
        }
        if (r < rows - 1 && board[r + 1][c] == 'O') {
            dfs(board, r + 1, c, rows, cols);
        }
        if (c > 0 && board[r][c - 1] == 'O') {
            dfs(board, r, c - 1, rows, cols);
        }
        if (c < cols - 1 && board[r][c + 1] == 'O') {
            dfs(board, r, c + 1, rows, cols);
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

        solve(board);
    }
}
