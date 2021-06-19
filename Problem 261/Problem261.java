/**
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i]
 * = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 *
 * Example 1:
 * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * Output: true
 *
 * Example 2:
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * Output: false
 *
 * Constraints:
 * 1 <= 2000 <= n
 * 0 <= edges.length <= 5000
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * There are no self-loops or repeated edges.
 */
public class Problem261 {

    /**
     * Inner UnionFind data structure
     */
    private static class UnionFind {

        private int[] parent;
        private int[] size; // We use this to keep track of the size of each set.

        /**
         * For efficiency, we aren't using makeset, but instead initialising
         * all the sets at the same time in the constructor.
         *
         * @param n
         */
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        /**
         * The find method, with path compression. There are ways of implementing
         * this elegantly with recursion, but the iterative version is easier for
         * most people to understand!
         *
         * @param node
         * @return
         */
        public int find(int node) {
            // Step 1: Find the root.
            int root = node;
            while (root != parent[root]) {
                root = parent[root];
            }
            // Step 2: Do a second traversal, this time setting each node to point
            // directly at A as we go.
            while (node != root) {
                int temp = parent[node];
                parent[node] = root;
                node = temp;
            }
            return root;
        }

        /**
         * The union method, with optimization union by size. It returns True if a
         * merge happened, False if otherwise.
         *
         * @param A
         * @param B
         * @return
         */
        public boolean union(int A, int B) {
            // Find the roots for A and B.
            int rootA = find(A);
            int rootB = find(B);
            // Check if A and B are already in the same set.
            if (rootA == rootB) {
                return false;
            }
            // We want to ensure the larger set remains the root.
            if (size[rootA] < size[rootB]) {
                // Make rootB the overall root.
                parent[rootA] = rootB;
                // The size of the set rooted at B is the sum of the 2.
                size[rootB] += size[rootA];
            } else {
                // Make rootA the overall root.
                parent[rootB] = rootA;
                // The size of the set rooted at A is the sum of the 2.
                size[rootA] += size[rootB];
            }
            return true;
        }
    }

    /**
     * Method to determine if given edges constitute a valid tree
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param n
     * @param edges
     * @return
     */
    private static boolean validTree(int n, int[][] edges) {
        // Condition 1: The graph must contain n - 1 edges.
        if (edges.length != n - 1) { return false; }

        // Condition 2: The graph must contain a single connected component.
        // Create a new UnionFind object with n nodes.
        UnionFind uf = new UnionFind(n);
        // Add each edge. Check if a merge happened, because if it didn't, there must be a cycle.
        for (int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];
            if (!uf.union(A, B)) {
                return false;
            }
        }
        // If we got this far, there's no cycles!
        return true;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        System.out.println(validTree(n, edges));
    }
}
