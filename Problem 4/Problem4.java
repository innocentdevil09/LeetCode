/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class Problem4 {

    /**
     * Trying to find median of two sorted arrays could be easily done in O(m + n) time -> merge the arrays together
     * and then use the median() method
     *
     * But the given problem could be solved in O(log(min(m, n))) time
     * To understand how to do that, keep the definition of median in mind. A median of an array is the value that
     * divides a sorted array into two equal parts.
     *
     * Let's say nums1 array has m elements and nums2 array has n elements
     * the medianIndex would be (m + n) / 2 in the final array
     * If we get all the elements in a sorted way upto the medianIndex, the job is done. We can easily calculate the
     * medianValue
     *
     * lets assume nums1 contributed i elements and nums2 contributed j elements to that final array, then a few
     * conditions hold:
     * 1. (i + j) = (m - i) + (n - j) // elements on both sides will be equal
     * 2. nums1[i] <= nums2[j]
     *
     * From 1. we get j = (m + n + 2i) / 2
     * To get the value of i, we can use condition 2. to execute a while loop to reach the value of both i and j
     *
     * Once we get the values of i and j, we know how many elements will be contributed by nums1 and nums2 respectively,
     * to the sorted array upto the medianIndex of combined array
     *
     * Need to take care of edge cases to avoid ArrayOutOfBoundsException
     *
     * @param nums1
     * @param nums2
     */
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            m = nums1.length;
            n = nums2.length;
        }

        int iMin = 0, iMax = m;
        int halfLength = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLength - i;
            if (i < iMax && nums1[i] < nums2[j - 1]) {
                iMin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int medianElement1 = 0;
                if (i == 0) { medianElement1 = nums2[j - 1]; }
                else if (j == 0) { medianElement1 = nums1[i - 1]; }
                else { medianElement1 = Math.max(nums1[i - 1], nums2[j - 1]); }
                if ((m + n) % 2 == 1) {
                    return medianElement1;
                }

                int medianElement2 = 0;
                if (i == m) { medianElement2 = nums2[j]; }
                else if (j == n) { medianElement2 = nums1[i]; }
                else { medianElement2 = Math.min(nums1[i], nums2[j]); }
                return (double) (medianElement1 + medianElement2) / 2;
            }
        }
        return 0.0;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
