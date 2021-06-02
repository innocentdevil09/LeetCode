/**
 * Given a character array s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.
 *
 * Your code must solve the problem in-place, i.e. without allocating extra space.
 *
 * Example 1:
 * Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 *
 * Example 2:
 * Input: s = ["a"]
 * Output: ["a"]
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s[i] is an English letter (uppercase or lowercase), digit, or space ' '.
 * There is at least one word in s.
 * s does not contain leading or trailing spaces.
 * All the words in s are guaranteed to be separated by a single space.
 */
public class Problem186 {

    /**
     * Method to reverse words in given array of chars
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param s
     */
    private static void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        reverseIndividualWords(s);
    }

    /**
     * Method to reverse chars in the given array for given indexes
     *
     * @param s
     * @param i
     * @param j
     */
    private static void reverse(char[] s, int i, int j) {
        while (i < j) {
            swap(s, i++, j--);
        }
    }

    /**
     * Swap method
     *
     * @param s
     * @param i
     * @param j
     */
    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    /**
     * Method to identify individual words in the given char array, and reverse to form original words
     *
     * @param s
     */
    private static void reverseIndividualWords(char[] s) {
        int i = 0, j = 0;
        while (j < s.length) {
            while (i < s.length && s[i] == ' ') { i++; }
            j = i;
            while (j < s.length && s[j] != ' ') { j++; }
            reverse(s, i, j - 1);
            i = j;
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        System.out.println(String.valueOf(s));

        reverseWords(s);
        System.out.println(String.valueOf(s));
    }
 }
