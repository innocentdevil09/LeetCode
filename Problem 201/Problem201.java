/**
 * Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in
 * this range, inclusive.
 *
 * Example 1:
 * Input: left = 5, right = 7
 * Output: 4
 *
 * Example 2:
 * Input: left = 0, right = 0
 * Output: 0
 *
 * Example 3:
 * Input: left = 1, right = 2147483647
 * Output: 0
 *
 * Constraints:
 * 0 <= left <= right <= 2^31 - 1
 */
public class Problem201 {

    /**
     * Method for returning bitwise and for all integers b/w m & n
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @param m
     * @param n
     * @return
     */
    private static int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m < n) {
            m = m >> 1;
            n = n >> 1;
            shift++;
        }
        return m << shift;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int m = 0, n = Integer.MAX_VALUE;
        System.out.println(rangeBitwiseAnd(m, n));
    }
}
