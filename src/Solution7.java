import java.util.Arrays;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */



public class Solution7 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 重建二叉树
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode t = null;
        if (in.length == 0){

        }else if(in.length == 1){
            t = new TreeNode(pre[0]);
        }else if (in.length != 0){
            t = new TreeNode(pre[0]);
            // 找到pre第一个值对应的in的序号
            int id = 0;
            for (int i=0;i<in.length;i++)
                if (in[i] == pre[0])
                    id = i;
            int[] in_left = Arrays.copyOfRange(in, 0, id);
            int[] in_right = Arrays.copyOfRange(in, id+1, in.length);
            int[] pre_left = Arrays.copyOfRange(pre, 1,1+in_left.length);
            int[] pre_right = Arrays.copyOfRange(pre, 1+in_left.length,pre.length);
            // pre的长度总是和in的长度相等
            TreeNode left = reConstructBinaryTree(pre_left, in_left);
            TreeNode right = reConstructBinaryTree(pre_right, in_right);
            t.left = left;
            t.right = right;
        }
        return t;
    }

    public static void main(String args[]){

//        int[] pre = {3,9,20,15,7};
//        int[] in = {9,3,15,20,7};

        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        Solution7 s = new Solution7();
        TreeNode t = s.reConstructBinaryTree(pre, in);
    }


}
