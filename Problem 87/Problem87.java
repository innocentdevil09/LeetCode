/**
 * We can scramble a string s to get a string t using the following algorithm:
 *
 * If the length of the string is 1, stop.
 * If the length of the string is > 1, do the following:
 * Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y
 * where s = x + y.
 * Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become
 * s = x + y or s = y + x.
 * Apply step 1 recursively on each of the two substrings x and y.
 * Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return
 * false.
 *
 * Example 1:
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 *
 * Explanation: One possible scenario applied on s1 is:
 * "great" --> "gr/eat" // divide at random index.
 * "gr/eat" --> "gr/eat" // random decision is not to swap the two substrings and keep them in order.
 * "gr/eat" --> "g/r / e/at" // apply the same algorithm recursively on both substrings. divide at ranom index each
 * of them.
 * "g/r / e/at" --> "r/g / e/at" // random decision was to swap the first substring and to keep the second substring
 * in the same order.
 * "r/g / e/at" --> "r/g / e/ a/t" // again apply the algorithm recursively, divide "at" to "a/t".
 * "r/g / e/ a/t" --> "r/g / e/ a/t" // random decision is to keep both substrings in the same order.
 * The algorithm stops now and the result string is "rgeat" which is s2.
 * As there is one possible scenario that led s1 to be scrambled to s2, we return true.
 *
 * Example 2:
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 *
 * Example 3:
 * Input: s1 = "a", s2 = "a"
 * Output: true
 *
 * Constraints:
 * s1.length == s2.length
 * 1 <= s1.length <= 30
 * s1 and s2 consist of lower-case English letters.
 */
public class Problem87 {

    /**
     * Approach checking all permutations. There is no other solution.
     * Recursive. Time complexity: O(5 ^ n)
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) { return true; }
        if (s1.length() != s2.length()) { return false; }
        int[] count = new int[26]; // only lower chars

        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) { return false; }
        }

        int n = s1.length();
        for (int i = 1; i < n; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(n - i))
                    && isScramble(s1.substring(i), s2.substring(0, n - i))) {
                return true;
            }
        }
        return false;
    }

    /*
    DP approach to solve the same problem. Harder to understand.
    Time complexity: O(4 ^ n)

    private static boolean isScramble(String s1, String s2) {
        int sSize = s1.size(), len = 0, i = 0, j = 0, k = 0;
        if(0==sSize) return true;
        if(1==sSize) return s1==s2;
        bool isS[sSize+1][sSize][sSize];

        for(i=0; i<sSize; ++i)
            for(j=0; j<sSize; ++j)
                isS[1][i][j] = s1[i] == s2[j];

        for(len=2; len <=sSize; ++len)
            for(i=0; i<=sSize-len; ++i)
                for(j=0; j<=sSize-len; ++j)
                {
                    isS[len][i][j] = false;
                        for(k=1; k<len && !isS[len][i][j]; ++k)
                        {
                            isS[len][i][j] = isS[len][i][j] || (isS[k][i][j] && isS[len-k][i+k][j+k]);
                            isS[len][i][j] = isS[len][i][j] || (isS[k][i+len-k][j] && isS[len-k][i][j+k]);
                        }
                }
        return isS[sSize][0][0];
    }
     */

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";

        System.out.println(isScramble(s1, s2));
    }
}
