import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * We can shift a string by shifting each of its letters to its successive letter.
 *
 * For example, "abc" can be shifted to be "bcd".
 * We can keep shifting the string to form a sequence.
 *
 * For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz".
 * Given an array of strings strings, group all strings[i] that belong to the same shifting sequence. You may return
 * the answer in any order.
 *
 * Example 1:
 * Input: strings = ["abc","bcd","acef","xyz","az","ba","a","z"]
 * Output: [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]
 *
 * Example 2:
 * Input: strings = ["a"]
 * Output: [["a"]]
 *
 * Constraints:
 * 1 <= strings.length <= 200
 * 1 <= strings[i].length <= 50
 * strings[i] consists of lowercase English letters.
 */
public class Problem249 {

    /**
     * Method to group strings using a common key
     *
     * Time Complexity: O(M * N) { N : length of array, M : length of longest word in array }
     * Space Complexity: O(N)
     *
     * @param strings
     * @return
     */
    private static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String key = createCommonKey(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }

    /**
     * Method to generate key for given string
     * We have to create the key by shifting each of its letters to its successive letter
     *
     * @param str
     * @return
     */
    private static String createCommonKey(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            int diff = str.charAt(i - 1) - str.charAt(i);
            diff = diff < 0 ? diff + 26 : diff;
            sb.append(diff).append(",");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"abc","bcd","acef","xyz","az","ba","a","z"};
        System.out.println(groupStrings(strings));
    }
}
