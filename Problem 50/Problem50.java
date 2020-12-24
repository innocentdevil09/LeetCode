/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e. xn).
 *
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * Constraints:
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * -10^4 <= x^n <= 10^4
 */
public class Problem50 {

    /**
     * This is a fun question. If you look into the the source code for Java's Math class, you will find that it
     * calls StrictMath.pow(double1, double2), and StrictMath's signature is public static native double pow(double
     * a, double b);
     *
     * So, in the end, it is a truly native call that might differ depending on the platform. However, there is an
     * implementation somewhere, and it isn't very easy to look at. Here is the description of the function and the
     * code for the function itself:
     *
     * Note:
     *
     * Looking through the math, trying to understand it might inevitably lead to even more questions. But, by
     * searching through this Github on Java Math Function Source Code
     * (https://github.com/openjdk-mirror/jdk7u-jdk/blob/f4d80957e89a19a29bb9f9807d2a28351ed7f7df/src/share/native/java/lang/fdlibm/src/e_pow.c)
     * and glancing out the mathematical summaries,
     * you can definitely understand the native functions better. Happy Exploring :)
     *
     * Method Description
     *
     * Method:  Let x =  2   * (1+f)
     *       1. Compute and return log2(x) in two pieces:
     *               log2(x) = w1 + w2,
     *          where w1 has 53-24 = 29 bit trailing zeros.
     *       2. Perform y*log2(x) = n+y' by simulating muti-precision
     *          arithmetic, where |y'|<=0.5.
     *       3. Return x**y = 2**n*exp(y'*log2)
     *
     * @param x
     * @param n
     * @return
     */
    private static double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    /**
     * Method for test cases
     * @param args
     */
    public static void main(String[] args) {
        double x = 0.001;
        int n = -1;

        System.out.println(myPow(x, n));
    }
}
