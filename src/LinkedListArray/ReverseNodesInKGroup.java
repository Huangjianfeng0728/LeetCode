package LinkedListArray;

public class ReverseNodesInKGroup {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy = head;
        while(true){
            head = reverseK(head , k);
            if (head == null){
                break;
            }
        }
        return dummy.next;
    }
    private ListNode reverseK(ListNode head , int k){
        ListNode nk = head;
        for (int i = 0 ; i < k ; i++){
            if (nk == null){
                return null;
            }
            nk = nk.next;
        }
        if (nk == null){
            return null;
        }
        ListNode n1 = head.next;
        ListNode nkplus = nk.next;

        ListNode prev = null;
        ListNode cur = n1;

        while (cur != nkplus){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        head.next = nk;
        n1.next = nkplus;
        return nkplus;
    }
}
