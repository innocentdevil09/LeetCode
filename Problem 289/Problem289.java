import java.util.Arrays;

/**
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by
 * the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or
 * dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the
 * following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state, where
 * births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 *
 * Example 1:
 * Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 *
 * Example 2:
 * Input: board = [[1,1],[1,0]]
 * Output: [[1,1],[1,1]]
 *
 * Constraints:
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] is 0 or 1.
 *
 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some
 * cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause
 * problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How
 * would you address these problems?
 */
public class Problem289 {

    // from earlier live to dead now
    private static final int LIVE_TO_DEAD = -1;
    // from earlier dead to live now
    private static final int DEAD_TO_LIVE = 2;

    /**
     * Method to get the next state in the Game of Life
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(1)
     *
     * @param board
     */
    private static void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int liveCount = getLiveNeighborsCount(board, i, j);
                if (board[i][j] == 0 && liveCount == 3) {
                    board[i][j] = DEAD_TO_LIVE;
                } else if (board[i][j] == 1 && (liveCount < 2 || liveCount > 3)) {
                    board[i][j] = LIVE_TO_DEAD;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == DEAD_TO_LIVE) { board[i][j] = 1; }
                if (board[i][j] == LIVE_TO_DEAD) { board[i][j] = 0; }
            }
        }
    }

    /**
     * Method to get live count around the given (i, j) of the board
     *
     * @param board
     * @param i
     * @param j
     * @return
     */
    private static int getLiveNeighborsCount(int[][] board, int i, int j) {
        int live = 0;
        int m = board.length, n = board[0].length;

        if (i > 0 && (board[i - 1][j] == 1 || board[i - 1][j] == -1)) { live++; }
        if (i < m - 1 && (board[i + 1][j] == 1 || board[i + 1][j] == -1)) { live++; }

        if (j > 0 && (board[i][j - 1] == 1 || board[i][j - 1] == -1)) { live++; }
        if (j < n - 1 && (board[i][j + 1] == 1 || board[i][j + 1] == -1)) { live++; }

        if (i > 0 && j > 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == -1)) { live++; }
        if (i > 0 && j < n - 1 && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == -1)) { live++; }
        if (i < m - 1 && j > 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == -1)) { live++; }
        if (i < m - 1 && j < n - 1 && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == -1)) { live++; }

        return live;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);

        for (int[] row : board) {
            Arrays.stream(row).forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }
}
