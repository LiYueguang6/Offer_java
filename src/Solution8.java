public class Solution8 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode findnextnode(TreeNode t){
        TreeNode p = t.right;
        if(p != null){
            p = findleftcild(p);
        }
        else {
            p = findrightparent(t.parent);
        }
        return p;
    }
    private TreeNode findleftcild(TreeNode t){
        if(t.left != null){
            t = findleftcild(t.left);
        }
        return t;
    }
    private TreeNode findrightparent(TreeNode t){
        if(t.parent.left != t){
            t = t.parent;
        }
        return t;
    }


    // 牛客看到的解法

    public TreeNode GetNext(TreeNode pNode) {
        if (pNode.right != null) {
            TreeNode node = pNode.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            while (pNode.parent != null) {
                TreeNode parent = pNode.parent;
                if (parent.left == pNode)
                    return parent;
                pNode = pNode.parent;
            }
        }
        return null;
    }


    public static void main(String args[]){
        // 不好写测试用例……
        Solution8 s = new Solution8();

    }
}
