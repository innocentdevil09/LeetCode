import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, return the length of the longest substring that contains at most two distinct characters.
 *
 * Example 1:
 * Input: s = "eceba"
 * Output: 3
 * Explanation: The substring is "ece" which its length is 3.
 *
 * Example 2:
 * Input: s = "ccaabbb"
 * Output: 5
 * Explanation: The substring is "aabbb" which its length is 5.
 *
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of English letters.
 */
public class Problem159 {

    /**
     * Simple approach to solve the problem using a hashMap
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            map.put(s.charAt(right), right);
            if (map.size() == 3) {
                int del_index = Collections.min(map.values());
                map.remove(s.charAt(del_index));
                left = del_index + 1;
            }
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "ccaabbb";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));
    }
}
