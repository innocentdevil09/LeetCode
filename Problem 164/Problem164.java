import java.util.stream.IntStream;

/**
 * Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If
 * the array contains less than two elements, return 0.
 *
 * You must write an algorithm that runs in linear time and uses linear extra space.
 *
 * Example 1:
 * Input: nums = [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
 *
 * Example 2:
 * Input: nums = [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 *
 * Constraints:
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 10^9
 */
public class Problem164 {

    /**
     * Inner class to store elements in Bucket data structure
     */
    private static class Bucket {
        boolean used;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
    }

    /**
     * Method to sort elements into buckets. Use buckets min & max val to find maximum gap
     *
     * Time Complexity: O(N + B)
     * Space Complexity: O(B)
     *
     * @param nums
     * @return
     */
    private static int maximumGap(int[] nums) {
        if (nums.length < 2) { return 0; }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        int bucketSize = Math.max(1, (max - min)) / (nums.length - 1);
        int bucketNum = ((max - min) / bucketSize) + 1;

        Bucket[] buckets = new Bucket[bucketNum];
        IntStream.range(0, bucketNum).forEach(i -> buckets[i] = new Bucket());

        for (int num : nums) {
            int bucketId = (num - min) / bucketSize;
            buckets[bucketId].used = true;
            buckets[bucketId].minVal = Math.min(buckets[bucketId].minVal, num);
            buckets[bucketId].maxVal = Math.max(buckets[bucketId].maxVal, num);
        }

        int prevBucketMax = min, maxGap = 0;
        for (Bucket b : buckets) {
            if (!b.used) { continue; }
            maxGap = Math.max(maxGap, b.minVal - prevBucketMax);
            prevBucketMax = b.maxVal;
        }
        return maxGap;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {3,6,9,1};
        System.out.println(maximumGap(nums));
    }
}
