package LinkedListArray;

import java.util.*;

public class CopyListWithRandomPointer {
     class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
     };
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode,RandomListNode> map = getNode(head);
        RandomListNode temp = head;
        while (head != null){
            map.get(head).next = map.get(head.next);
            if (head.random != null){
                map.get(head).random = map.get(head.random);
            }else{
                map.get(head).random = null;
            }

            head = head.next;
        }
        return map.get(temp);
    }
    private HashMap<RandomListNode,RandomListNode> getNode(RandomListNode head){
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        Queue<RandomListNode> queue = new LinkedList<>();
        queue.offer(head);
        while(!queue.isEmpty()){
            RandomListNode root = queue.poll();
            if (root != null){
                queue.offer(root.next);
                map.put(root,new RandomListNode(root.label));
            }
        }
        return map;
    }
}
