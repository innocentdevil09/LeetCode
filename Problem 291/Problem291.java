import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string s, return true if s matches the pattern.
 *
 * A string s matches a pattern if there is some bijective mapping of single characters to strings such that if each
 * character in pattern is replaced by the string it maps to, then the resulting string is s. A bijective mapping
 * means that no two characters map to the same string, and no character maps to two different strings.
 *
 * Example 1:
 * Input: pattern = "abab", s = "redblueredblue"
 * Output: true
 * Explanation: One possible mapping is as follows:
 * 'a' -> "red"
 * 'b' -> "blue"
 *
 * Example 2:
 * Input: pattern = "aaaa", s = "asdasdasdasd"
 * Output: true
 * Explanation: One possible mapping is as follows:
 * 'a' -> "asd"
 *
 * Example 3:
 * Input: pattern = "abab", s = "asdasdasdasd"
 * Output: true
 * Explanation: One possible mapping is as follows:
 * 'a' -> "a"
 * 'b' -> "sdasd"
 * Note that 'a' and 'b' cannot both map to "asd" since the mapping is a bijection.
 *
 * Example 4:
 * Input: pattern = "aabb", s = "xyzabcxzyabc"
 * Output: false
 *
 * Constraints:
 * 1 <= pattern.length, s.length <= 20
 * pattern and s consist of only lower-case English letters.
 */
public class Problem291 {

    /**
     * DFS traversal to match given pattern with snippets in string s
     *
     * Time Complexity: O(2 ^ N)
     * Space Complexity: O(2 ^ N)
     *
     * @param pattern
     * @param s
     * @return
     */
    private static boolean wordPatternMatch(String pattern, String s) {
        String[] words = new String[pattern.length()];
        Arrays.fill(words, "");
        return dfs(words, pattern, s, 0, pattern.length());
    }

    /**
     * DFS traversal to add each char to word array at index, then check if a pattern is formed
     *
     * @param words
     * @param pattern
     * @param s
     * @param i
     * @param len
     * @return
     */
    private static boolean dfs(String[] words, String pattern, String s, int i, int len) {
        if (len == 0) {
            if (i < s.length()) { return false; }
            return wordPattern(pattern, words);
        }
        int index = pattern.length() - len;
        while (i < s.length()) {
            words[index] += String.valueOf(s.charAt(i));
            if (dfs(words, pattern, s, i + 1, len - 1)) {
                return true;
            }
            i++;
        }
        words[index] = "";
        return false;
    }

    /**
     * Method to verify given pattern with words array
     *
     * @param pattern
     * @param words
     * @return
     */
    private static boolean wordPattern(String pattern, String[] words) {
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c) && !map.get(c).equals(words[i])) {
                return false;
            } else if (!map.containsKey(c)) {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(c, words[i]);
            }
        }
        return true;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String pattern = "aaaa", s = "asdasdasdasd";
        System.out.println(wordPatternMatch(pattern, s));
    }
}
