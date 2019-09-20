import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Problem22 {

    /**
     * Method to generate parenthesis for a given number of pairs allowed
     * Algo :- Uses a very important tool of backtracking to generate all pairs of parenthesis
     *
     * @param n
     */
    private static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    /**
     * NOTE: A very important concept of backtracking
     * Backtracking lets you keep a track of the current state of the variable by using other parameters and modify
     * it accordingly. It is a useful concept while using recursion to solve a certain problem.
     *
     * Time Complexity : O(4^n/_/n)
     * Space Complexity : O(4^n/_/n)
     *
     * @param list
     * @param current
     * @param open
     * @param close
     * @param n
     */
    private static void backtrack(List<String> list, String current, int open, int close, int n) {
        if (current.length() == 2 * n) {
            list.add(current);
            return;
        }

        if (open < n) {
            backtrack(list, current + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(list, current + ")", open, close + 1, n);
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 3;

        System.out.println(generateParenthesis(n));
    }
}
