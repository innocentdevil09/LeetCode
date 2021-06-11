/**
 * You are given a string s. You can convert s to a palindrome by adding characters in front of it.
 * Return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 * Input: s = "aacecaaa"
 * Output: "aaacecaaa"
 *
 * Example 2:
 * Input: s = "abcd"
 * Output: "dcbabcd"
 *
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of lowercase English letters only.
 */
public class Problem214 {

    /**
     * Knuth-Morris-Pratt algorithm
     * KMP is a string matching algorithm that runs in O(n+m) times, where n and m are sizes of the text and string
     * to be searched respectively. The key component of KMP is the failure
     * function lookup table,say f(s). The purpose of the lookup table is to store the length of the proper prefix of
     * the string b1 b2...bs that is also a suffix of b1 b2...bs
     * This table is important because if we are trying to match a text string for b1 b2...bn, and we have matched the
     * first s positions, but when we fail, then the value of lookup table for s is the longest prefix of b1 b2...bn
     * that could possibly match the text string upto the point we are at. Thus, we don't need to start all over
     * again, and can resume searching from the matching prefix.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param s
     * @return
     */
    private static String shortestPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        String s_new = s + "#" + reverse;

        int[] f = new int[s_new.length()];
        for (int i = 1; i < f.length; i++) {
            int t = f[i - 1];
            while (t > 0 && s_new.charAt(i) != s_new.charAt(t)) {
                t = f[t - 1];
            }
            if (s_new.charAt(i) == s_new.charAt(t)) { t++; }
            f[i] = t;
        }
        StringBuilder res = new StringBuilder();
        res.append(reverse, 0, reverse.length() - f[s_new.length() - 1]).append(s);
        return res.toString();
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));
    }
}
