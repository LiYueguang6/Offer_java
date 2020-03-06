import java.util.Stack;


public class Solution9 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty())
            return 0;
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int popnum = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return popnum;
    }



    public static void main(String args[]){
        Solution9 s = new Solution9();
        s.push(1);
        s.push(2);
        s.push(3);
        int a = s.pop();
        s.push(4);
        int b = s.pop();
    }
}
