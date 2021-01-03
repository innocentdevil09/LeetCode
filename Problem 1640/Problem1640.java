/**
 * You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in
 * pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order. However, you are
 * not allowed to reorder the integers in each array pieces[i].
 *
 * Return true if it is possible to form the array arr from pieces. Otherwise, return false.
 *
 * Example 1:
 * Input: arr = [85], pieces = [[85]]
 * Output: true
 *
 * Example 2:
 * Input: arr = [15,88], pieces = [[88],[15]]
 * Output: true
 * Explanation: Concatenate [15] then [88]
 *
 * Example 3:
 * Input: arr = [49,18,16], pieces = [[16,18,49]]
 * Output: false
 * Explanation: Even though the numbers match, we cannot reorder pieces[0].
 *
 * Example 4:
 * Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * Output: true
 * Explanation: Concatenate [91] then [4,64] then [78]
 *
 * Example 5:
 * Input: arr = [1,3,5,7], pieces = [[2,4,6,8]]
 * Output: false
 *
 * Constraints:
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * The integers in arr are distinct.
 * The integers in pieces are distinct (i.e., If we flatten pieces in a 1D array, all the integers in this array are
 * distinct).
 */
public class Problem1640 {

    /**
     * Method to check if the given pieces matrix elements can be re-arranged to form the arr array
     *
     * @param arr
     * @param pieces
     * @return
     */
    private static boolean canFormArray(int[] arr, int[][] pieces) {
        for (int i = 0; i < arr.length; i++) {
            int index = getIndex(pieces, arr[i]);
            if (index == -1) { return false; }
            for (int j = 0; j < pieces[index].length; i++, j++) {
                if (arr[i] != pieces[index][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method to return index of row in the pieces matrix containing the element
     *
     * @param pieces
     * @param n
     * @return
     */
    private static int getIndex(int[][] pieces, int n) {
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i][0] == n) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {91,4,64,78};
        int[][] pieces = new int[][]{{78},{4,64},{91}};

        System.out.println(canFormArray(arr, pieces));
    }
}
