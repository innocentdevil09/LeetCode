import java.util.*;

/**
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is
 * a valid dictionary word. Return all such possible sentences in any order.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 *
 * Example 2:
 * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
 * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: []
 *
 * Constraints:
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
public class Problem140 {

    /**
     * Backtracking approach
     *
     * Time Complexity: O(W + 2^N + N^2) [W - words in dict, N - length of string]
     * Space Complexity: O(2^N * N + W + N)
     *
     * @param s
     * @param wordDict
     * @return
     */
    private static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Map<String, List<String>> map = new HashMap<>();
        return dfs(s, dict, map);
    }

    /**
     * Method for backtracking and dividing the problem into smaller groups to get all sentences
     *
     * @param s
     * @param dict
     * @param map
     * @return
     */
    private static List<String> dfs(String s, Set<String> dict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        List<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        for (String word : dict) {
            if (s.startsWith(word)) {
                List<String> subList = dfs(s.substring(word.length()), dict, map);
                for (String sub : subList) {
                    result.add(word + (sub.isEmpty() ? "" : " " + sub));
                }
            }
        }
        map.put(s, result);
        return result;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

        System.out.println(wordBreak(s, wordDict));
    }
}
