/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * Example 1:
 * Input: nums = [10,2]
 * Output: "210"
 *
 * Example 2:
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 *
 * Example 3:
 * Input: nums = [1]
 * Output: "1"
 *
 * Example 4:
 * Input: nums = [10]
 * Output: "10"
 *
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 10^9
 */
public class Problem179 {

    /**
     * Method to return largest possible string by combining all integers in array
     * Use Merge sort, and tweak the sorting algorithm to re-arrange all elements in desired manner
     *
     * Time Complexity: O(N logN)
     * Space Complexity: O(N)
     *
     * @param nums
     * @return
     */
    private static String largestNumber(int[] nums) {
        int[] aux = new int[nums.length];
        sort(nums, aux, 0, nums.length - 1);
        if (nums.length == 0) { return "0"; }

        StringBuilder sb = new StringBuilder();
        for (int n : nums) { sb.append(n); }
        return sb.toString();
    }

    /**
     * Merge Sort
     * Self-explanatory
     *
     * @param nums
     * @param aux
     * @param lo
     * @param hi
     */
    private static void sort(int[] nums, int[] aux, int lo, int hi) {
        if (lo >= hi) { return; }
        int mid = lo + (hi - lo) / 2;
        sort(nums, aux, lo, mid);
        sort(nums, aux, mid + 1, hi);
        merge(nums, aux, lo, mid, hi);
    }

    /**
     * Method to merge the elements in sorted manner
     *
     * @param nums
     * @param aux
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(int[] nums, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) { nums[k] = aux[j++]; }
            else if (j > hi) { nums[k] = aux[i++]; }
            else if (less(aux[i], aux[j])) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }

    /**
     * Method to determine comparison of integers
     *
     * @param a
     * @param b
     * @return
     */
    private static boolean less(int a, int b) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        sb1.append(a).append(b);
        sb2.append(b).append(a);

        return Long.parseLong(sb1.toString()) > Long.parseLong(sb2.toString());
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }
}
