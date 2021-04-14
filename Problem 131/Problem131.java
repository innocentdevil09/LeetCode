import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible
 * palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 *
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
public class Problem131 {

    /**
     * DFS with Dynamic Programming
     *
     * Algo:
     * A given string s starting at index start and ending at index end is a palindrome if following conditions are
     * satisfied :
     * 1. The characters at start and end indexes are equal.
     * 2. The substring starting at index start+1 and ending at index end−1 is a palindrome.
     *
     * So, dp[start][end] = true, if string is palindrome otherwise false
     *
     * Time Complexity: O(N * 2^N)
     * Space Complexity: O(N * N) (len of string * recursive call stack)
     *
     * @param s
     * @return
     */
    private static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.isEmpty()) { return res; }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        dfs(res, 0, new ArrayList<>(), s, dp);
        return res;
    }

    /**
     * DFS Backtracking approach with dp array to optimise step to find if string is palindrome
     *
     * @param res
     * @param index
     * @param list
     * @param s
     * @param dp
     */
    private static void dfs(List<List<String>> res, int index, List<String> list, String s, boolean[][] dp) {
        if (index >= s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(index) == s.charAt(i) && (i - index <= 2 || dp[index + 1][i - 1])) {
                dp[index][i] = true;
                list.add(s.substring(index, i + 1));
                dfs(res, i + 1, list, s, dp);
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
}
