import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a data structure that will be initialized with a string array, and then it should answer queries of the
 * shortest distance between two different strings from the array.
 *
 * Implement the WordDistance class:
 *
 * WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
 * int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array
 * wordsDict.
 *
 * Example 1:
 * Input
 * ["WordDistance", "shortest", "shortest"]
 * [[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
 * Output
 * [null, 3, 1]
 *
 * Explanation
 * WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
 * wordDistance.shortest("coding", "practice"); // return 3
 * wordDistance.shortest("makes", "coding");    // return 1
 *
 * Constraints:
 * 1 <= wordsDict.length <= 3 * 10^4
 * 1 <= wordsDict[i].length <= 10
 * wordsDict[i] consists of lowercase English letters.
 * word1 and word2 are in wordsDict.
 * word1 != word2
 * At most 5000 calls will be made to shortest.
 */
public class Problem244 {

    /**
     * WordDistance class to return shortest distance between two words in a given array
     * Uses a memoizer to optimise on queries
     */
    private static class WordDistance {

        private Map<String, List<Integer>> map = null;
        private Map<String, Integer> memoize = null;

        public WordDistance(String[] words) {
            map = new HashMap<>();
            memoize = new HashMap<>();

            for (int i = 0; i < words.length; i++) {
                List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
                list.add(i);
                map.put(words[i], list);
            }
        }

        public int shortest(String word1, String word2) {
            StringBuilder sb = new StringBuilder();
            sb.append(word1).append("$$").append(word2);

            if (memoize.containsKey(sb.toString())) {
                return memoize.get(sb.toString());
            }

            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);

            int len = Integer.MAX_VALUE;
            for (int i : list1) {
                for (int j : list2) {
                    len = Math.min(len, Math.abs(i - j));
                }
            }
            memoize.put(sb.toString(), len);
            return len;
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        WordDistance wordDistance = new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        System.out.println(wordDistance.shortest("coding", "practice")); // return 3
        System.out.println(wordDistance.shortest("makes", "coding"));    // return 1
    }
}
