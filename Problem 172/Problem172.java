/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 *
 * Example 1:
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 *
 * Example 2:
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 *
 * Example 3:
 * Input: n = 0
 * Output: 0
 *
 * Constraints:
 * 0 <= n <= 10^4
 */
public class Problem172 {

    /**
     * Method to return trailing zeroes after getting factorial value of given n
     *
     * Time Complexity: O(log N)
     * Space Complexity: O(log N)
     *
     * @param n
     * @return
     */
    private static int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 100;
        System.out.println(trailingZeroes(n));
    }
}
