import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a
 * particular value.
 *
 * Implement the TwoSum class:
 *
 * TwoSum() Initializes the TwoSum object, with an empty array initially.
 * void add(int number) Adds number to the data structure.
 * boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise,
 * it returns false.
 *
 * Example 1:
 * Input
 * ["TwoSum", "add", "add", "add", "find", "find"]
 * [[], [1], [3], [5], [4], [7]]
 * Output
 * [null, null, null, null, true, false]
 *
 * Explanation
 * TwoSum twoSum = new TwoSum();
 * twoSum.add(1);   // [] --> [1]
 * twoSum.add(3);   // [1] --> [1,3]
 * twoSum.add(5);   // [1,3] --> [1,3,5]
 * twoSum.find(4);  // 1 + 3 = 4, return true
 * twoSum.find(7);  // No two integers sum up to 7, return false
 *
 *
 * Constraints:
 *
 * -10^5 <= number <= 10^5
 * -2^31 <= value <= 2^31 - 1
 * At most 5 * 10^4 calls will be made to add and find.
 */
public class Problem170 {

    /**
     * Trade-off to spend O(N) in find operation than in the sum operation
     * Also added advantage of efficient in space complexity
     */
    private static class TwoSum {

        private Map<Integer, Integer> map = null;

        /** Initialize your data structure here. */
        public TwoSum() {
            map = new HashMap<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for (int n : map.keySet()) {
                int diff = value - n;
                if (!map.containsKey(diff)) { continue; }

                int val = map.get(diff);
                if (diff != n || val > 1) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);   // [] --> [1]
        twoSum.add(3);   // [1] --> [1,3]
        twoSum.add(5);   // [1,3] --> [1,3,5]

        System.out.println(twoSum.find(4));  // 1 + 3 = 4, return true
        System.out.println(twoSum.find(7));  // No two integers sum up to 7, return false
    }
}
