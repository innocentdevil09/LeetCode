/**
 * Given a string s consists of some words separated by spaces, return the length of the last word in the string. If
 * the last word does not exist, return 0.
 * A word is a maximal substring consisting of non-space characters only.
 *
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 *
 * Example 2:
 * Input: s = " "
 * Output: 0
 *
 * Constraints:
 * 1 <= s.length <= 10^4
 * s consists of only English letters and spaces ' '.
 */
public class Problem58 {

    /**
     * Method to fetch length of last word in given string
     *
     * @param s
     * @return
     */
    private static int lengthOfLastWord(String s) {
        int count = 0;
        char[] arr = s.trim().toCharArray();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') { break; }
            count++;
        }
        return count;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        String s = "Hello World";

        System.out.println(lengthOfLastWord(s));
    }
}
