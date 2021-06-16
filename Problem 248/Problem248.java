import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two strings low and high that represent two integers low and high where low <= high, return the number of
 * strobogrammatic numbers in the range [low, high].
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Example 1:
 * Input: low = "50", high = "100"
 * Output: 3
 *
 * Example 2:
 * Input: low = "0", high = "0"
 * Output: 1
 *
 * Constraints:
 * 1 <= low.length, high.length <= 15
 * low and high consist of only digits.
 * low <= high
 * low and high do not contain any leading zeros except for zero itself.
 */
public class Problem248 {

    /**
     * Method to return all strobogrammatic nums in the given range (low, high)
     * DFS method to construct all possible nums and check if its in range
     *
     * Time Complexity: O(2 ^ N) { N = high.length() }
     * Space Complexity: O(N)
     *
     * @param low
     * @param high
     * @return
     */
    private static int strobogrammaticInRange(String low, String high) {
        char[] arr = {'0', '1', '6', '8', '9'};
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');

        int[] count = new int[1];
        List<String> list = Arrays.asList("", "0", "1", "8");
        for (String s : list) {
            dfs(s, arr, map, count, low, high);
        }
        return count[0];
    }

    /**
     * DFS approach to construct all possible nums with strobogrammatic chars
     *
     * @param num
     * @param arr
     * @param map
     * @param count
     * @param low
     * @param high
     */
    private static void dfs(String num, char[] arr, Map<Character, Character> map, int[] count, String low,
            String high) {
        int len = num.length();
        if (len > high.length()) { return; }

        if (len == 1 || (len > 1 && num.charAt(0) != '0')) {
            int a = compareString(num, low);
            int b = compareString(num, high);
            if (b > 0) { return; }
            if (a >= 0) { count[0] += 1; }
        }

        for (char x : arr) {
            String new_num = x + num + map.getOrDefault(x, x);
            dfs(new_num, arr, map, count, low, high);
        }
    }

    /**
     * Method to compare two given strings
     *
     * @param a
     * @param b
     * @return
     */
    private static int compareString(String a, String b) {
        return a.length() == b.length() ? a.compareTo(b) : a.length() - b.length();
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String low = "50", high = "100";
        System.out.println(strobogrammaticInRange(low, high));
    }
}
