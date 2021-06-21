/**
 * Convert a non-negative integer num to its English words representation.
 *
 * Example 1:
 * Input: num = 123
 * Output: "One Hundred Twenty Three"
 *
 * Example 2:
 * Input: num = 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 *
 * Example 3:
 * Input: num = 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * Example 4:
 * Input: num = 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 *
 * Constraints:
 * 0 <= num <= 2^31 - 1
 */
public class Problem273 {

    private static final int BILLION = 1000000000;
    private static final int MILLION = 1000000;
    private static final int THOUSAND = 1000;
    private static final int HUNDRED = 100;
    private static final int TWENTY = 20;

    private static String[] words = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
    "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    /**
     * Method to convert num to words
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param num
     * @return
     */
    private static String numberToWords(int num) {
        if (num == 0) { return "Zero"; }
        return helper(num);
    }

    /**
     * Recursive method to fetch string
     *
     * @param num
     * @return
     */
    private static String helper(int num) {
        StringBuilder sb = new StringBuilder();

        if (num >= BILLION) {
            sb.append(helper(num / BILLION)).append(" Billion ").append(helper(num % BILLION));
        } else if (num >= MILLION) {
            sb.append(helper(num / MILLION)).append(" Million ").append(helper(num % MILLION));
        } else if (num >= THOUSAND) {
            sb.append(helper(num / THOUSAND)).append(" Thousand ").append(helper(num % THOUSAND));
        } else if (num >= HUNDRED) {
            sb.append(helper(num / HUNDRED)).append(" Hundred ").append(helper(num % HUNDRED));
        } else if (num >= TWENTY) {
            sb.append(words[20 + (num - 20) / 10]).append(" ").append(helper(num % 10));
        } else {
            sb.append(words[num]);
        }

        return sb.toString().trim();
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int num = Integer.MAX_VALUE;
        System.out.println(numberToWords(num));
    }
}
