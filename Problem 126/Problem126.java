import java.util.*;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
 * beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation
 * sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned
 * as a list of the words [beginWord, s1, s2, ..., sk].
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 * Explanation: There are 2 shortest transformation sequences:
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * "hit" -> "hot" -> "lot" -> "log" -> "cog"
 *
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: []
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
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
public class Problem126 {

    /**
     * Bi-directional DFS + BFS approach to solve the given problem
     *
     * Time Complexity: O(n^n)
     * Space Complexity: O(n^2)
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    private static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) { return new ArrayList<>(); }

        dict.add(beginWord);
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> neighbors = new HashMap<>();
        bfs(beginWord, endWord, dict, distance, neighbors);

        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), beginWord, endWord, distance, neighbors);
        return res;
    }

    /**
     * DFS traversal through the neighbors of curr word
     *
     * @param res
     * @param list
     * @param curr
     * @param endWord
     * @param distance
     * @param neighbors
     */
    private static void dfs(List<List<String>> res, List<String> list, String curr, String endWord,
            Map<String, Integer> distance, Map<String, List<String>> neighbors) {

        list.add(curr);
        if (curr.equals(endWord)) {
            res.add(new ArrayList<>(list));
        } else {
            for (String s : neighbors.get(curr)) {
                if (distance.get(s) == distance.get(curr) + 1) {
                    dfs(res, list, s, endWord, distance, neighbors);
                }
            }
        }
        list.remove(list.size() - 1);
    }

    /**
     * BFS traverse through neighbors of each single word starting from beginWord
     * The queue keeps a track of all the possible neighbors in the current stack, and keep updating the both list as
     * well as the distance -- to be used to form a chain starting beginWord to endWord
     *
     * @param beginWord
     * @param endWord
     * @param dict
     * @param distance
     * @param neighbors
     */
    private static void bfs(String beginWord, String endWord, Set<String> dict, Map<String, Integer> distance,
            Map<String, List<String>> neighbors) {

        dict.forEach(s -> neighbors.put(s, new ArrayList<>()));
        distance.put(beginWord, 0);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String s = queue.poll();
            List<String> neighborList = getNeighbors(s, dict);

            for (String neighbor : neighborList) {
                neighbors.get(s).add(neighbor);
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, distance.get(s) + 1);
                    if (endWord.equals(neighbor)) {
                        continue;
                    } else {
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    /**
     * Method to fetch all the possible neighbors for given string
     *
     * @param s
     * @param dict
     * @return
     */
    private static List<String> getNeighbors(String s, Set<String> dict) {
        List<String> neighbors = new ArrayList<>();
        for (String str : dict) {
            if (isNextWord(s, str)) {
                neighbors.add(str);
            }
        }
        return neighbors;
    }

    /**
     * Method to return boolean if string s2 is next word compared to string s1
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isNextWord(String s1, String s2) {
        if (s1.length() != s2.length()) { return false; }
        int mismatch = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                mismatch++;
            }
        }
        return mismatch == 1;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        System.out.println(findLadders(beginWord, endWord, wordList));
    }
}
