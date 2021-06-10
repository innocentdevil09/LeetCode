import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
 * or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * Example 1:
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea",
 * "eat","rain"]
 * Output: ["eat","oath"]
 *
 * Example 2:
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 *
 * Constraints:
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 10^4
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 */
public class Problem212 {

    /**
     * Method to find all possible words in the given words array in the board
     * DFS approach
     *
     * Time Complexity: O(2 ^ M * N)
     * Space Complexity: O(N)
     *
     * @param board
     * @param words
     * @return
     */
    private static List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();

        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (!result.contains(word)
                            && board[i][j] == word.charAt(0)
                            && dfs(board, word, 0, i, j)) {
                        result.add(word);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * DFS traversal of the board for a given board
     * We do not have to use the same char in board again
     *
     * @param board
     * @param word
     * @param index
     * @param row
     * @param col
     * @return
     */
    private static boolean dfs(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) { return true; }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = ' ';

        boolean found = dfs(board, word, index + 1, row + 1, col)
                || dfs(board, word, index + 1, row - 1, col)
                || dfs(board, word, index + 1, row, col + 1)
                || dfs(board, word, index + 1, row, col - 1);

        board[row][col] = temp;
        return found;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {{'o','a','a','n'},
                          {'e','t','a','e'},
                          {'i','h','k','r'},
                          {'i','f','l','v'}};

        System.out.println(findWords(board, words));
    }
}
