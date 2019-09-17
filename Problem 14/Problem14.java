/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class Problem14 {

    /**
     * Method to get the longest common prefix among all the strings in the array.
     * The prefect solution for such questions are the use of trie
     * The current algo uses a pointer which gets incremented as long as all the strings in the array have the same
     * character at the given index
     *
     * @param strs
     */
    private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) { return ""; }
        int i = 0;
        boolean isFinished = false;
        int minLength = getMinLength(strs);

        while (!isFinished && i < minLength) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != ch) {
                    isFinished = true;
                    break;
                }
            }
            if (!isFinished) { i++; }
        }
        return i > 0 ? strs[0].substring(0, i) : "";
    }

    /**
     * Adjunct method to longestCommonPrefix()
     * It is used to get the minimum length of among all the strings in the array
     *
     * @param strs
     */
    private static int getMinLength(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        return minLength;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};

        System.out.println(longestCommonPrefix(strs));
    }
}
