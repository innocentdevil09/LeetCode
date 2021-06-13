/**
 * Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two
 * rectangles.
 *
 * The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
 * The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).
 *
 * Example 1:
 * Rectangle Area
 * Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * Output: 45
 *
 * Example 2:
 * Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * Output: 16
 *
 * Constraints:
 * -10^4 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 10^4
 */
public class Problem223 {

    /**
     * Computing area of rectangle, taking into account overlap area
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @param F
     * @param G
     * @param H
     * @return
     */
    private static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long area = ((long) (C - A) * (long) (D - B)) + ((long) (G - E) * (long) (H - F));

        int left = (C <= E || G <= A) ? 0 : Math.max(A, E);
        int right = (C <= E || G <= A) ? 0 : Math.min(C, G);
        int down = (H <= B || D <= F) ? 0 : Math.max(F, B);
        int up = (H <= B || D <= F) ? 0 : Math.min(H, D);

        area -= (long) (right - left) * (long) (up - down);
        return (int) area;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;

        System.out.println(computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }
}
