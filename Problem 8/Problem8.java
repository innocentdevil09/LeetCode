/**
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is
 * found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have
 * no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence
 * exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−2^31,  2^31 − 1]. If the numerical value is out of the range of representable values, INT_MAX (2^31 − 1) or INT_MIN
 * (−2^31) is returned.
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 * Example 2:
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 */
public class Problem8 {

    /**
     * Method to implement atoi to convert string to integer
     * 1. If numerical val is out of range i.e > MAX_VALUE or < MIN_VALUE, we return the extreme limits of Integer
     * 2. Whitespace characters at the beginning and trailing end of the string are ignored
     * 3. Only the digits at the beginning of the string are considered for result
     *
     * @param str
     */
    private static int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) { return 0; }
        if (str.charAt(0) != '+' && str.charAt(0) != '-' && !Character.isDigit(str.charAt(0))) {
            return 0;
        }

        boolean isNegative = str.charAt(0) == '-';

        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && (str.charAt(i) == '-' || str.charAt(i) == '+')) { continue; }
            if (!Character.isDigit(str.charAt(i))) { break; }

            int digit = str.charAt(i) - '0';
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            num = num * 10 + digit;
        }
        return isNegative ? num * -1 : num;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "-91283472332";

        System.out.println(myAtoi(str));
    }
}
