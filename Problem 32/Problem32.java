/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 *
 * Example 1:
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 *
 * Example 2:
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 *
 * Example 3:
 * Input: s = ""
 * Output: 0
 *
 * Constraints:
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 */
public class Problem32 {

    /**
     * In this approach, we make use of two counters left and right. First, we start traversing the string from the
     * left towards the right and for every ‘(’ encountered, we increment the left counter and for every ‘)’
     * encountered, we increment the right counter. Whenever left becomes equal to right, we calculate the length of
     * the current valid string and keep track of maximum length substring found so far. If right becomes greater
     * than left we reset left and right to 0.
     *
     * Next, we start traversing the string from right to left and similar procedure is applied.
     * @param s
     * @return
     */
    private static int longestValidParantheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        String[] strs = {")((())()((())", ")()())()()(", ")()()(()())", ")()())()()(", "(()())()()("};

        for (String s : strs) {
            System.out.println(longestValidParantheses(s));
            System.out.println("-------------------------------------------------");
        }
    }
}
