/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also
 * represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * Constraints:
 * 1 <= num1.length, num2.length <= 200
 * num1 and num2 consist of digits only.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
public class Problem43 {

    /**
     * Remember how we do multiplication?
     *
     * Start from right to left, perform multiplication on every pair of digits, and add them together. From the
     * following process, we can immediately conclude:
     *  `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]`
     *
     * @param num1
     * @param num2
     * @return
     */
    private static String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] result = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + result[p2];
                result[p1] += sum/10;
                result[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : result) {
            if (p == 0 && sb.length() == 0) { continue; }
            sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        String num1 = "1200";
        String num2 = "12";

        System.out.println(multiply(num1, num2));
    }
}
