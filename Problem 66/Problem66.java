/**
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the
 * array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * Example 3:
 * Input: digits = [0]
 * Output: [1]
 *
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class Problem66 {

    /**
     * The last part of code is only for the case that the whole input array is 9s.
     * For example : 99999-----> 100000
     * Any other case would return in the loop.
     *
     * @param digits
     * @return
     */
    private static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newResult = new int[n + 1];
        newResult[0] = 1;
        return newResult;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[] digits = {9,9,9,9};

        digits = plusOne(digits);
        for (int i : digits) {
            System.out.print(i + " | ");
        }
    }
}
