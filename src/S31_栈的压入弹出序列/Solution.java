package S31_栈的压入弹出序列;

import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack();
        int popid = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while(stack.peek()==popA[popid]){
                stack.pop();
                popid++;
                if(popid==popA.length) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] pushA = {1,2,3,4,5};
        int[] popA = {5,1,3,2,4};
        boolean a = s.IsPopOrder(pushA,popA);
        System.out.println(a);
    }
}
