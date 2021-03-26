import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 *
 * Constraints:
 * 1 <= numRows <= 30
 */
public class Problem118 {

    /**
     * Method to generate Pascal's triangle
     *
     * Time Complexity: O(numRows^2)
     * Space Complexity: O(numRows^2)
     *
     * @param numRows
     * @return
     */
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) { return res; }

        List<Integer> prevList = null;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if (prevList != null) {
                for (int j = 0; j < prevList.size() - 1; j++) {
                    list.add(prevList.get(j) + prevList.get(j + 1));
                }
            }
            if (list.size() < i) {
                list.add(1);
            }
            prevList = list;
            res.add(list);
        }
        return res;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }
}
