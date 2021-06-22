import java.util.Arrays;
import java.util.List;

/**
 * Given two vectors of integers v1 and v2, implement an iterator to return their elements alternately.
 *
 * Implement the ZigzagIterator class:
 *
 * ZigzagIterator(List<int> v1, List<int> v2) initializes the object with the two vectors v1 and v2.
 * boolean hasNext() returns true if the iterator still has elements, and false otherwise.
 * int next() returns the current element of the iterator and moves the iterator to the next element.
 *
 * Example 1:
 * Input: v1 = [1,2], v2 = [3,4,5,6]
 * Output: [1,3,2,4,5,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should
 * be: [1,3,2,4,5,6].
 *
 * Example 2:
 * Input: v1 = [1], v2 = []
 * Output: [1]
 *
 * Example 3:
 * Input: v1 = [], v2 = [1]
 * Output: [1]
 *
 * Constraints:
 * 0 <= v1.length, v2.length <= 1000
 * 1 <= v1.length + v2.length <= 2000
 * -2^31 <= v1[i], v2[i] <= 2^31 - 1
 *
 * Follow up: What if you are given k vectors? How well can your code be extended to such cases?
 *
 * Clarification for the follow-up question:
 *
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to
 * you, replace "Zigzag" with "Cyclic".
 *
 * Example:
 * Input: v1 = [1,2,3], v2 = [4,5,6,7], v3 = [8,9]
 * Output: [1,4,8,2,5,9,3,6,7]
 */
public class Problem281 {

    /**
     * Zigzag Iterator class
     */
    private static class ZigzagIterator {

        private int i = 0, j = 0;
        private List<Integer> v1 = null, v2 = null;
        private boolean first = true;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        public int next() {
            if ((first && i < v1.size()) || (j > v2.size())) {
                first = false;
                return v1.get(i++);
            } else {
                first = true;
                return v2.get(j++);
            }
        }

        public boolean hasNext() {
            return i < v1.size() || j < v2.size();
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> v1 = Arrays.asList(1, 2);
        List<Integer> v2 = Arrays.asList(3,4,5,6);

        ZigzagIterator iter = new ZigzagIterator(v1, v2);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
