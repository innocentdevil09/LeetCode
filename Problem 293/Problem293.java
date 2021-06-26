import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * You are playing a Flip Game with your friend.
 *
 * You are given a string currentState that contains only '+' and '-'. You and your friend take turns to flip two
 * consecutive "++" into "--". The game ends when a person can no longer make a move, and therefore the other person
 * will be the winner.
 *
 * Return all possible states of the string currentState after one valid move. You may return the answer in any order
 * . If there is no valid move, return an empty list [].
 *
 * Example 1:
 * Input: currentState = "++++"
 * Output: ["--++","+--+","++--"]
 *
 * Example 2:
 * Input: currentState = "+"
 * Output: []
 *
 * Constraints:
 * 1 <= currentState.length <= 500
 * currentState[i] is either '+' or '-'.
 */
public class Problem293 {

    /**
     * Method to generate next state of given string
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param s
     * @return
     */
    private static List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            char curr = s.charAt(i);
            char next = s.charAt(i + 1);
            if (curr == '+' && next == '+') {
                char[] arr = s.toCharArray();
                arr[i] = '-';
                arr[i + 1] = '-';
                list.add(new String(arr));
            }
        }
        return list;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "++++";
        System.out.println(generatePossibleNextMoves(s));
    }
}
