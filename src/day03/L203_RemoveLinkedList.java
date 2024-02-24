package day03;

/**
 * Leetcode 203 移除链表元素
 * 给一个链表和一个val值，移除链表中所有值为val的节点
 * <p>
 * e.g. input = 1 ->2-> 3->null, val = 2, output = 1->3->null
 * 思路： 删除节点存在于三种为止，头节点，中间，尾节点， 为了方便，加一个dummy node
 */
public class L203_RemoveLinkedList {
    public static void main(String[] args) {
        //1->2->3->2->null
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ;
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode result = removeElements(n1, 2);
        System.out.println(result.val);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }

    }

    private static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
                head = head.next;
            } else {
                prev = head;
                head = head.next;
            }
        }
        return dummy.next;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
