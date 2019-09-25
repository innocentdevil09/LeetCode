/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
 * extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example 1:
 *
 * Given nums = [3,2,2,3], val = 3,
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 *
 * Note that the order of those five elements can be arbitrary.
 *
 * It doesn't matter what values are set beyond the returned length.
 */
public class Problem27 {

    /**
     * Method to rearrange the array such that the val to be removed is replaced by the elements at other indexes
     * Algo :-
     * 1. We use two pointers approach to rearrange the array.
     * 2. The pointer i is incremented one place at a time while the pointer j is incremented everytime it encounters
     * an index containing element val to be excluded
     * 3. In case there are no elements to be removed within the array, both i and j will keep incrementing by 1 till
     * the end of array
     * 4. However, for each index where val element is present, j pointer will shift to its next position and we
     * could then replace the element at index i with the element at index j
     * 5. This approach covers all edge cases, including the case if the all the elements in the array are equal to val
     *
     * @param nums
     * @param val
     */
    private static int removeElement(int[] nums, int val) {
        int res = nums.length;
        for (int i = 0, j = 0; j < nums.length; i++, j++) {
            while (j < nums.length && nums[j] == val) {
                j++;
                res--;
            }
            if (j < nums.length) {
                nums[i] = nums[j];
            }
        }
        return res;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.println(removeElement(nums, val));
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
