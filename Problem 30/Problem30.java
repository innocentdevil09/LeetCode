import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string s and an array of strings words of the same length. Return all starting indices of
 * substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any
 * intervening characters.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 * Example 2:
 *
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: []
 *
 * Example 3:
 *
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * Output: [6,9,12]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lower-case English letters.
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 30
 * words[i] consists of lower-case English letters.
 */
public class Problem30 {

    /**
     * Method to return the indices for all the substring search for a given array of words.
     * The approach to solve this problem is that of a sliding window. You do not need to fetch all the possible
     * substrings. Idea is to store all those words inside a hashMap, and use sliding window to check if substring of
     * the original string, is present inside the map.
     *
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> substringIndexList = new ArrayList<>();
        if (words.length == 0) {
            return substringIndexList;
        }
        int arrLength = words.length;
        int wordLength = words[0].length();
        int totalChars = arrLength * wordLength;

        if (totalChars > s.length()) {
            return substringIndexList;
        }

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - totalChars; i++) {
            Map<String, Integer> tempWordMap = new HashMap<>(wordMap);
            int j = i, counter = arrLength;

            while (j < i + totalChars && counter > 0) {
                String word = s.substring(j, j + wordLength);
                if (!wordMap.containsKey(word) || tempWordMap.get(word) == 0) {
                    break;
                }
                j += wordLength;
                counter--;
                tempWordMap.put(word, tempWordMap.get(word) - 1);
            }
            if (counter == 0) {
                substringIndexList.add(i);
            }
        }
        return substringIndexList;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"foo", "bar", "the"};
        long startTime = System.currentTimeMillis();
        System.out.println(findSubstring(s, words));
        long endTime = System.currentTimeMillis();

        System.out.println("Time : " + (endTime - startTime));
    }
}
