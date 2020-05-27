package S32_1_从上往下打印二叉树;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> a = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            if (t!=null){
                a.add(t.val);
                q.add(t.left);
                q.add(t.right);
            }
        }
        return a;
    }
    public static void main(String[] args) {

    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}