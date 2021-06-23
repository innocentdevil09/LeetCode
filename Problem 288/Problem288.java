import java.util.HashMap;
import java.util.Map;

/**
 * The abbreviation of a word is a concatenation of its first letter, the number of characters between the first and
 * last letter, and its last letter. If a word has only two characters, then it is an abbreviation of itself.
 *
 * For example:
 * dog --> d1g because there is one letter between the first letter 'd' and the last letter 'g'.
 * internationalization --> i18n because there are 18 letters between the first letter 'i' and the last letter 'n'.
 * it --> it because any word with only two characters is an abbreviation of itself.
 * Implement the ValidWordAbbr class:
 *
 * ValidWordAbbr(String[] dictionary) Initializes the object with a dictionary of words.
 * boolean isUnique(string word) Returns true if either of the following conditions are met (otherwise returns false):
 * There is no word in dictionary whose abbreviation is equal to word's abbreviation.
 * For any word in dictionary whose abbreviation is equal to word's abbreviation, that word and word are the same.
 *
 * Example 1:
 * Input
 * ["ValidWordAbbr", "isUnique", "isUnique", "isUnique", "isUnique"]
 * [[["deer", "door", "cake", "card"]], ["dear"], ["cart"], ["cane"], ["make"]]
 * Output
 * [null, false, true, false, true]
 *
 * Explanation
 * ValidWordAbbr validWordAbbr = new ValidWordAbbr(["deer", "door", "cake", "card"]);
 * validWordAbbr.isUnique("dear"); // return false, dictionary word "deer" and word "dear" have the same abbreviation
 *                                 // "d2r" but are not the same.
 * validWordAbbr.isUnique("cart"); // return true, no words in the dictionary have the abbreviation "c2t".
 * validWordAbbr.isUnique("cane"); // return false, dictionary word "cake" and word "cane" have the same abbreviation
 *                                 // "c2e" but are not the same.
 * validWordAbbr.isUnique("make"); // return true, no words in the dictionary have the abbreviation "m2e".
 * validWordAbbr.isUnique("cake"); // return true, because "cake" is already in the dictionary and no other word in
 * the dictionary has "c2e" abbreviation.
 *
 * Constraints:
 * 1 <= dictionary.length <= 3 * 10^4
 * 1 <= dictionary[i].length <= 20
 * dictionary[i] consists of lowercase English letters.
 * 1 <= word.length <= 20
 * word consists of lowercase English letters.
 * At most 5000 calls will be made to isUnique.
 */
public class Problem288 {

    /**
     * Valid Word Abbreviation class
     */
    private static class ValidWordAbbr {

        private Map<String, String> map = null;

        /**
         * Initialize map in constructor
         *
         * @param dictionary
         */
        public ValidWordAbbr(String[] dictionary) {
            map = new HashMap<>();

            for (String word : dictionary) {
                String abbr = getAbbr(word);
                if (map.containsKey(abbr) && !map.get(abbr).equals(word)) {
                    map.put(abbr, "");
                } else {
                    map.put(abbr, word);
                }
            }
        }

        /**
         * Method to determine if unique
         *
         * @param word
         * @return
         */
        public boolean isUnique(String word) {
            String abbr = getAbbr(word);
            return !map.containsKey(abbr) || map.get(abbr).equals(word);
        }

        /**
         * Method to abbreviate the given word
         *
         * @param word
         * @return
         */
        private String getAbbr(String word) {
            int n = word.length();
            if (n <= 2) { return word; }

            StringBuilder sb = new StringBuilder();
            sb.append(word.charAt(0)).append(n - 2).append(word.charAt(n - 1));
            return sb.toString();
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] dictionary = {"deer", "door", "cake", "card"};

        ValidWordAbbr validWordAbbr = new ValidWordAbbr(dictionary);
        System.out.println(validWordAbbr.isUnique("dear")); // return false, dictionary word "deer" and word "dear"
                                        // have the same abbreviation
                                        // "d2r" but are not the same.
        System.out.println(validWordAbbr.isUnique("cart")); // return true, no words in the dictionary have the
                                        // abbreviation "c2t".
        System.out.println(validWordAbbr.isUnique("cane")); // return false, dictionary word "cake" and word "cane"
                                        // have the same abbreviation
                                        // "c2e" but are not the same.
        System.out.println(validWordAbbr.isUnique("make")); // return true, no words in the dictionary have the
                                        // abbreviation "m2e".
        System.out.println(validWordAbbr.isUnique("cake")); // return true, because "cake" is already in the
                                        // dictionary and no other word in the dictionary has "c2e" abbreviation.
    }
}
