import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
 * So it is impossible.
 *
 * Constraints:
 * 1 <= numCourses <= 10^5
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class Problem207 {

    /**
     * DFS traversal. Check cyclical dependency
     *
     * Time Complexity: O(2 ^ N)
     * Space Complexity: O(N)
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            if (pre[0] >= numCourses || pre[1] >= numCourses || pre[0] == pre[1]) {
                return false;
            }
            boolean[] marked = new boolean[numCourses];
            if (!dfs(pre[0], pre[1], graph, marked)) {
                return false;
            }
            graph[pre[0]].add(pre[1]);
        }
        return true;
    }

    /**
     * DFS method
     * The dfs approach is there to check cyclical dependency. Therefore we check of all the courses that are
     * pre-requisites, is anyone of them same as the current course? That's all
     *
     * @param course
     * @param prerequisite
     * @param graph
     * @param marked
     * @return
     */
    private static boolean dfs(int course, int prerequisite, List<Integer>[] graph, boolean[] marked) {
        if (course == prerequisite) { return false; }
        marked[prerequisite] = true;
        for (int k : graph[prerequisite]) {
            if (!marked[k] && !dfs(course, k, graph, marked)) {
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
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};

        System.out.println(canFinish(numCourses, prerequisites));
    }
}
