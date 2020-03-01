/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
import java.util.ArrayList;

public class Solution6 {

    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 基础解法
        ArrayList<Integer> array = new ArrayList<Integer>();
        ListNode p = listNode;
        while (p!=null){
            array.add(p.val);
            p = p.next;
        }
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        for (int i=array.size()-1;i>-1;i--){
            array2.add(array.get(i));
        }

        return array2;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        // 尝试降低空间复杂度，翻转链表
        ArrayList<Integer> array = new ArrayList<Integer>();
        if(listNode==null){
            return array;
        }
        ListNode p = listNode;
        listNode = listNode.next;
        ListNode next = listNode;
        p.next = null;
        while (listNode!=null){
            listNode = listNode.next;
            next.next=p;
            p = next;
            next = listNode;
        }
        while (p!=null){
            array.add(p.val);
            p = p.next;
        }

        return array;
    }



    public static void main(String args[]){
        Solution6 s = new Solution6();
        ListNode listNode = new ListNode(-1);
        ListNode p = listNode;
        for (int i=0;i<10;i++){
            ListNode newnode = new ListNode(i);
            p.next = newnode;
            p = p.next;
        }
//        listNode = null;
        System.out.println(s.printListFromTailToHead2(listNode));
    }
}
