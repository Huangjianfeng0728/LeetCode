package LinkedListArray;

public class SortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode leftDummy = new ListNode(0);
        ListNode midDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode leftTail = leftDummy;
        ListNode midTail = midDummy;
        ListNode rightTail = rightDummy;
        while(head != null){
            if (head.val < mid.val){
                leftTail.next = head;
                leftTail = head;
            }else if (head.val > mid.val){
                rightTail.next = head;
                rightTail = head;
            }else{
                midTail.next = head;
                midTail = head;
            }
            head = head.next;
        }
        leftTail.next = null;
        midTail.next = null;
        rightTail.next = null;
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);

        return connect(left,midDummy.next,right);
    }
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode connect(ListNode left , ListNode mid , ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        tail.next = left;
        tail = getTail(tail);
        tail.next = mid;
        tail = getTail(tail);
        tail.next = right;
        tail = getTail(tail);

        return dummy.next;
    }
    private ListNode getTail(ListNode head){
        if (head == null){
            return null;
        }
        while(head.next != null){
            head = head.next;
        }
        return head;
    }


}
