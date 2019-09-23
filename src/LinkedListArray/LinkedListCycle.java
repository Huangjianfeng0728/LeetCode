package LinkedListArray;

public class LinkedListCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode quick = head.next;
        ListNode slow = head;
        while(quick != null && quick.next != null){
            if (quick == slow){
                return true;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        return false;
    }
}
