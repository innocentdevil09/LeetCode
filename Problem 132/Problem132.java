/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example 1:
 * Input: s = "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 * Example 2:
 * Input: s = "a"
 * Output: 0
 *
 * Example 3:
 * Input: s = "ab"
 * Output: 1
 *
 * Constraints:
 * 1 <= s.length <= 2000
 * s consists of lower-case English letters only.
 */
public class Problem132 {

    /**
     * Dynamic Programming
     *
     * Algo:
     * A given string s starting at index start and ending at index end is a palindrome if following
     * conditions are satisfied :
     * 1. The characters at start and end indexes are equal.
     * 2. The substring starting at index start+1 and ending at index end−1 is a palindrome.
     *
     * So, dp[start][end] = true, if string is palindrome otherwise false
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(N^2)
     *
     * @param s
     * @return
     */
    private static int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        char[] c = s.toCharArray();

        int[] cut = new int[n];
        for (int end = 0; end < n; end++) {
            int min = end;
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                    min = start == 0 ? 0 : Math.min(min, cut[start - 1] + 1);
                }
            }
            cut[end] = min;
        }
        return cut[n - 1];
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));
    }
}
