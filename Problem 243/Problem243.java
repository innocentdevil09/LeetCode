/**
 * Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2,
 * return the shortest distance between these two words in the list.
 *
 * Example 1:
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
 * Output: 3
 *
 * Example 2:
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * Output: 1
 *
 * Constraints:
 * 1 <= wordsDict.length <= 3 * 10^4
 * 1 <= wordsDict[i].length <= 10
 * wordsDict[i] consists of lowercase English letters.
 * word1 and word2 are in wordsDict.
 * word1 != word2
 */
public class Problem243 {

    /**
     * Method to compute shortest distance b/w given words in array
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    private static int shortestDistance(String[] words, String word1, String word2) {
        int len = words.length;
        int first = -1, second = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                first = i;
            } else if (words[i].equals(word2)) {
                second = i;
            }

            if (first != -1 && second != -1) {
                len = Math.min(len, Math.abs(first - second));
            }
        }
        return len;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding", word2 = "practice";

        System.out.println(shortestDistance(words, word1, word2));
    }
}
