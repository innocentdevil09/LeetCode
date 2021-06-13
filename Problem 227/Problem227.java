import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * The integer division should truncate toward zero.
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such
 * as eval().
 *
 * Example 1:
 * Input: s = "3+2*2"
 * Output: 7
 *
 * Example 2:
 * Input: s = " 3/2 "
 * Output: 1
 *
 * Example 3:
 * Input: s = " 3+5 / 2 "
 * Output: 5
 *
 * Constraints:
 * 1 <= s.length <= 3 * 10^5
 * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range [0, 2^31 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 */
public class Problem227 {

    /**
     * Method to process given string, to perform arithmetic calculations
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param s
     * @return
     */
    private static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int operand = 0, sign = 1;
        int result = 0;
        int multiply = 0, divide = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                operand = operand * 10 + (c - '0');
            } else if (c == '+') {
                operand = ops(stack, operand, divide, multiply);
                divide = multiply = 0;
                result += sign * operand;
                sign = 1;
                operand = 0;
            } else if (c == '-') {
                operand = ops(stack, operand, divide, multiply);
                divide = multiply = 0;
                result += sign * operand;
                sign = -1;
                operand = 0;
            } else if (c == '*') {
                operand = ops(stack, operand, divide, multiply);
                divide = multiply = 0;
                stack.push(operand);
                operand = 0;
                multiply++;
            } else if (c == '/') {
                operand = ops(stack, operand, divide, multiply);
                divide = multiply = 0;
                stack.push(operand);
                operand = 0;
                divide++;
            }
        }
        operand = ops(stack, operand, divide, multiply);
        return result + (sign * operand);
    }

    /**
     * Common operations for division & multiplication
     *
     * @param stack
     * @param operand
     * @param divide
     * @param multiply
     * @return
     */
    private static int ops(Deque<Integer> stack, int operand, int divide, int multiply) {
        while (divide > 0) {
            int prev = stack.pop();
            operand = prev / operand;
            divide--;
        }
        while (multiply > 0) {
            operand *= stack.pop();
            multiply--;
        }
        return operand;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));
    }
}
