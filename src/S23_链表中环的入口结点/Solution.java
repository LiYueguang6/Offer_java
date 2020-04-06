package S23_链表中环的入口结点;

public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead==null || pHead.next == null)
            return pHead;
        ListNode fast = pHead.next.next,slow = pHead.next;
        while(fast!=slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = pHead;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {

    }
}
