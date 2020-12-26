/**
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 * Example 3:
 * Input: n = 3, k = 1
 * Output: "123"
 *
 * Constraints:
 * 1 <= n <= 9
 * 1 <= k <= n!
 */
public class Problem60 {

    /**
     * Method to get the kth permutation for a given number
     *
     * @param n
     * @param k
     * @return
     */
    private static String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }

        for (int i = 1; i < k; i++) {
            nextPermutation(arr);
        }
        String result = "";
        for (int i : arr) {
            result += "" + i;
        }
        return result;
    }

    /**
     * Method to rearrange the elements in the given array to get the next permutation
     *
     * @param arr
     */
    private static void nextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 2;
        for (i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
        }
        int ceiling = findCeiling(arr, arr[i], i + 1);
        swap(arr, i, ceiling);
        reverse(arr, i + 1, n - 1);
    }

    /**
     * Method to get the index of the next number to be used to get the next permutation
     *
     * @param arr
     * @param threshold
     * @param start
     * @return
     */
    private static int findCeiling(int[] arr, int threshold, int start) {
        int ceiling = arr.length - 1;
        while (ceiling > start && arr[ceiling] < threshold) {
            ceiling--;
        }
        return ceiling;
    }

    /**
     * Method to swap the elements at given two index
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        arr[i] += arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    /**
     * Method to reverse the given array between index lo & hi
     *
     * @param arr
     * @param lo
     * @param hi
     */
    private static void reverse(int[] arr, int lo, int hi) {
        while (lo < hi) {
            swap(arr, lo, hi);
            lo++;
            hi--;
        }
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int n = 4, k = 9;

        System.out.println(getPermutation(n, k));
    }
}
