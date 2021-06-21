/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version
 * of your product fails the quality check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the
 * following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find
 * the first bad version. You should minimize the number of calls to the API.
 *
 * Example 1:
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 *
 * Example 2:
 * Input: n = 1, bad = 1
 * Output: 1
 *
 * Constraints:
 * 1 <= bad <= n <= 2^31 - 1
 */
public class Problem278 {

    /**
     * Data variable
     */
    private static int BAD;

    /**
     * Method to indicate if given version is bad
     *
     * @param version
     * @return
     */
    private static boolean isBadVersion(int version) {
        return version >= BAD;
    }

    /**
     * Binary Search
     *
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     *
     * @param n
     * @return
     */
    private static int firstBadVersion(int n) {
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        BAD = 4;
        int n = 5;
        System.out.println(firstBadVersion(n));
    }
}
