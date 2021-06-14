/**
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 *
 * Example 1:
 * Input: n = 13
 * Output: 6
 *
 * Example 2:
 * Input: n = 0
 * Output: 0
 *
 * Constraints:
 * 0 <= n <= 2 * 10^9
 */
public class Problem233 {

    /**
     * Lets take an example, say n=1234.
     *
     * No of ’1’ in ones place = 1234/10(corresponding to 1,11,21,...1221) + min(4,1)(corresponding to 1231) = 124
     *
     * No of ’1’ in tens place = (1234/100)*10(corresponding to 10,11,12,...,110,111,...1919) + min(25,10)
     * (corresponding to 1210,1211,...1219)= 130
     *
     * No of ’1’ in hundreds place = (1234/1000)*100(corresponding to 100,101,12,...,199) + min(135,100)
     * (corresponding to 1100,1101...1199)= 200
     *
     * No of ’1’ in thousands place = (1234/10000)*10000 + min(235,1000)(corresponding to 1000,1001,...1234)= 235
     *
     * Therefore, Total = 124+130+200+235=689.
     *
     * @param n
     * @return
     */
    private static int countDigitOne(int n) {
        long count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            count += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
        }
        return (int) count;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 1234;
        System.out.println(countDigitOne(n));
    }
}
