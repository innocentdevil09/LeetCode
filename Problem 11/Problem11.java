/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical
 * lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class Problem11 {

    /**
     * We use the Two-pointer approach
     * The intuition behind this approach is that the area formed between the lines will always be limited by the
     * height of the shorter line. Further, the farther the lines, the more will be the area obtained.
     *
     * One pointer at the beginning of array, the other at the end of array. Then move the shorter line.
     *
     * @param height
     */
    private static int maxArea(int[] height) {
        int maxArea = 0;

        int index1 = 0, index2 = height.length - 1;
        while (index1 != index2) {
            int area = (index2 - index1) * Math.min(height[index1], height[index2]);
            maxArea = Math.max(maxArea, area);

            if (height[index1] > height[index2]) {
                index2--;
            } else {
                index1++;
            }
        }
        return maxArea;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(height));
    }
}
