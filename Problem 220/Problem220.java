import java.util.TreeSet;

/**
 * Given an integer array nums and two integers k and t, return true if there are two distinct indices i and j in the
 * array such that abs(nums[i] - nums[j]) <= t and abs(i - j) <= k.
 *
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 *
 * Constraints:
 * 0 <= nums.length <= 2 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^4
 * 0 <= t <= 2^31 - 1
 */
public class Problem220 {

    /**
     * TreeSet data structure as it helps with getting the floor & ceiling values for a given num.
     *
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long val = nums[i];

            Long ceiling = treeSet.ceiling(val);
            if (ceiling != null && Math.abs(ceiling - val) <= (long) t) { return true; }

            Long floor = treeSet.floor(val);
            if (floor != null && Math.abs(val - floor) <= (long) t) { return true; }

            treeSet.add(val);
            // If the size of the set is larger than k, remove the oldest item.
            if (treeSet.size() > k) {
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1,5,9,1,5,9};
        int k = 2, t = 3;

        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
}
