/**
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is
 * no such window in s that covers all characters in t, return the empty string "".
 *
 * Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
 *
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 *
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 *
 * Constraints:
 * 1 <= s.length, t.length <= 10^5
 * s and t consist of English letters.
 */
public class Problem76 {

    /**
     * There is a template that can solve most 'substring' problems
     *
     * For most substring problem, we are given a string and need to find a substring of it which satisfy some
     * restrictions. A general way is to use a hashmap assisted with two pointers.
     *
     * Here is the algorithm to solve the given problem:
     * 1. Use two pointers: start and end to represent a window.
     * 2. Move end to find a valid window.
     * 3. When a valid window is found, move start to find a smaller window.
     *
     * @param s
     * @param t
     * @return
     */
    private static String minWindow(String s, String t) {
        int[] map = new int[256];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int start = 0, end = 0, minStart = 0, len = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map[c] > 0) {
                counter--;
            }
            map[c]--;
            end++;
            while (counter == 0) {
                if (len > end - start) {
                    len = end - start;
                    minStart = start;
                }
                char c1 = s.charAt(start);
                map[c1]++;
                if (map[c1] > 0) {
                    counter++;
                }
                start++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + len);
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}
