import java.util.stream.IntStream;

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * Constraints:
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 */
public class Problem72 {

    /**
     * Let following be the function definition :-
     *
     * f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2
     *
     * Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
     * f(i, j) = f(i - 1, j - 1)
     *
     * Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper
     * f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
     *
     * f(i, j - 1) represents insert operation
     * f(i - 1, j) represents delete operation
     * f(i - 1, j - 1) represents replace operation
     *
     * Here, we consider any operation from word1 to word2. It means, when we say insert operation, we insert a new
     * character after word1 that matches the jth character of word2. So, now have to match i characters of word1 to
     * j - 1 characters of word2. Same goes for other 2 operations as well.
     *
     * Note that the problem is symmetric. The insert operation in one direction (i.e. from word1 to word2) is same
     * as delete operation in other. So, we could choose any direction.
     *
     * @param word1
     * @param word2
     * @return
     */
    private static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        IntStream.range(1, m + 1).forEach(i -> dp[i][0] = i);
        IntStream.range(1, n + 1).forEach(i -> dp[0][i] = i);

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";

        System.out.println(minDistance(word1, word2));
    }
}
