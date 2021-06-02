/**
 * Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding
 * column number.
 *
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 * Example 1:
 * Input: columnTitle = "A"
 * Output: 1
 *
 * Example 2:
 * Input: columnTitle = "AB"
 * Output: 28
 *
 * Example 3:
 * Input: columnTitle = "ZY"
 * Output: 701
 *
 * Example 4:
 * Input: columnTitle = "FXSHRXW"
 * Output: 2147483647
 *
 * Constraints:
 * 1 <= columnTitle.length <= 7
 * columnTitle consists only of uppercase English letters.
 * columnTitle is in the range ["A", "FXSHRXW"].
 */
public class Problem171 {

    /**
     * Method to convert excel column title to number
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param s
     * @return
     */
    private static int titleToNumber(String s) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (int) (s.charAt(i) - 'A' + 1);
            if (i < n - 1) {
                sum *= 26;
            }
        }
        return sum;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "FXSHRXW";
        System.out.println(titleToNumber(s));
    }
}
