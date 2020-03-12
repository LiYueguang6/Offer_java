package S14_剪绳子;

public class Solution {
    private int x = 1;
    public int cutRope(int target) {
        // 剪绳子的段数不能为1，要加一个段数.这个地方一开始没考虑到
        this.digui(target,1,1, 0);
        return this.x;
    }

    private int digui(int target,int x2,int cut,int count){
        x2 = x2 * cut;
        if (target<=1&&count>1) {
            if (x2 > this.x)
                this.x = x2;
        } else
            for (int i = 1; i < target+1; i++) {

                digui(target-i, x2,i,count+1);
            }


        return 0;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.cutRope(3));
    }
}
