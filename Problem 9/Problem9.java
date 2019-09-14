/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a
 * palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 *
 * Could you solve it without converting the integer to a string?
 */
public class Problem9 {

    /**
     * Method to determine if the given input integer is a palindrome
     *
     * @param x
     */
    private static boolean isPalindrome(int x) {
        if (x < 0) { return false; }

        int reverse = 0;
        int temp = x;
        while (temp != 0) {
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && temp % 10 > 7)) {
                return false;
            }
            reverse = (reverse * 10) + (temp % 10);
            temp /= 10;
        }
        return reverse == x;
    }

    /**
     * Method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int x = 121;

        System.out.println(isPalindrome(x));
    }
}
