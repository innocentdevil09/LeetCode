import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid rooms initialized with these three possible values.
 *
 * -1 A wall or an obstacle.
 * 0 A gate.
 * INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that
 * the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be
 * filled with INF.
 *
 * Example 1:
 * Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],
 * [0,-1,2147483647,2147483647]]
 * Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 *
 * Example 2:
 * Input: rooms = [[-1]]
 * Output: [[-1]]
 *
 * Example 3:
 * Input: rooms = [[2147483647]]
 * Output: [[2147483647]]
 *
 * Example 4:
 * Input: rooms = [[0]]
 * Output: [[0]]
 *
 * Constraints:
 * m == rooms.length
 * n == rooms[i].length
 * 1 <= m, n <= 250
 * rooms[i][j] is -1, 0, or 2^31 - 1.
 */
public class Problem286 {

    /**
     * Simple BFS traversal to mark distances
     * Since BFS guarantees that we search all rooms of distance d before searching rooms of distance d + 1,
     * the distance to an empty room must be the shortest
     *
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     *
     * @param rooms
     */
    private static void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(i * n + j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int row = node / n, col = node % n;

            if (row + 1 < m && rooms[row + 1][col] == Integer.MAX_VALUE) {
                // Since BFS guarantees that we search all rooms of distance d before searching rooms of distance d + 1,
                // the distance to an empty room must be the shortest
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.offer((row + 1) * n + col);
            }
            if (row - 1 >= 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.offer((row - 1) * n + col);
            }
            if (col + 1 < m && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.offer(row * n + col + 1);
            }
            if (col - 1 >= 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.offer(row * n + col - 1);
            }
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] rooms = new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};

        wallsAndGates(rooms);

        for (int[] room : rooms) {
            Arrays.stream(room).forEach(r -> System.out.print(r + " "));
            System.out.println();
        }
    }
}
