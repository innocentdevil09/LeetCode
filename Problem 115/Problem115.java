/**
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 *
 * A string's subsequence is a new string formed from the original string by deleting some (can be none) of the
 * characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of
 * "ABCDE" while "AEC" is not).
 *
 * It is guaranteed the answer fits on a 32-bit signed integer.
 *
 * Example 1:
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from S.
 * rabbbit
 * rabbbit
 * rabbbit
 *
 * Example 2:
 * Input: s = "babgbag", t = "bag"
 * Output: 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag" from S.
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 1000
 * s and t consist of English letters.
 */
public class Problem115 {

    /**
     * DP Approach to get num of subsequences that equals string t
     * Algo:
     *      At each position i in string s and position j in string j, the char could either match or not. In case it
     *      does not match, we proceed with i + 1 until we find a char match in s with char in string t.
     *      In case the char matches, we still need to look into other subsequences that could potentially match with
     *      char at j in string t.
     *      We use a dp 2-D array to cover both the scenarios
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     *
     * @param s
     * @param t
     * @return
     */
    private static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];

                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";

        System.out.println(numDistinct(s, t));
    }
}
