package S18_链表2题;

public class Solution1 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public void del(ListNode pHead, ListNode todel){
        while (pHead!=null){
            if(pHead.next.val == todel.val){
                ListNode todelNode = pHead.next;
                if (todelNode.next!=null)
                pHead.next = todelNode.next;
                todelNode = null;
            }
        }
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
    }
}
