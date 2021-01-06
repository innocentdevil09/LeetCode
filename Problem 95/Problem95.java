import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 *
 * Example:
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *
 * Constraints:
 * 0 <= n <= 8
 */
public class Problem95 {

    /**
     * Inner Node data structure for Trees
     */
    private static class Node {
        Node left, right;
        int val;
        
        Node(int val) {
            this.val = val;
        }
    }

    /**
     * DP approach to generate all the unique combination of trees
     * Generating all permutations of n is at most O(n!), however [2,1,3] & [2,3,1] -- both gives the same tree. This
     * becomes a problem and so, adding a check to add to the list only if unique increases the time complexity
     *
     * DP approach solves that, but it's hard to understand and come up intuitively
     * dp[i] stores the result until length i. For the result for length i+1, select the root node j from 0 to i,
     * combine the result from left side and right side. Note for the right side we have to clone the nodes as the value
     * will be offset by j.
     *
     * @param n
     * @return
     */
    private static List<Node> generateTrees(int n) {
        List<Node>[] dp = new List[n + 1];
        if (n == 0) { return new ArrayList<>(); }

        dp[0] = new ArrayList<>();
        dp[0].add(null);

        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) {

                for (Node left : dp[j]) {
                    for (Node right : dp[i - j - 1]) {
                        Node node = new Node(j + 1);
                        node.left = left;
                        node.right = clone(right, j + 1);
                        dp[i].add(node);
                    }
                }
            }
        }
        return dp[n];
    }

    /**
     * Method to clone a given node and return
     *
     * @param node
     * @param offset
     * @return
     */
    private static Node clone(Node node, int offset) {
        if (node == null) {
            return null;
        }

        Node newNode = new Node(node.val + offset);
        newNode.left = clone(node.left, offset);
        newNode.right = clone(node.right, offset);
        return newNode;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int n = 3;

        System.out.println(generateTrees(n));
    }
}
