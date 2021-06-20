import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, return true if a permutation of the string could form a palindrome.
 *
 * Example 1:
 * Input: s = "code"
 * Output: false
 *
 * Example 2:
 * Input: s = "aab"
 * Output: true
 *
 * Example 3:
 * Input: s = "carerac"
 * Output: true
 *
 * Constraints:
 * 1 <= s.length <= 5000
 * s consists of only lowercase English letters.
 */
public class Problem266 {

    /**
     * Method to determine if given string could ever be a palindrome
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param s
     * @return
     */
    private static boolean canPermutePalindrome(String s) {
        if (s == null || s.isEmpty()) { return true; }
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.add(c)) {
                set.remove(c);
            }
        }
        return set.size() <= 1;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "carerac";
        System.out.println(canPermutePalindrome(s));
    }
}
