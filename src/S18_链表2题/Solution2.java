package S18_链表2题;

public class Solution2 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null){
            return pHead;
        }
        int numnow = pHead.val;
        ListNode p_pre = pHead;
        ListNode p_b = pHead;
        while (p_b!=null){
            if (p_b.val!=numnow){
                p_pre.next=p_b;
                numnow = p_b.val;
                p_pre = p_b;
            }
            p_b = p_b.next;
        }
        return pHead;
    }


    // 上面那个搞错了，题目不是去重，而是删掉所有重复过的
    // 遗憾的是没有解决全链表重复的情况
    public ListNode deleteDuplication2 (ListNode pHead){
        if (pHead==null || pHead.next ==null)
            return pHead;
        ListNode p = pHead;
        ListNode p_b = pHead.next; // 记录要删除的节点

        pHead = new ListNode(0);
        ListNode p_pre = pHead;

        while (p_b!=null){
            if (p_b.val == p.val)
                // 值相同，往后推
                p_b = p_b.next;
            else{
                // 值不同
                if (p.next == p_b){
                    // 如果p值只有一个
                    p_pre.next = p;
                    p_pre = p_pre.next;
                    p = p_b;
                    p_b = p_b.next;
                }
                else {
                    // 如果好多p值了

                    p = p_b;
                    p_b = p_b.next;
                }
            }
        }
        if (p.next == null){
            p_pre.next = p;
        }
        if (p.next!=null)
            p_pre.next = null;
        return pHead.next;
    }
    //递归方法
    public ListNode deleteDuplication3(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val)
                next = next.next;
            return deleteDuplication3(next);
        } else {
            pHead.next = deleteDuplication3(pHead.next);
            return pHead;
        }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        ListNode p=head.next;
        p.next = new ListNode(1);
        p=p.next;
        p.next = new ListNode(2);
        head = s.deleteDuplication2(head);
    }
}
