/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If
 * the two linked lists have no intersection at all, return null.
 *
 * It is guaranteed that there are no cycles anywhere in the entire linked structure.
 * Note that the linked lists must retain their original structure after the function returns.
 *
 * Example 1:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes
 * before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 * Example 2:
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Intersected at '2'
 * Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the
 * intersected node in A; There are 1 node before the intersected node in B.
 *
 * Example 3:
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: No intersection
 * Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists
 * do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 *
 * Constraints:
 * The number of nodes of listA is in the m.
 * The number of nodes of listB is in the n.
 * 0 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * intersectVal is 0 if listA and listB do not intersect.
 * intersectVal == listA[skipA + 1] == listB[skipB + 1] if listA and listB intersect.
 *
 *
 * Follow up: Could you write a solution that runs in O(n) time and use only O(1) memory?
 */
public class Problem160 {

    /**
     * Inner Node class to represent Linked List data structure
     */
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Method to get intersection node for given two linked lists. Null if there is no intersection
     *
     * Time Complexity: O(N + M)
     * Space Complexity: O(1)
     *
     * @param headA
     * @param headB
     * @return
     */
    private static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) { return null; }
        Node currA = headA, currB = headB;
        int sizeA = getCount(currA);
        int sizeB = getCount(currB);

        if (sizeA > sizeB) {
            int diff = sizeA - sizeB;
            for (; diff > 0; diff--) {
                currA = currA.next;
            }
        } else if (sizeB > sizeA) {
            int diff = sizeB - sizeA;
            for (; diff > 0; diff--) {
                currB = currB.next;
            }
        }

        while (currA != null && currB != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }

    /**
     * Method to get size count of linked list
     *
     * @param head
     * @return
     */
    private static int getCount(Node head) {
        int count = 0;
        for (Node x = head; x != null; x = x.next) {
            count++;
        }
        return count;
    }

    /**
     * Main method for test cases
     *
     * @param args
     */
    public static void main(String[] args) {
        Node intersection = new Node(8);
        intersection.next = new Node(4);
        intersection.next.next = new Node(5);

        Node headA = new Node(4);
        headA.next = new Node(1);
        headA.next.next = intersection;

        Node headB = new Node(5);
        headB.next = new Node(6);
        headB.next.next = new Node(1);
        headB.next.next.next = intersection;

        Node res = getIntersectionNode(headA, headB);
        System.out.println(res.val);
    }
}
