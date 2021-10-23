import javafx.util.Pair;

import java.util.PriorityQueue;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a
 * character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 *
 * Example 1:
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 * Example 3:
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 * Constraints:
 * 1 <= s.length <= 5 * 10^5
 * s consists of uppercase and lowercase English letters and digits.
 */
public class Problem451 {

    /**
     * Method to sort given string by frequency of its chars
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param s
     * @return
     */
    private static String frequencySort(String s) {
        if (s == null || s.isEmpty()) { return s; }

        int[] freq = new int[256];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) { continue; }
            Pair<Character, Integer> pair = new Pair<>((char) (i), freq[i]);
            pq.offer(pair);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair<Character, Integer> pair = pq.poll();
            for (int i = 0; i < pair.getValue(); i++) {
                sb.append(pair.getKey());
            }
        }
        return sb.toString();
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "9988777yyhhgfvvvvvvddsseeeeww3344";
        System.out.println(frequencySort(s));
    }
}
