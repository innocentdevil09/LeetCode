import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from
 * a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings
 * collectively.
 *
 * The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti,
 * heighti]:
 *
 * lefti is the x coordinate of the left edge of the ith building.
 * righti is the x coordinate of the right edge of the ith building.
 * heighti is the height of the ith building.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 *
 * The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,
 * y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in
 * the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost
 * building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.
 *
 * Note: There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...,[2
 * 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height 5 should be merged into one in the
 * final output as such: [...,[2 3],[4 5],[12 7],...]
 *
 * Example 1:
 * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * Explanation:
 * Figure A shows the buildings of the input.
 * Figure B shows the skyline formed by those buildings. The red points in figure B represent the key points in the
 * output list.
 *
 * Example 2:
 * Input: buildings = [[0,2,3],[2,5,3]]
 * Output: [[0,3],[5,0]]
 *
 * Constraints:
 * 1 <= buildings.length <= 10^4
 * 0 <= lefti < righti <= 2^31 - 1
 * 1 <= heighti <= 2^31 - 1
 * buildings is sorted by lefti in non-decreasing order.
 */
public class Problem218 {

    /**
     * Merge Sort algorithm
     * Another solution uses MaxHeap
     *
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     *
     * @param buildings
     * @return
     */
    private static List<List<Integer>> getSkyLine(int[][] buildings) {
        if (buildings.length == 0) { return new ArrayList<>(); }
        return getSkyLine(buildings, 0, buildings.length - 1);
    }

    /**
     * Helper method
     *
     * @param buildings
     * @param left
     * @param right
     * @return
     */
    private static List<List<Integer>> getSkyLine(int[][] buildings, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            return merge(getSkyLine(buildings, left, mid), getSkyLine(buildings, mid + 1, right));
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(buildings[left][0], buildings[left][2]));
        result.add(Arrays.asList(buildings[right][1], 0));
        return result;
    }

    /**
     * Method to merge left & right skylines together in sorted manner
     * Three cases based on x-coordinate
     *
     * @param leftSkyLine
     * @param rightSkyLine
     * @return
     */
    private static List<List<Integer>> merge(List<List<Integer>> leftSkyLine, List<List<Integer>> rightSkyLine) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, j = 0;
        int h1 = 0, h2 = 0;

        while (i < leftSkyLine.size() && j < rightSkyLine.size()) {
            int x = 0, h = 0;
            if (leftSkyLine.get(i).get(0) < rightSkyLine.get(j).get(0)) {
                x = leftSkyLine.get(i).get(0);
                h1 = leftSkyLine.get(i).get(1);
                h = Math.max(h1, h2);
                i++;
            } else if (leftSkyLine.get(i).get(0) > rightSkyLine.get(j).get(0)) {
                x = rightSkyLine.get(j).get(0);
                h2 = rightSkyLine.get(j).get(1);
                h = Math.max(h1, h2);
                j++;
            } else {
                x = leftSkyLine.get(i).get(0);
                h1 = leftSkyLine.get(i).get(1);
                h2 = rightSkyLine.get(j).get(1);
                h = Math.max(h1, h2);
                i++; j++;
            }

            if (result.isEmpty() || h != result.get(result.size() - 1).get(1)) {
                result.add(Arrays.asList(x, h));
            }
        }

        for (int k = i; k < leftSkyLine.size(); k++) {
            result.add(leftSkyLine.get(k));
        }
        for (int k = j; k < rightSkyLine.size(); k++) {
            result.add(rightSkyLine.get(k));
        }
        return result;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        System.out.println(getSkyLine(buildings));
    }
}
