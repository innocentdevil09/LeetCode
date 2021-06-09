/**
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not
 * include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * Example 2:
 * Input: n = 2
 * Output: false
 *
 * Constraints:
 * 1 <= n <= 2^31 - 1
 */
public class Problem202 {

    /**
     * Method to determine if given number == 1, if we continue to square sum of its digits
     *
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     *
     * @param n
     * @return
     */
    private static boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            slow = getSquareSum(slow);
            fast = getSquareSum(getSquareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    /**
     * Method to return square sum of digits
     *
     * @param n
     * @return
     */
    private static int getSquareSum(int n) {
        int sum = 0;
        for (int i = n; i > 0; i /= 10) {
            sum += Math.pow(i % 10, 2);
        }
        return sum;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 9856;
        System.out.println(isHappy(n));
    }
}
