package S22_链表中倒数第K个结点;

public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode p = head;
        ListNode pre = head;
        for (int i = 0; i < k; i++) {
            if (p==null)
                return null;
            p = p.next;
        }
        while(p!=null){
            p = p.next;
            pre = pre.next;
        }
        return pre;
    }

    public static void main(String[] args) {

    }
}
