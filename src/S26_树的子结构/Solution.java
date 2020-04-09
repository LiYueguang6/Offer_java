package S26_树的子结构;

public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
       if (root1==null || root2==null)
           return false;

       return Samenode(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }
    public boolean Samenode(TreeNode root1,TreeNode root2){
        if (root2==null)
            return true;
        if (root1==null)
            return false;
        return (root1.val==root2.val) && Samenode(root1.left,root2.left) && Samenode(root1.right,root2.right);
    }


    public static void main(String[] args) {

    }
}
