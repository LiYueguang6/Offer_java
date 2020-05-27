package S32_2_把二叉树打印成多行;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        q.add(pRoot);
        while(!q.isEmpty()){
            int count = q.size();
            ArrayList<Integer> b = new ArrayList<>();
            while (count-->0){
                TreeNode t = q.poll();
                if (t!=null) {
                    b.add(t.val);
                    q.add(t.left);
                    q.add(t.right);
                }
            }
            if(b.size()>0){
                a.add(b);
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