import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * Example 3:
 * Input: intervals = [], newInterval = [5,7]
 * Output: [[5,7]]
 *
 * Example 4:
 * Input: intervals = [[1,5]], newInterval = [2,3]
 * Output: [[1,5]]
 *
 * Example 5:
 * Input: intervals = [[1,5]], newInterval = [2,7]
 * Output: [[1,7]]
 *
 * Constraints:
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 10^5
 * intervals is sorted by intervals[i][0] in ascending order.
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 10^5
 */
public class Problem57 {

    /**
     * The idea is to sort the intervals by their starting points. Then, we take the first interval and compare its
     * end with the next intervals starts. As long as they overlap, we update the end to be the max end of the
     * overlapping intervals. Once we find a non overlapping interval, we can add the previous "extended" interval
     * and start over.
     *
     * Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the resulting algorithm takes O(n log(n)).
     *
     * @param intervals
     * @return
     */
    private static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>();
        boolean isAdded = false;
        for (int[] interval : intervals) {
            if (interval[0] >= newInterval[0]) {
                intervalList.add(newInterval);
                isAdded = true;
            }
            intervalList.add(interval);
        }
        if (!isAdded) {
            intervalList.add(newInterval);
        }

        List<int[]> result = new ArrayList<>();
        int[] tracker = intervalList.get(0);
        result.add(tracker);
        for (int[] interval : intervalList) {
            if (interval[0] <= tracker[1]) {
                tracker[1] = Math.max(tracker[1], interval[1]);
            } else {
                tracker = interval;
                result.add(tracker);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = new int[]{4,8};

        int[][] merged = insert(intervals, newInterval);
        for (int[] row : merged) {
            for (int col : row) {
                System.out.print(col + " | ");
            }
            System.out.print("\n");
        }
    }
}
