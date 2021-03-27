/**
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 *
 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 * Constraints:
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class Problem125 {

    /**
     * Method to determine if given string is palindrome
     * Considering only alphanumeric chars, and ignoring cases
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param s
     * @return
     */
    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char x = s.charAt(i);
            char y = s.charAt(j);
            if (!Character.isDigit(x) && !Character.isAlphabetic(x)) {
                i++; continue;
            } else if (!Character.isDigit(y) && !Character.isAlphabetic(y)) {
                j--; continue;
            }
            if (Character.isAlphabetic(x)) { x = Character.toLowerCase(x); }
            if (Character.isAlphabetic(y)) { y = Character.toLowerCase(y); }

            if (x - y != 0) { return false; }
            i++; j--;
        }
        return true;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));
    }
}
