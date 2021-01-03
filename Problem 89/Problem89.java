import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 *
 * Example 1:
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 *
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 *
 * Example 2:
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 *              A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 *              Therefore, for n = 0 the gray code sequence is [0].
 */
public class Problem89 {

    /**
     * Bit Manipulation.
     *
     * My idea is to generate the sequence iteratively. For example, when n=3, we can get the result based on n=2.
     * 00,01,11,10 -> (000,001,011,010 ) (110,111,101,100).
     *
     * @param n
     * @return
     */
    private static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>(result);
            for (int k = temp.size() - 1; k >= 0; k--) {
                result.add(temp.get(k) | 1<<i);
            }
        }
        return result;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int n = 5;

        System.out.println(grayCode(n));
    }
}
