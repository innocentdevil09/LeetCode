import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number
 * of conference rooms required.
 *
 * Example 1:
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 *
 * Example 2:
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 * Constraints:
 * 1 <= intervals.length <= 10^4
 * 0 <= starti < endi <= 10^6
 */
public class Problem253 {

    /**
     * Method to determine min conference rooms required for all meetings
     *
     * Time Complexity: O(N logN)
     * Space Complexity: O(N)
     *
     * @param intervals
     * @return
     */
    private static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) { return 0; }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRooms(intervals));
    }
}
