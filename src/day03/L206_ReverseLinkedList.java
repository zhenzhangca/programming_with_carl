package day03;

/**
 * Leetcode 206 反转链表
 * 基础题
 * <p>
 *
 * 思路： 可以用iterative 和 recursive两种做法
 */
public class L206_ReverseLinkedList {
    public static void main(String[] args) {
        //1->2->3->2->null
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode result = reverseLinkedList(n1);
        System.out.println(result.val);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }

    }

    private static ListNode reverseLinkedList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


}
