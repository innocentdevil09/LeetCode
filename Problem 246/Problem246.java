/**
 * Given a string num which represents an integer, return true if num is a strobogrammatic number.
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Example 1:
 * Input: num = "69"
 * Output: true
 *
 * Example 2:
 * Input: num = "88"
 * Output: true
 *
 * Example 3:
 * Input: num = "962"
 * Output: false
 *
 * Example 4:
 * Input: num = "1"
 * Output: true
 */
public class Problem246 {

    /**
     * Method to check if given num is strobogrammatic
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param num
     * @return
     */
    private static boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray()) {
            if (c == '2' || c == '3' || c == '4' || c == '5' || c == '7') { return false; }
            if (c == '6') {
                sb.append('9');
            } else if (c == '9') {
                sb.append('6');
            } else {
                sb.append(c);
            }
        }
        return num.equals(sb.reverse().toString());
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String num = "69";
        System.out.println(isStrobogrammatic(num));
    }
}
