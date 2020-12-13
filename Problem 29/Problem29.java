/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 2^31 − 1 when the division
 * result overflows.
 */
public class Problem29 {

    /**
     * Method to divide two given integers
     * This core logic remains that of using addition/subtraction to calculate the quotient. However, bit
     * manipulation provides the opportunity to get the solution in log(n) time
     *
     * @param dividend
     * @param divisor
     * @return
     */
    private static int divide(int dividend, int divisor) {
        boolean negativeDividend = dividend < 0 && divisor > 0;
        boolean negativeDivisor = dividend >= 0 && divisor < 0;

        long tempDividend = dividend < 0 ? -1L * dividend : dividend;
        long tempDivisor = divisor < 0 ? -1L * divisor : divisor;
        long temp = 0, quotient = 0;

        for (int i = 31; i >= 0; i--) {
            if (temp + (tempDivisor << i) <= tempDividend) {
                temp += tempDivisor << i;
                quotient |= 1L << i;
            }
        }
        quotient = (negativeDividend || negativeDivisor) ? (-1 * quotient) : quotient;
        if (quotient > Integer.MAX_VALUE || quotient < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) quotient;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int dividend = -2147483648, divisor = 1;

        System.out.println(divide(dividend, divisor));
    }
}
