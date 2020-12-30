/**
 * Given an m x n board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Example 3:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 * Constraints:
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 200
 * 1 <= word.length <= 10^3
 * board and word consists only of lowercase and uppercase English letters.
 */
public class Problem79 {

    /**
     * Method to determine if a given word exists in the matrix board, by combining the adjoining the chars
     * Approach used is that of dfs to check all the adjoining cells for potential matches
     *
     * @param board
     * @param word
     * @return
     */
    private static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[] wordArray = word.toCharArray();
        int k = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != wordArray[k]) { continue; }
                boolean[][] marked = new boolean[m][n];
                boolean b = dfs(board, marked, wordArray, i, j, k + 1);
                if (b) { return true; }
            }
        }
        return false;
    }

    /**
     * DFS method to track the completion of the given word and determine whether it exists
     *
     * @param board
     * @param marked
     * @param wordArray
     * @param i
     * @param j
     * @param k
     * @return
     */
    private static boolean dfs(char[][] board, boolean[][] marked, char[] wordArray, int i, int j, int k) {
        if (k == wordArray.length) { return true; }
        marked[i][j] = true;

        if (i > 0 && board[i - 1][j] == wordArray[k] && !marked[i - 1][j]) {
            boolean b = dfs(board, marked, wordArray, i - 1, j, k + 1);
            if (b) { return true; }
            marked[i - 1][j] = false;
        }
        if (j > 0 && board[i][j - 1] == wordArray[k] && !marked[i][j - 1]) {
            boolean b = dfs(board, marked, wordArray, i, j - 1, k + 1);
            if (b) { return true; }
            marked[i][j - 1] = false;
        }
        if (i < board.length - 1 && board[i + 1][j] == wordArray[k] && !marked[i + 1][j]) {
            boolean b = dfs(board, marked, wordArray, i + 1, j, k + 1);
            if (b) { return true; }
            marked[i + 1][j] = false;
        }
        if (j < board[0].length - 1 && board[i][j + 1] == wordArray[k] && !marked[i][j + 1]) {
            boolean b = dfs(board, marked, wordArray, i, j + 1, k + 1);
            if (b) { return true; }
            marked[i][j + 1] = false;
        }
        marked[i][j] = false;
        return false;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        System.out.println(exist(board, word));
    }
}
