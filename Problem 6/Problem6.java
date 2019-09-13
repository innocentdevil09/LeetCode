import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class Problem6 {

    /**
     * Method to convert a given string s into a zig-zag form based on the given number of rows
     * Algo :-
     * 1. Initialize a list of rows each containing a StringBuilder object to append characters of the same rows
     * together
     * 2. Keep a track of the rowIndex by using a boolean flag, which helps to form a cycle of incrementing &
     * decrementing the rowIndex as we move forward reading each character in the given string
     * 3. Append all StringBuilder objs into one and return the result
     *
     * @param s
     * @param numRows
     */
    private static String convert(String s, int numRows) {
        if (numRows == 1) { return s; }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char ch : s.toCharArray()) {
            rows.get(currentRow).append(ch);
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;

        System.out.println(convert(s, numRows));
    }
}
