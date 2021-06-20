import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * You may return the answer in any order. If s has no palindromic permutation, return an empty list.
 *
 * Example 1:
 * Input: s = "aabb"
 * Output: ["abba","baab"]
 *
 * Example 2:
 * Input: s = "abc"
 * Output: []
 *
 * Constraints:
 * 1 <= s.length <= 16
 * s consists of only lowercase English letters.
 */
public class Problem267 {

    /**
     * DFS approach
     * First check if given string can form palindrome. The use dfs method to form all possible permutations of
     * palindromes
     *
     * Time Complexity: (2 ^ 26)
     * Space Complexity: O(N)
     *
     * @param s
     * @return
     */
    private static List<String> generatePalindromes(String s) {
        int[] map = new int[26];
        getUniqueCount(s, map);
        if (couldNotFormPalindrome(map)) {
            return new ArrayList<>();
        }

        int n = s.length();
        char[] chars = new char[n];
        List<String> res = new ArrayList<>();
        permute(map, chars, res, 0, n - 1);
        return res;
    }

    /**
     * DFS approach
     *
     * @param map
     * @param chars
     * @param res
     * @param left
     * @param right
     */
    private static void permute(int[] map, char[] chars, List<String> res, int left, int right) {
        if (left > right) {
            res.add(String.valueOf(chars));
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] >= 2) {
                map[i] -= 2;
                chars[left] = (char) (i + 'a');
                chars[right] = (char) (i + 'a');
                permute(map, chars, res, left + 1, right - 1);
                map[i] += 2;
            } else if (map[i] == 1 && left == right) {
                map[i] -= 1;
                chars[left] = (char) (i + 'a');
                permute(map, chars, res, left + 1, right - 1);
                map[i] += 1;
            }
        }
    }

    /**
     * Method to check if there is more than char with odd count, to determine if it can form palindrome
     *
     * @param map
     * @return
     */
    private static boolean couldNotFormPalindrome(int[] map) {
        int oddCount = 0;
        for (int charCount : map) {
            if (charCount % 2 != 0) { oddCount++; }
        }
        return oddCount > 1;
    }

    /**
     * Method to update map with count of each char in the given string
     *
     * @param s
     * @param map
     */
    private static void getUniqueCount(String s, int[] map) {
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(generatePalindromes(s));
    }
}
