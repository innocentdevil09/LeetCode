import java.util.HashMap;
import java.util.Map;

/**
 * You are playing a Flip Game with your friend.
 *
 * You are given a string currentState that contains only '+' and '-'. You and your friend take turns to flip two
 * consecutive "++" into "--". The game ends when a person can no longer make a move, and therefore the other person
 * will be the winner.
 *
 * Return true if the starting player can guarantee a win, and false otherwise.
 *
 * Example 1:
 * Input: currentState = "++++"
 * Output: true
 * Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 *
 * Example 2:
 * Input: currentState = "+"
 * Output: false
 *
 * Constraints:
 * 1 <= currentState.length <= 60
 * currentState[i] is either '+' or '-'.
 *
 * Follow up: Derive your algorithm's runtime complexity.
 */
public class Problem294 {

    /**
     * Method to determine if the user can win the given state of string
     *
     * Time Complexity: O(2 ^ N)
     * Space Complexity: O(2 ^ N)
     *
     * @param currentState
     * @return
     */
    private static boolean canWin(String currentState) {
        char[] arr = currentState.toCharArray();
        Map<String, Boolean> cache = new HashMap<>();
        return dfs(arr, cache);
    }

    /**
     * DFS traversal to check every possible state of string
     *
     * @param arr
     * @param cache
     * @return
     */
    private static boolean dfs(char[] arr, Map<String, Boolean> cache) {
        String s = String.valueOf(arr);
        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '+' && arr[i + 1] == '+') {
                arr[i] = arr[i + 1] = '-';
                boolean win = dfs(arr, cache);
                arr[i] = arr[i + 1] = '+';

                if (!win) {
                    cache.put(s, true);
                    return true;
                }
            }
        }
        cache.put(s, false);
        return false;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "++++";
        System.out.println(canWin(s));
    }
}
