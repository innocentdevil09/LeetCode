/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a
 * different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a
 * contiguous section all of the same character. Then for each group, say the number of characters, then say the
 * character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
 *
 * Example 1:
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 *
 * Example 2:
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 *
 * Constraints:
 * 1 <= n <= 30
 */
public class Problem38 {

    /**
     * As per the given problem, sequence S(n -1) becomes the precusor to get S(n). Hence the approach to solve this
     * problem involves defining the base method at n == 1, and calculating all the sequence of strings leading upto n.
     *
     * Time Complexity: O(2^n)
     * Space complexity: O(2^n-1)
     *
     * @param n
     * @return
     */
    private static String countAndSay(int n) {
        if (n == 1) { return "1"; }
        String prev = countAndSay(n - 1);
        return countAndSayString(prev);
    }

    /**
     * Method to fetch the next sequence of string in the flow for a given string.
     * Count the number of occurences of the integer, and append the count alongwith the integer to form the string.
     *
     * @param prev
     * @return
     */
    private static String countAndSayString(String prev) {
        StringBuilder sb = new StringBuilder();
        int tempCount = 1;

        for (int i = 0; i < prev.length(); i++) {
            char c = prev.charAt(i);
            while (i < prev.length() - 1 && c == prev.charAt(i + 1)) {
                i++;
                tempCount++;
            }
            sb.append(tempCount).append(c);
            tempCount = 1;
        }
        return sb.toString();
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int n = 30;

        System.out.println(countAndSay(n));
    }
}
