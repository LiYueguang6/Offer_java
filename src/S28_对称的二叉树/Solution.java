package S28_对称的二叉树;

public class Solution {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot==null)
            return true;
        return equalnode(pRoot,pRoot);

    }
    boolean equalnode(TreeNode p1,TreeNode p2){
        if (p1!=null && p2!=null)
            return p1.val == p2.val && equalnode(p1.left,p2.right) && equalnode(p1.right,p2.left);
        if (p1 == null && p2 ==null)
            return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        Solution s =new Solution();
        System.out.println(s.isSymmetrical(t));
    }
}
