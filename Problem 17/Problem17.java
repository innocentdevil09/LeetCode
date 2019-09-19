import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
 * represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any
 * letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Problem17 {

    /**
     * Method to return the combination of letters possible for a given input sequence of digits of a mobile dialpad
     *
     * @param digits
     */
    private static List<String> letterCombination(String digits) {
        if (digits == null || digits.isEmpty()) { return new ArrayList<>(); }

        List<String> result = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            List<String> letters = getLetters(c);
            result = getCombinedStringList(result, letters);
        }
        return result;
    }

    /**
     * Method to get the list of strings formed by combining all the strings in the given two lists in every possible
     * combination
     *
     * @param list1
     * @param list2
     */
    private static List<String> getCombinedStringList(List<String> list1, List<String> list2) {
        if (list1.isEmpty()) { return list2; }
        if (list2.isEmpty()) { return list1; }

        List<String> combined = new ArrayList<>();
        for (String s1 : list1) {
            for (String s2 : list2) {
                combined.add(s1 + s2);
            }
        }
        return combined;
    }

    /**
     * Method to return list of characters that occur on a mobile dialpad for a given input digit
     *
     * @param c
     */
    private static List<String> getLetters(char c) {
        switch(c) {
            case '2':
                return Arrays.asList("a", "b", "c");
            case '3':
                return Arrays.asList("d", "e", "f");
            case '4':
                return Arrays.asList("g", "h", "i");
            case '5':
                return Arrays.asList("j", "k", "l");
            case '6':
                return Arrays.asList("m", "n", "o");
            case '7':
                return Arrays.asList("p", "q", "r", "s");
            case '8':
                return Arrays.asList("t", "u", "v");
            case '9':
                return Arrays.asList("w", "x", "y", "z");
            default:
                return new ArrayList<>();
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String digits = "23";

        System.out.println(letterCombination(digits));
    }
}
