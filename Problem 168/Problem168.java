/**
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 * For example:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 *
 * Example 1:
 * Input: columnNumber = 1
 * Output: "A"
 *
 * Example 2:
 * Input: columnNumber = 28
 * Output: "AB"
 *
 * Example 3:
 * Input: columnNumber = 701
 * Output: "ZY"
 *
 * Example 4:
 * Input: columnNumber = 2147483647
 * Output: "FXSHRXW"
 *
 * Constraints:
 * 1 <= columnNumber <= 2^31 - 1
 */
public class Problem168 {

    /**
     * Simple algorithm to convert number to excel column sheet count
     * Need to take care of edge case scenario
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param n
     * @return
     */
    private static String convertToTile(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int x = n % 26;
            n /= 26;
            if (x == 0) {
                x = 26;
                n -= 1;
            }
            sb.append((char) ('A' + x - 1));
        }
        return sb.reverse().toString();
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 2147483647;
        System.out.println(convertToTile(n));
    }
}
