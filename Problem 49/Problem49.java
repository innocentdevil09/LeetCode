import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using
 * all the original letters exactly once.
 *
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lower-case English letters.
 */
public class Problem49 {

    /**
     * Approach used is to store sorted strings in a hashMap. Since anagrams would form the same sorted strings, we
     * could use this property to store all such anagrams together as a list in a hashMap.
     *
     * @param strs
     * @return
     */
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sortedString = sortString(str);
            List<String> list = map.containsKey(sortedString) ? map.get(sortedString) : new ArrayList<>();
            list.add(str);
            map.put(sortedString, list);
        }

        List<List<String>> result = new ArrayList<>();
        for (String str : map.keySet()) {
            result.add(map.get(str));
        }
        return result;
    }

    /**
     * Method to sort the given string
     *
     * Approach used: Count Sort
     * Time complexity: O(n)
     *
     * @param s
     * @return
     */
    private static String sortString(String s) {
        int[] letter = new int[26];
        for (char c : s.toCharArray()) {
            letter[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letter.length; i++) {
            for (int j = 0; j < letter[i]; j++) {
                sb.append((char)('a' + i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
