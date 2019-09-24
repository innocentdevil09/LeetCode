/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the
 * new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
 * extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4
 * respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 */
public class Problem26 {

    /**
     * Method to rearrange array such that duplicate elements occur after the length with its unique elements
     * e.g. [0,0,1,1,1,2,2,3,3,4] will be changed to [0,1,2,3,4,2,2,3,3,4]
     *
     * The algo does not care to maintain all the original elements of the array. It only rearranges the array using
     * two pointers
     *
     * The algo is slightly tricky and counter-intuitive in the sense that it does not use sliding approach or does
     * not swap the elements inside the array to rearrange the elements.
     * Using the two pointers, we try to determine the index where we need to place the correct elements, that's all.
     *
     * @param nums
     */
    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) { return 0; }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        System.out.println(removeDuplicates(nums));
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
