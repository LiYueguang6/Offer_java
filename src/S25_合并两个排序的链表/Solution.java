package S25_合并两个排序的链表;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {

        ListNode head = new ListNode(-1);
        ListNode p = head;
        if (list1==null)
            return list2;
        if (list2==null)
            return list1;
        while(list1 != null && list2 != null){
            if (list1.val>list2.val){
                // 如果list1的值大于list2的值，则
                p.next = list2;
                list2 = list2.next;
            }
            else {
                p.next = list1;
                list1 = list1.next;
            }
            p = p.next;
        }
        if (list1!=null)
            p.next = list1;
        if (list2!=null)
            p.next = list2;
        return head.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        s.Merge(list1,list2);
    }
}
