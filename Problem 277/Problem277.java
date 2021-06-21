/**
 * Suppose you are at a party with n people (labeled from 0 to n - 1), and among them, there may exist one celebrity.
 * The definition of a celebrity is that all the other n - 1 people know him/her, but he/she does not know any of them.
 *
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to
 * do is to ask questions like: "Hi, A. Do you know B?" to get information about whether A knows B. You need to find
 * out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 *
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int
 * findCelebrity(n). There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if
 * there is a celebrity in the party. If there is no celebrity, return -1.
 *
 * Example 1:
 * Input: graph = [[1,1,0],[0,1,0],[1,1,1]]
 * Output: 1
 * Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j,
 * otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because
 * both 0 and 2 know him but 1 does not know anybody.
 *
 * Example 2:
 * Input: graph = [[1,0,1],[1,1,0],[0,1,1]]
 * Output: -1
 * Explanation: There is no celebrity.
 *
 * Constraints:
 * n == graph.length
 * n == graph[i].length
 * 2 <= n <= 100
 * graph[i][j] is 0 or 1.
 * graph[i][i] == 1
 *
 * Follow up: If the maximum number of allowed calls to the API knows is 3 * n, could you find a solution without
 * exceeding the maximum number of calls?
 */
public class Problem277 {

    /**
     * Data structure to store relations
     */
    private static int[][] graph;

    /**
     * Method to return relation between two given members
     *
     * @param i
     * @param j
     * @return
     */
    private static boolean knows(int i, int j) {
        return graph[i][j] == 1;
    }

    /**
     * Method to return celebrity among given members, if present
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param n
     * @return
     */
    private static int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }
        if (isCelebrity(celebrity, n)) {
            return celebrity;
        }
        return -1;
    }

    /**
     * Method to check if given celebrity member is valid
     *
     * @param celebrity
     * @param n
     * @return
     */
    private static boolean isCelebrity(int celebrity, int n) {
        for (int i = 0; i < n; i++) {
            if (i == celebrity) { continue; }
            if (!knows(i, celebrity) || knows(celebrity, i)) {
                return false;
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
        graph = new int[][]{{1,1,0},{0,1,0},{1,1,1}};
        System.out.println(findCelebrity(graph.length));
    }
}
