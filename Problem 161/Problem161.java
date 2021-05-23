/**
 * Given two strings s and t, return true if they are both one edit distance apart, otherwise return false.
 * A string s is said to be one distance apart from a string t if you can:
 *
 * Insert exactly one character into s to get t.
 * Delete exactly one character from s to get t.
 * Replace exactly one character of s with a different character to get t.
 *
 * Example 1:
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 *
 * Example 2:
 * Input: s = "", t = ""
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 *
 * Example 3:
 * Input: s = "a", t = ""
 * Output: true
 *
 * Example 4:
 * Input: s = "", t = "A"
 * Output: true
 *
 * Constraints:
 * 0 <= s.length <= 10^4
 * 0 <= t.length <= 10^4
 * s and t consist of lower-case letters, upper-case letters and/or digits.
 */
public class Problem161 {

    /**
     * Method to determine if two strings could be equated by either adding/removing/replacing a character
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param s
     * @param t
     * @return
     */
    private static boolean isOneEditDistance(String s, String t) {
        if (s.equals(t) || Math.abs(s.length() - t.length()) > 1) { return false; }

        if (s.length() == t.length()) {
            int replace = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    replace++;
                }
            }
            return replace == 1;
        }

        int min = Math.min(s.length(), t.length());
        int matches = 0;
        for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
            if (s.charAt(i) == t.charAt(j)) {
                matches++;
                continue;
            }
            if (s.length() > t.length()) {
                j--;
            } else {
                i--;
            }
        }
        return matches == min;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "ab", t = "acb";
        System.out.println(isOneEditDistance(s, t));
    }
}
