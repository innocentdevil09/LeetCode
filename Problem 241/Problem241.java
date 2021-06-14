import java.util.ArrayList;
import java.util.List;

/**
 * Given a string expression of numbers and operators, return all possible results from computing all the different
 * possible ways to group numbers and operators. You may return the answer in any order.
 *
 * Example 1:
 * Input: expression = "2-1-1"
 * Output: [0,2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * Example 2:
 * Input: expression = "2*3-4*5"
 * Output: [-34,-14,-10,-10,10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * Constraints:
 * 1 <= expression.length <= 20
 * expression consists of digits and the operator '+', '-', and '*'.
 */
public class Problem241 {

    /**
     * Combinatorics
     *
     * Time Complexity:
     *
     * @param input
     * @return
     */
    private static List<Integer> diffWaysToCompute(String input) {
        return combinatorics(input, 0, input.length());
    }

    /**
     * Combinatorics
     *
     * @param input
     * @param left
     * @param right
     * @return
     */
    private static List<Integer> combinatorics(String input, int left, int right) {
        List<Integer> result = new ArrayList<>();
        if (right < left) { return result; }
        String s = input.substring(left, right);
        if (!s.contains("*") && !s.contains("+") && !s.contains("-")) {
            result.add(Integer.parseInt(s));
            return result;
        }

        for (int i = left; i < right; i++) {
            char c = input.charAt(i);
            if (c == '*' || c == '+' || c == '-') {
                List<Integer> leftSideVal = combinatorics(input, left, i);
                List<Integer> rightSideVal = combinatorics(input, i + 1, right);

                for (int j : leftSideVal) {
                    for (int k : rightSideVal) {
                        if (c == '+') {
                            result.add(j + k);
                        } else if (c == '-') {
                            result.add(j - k);
                        } else {
                            result.add(j * k);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String input = "2*3-4*5";
        System.out.println(diffWaysToCompute(input));
    }
}
