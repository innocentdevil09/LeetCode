import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer n, return all the strobogrammatic numbers that are of length n. You may return the answer in any
 * order.
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Example 1:
 * Input: n = 2
 * Output: ["11","69","88","96"]
 *
 * Example 2:
 * Input: n = 1
 * Output: ["0","1","8"]
 *
 * Constraints:
 * 1 <= n <= 14
 */
public class Problem247 {

    /**
     * Combinatorics
     *
     * Time Complexity:
     *
     * @param n
     * @return
     */
    private static List<String> findStrobogrammatic(int n) {
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(0, Arrays.asList(""));
        map.put(1, Arrays.asList("0", "1", "8"));
        map.put(2, Arrays.asList("00", "11", "69", "88", "96"));

        if (n < 2) { return map.get(n); }
        if (n == 2) {
            return map.get(2).subList(1, 5);
        }
        return combinatorix(n, map, false);
    }

    /**
     * Combinatorics
     *
     * @param n
     * @param map
     * @param startsWithZero
     * @return
     */
    private static List<String> combinatorix(int n, Map<Integer, List<String>> map, boolean startsWithZero) {
        if (n <= 2) { return map.get(n); }

        List<String> str = combinatorix(n - 2, map, true);

        List<String> list = new ArrayList<>();
        for (String s : map.get(2)) {
            if (!startsWithZero && s.charAt(0) == '0') { continue; }
            char a = s.charAt(0);
            char b = s.charAt(1);

            for (String x : str) {
                list.add(a + x + b);
            }
        }
        return list;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 10;
        System.out.println(findStrobogrammatic(n));
    }
}
