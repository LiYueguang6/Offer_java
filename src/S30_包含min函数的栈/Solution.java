package S30_包含min函数的栈;
import java.util.Stack;

public class Solution {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> minstack = new Stack<>(); // 维护一个最小值栈
    public void push(int node) {
        stack1.push(node);
        minstack.push(minstack.isEmpty()?node:Math.min(minstack.peek(),node));
    }

    public void pop() {
        stack1.pop();
        minstack.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return minstack.peek();
    }
}
