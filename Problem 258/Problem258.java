/**
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 *
 * Example 1:
 * Input: num = 38
 * Output: 2
 * Explanation: The process is
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * Since 2 has only one digit, return it.
 *
 * Example 2:
 * Input: num = 0
 * Output: 0
 *
 * Constraints:
 * 0 <= num <= 2^31 - 1
 *
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 */
public class Problem258 {

    /**
     * Mathematical formulae for digital root
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @param num
     * @return
     */
    private static int addDigits(int num) {
        if (num == 0) { return 0; }
        if (num % 9 == 0) { return 9; }
        return num % 9;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }
}
