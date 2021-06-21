/**
 * You are painting a fence of n posts with k different colors. You must paint the posts following these rules:
 *
 * Every post must be painted exactly one color.
 * At most one pair of adjacent fence posts can have the same color.
 * Given the two integers n and k, return the number of ways you can paint the fence.
 *
 * Example 1:
 * Input: n = 3, k = 2
 * Output: 6
 * Explanation: All the possibilities are shown.
 * Note that painting all the posts red or all the posts green is invalid because there can only be at most one pair
 * of adjacent posts that are the same color.
 *
 * Example 2:
 * Input: n = 1, k = 1
 * Output: 1
 *
 * Example 3:
 * Input: n = 7, k = 2
 * Output: 42
 *
 * Constraints:
 * 1 <= n <= 50
 * 1 <= k <= 10^5
 * The answer is guaranteed to be in the range [0, 2^31 - 1] for the given n and k.
 */
public class Problem276 {

    /**
     * If you are painting the ith post, you have two options:
     *
     * make it different color as i-1th post
     * make it same color as i-1 th post (if you are allowed!)
     * simply add these for your answer:
     * num_ways(i) = num_ways_diff(i) + num_ways_same(i)
     *
     * Now just think of how to calculate each of those functions.
     *
     * The first one is easy. If you are painting the ith post, how many ways can you paint it to make it different
     * from the i-1 th post? k-1
     *
     * num_ways_diff(i) = num_ways(i-1) * (k-1)
     *
     * The second one is hard, but not so hard when you think about it.
     *
     * If you are painting the ith post, how many ways can you paint it to make it the same as the i-1th post? At
     * first, we should think the answer is 1 -- it must be whatever color the last one was.
     *
     * num_ways_same(i) = num_ways(i-1) * 1
     *
     * But no! This will fail in the cases where painting the last post the same results in three adjacent posts of
     * the same color! We need to consider ONLY the cases where the last two colors were different. But we can do that!
     *
     * num_ways_diff(i-1) <- all the cases where the i-1th and i-2th are different.
     *
     * THESE are the cases where can just plop the same color to the end, and no longer worry about causing three in
     * a row to be the same.
     *
     * num_ways_same(i) = num_ways_diff(i-1) * 1
     *
     * We sum these for our answer, like I said before:
     *
     * num_ways(i) = num_ways_diff(i) + num_ways_same(i)
     * = num_ways(i-1) * (k-1) + num_ways_diff(i-1)
     *
     * We know how to compute num_ways_diff, so we can substitute:
     * num_ways(i) = num_ways(i-1) * (k-1) + num_ways(i-2) * (k-1)
     *
     * We can even simplify a little more:
     *
     * num_ways(i) = (num_ways(i-1) + num_ways(i-2)) * (k-1)
     *
     * As a note, trying to intuitively understand that last line is impossible. If you think you understand it
     * intuitively, you are fooling yourself. Only the original equation makes intuitive sense.
     *
     * @param n
     * @param k
     * @return
     */
    private static int numWays(int n, int k) {
        // if there are no posts, there are no ways to paint them
        if (n == 0 || k == 0) { return 0; }
        int[] dp = new int[n + 1];

        // if there is only one post, there are k ways to paint it
        if (n >= 1) { dp[1] = k; }
        // if there are only two posts, you can't make a triplet, so you
        // are free to paint however you want.
        // first post, k options. second post, k options
        if (n >= 2) { dp[2] = k * k; }
        if (k == 1) { return dp[n]; }
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
        }
        return dp[n];
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 7, k = 2;
        System.out.println(numWays(n, k));
    }
}
