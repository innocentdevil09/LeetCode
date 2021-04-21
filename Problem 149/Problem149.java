import javafx.util.Pair;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number
 * of points that lie on the same straight line.
 *
 * Example 1:
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 *
 * Example 2:
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 *
 * Constraints:
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * All the points are unique.
 */
public class Problem149 {

    private static int[][] points_ref;
    private static int n;
    private static Map<Pair<Integer, Integer>, Integer> lines = new HashMap<>();
    private static int horizontal_lines;

    /**
     * Simplify the problem and search the maximum number of points on a line passing through the point i
     * Since we are drawing a line between the starting point i and each of the following points, if all these lines
     * share the same slope value, then we can be sure that all these points are aligned on the same line.
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     *
     * @param points
     * @return
     */
    private static int maxPoints(int[][] points) {
        points_ref = points;
        n = points.length;
        if (n < 3) { return n; }

        int max_count = 1;
        for (int i = 0; i < n - 1; i++) {
            max_count = Math.max(max_points_on_a_line_containing_i(i), max_count);
        }
        return max_count;
    }

    /**
     * Compute the max number of points for a line containing point i.
     *
     * @param i
     * @return
     */
    private static int max_points_on_a_line_containing_i(int i) {
        // init lines passing through point i
        lines.clear();
        horizontal_lines = 1;
        // One starts with just one point on a line : point i.
        int count = 1;
        // There is no duplicates of a point i so far
        int duplicates = 0;
        // Compute lines passing through point i (fixed) and point j.
        // Update in a loop the number of points on a line and the number of duplicates of point i.
        for (int j = i + 1; j < n; j++) {
            Pair<Integer, Integer> p = add_line(i, j, count, duplicates);
            count = p.getKey();
            duplicates = p.getValue();
        }
        return count + duplicates;
    }

    /**
     * Add a line passing through i and j points. Update max number of points on a line containing point i. Update a
     * number of duplicates of i point.
     *
     * @param i
     * @param j
     * @param count
     * @param duplicates
     * @return
     */
    private static Pair<Integer, Integer> add_line(int i, int j, int count, int duplicates) {
        int x1 = points_ref[i][0];
        int y1 = points_ref[i][1];
        int x2 = points_ref[j][0];
        int y2 = points_ref[j][1];

        if (x1 == x2 && y1 == y2) {
            duplicates++;
        } else if (y1 == y2) {
            horizontal_lines++;
            count = Math.max(count, horizontal_lines);
        } else {
            Pair<Integer, Integer> slope = slope_coprime(x1, x2, y1, y2);
            lines.put(slope, lines.getOrDefault(slope, 1) + 1);
            count = Math.max(count, lines.get(slope));
        }
        return new Pair<>(count, duplicates);
    }

    /**
     * To avoid the precision issue with float/double numbers, using a pair of co-prime numbers to
     * represent the slope.
     *
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return
     */
    private static Pair<Integer, Integer> slope_coprime(int x1, int x2, int y1, int y2) {
        int deltaX = x1 - x2, deltaY = y1 - y2;
        if (deltaX == 0) {
            return new Pair<>(0, 0);
        } else if (deltaY == 0) {
            return new Pair<>(Integer.MAX_VALUE, Integer.MAX_VALUE);
        } else if (deltaX < 0) {
            deltaX *= -1;
            deltaY *= -1;
        }

        int gcd = BigInteger.valueOf(deltaX).gcd(BigInteger.valueOf(deltaY)).intValue();

        return new Pair<>(deltaX / gcd, deltaY/ gcd);
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 1}, {2, 2}, {3, 3}};

        System.out.println(maxPoints(points));
    }
}
