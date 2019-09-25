/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
public class Problem28 {

    /**
     * Method to return index of the beginning of needle string in the haystack
     * This method aims to replicate the functionality of indexOf() method in Java
     * Algo :-
     * Basically two pointers, i for haystack and j for needle. Keep checking if the char at the given indexes for
     * haystack and needle match.
     *
     * @param haystack
     * @param needle
     */
    private static int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) { return i; }
                if (i + j == haystack.length()) { return - 1; }
                if (haystack.charAt(i + j) != needle.charAt(j)) { break; }
            }
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        System.out.println(strStr(haystack, needle));
    }
}
