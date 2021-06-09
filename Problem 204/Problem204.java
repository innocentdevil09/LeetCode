import java.util.Arrays;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example 1:
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * Example 2:
 * Input: n = 0
 * Output: 0
 *
 * Example 3:
 * Input: n = 1
 * Output: 0
 *
 * Constraints:
 * 0 <= n <= 5 * 10^6
 */
public class Problem204 {

    /**
     * Method to get prime sieves
     *
     * Time Complexity: O(_/N loglog N)
     * Space Complexity: O(N)
     *
     * @param n
     * @return
     */
    private static int countPrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        if (n >= 2) { primes[2] = true; }

        for (int i = 3; i <= n; i += 2) {
            primes[i] = true;
        }

        for (int k = 3; k * k <= n; k += 2) {
            if (primes[k]) {
                for (int j = k * k; j <= n; j += 2*k) {
                    primes[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (primes[i]) { count++; }
        }
        return count;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 13098;
        System.out.println(countPrimes(n));
    }
}
