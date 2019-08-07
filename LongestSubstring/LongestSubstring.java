import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement:
 * ------------------
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {

    /**
     * Method to get length of longest substring without any repeating character
     * Algo:
     * We use a sliding window approach.
     * 1. Keep two variables i & j -> i is used to keep track of the index where the repeated character occurs and j
     *    is used to traverse the string array
     * 2. The longest substring without any repeating character is => j - i
     *    where,
     *    j = current index of char in string
     *    i = previous index of the current char if it is repeated
     *
     * 3. Traverse the array only once, and get the max of all non-repeated substrings
     *
     * @param s
     */
    public int lengthOfLongestSubstring(String s) {
        int maxSubstringLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int i = 0, j = 0; j < s.length(); j++) {
            if (charIndexMap.containsKey(s.charAt(j))) {
                i = Math.max(i, charIndexMap.get(s.charAt(j)));
            }
            maxSubstringLength = Math.max(maxSubstringLength, j - i + 1);
            charIndexMap.put(s.charAt(j), j + 1);
        }
        return maxSubstringLength;
    }
}
