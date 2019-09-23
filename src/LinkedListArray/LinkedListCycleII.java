package LinkedListArray;

public class LinkedListCycleII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode quick = head.next;
        ListNode slow = head;
        while(quick != null && quick.next != null){
            if (quick == slow){
                while (head != slow.next){
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        return null;
    }
}
