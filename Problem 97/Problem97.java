/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 *
 * Example 1:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 *
 * Example 2:
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 *
 * Example 3:
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 *
 * Constraints:
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1, s2, and s3 consist of lower-case English letters.
 */
public class Problem97 {

    /**
     * Method to check if s1 & s2 strings can interleave to form string s3
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    private static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) { return false; }
        if ((s1 + s2).equals(s3)) { return true; }
        if ((s2 + s1).equals(s3)) { return true; }

        int m = s1.length(), n = s2.length();
        boolean[][] invalid = new boolean[m + 1][n + 1];

        return dfs(s1, s2, s3, 0, 0, 0, invalid);
    }

    /**
     * Method to backtrack all possible steps while interleaving strings s1 & s2.
     * We use invalid[][] boolean matrix for memoization
     *
     * @param s1
     * @param s2
     * @param s3
     * @param i
     * @param j
     * @param k
     * @param invalid
     * @return
     */
    private static boolean dfs(String s1, String s2, String s3, int i, int j, int k, boolean[][] invalid) {
        if (invalid[i][j]) { return false; }
        if (k == s3.length()) { return true; }

        boolean valid = i < s1.length() && s1.charAt(i) == s3.charAt(k) && dfs(s1, s2, s3, i + 1, j, k + 1, invalid);
        valid = valid || j < s2.length() && s2.charAt(j) == s3.charAt(k) && dfs(s1, s2, s3, i, j + 1, k + 1, invalid);

        if (!valid) { invalid[i][j] = true; }
        return valid;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";

        System.out.println(isInterleave(s1, s2, s3));
    }
}
