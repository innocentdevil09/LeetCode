import java.util.ArrayList;
import java.util.List;

/**
 * Given a string num that contains only digits and an integer target, return all possibilities to add the binary
 * operators '+', '-', or '*' between the digits of num so that the resultant expression evaluates to the target value.
 *
 * Example 1:
 * Input: num = "123", target = 6
 * Output: ["1*2*3","1+2+3"]
 *
 * Example 2:
 * Input: num = "232", target = 8
 * Output: ["2*3+2","2+3*2"]
 *
 * Example 3:
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 *
 * Example 4:
 * Input: num = "00", target = 0
 * Output: ["0*0","0+0","0-0"]
 *
 * Example 5:
 * Input: num = "3456237490", target = 9191
 * Output: []
 *
 * Constraints:
 * 1 <= num.length <= 10
 * num consists of only digits.
 * -2^31 <= target <= 2^31 - 1
 */
public class Problem282 {

    /**
     * Method to retrieve all possible expressions
     *
     * Time Complexity: O(4 ^ N)
     * Space Complexity: O(4 ^ N)
     *
     * @param num
     * @param target
     * @return
     */
    private static List<String> addOperators(String num, int target) {
        List<String> expressions = new ArrayList<>();
        if (num == null || num.isEmpty()) {
            return expressions;
        }

        char[] cache = new char[2 * num.length()];
        addOperators(num.toCharArray(), target, 0, 0, 0, cache, 0, expressions);
        return expressions;
    }

    /**
     * DFS approach to calculate all possible operands and expressions
     *
     * @param num
     * @param target
     * @param index
     * @param currentValue
     * @param lastValue
     * @param cache
     * @param endIndex
     * @param expressions
     */
    private static void addOperators(char[] num, int target, int index, long currentValue, long lastValue,
            char[] cache, int endIndex, List<String> expressions) {

        if (index == num.length) {
            if (currentValue == target) {
                expressions.add(new String(cache, 0, endIndex));
            }
            return;
        }
        /*
          Find new cache length;
          the corner case, where we have no data in cache, in this case we need to push at first index (0) otherwise
          at the next index
         */
        int nextEndIndex = (index == 0) ? endIndex : endIndex + 1;
        long val = 0L;
        /*
          Our choices:
          We can choose a single digits as operands Or multi digits as operand (  1 + 2 or 12 + 34 )
         */
        for (int i = index; i < num.length; i++) {
            /*
              We don't consider a operand which is 0 as single digit operand, as operand like 0 or 01 , 023... does
              not make sense -- to avoid cases where we have 1 + 05 or 1 * 05
             */
            if (i != index && num[index] == '0') {
                break;
            }
            val = val * 10 + (num[i] - '0');
            if (index == 0) {
                cache[nextEndIndex++] = num[i];
                addOperators(num, target, i + 1, val, val, cache, nextEndIndex, expressions);
            } else {
                cache[nextEndIndex++] = num[i];

                cache[endIndex] = '+';
                addOperators(num, target, i + 1, currentValue + val, val, cache, nextEndIndex, expressions);

                cache[endIndex] = '-';
                addOperators(num, target, i + 1, currentValue - val, -val, cache, nextEndIndex, expressions);

                /**
                 * Multiply operator application '*'; As this has the highest precedence then + and -, we simply can't apply * on last and current value.
                 * Current value become = currentValue - lastValue + last*currentDigitvalue;
                 * For example
                 * current value = 12 ,
                 * last value = 2 ( let say we applied + as 10 + 2 )
                 * currendDigitValue = 4
                 * so expression become : 10 + 2 * 4
                 * if we simply do 12 * 4 = 48 which is wrong as 10 + 2 * 4 = 10 + 8 = 18
                 *
                 * New value = 10 + 2 * 4 = 18
                 * last value = 2*4 = 8
                 */
                cache[endIndex] = '*';
                addOperators(num, target, i + 1, currentValue - lastValue + lastValue * val, lastValue * val, cache,
                        nextEndIndex, expressions);
            }
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        String num = "232";
        int target = 8;
        System.out.println(addOperators(num, target));
    }
}
