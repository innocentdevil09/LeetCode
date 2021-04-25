import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 *
 * Note that division between two integers should truncate toward zero.
 *
 * It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to
 * a result, and there will not be any division by zero operation.
 *
 * Example 1:
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 * Example 2:
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 *
 * Example 3:
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 *
 * Constraints:
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
public class Problem150 {

    /**
     * Method to use Stack and evaluate reverse Polish Notation
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param tokens
     * @return
     */
    private static int evalRPN(String[] tokens) {
        if (tokens.length == 0) { return 0; }
        Set<String> ops = new HashSet<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");

        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (ops.contains(token)) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(evaluate(n1, n2, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    /**
     * Method to evaluate arithmetic expression
     *
     * @param n1
     * @param n2
     * @param token
     * @return
     */
    private static int evaluate(int n1, int n2, String token) {
        switch (token) {
            case "+" :
                return n1 + n2;
            case "-" :
                return n2 - n1;
            case "*" :
                return n1 * n2;
            case "/" :
                boolean isNegative = (n1 < 0 || n2 < 0);
                if (n1 < 0 && n2 < 0) { isNegative = false; }
                n1 = Math.abs(n1);
                n2 = Math.abs(n2);

                int res = n2 / n1;
                return isNegative ? -res : res;
        }
        return Integer.MAX_VALUE;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
