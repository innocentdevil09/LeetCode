/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * Given an integer n, return the nth ugly number.
 *
 * Example 1:
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 *
 * Example 2:
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 *
 * Constraints:
 * 1 <= n <= 1690
 */
public class Problem264 {

    /**
     * Data structure to store ugly numbers
     */
    private static class Ugly {

        private int[] nums = new int[1690];

        public Ugly() {
            nums[0] = 1;
            int i2 = 0, i3 = 0, i5 = 0;

            for (int i = 1; i < 1690; i++) {
                int ugly = Math.min(nums[i2] * 2, Math.min(nums[i3] * 3, nums[i5] * 5));
                nums[i] = ugly;

                if (ugly == nums[i2] * 2) { i2++; }
                if (ugly == nums[i3] * 3) { i3++; }
                if (ugly == nums[i5] * 5) { i5++; }
            }
        }
    }

    /**
     * Need to initialize at the start
     */
    private static Ugly ugly = new Ugly();

    /**
     * Method to return nth ugly number
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @param n
     * @return
     */
    private static int nthUglyNumber(int n) {
        return ugly.nums[n - 1];
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }
}
