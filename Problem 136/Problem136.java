/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 *
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 *
 * Constraints:
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
public class Problem136 {

    /**
     * NOT ( ~ ): Bitwise NOT is an unary operator that flips the bits of the number i.e., if the ith bit is 0, it
     * will change it to 1 and vice versa. Bitwise NOT is nothing but simply the one’s complement of a number. Lets
     * take an example.
     * N = 5 = (101)2
     * ~N = ~5 = ~(101)2 = (010)2 = 2
     *
     * AND ( & ): Bitwise AND is a binary operator that operates on two equal-length bit patterns. If both bits in
     * the compared position of the bit patterns are 1, the bit in the resulting bit pattern is 1, otherwise 0.
     * A = 5 = (101)2 , B = 3 = (011)2 A & B = (101)2 & (011)2= (001)2 = 1
     *
     * OR ( | ): Bitwise OR is also a binary operator that operates on two equal-length bit patterns, similar to
     * bitwise AND. If both bits in the compared position of the bit patterns are 0, the bit in the resulting bit
     * pattern is 0, otherwise 1.
     * A = 5 = (101)2 , B = 3 = (011)2
     * A | B = (101)2 | (011)2 = (111)2 = 7
     *
     * XOR ( ^ ): Bitwise XOR also takes two equal-length bit patterns. If both bits in the compared position of the
     * bit patterns are 0 or 1, the bit in the resulting bit pattern is 0, otherwise 1.
     * A = 5 = (101)2 , B = 3 = (011)2
     * A ^ B = (101)2 ^ (011)2 = (110)2 = 6
     *
     * Left Shift ( << ): Left shift operator is a binary operator which shift the some number of bits, in the given
     * bit pattern, to the left and append 0 at the end. Left shift is equivalent to multiplying the bit pattern with
     * 2
     * k
     *  ( if we are shifting k bits ).
     * 1 << 1 = 2 = 21
     * 1 << 2 = 4 = 22 1 << 3 = 8 = 23
     * 1 << 4 = 16 = 24
     * …
     * 1 << n = 2n
     *
     * Right Shift ( >> ): Right shift operator is a binary operator which shift the some number of bits, in the
     * given bit pattern, to the right and append 1 at the end. Right shift is equivalent to dividing the bit pattern
     * with 2k ( if we are shifting k bits ).
     * 4 >> 1 = 2
     * 6 >> 1 = 3
     * 5 >> 1 = 2
     * 16 >> 4 = 1
     *
     * @param nums
     * @return
     */
    private static int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}
