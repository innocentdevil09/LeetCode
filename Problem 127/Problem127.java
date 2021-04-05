import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
 * beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest
 * transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 *
 * Example 1:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 *
 * Example 2:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 * Constraints:
 *
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 */
public class Problem127 {

    /**
     * BFS traverse
     *
     * "The idea behind bidirectional search is to run two simultaneous searches—one forward from
     * the initial state and the other backward from the goal—hoping that the two searches meet in
     * the middle. The motivation is that b^(d/2) + b^(d/2) is much less than b^d. b is branch factor, d is depth."
     *
     * Time Complexity: O(M^2 * N)
     * Space Complexity: O(M^2 * N)
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) { return 0; }
        Set<String> q_begin = new HashSet<>(), q_end = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int level = 1;

        q_begin.add(beginWord);
        q_end.add(endWord);
        while (!q_begin.isEmpty() && !q_end.isEmpty()) {
            if (q_begin.size() > q_end.size()) {
                Set<String> temp = q_begin;
                q_begin = q_end;
                q_end = temp;
            }

            Set<String> temp = new HashSet<>();
            for (String word : q_begin) {
                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chars[i];
                        chars[i] = c;

                        String target = String.valueOf(chars);

                        if (q_end.contains(target)) {
                            return level + 1;
                        }
                        if (!visited.contains(target) && dict.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chars[i] = old;
                    }
                }
            }
            q_begin = temp;
            level++;
        }
        return 0;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(ladderLength(beginWord, endWord, list));
    }
}
