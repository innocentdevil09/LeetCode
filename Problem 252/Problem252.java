/**
 * Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend
 * all meetings.
 *
 * Example 1:
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: false
 *
 * Example 2:
 * Input: intervals = [[7,10],[2,4]]
 * Output: true
 *
 * Constraints:
 * 0 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti < endi <= 10^6
 */
public class Problem252 {

    /**
     * Method to determine overlapping meeting intervals
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param intervals
     * @return
     */
    private static boolean canAttendMeetings(int[][] intervals) {
        int len = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            len = Math.max(len, interval[1]);
        }

        boolean[] timing = new boolean[len];
        for (int[] interval : intervals) {
            for (int i = interval[0]; i < interval[1]; i++) {
                if (timing[i]) { return false; }
                timing[i] = true;
            }
        }
        return true;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(canAttendMeetings(intervals));
    }
}
