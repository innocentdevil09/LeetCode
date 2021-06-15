import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings wordsDict and two strings that already exist in the array word1 and word2, return the
 * shortest distance between these two words in the list.
 *
 * Note that word1 and word2 may be the same. It is guaranteed that they represent two individual words in the list.
 *
 * Example 1:
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * Output: 1
 *
 * Example 2:
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "makes"
 * Output: 3
 *
 * Constraints:
 * 1 <= wordsDict.length <= 3 * 10^4
 * 1 <= wordsDict[i].length <= 10
 * wordsDict[i] consists of lowercase English letters.
 * word1 and word2 are in wordsDict.
 */
public class Problem245 {

    /**
     * Method to calculate shortest distance between words, in case the given words are equal
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    private static int shortestWordDistance(String[] words, String word1, String word2) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                indexes.add(i);
            }
        }

        int dist = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            for (int i = 0; i < indexes.size() - 1; i++) {
                dist = Math.min(dist, indexes.get(i + 1) - indexes.get(i));
            }
        } else {
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word2)) {
                    for (int k : indexes) {
                        dist = Math.min(dist, Math.abs(i - k));
                    }
                }
            }
        }
        return dist;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};

        System.out.println(shortestWordDistance(words, "makes", "coding"));
        System.out.println(shortestWordDistance(words, "makes", "makes"));
    }
}
