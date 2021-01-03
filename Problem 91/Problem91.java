/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be mapped back into letters using the reverse of the mapping
 * above (there may be multiple ways). For example, "111" can have each of its "1"s be mapped into 'A's to make
 * "AAA", or it could be mapped to "11" and "1" ('K' and 'A' respectively) to make "KA". Note that "06" cannot be
 * mapped into 'F' since "6" is different from "06".
 *
 * Given a non-empty string num containing only digits, return the number of ways to decode it.
 *
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 * Example 1:
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 *
 * Example 3:
 * Input: s = "0"
 * Output: 0
 * Explanation: There is no character that is mapped to a number starting with 0. The only valid mappings with 0 are
 * 'J' -> "10" and 'T' -> "20".
 * Since there is no character, there are no valid ways to decode this since all digits need to be mapped.
 *
 * Example 4:
 * Input: s = "1"
 * Output: 1
 *
 * Constraints:
 * 1 <= s.length <= 100
 * s contains only digits and may contain leading zero(s)
 */
public class Problem91 {

    /**
     * This problem gave me my worst feeling. That is because i was able to solve the problem in my head, but
     * couldn't translate it to code. Gave me shivers.
     * Obviously would've solved if i was coding in IDE, but that's not how it should be done.
     *
     * The approach is pretty simple. It relies on dynamic programming.
     * The output at index i depends upon the value of its previous index dp[i - 1] & dp[i - 2] if it is a valid number.
     *
     * @param s
     * @return
     */
    private static int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) != '0' ? 1 : 0;
        for (int k = 1; k < s.length(); k++) {
            int first = Integer.parseInt(s.substring(k, k + 1));
            int second = Integer.parseInt(s.substring(k - 1, k + 1));
            if (first >= 1 && first <= 9) {
                dp[k] += dp[k - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[k] += (k > 1) ? dp[k - 2] : 1;
            }
        }
        return dp[n - 1];
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        String s = "1123";
        System.out.println(numDecodings(s));
    }
}
