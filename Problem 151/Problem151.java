/**
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string
 * should only have a single space separating the words. Do not include any extra spaces.
 *
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Example 4:
 * Input: s = "  Bob    Loves  Alice   "
 * Output: "Alice Loves Bob"
 *
 * Example 5:
 * Input: s = "Alice does not even like bob"
 * Output: "bob like even not does Alice"
 *
 * Constraints:
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 *
 * Follow up: Could you solve it in-place with O(1) extra space?
 */
public class Problem151 {

    /**
     * Method to reverse words in a given string
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param s
     * @return
     */
    private static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        reverseChars(arr, 0, arr.length - 1);
        constructWords(arr);
        return cleanSpaces(arr);
    }

    /**
     * Method to remove spaces from start, end or in between the words
     *
     * @param arr
     * @return
     */
    private static String cleanSpaces(char[] arr) {
        int i = 0, j = 0;
        while (j < arr.length) {
            while (j < arr.length && arr[j] == ' ') { j++; }
            while (j < arr.length && arr[j] != ' ') { arr[i++] = arr[j++]; }
            while (j < arr.length && arr[j] == ' ') { j++; }
            if (j < arr.length) {
                arr[i++] = ' ';
            }
        }
        return String.valueOf(arr).substring(0, i);
    }

    /**
     * Method to reverse chars to construct proper words
     *
     * @param arr
     */
    private static void constructWords(char[] arr) {
        int i = 0, j = 0;
        while (j < arr.length) {
            while ((i < j) || (i < arr.length && arr[i] == ' ')) { i++; }
            while ((j < i) || (j < arr.length && arr[j] != ' ')) { j++; }
            reverseChars(arr, i, j - 1);
        }
    }

    /**
     * Method to reverse chars in a given string
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void reverseChars(char[] arr, int i, int j) {
        while (i < j) {
            char x = arr[i];
            arr[i] = arr[j];
            arr[j] = x;
            i++; j--;
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "  Bob    Loves  Alice   ";
        System.out.println(reverseWords(s));
    }
}
