/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * Constraints:
 * 1 <= a.length, b.length <= 10^4
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class Problem67 {

    /**
     * Method to add two given binary numbers in string format
     *
     * @param a
     * @param b
     * @return
     */
    private static String addBinary(String a, String b) {
        char carryOver = '0';
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = arrA.length - 1, j = arrB.length - 1; i >= 0 || j >= 0; i--, j--) {
            char ca = i >= 0 ? arrA[i] : '0';
            char cb = j >= 0 ? arrB[j] : '0';

            String s = sum(ca, cb, carryOver);
            carryOver = s.length() == 2 ? '1' : '0';
            sb.append(s.charAt(s.length() - 1));
        }
        if (carryOver == '1') {
            sb.append(carryOver);
        }

        return sb.reverse().toString();
    }

    /**
     * Method to list down all scenarios with different values for char a, b, and carryOver
     *
     * @param a
     * @param b
     * @param carryOver
     * @return
     */
    private static String sum(char a, char b, char carryOver) {
        if (a == '1' && b == '1' && carryOver == '1') {
            return "11";
        }
        if ((a == '1' && b == '1' && carryOver == '0') || (a == '1' && b == '0' && carryOver == '1') || (a == '0' && b == '1' && carryOver == '1') ) {
            return "10";
        }
        if ((a == '1' && b == '0' && carryOver == '0') || (a == '0' && b == '1' && carryOver == '0') || (a == '0' && b == '0' && carryOver == '1') ) {
            return "1";
        }
        return "0";
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";

        System.out.println(addBinary(a, b));
    }
}
