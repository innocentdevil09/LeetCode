import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
 *
 * For example, "ACGAATTCCG" is a DNA sequence.
 * When studying DNA, it is useful to identify repeated sequences within the DNA.
 *
 * Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur
 * more than once in a DNA molecule. You may return the answer in any order.
 *
 * Example 1:
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC","CCCCCAAAAA"]
 *
 * Example 2:
 * Input: s = "AAAAAAAAAAAAA"
 * Output: ["AAAAAAAAAA"]
 *
 * Constraints:
 * 1 <= s.length <= 10^5
 * s[i] is either 'A', 'C', 'G', or 'T'.
 */
public class Problem187 {

    /**
     * Method for finding repeated sequences of length 10
     *
     * Time Complexity: O((N - 10)*10)
     * Space Complexity: O(N - 10)
     *
     * @param s
     * @return
     */
    private static List<String> findRepeatedDnaSequences(String s) {
        Set<String> repeated = new HashSet<>();
        Set<String> res = new HashSet<>();

        for (int i = 0; i < s.length() - 10 + 1; i++) {
            String seq = s.substring(i, i + 10);
            if (repeated.contains(seq)) {
                res.add(seq);
            }
            repeated.add(seq);
        }
        return new ArrayList<>(res);
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));
    }
}
