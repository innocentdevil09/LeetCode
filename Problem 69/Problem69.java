/**
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is
 * returned.
 *
 * Example 1:
 * Input: x = 4
 * Output: 2
 *
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 *
 * Constraints:
 * 0 <= x <= 2^31 - 1
 */
public class Problem69 {

    /**
     * Using bit manipulation to get sqrt
     *
     * @param x
     * @return
     */
    private static int mySqrt(int x) {
        if (x == 0) { return 0; }
        int h = 0;
        while ((long)(1<<h) * (long)(1<<h) <= x) {
            h++;
        }
        h--;
        int b = h - 1;
        int result = 1<<h;

        while (b >= 0) {
            if ((long)(result | (1<<b)) * (long)(result | (1<<b)) <= x) {
                result |= (1<<b);
            }
            b--;
        }
        return result;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int x = 9;

        System.out.println(mySqrt(x));
    }
}
