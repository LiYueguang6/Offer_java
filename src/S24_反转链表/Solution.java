package S24_反转链表;

public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        if (head==null)
            return null;
        ListNode p;
        ListNode nhead = head;
        head = head.next;
        nhead.next = null;
        while(head!=null){
            p = head;
            head = head.next;
            p.next = nhead;
            nhead = p;
        }
        return nhead;
    }
}
