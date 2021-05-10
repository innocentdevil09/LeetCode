/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 *
 *
 * Example 1:
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 * Constraints:
 * -2^31 <= val <= 2^31 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
public class Problem155 {

    /**
     * MinStack class to return min value
     */
    private static class MinStack {

        private static class Node {
            int val;
            int min;
            Node next;

            Node(int val, int min) {
                this.val = val;
                this.min = min;
            }
        }

        Node head;

        /** initialize your data structure here. */
        MinStack() {

        }

        void push(int val) {
            if (head == null) {
                head = new Node(val, val);
            } else {
                Node newNode = new Node(val, Math.min(val, head.min));
                newNode.next = head;
                head = newNode;
            }
        }

        void pop() {
            if (head != null) {
                head = head.next;
            }
        }

        int top() {
            return head.val;
        }

        int getMin() {
            return head.min;
        }
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin());; // return -2
    }
}
