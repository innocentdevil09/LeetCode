/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the
 * area of largest rectangle in the histogram.
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * Example:
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class Problem84 {

    /**
     * The original approach to solve this problem has time complexity = O(n^2).
     * So, what you need is -- for every index i, scan out in both directions as long as the neighbour has a greater
     * height. That is because you need to assume that the current index i has the minHeight. Therefore, the only way
     * to increase the area is to increase the base under contention.
     *
     * To bring down the time complexity, we use dynamic programming and compromise on space complexity i.e. two
     * arrays for left and right extension.
     * Time complexity comes down to O(n)
     *
     * @param heights
     * @return
     */
    private static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int[] leftExtension = new int[n];
        int[] rightExtension = new int[n];

        leftExtension[0] = -1;
        rightExtension[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = leftExtension[p];
            }
            leftExtension[i] = p;
        }

        for (int j = n - 1; j >= 0; j--) {
            int p = j + 1;
            while (p < n && heights[p] >= heights[j]) {
                p = rightExtension[p];
            }
            rightExtension[j] = p;
        }

        int maxArea = 0;
        for (int k = 0; k < n; k++) {
            maxArea = Math.max(maxArea, heights[k] * (rightExtension[k] - leftExtension[k] - 1));
        }
        return maxArea;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};

        System.out.println(largestRectangleArea(heights));
    }
}
