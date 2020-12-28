import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters
 * and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra
 * spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not
 * divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Example 2:
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be
 * left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 *
 * Example 3:
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art",
 * "is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 * Constraints:
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] consists of only English letters and symbols.
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 */
public class Problem68 {

    /**
     * Approach:
     * --------
     * We start with collecting all words in a list, by greedily trying to go as far right as possible until we fill
     * our current line.
     *
     * Then we justify one line at a time.
     *
     * justify: In all cases we pad the right side with spaces until we reach max width for the line;
     *
     * 1. If it's one word then it is easy, the result is just that word.
     * 2. If it's the last line then the result is all words separated by a single space.
     * 3. Otherwise we calculate the size of each space evenly and if there is a remainder we distribute an extra space
     * until it is gone.
     *
     * @param words
     * @param maxWidth
     * @return
     */
    private static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            counter += words[i].length();
            if (counter > maxWidth) {
                list.add(sb.toString());
                sb = new StringBuilder();
                counter = 0;
                i--;
                continue;
            }
            sb.append(words[i]).append(" ");
            counter += 1;
        }
        list.add(sb.toString());

        return postJustifying(list, maxWidth);
    }

    /**
     * Method to justify the list of strings to return the result
     *
     * @param list
     * @param maxWidth
     * @return
     */
    private static List<String> postJustifying(List<String> list, int maxWidth) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < list.size() - 1; i++) {
            result.add(fullyJustified(list.get(i), maxWidth));
        }

        String lastLine = list.get(list.size() - 1);
        result.add(leftJustified(lastLine, maxWidth));

        return result;
    }

    /**
     * Method to fully justify the given string, by adding spaces to the existing ones such that the length of string
     * equals maxWidth
     *
     * @param s
     * @param maxWidth
     * @return
     */
    private static String fullyJustified(String s, int maxWidth) {
        s = s.trim();
        int len = maxWidth - s.length();

        List<Integer> spaceIndices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') { spaceIndices.add(i); }
        }
        int[] spaces = new int[spaceIndices.size()];
        IntStream.range(0, spaceIndices.size()).forEach(i -> spaces[i] = spaceIndices.get(i));

        StringBuilder sb = new StringBuilder();
        sb.append(s);

        for (int i = 0; i < len; i++) {
            if (spaces.length == 0) {
                sb.append(" ");
                continue;
            }
            sb.insert(spaces[i % spaces.length], " ");
            IntStream.range(i % spaces.length + 1, spaces.length).forEach(k -> spaces[k]++);
        }
        return sb.toString();
    }

    /**
     * Method to spaces after the end of string to make it left justified
     *
     * @param s
     * @param maxWidth
     * @return
     */
    private static String leftJustified(String s, int maxWidth) {
        s = s.trim();
        int len = maxWidth - s.length();

        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for (int i = 0; i < len; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        System.out.println(fullJustify(words, maxWidth));
    }
}
