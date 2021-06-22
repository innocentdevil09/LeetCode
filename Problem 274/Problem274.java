/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their
 * ith paper, return compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at
 * least h citations each, and the other n − h papers have no more than h citations each.
 * If there are several possible values for h, the maximum one is taken as the h-index.
 *
 * Example 1:
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5
 * citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3
 * citations each, their h-index is 3.
 *
 * Example 2:
 * Input: citations = [1,3,1]
 * Output: 1
 *
 * Constraints:
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 */
public class Problem274 {

    /**
     * Method to determine h count of papers which cited >= h times
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param citations
     * @return
     */
    private static int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        for (int c : citations) {
            papers[(Math.min(n, c))]++;
        }

        int k = n;
        for (int i = papers[n]; k > i; i += papers[k]) {
            k--;
        }
        return k;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex(citations));
    }
}