import java.util.Arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class Problem242 {

    /**
     * Method to verify if given strings are anagrams
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram(String s, String t) {
        int[] s_array = new int[26];
        int[] t_array = new int[26];

        for (char c : s.toCharArray()) {
            s_array[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            t_array[c - 'a']++;
        }
        return Arrays.equals(s_array, t_array);
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
