/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 */
public class Problem7 {

    /**
     * Method to reverse a given integer. The algo takes care of the edge cases if the given number after reversing
     * exceeds the memory of int obj
     *
     * @param x
     */
    private static int reverse(int x) {
        int reverse = 0;
        int temp = x;

        while (temp != 0) {
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && temp % 10 > 7)) {
                return 0;
            }
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && temp % 10 < -8)) {
                return 0;
            }
            reverse = (reverse * 10) + (temp % 10);
            temp /= 10;
        }
        return reverse;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int x = -123;

        System.out.println(reverse(x));
    }
}
