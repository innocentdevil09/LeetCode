/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class Problem5 {

    /**
     * Method to return the largest palindrome substring found in the given string s
     * The algo is to pick each index i of string s, and then expand from that given index in opposite directions.
     * Get the palindrome lengths, and then return whichever is the longest.
     *
     * @param s
     */
    private static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) { return ""; }
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = getPalindromeLength(s, i, i);
            int len2 = getPalindromeLength(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                end = i + (len / 2);
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * Method to get the length of palindrome that starts from index left & right of the given string
     *
     * @param s
     * @param i
     * @param j
     */
    private static int getPalindromeLength(String s, int i, int j) {
        int start = i;
        int end = j;

        while (start > -1 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "babad";

        System.out.println(longestPalindrome(s));
    }
}
