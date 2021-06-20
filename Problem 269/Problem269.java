import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
 *
 * You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted
 * lexicographically by the rules of this new language.
 *
 * Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by
 * the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.
 *
 * A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s
 * comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same,
 * then s is smaller if and only if s.length < t.length.
 *
 * Example 1:
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 *
 * Example 2:
 * Input: words = ["z","x"]
 * Output: "zx"
 *
 * Example 3:
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 *
 * Constraints:
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of only lowercase English letters.
 */
public class Problem269 {

    /**
     * Topological Sorting
     *
     * Time Complexity: O(C) { C = total length of all the words in the input list, added together }
     * Space Complexity: O(1) or O(U + min(U^2, N)) { U = the total number of unique letters in the alien alphabet,
     * max 26; N = total number of strings in the input list}
     *
     * @param words
     * @return
     */
    private static String alienOrder(String[] words) {
        Map<Character, List<Character>> reverseAdj = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                reverseAdj.put(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    reverseAdj.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Map<Character, Boolean> marked = new HashMap<>();
        for (char c : reverseAdj.keySet()) {
            if (!dfs(c, reverseAdj, marked, sb)) {
                return "";
            }
        }
        if (sb.length() < reverseAdj.size()) { return ""; }
        return sb.toString();
    }

    /**
     * DFS approach for topological sort
     *
     * @param c
     * @param reverseAdj
     * @param marked
     * @param sb
     * @return
     */
    private static boolean dfs(char c, Map<Character, List<Character>> reverseAdj, Map<Character, Boolean> marked,
            StringBuilder sb) {

        if (marked.containsKey(c)) {
            return marked.get(c);
        }

        marked.put(c, false);
        for (char c1 : reverseAdj.get(c)) {
            if (!dfs(c1, reverseAdj, marked, sb)) {
                return false;
            }
        }
        marked.put(c, true);
        sb.append(c);
        return true;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(alienOrder(words));
    }
}
