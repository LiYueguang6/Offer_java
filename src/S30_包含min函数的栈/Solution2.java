package S30_包含min函数的栈;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
    // 之前那个方法借用了系统的stack，应该是不行的，要自己通过数组实现一个。
    private int peek = -1;
// 直接定义大数组不好，要设置一个自动扩容的方式
//    private int sizeall = 10000;
//    private int[] stack = new int[sizeall];
//    private int[] minstack = new int[sizeall];
    private int[] stack = new int[1];
    private int[] minstack = new int[1];

    public void push(int node) {
        stack[peek+1] = node;
        minstack[peek+1] = (peek>-1?Math.min(minstack[peek],node):node);
        peek++;
        if (peek==stack.length-1){
            stack = Arrays.copyOf(stack,stack.length*2);
            minstack = Arrays.copyOf(minstack,minstack.length*2);
        }
    }

    public void pop() {
        if (peek==-1)
            return;
        peek--;
    }

    public int top() {
        return peek==-1?null:stack[peek];
    }

    public int min() {
        return peek==-1?null:minstack[peek];
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.push(3);
        System.out.println(s.min());
        s.push(4);
        System.out.println(s.min());
        s.push(2);
        System.out.println(s.min());
        s.pop();
        s.pop();
        s.pop();
        s.pop();

    }
}
