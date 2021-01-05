import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You
 * can return them in any order.
 *
 * A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots
 * and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255
 * .245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 *
 * Example 1:
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 *
 * Example 2:
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 *
 * Example 3:
 * Input: s = "1111"
 * Output: ["1.1.1.1"]
 *
 * Example 4:
 * Input: s = "010010"
 * Output: ["0.10.0.10","0.100.1.0"]
 *
 * Example 5:
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * Constraints:
 * 0 <= s.length <= 3000
 * s consists of digits only.
 */
public class Problem93 {

    /**
     * Method to retrieve all the list of valid ip addresses from the given string
     *
     * @param s
     * @return
     */
    private static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int len = s.length();
        if (len < 4 || len > 12) { return result; }

        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, len);

                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Method to determine ip address validity of string s
     * @param s
     * @return
     */
    private static boolean isValid(String s) {
        return !s.isEmpty() && !s.startsWith("0") && Integer.parseInt(s) <= 255;
    }

    /**
     * Main method for test cases
     * @param args
     */
    public static void main(String[] args) {
        String s = "0000";

        System.out.println(restoreIpAddresses(s));
    }
}
