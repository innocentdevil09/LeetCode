import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the
 * result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such
 * as eval().
 *
 * Example 1:
 * Input: s = "1 + 1"
 * Output: 2
 *
 * Example 2:
 * Input: s = " 2-1 + 2 "
 * Output: 3
 *
 * Example 3:
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 *
 * Example 4:
 * Input: s = "+48 + -48"
 * Output: 0
 * Explanation: Numbers can have multiple digits and start with +/-.
 *
 * Constraints:
 * 1 <= s.length <= 3 * 10^5
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * s represents a valid expression.
 * Every number and running calculation will fit in a signed 32-bit integer.
 */
public class Problem224 {

    /**
     * Method to process given string as arithmetic operation
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param s
     * @return
     */
    private static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int operand = 0, sign = 1;
        int result = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                operand = operand * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * operand;
                sign = 1;
                operand = 0;
            } else if (c == '-') {
                result += sign * operand;
                sign = -1;
                operand = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * operand;
                result *= stack.pop();
                result += stack.pop();
                operand = 0;
            }
        }
        return result + (sign * operand);
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }
}
