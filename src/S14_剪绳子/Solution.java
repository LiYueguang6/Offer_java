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

    // 贪心算法，尽可能多剪长度为3的段

    public int cutRope2(int target) {
        if (target < 2)
            return 0;
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;
        int timesOf3 = target / 3;
        if (target - timesOf3 * 3 == 1)
            timesOf3--;
        int timesOf2 = (target - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }
    // 动态规划
    // 简单描述一下，动态规划就是将父问题转化为子问题，不用考虑子问题的求解，
    // 比如该问题中假设target=8，那么f(8)即等于Max(j from 1 to 7)f(j)*f(8-j)，
    // 这样问题就变成了各个子问题f(1)~f(7)的求解
    public int cutRope3(int target) {
        int[] dp = new int[target + 1];
        dp[1] = 1;
        for (int i = 2; i <= target; i++)  //
            for (int j = 1; j < i; j++)  // 这里设置j<i，可以避免单段绳子不剪（避免了2和3的特殊情况）
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
                // dp[i]不用多说了，第二项和第三项比较的是j段单段和dp[j]的大小，在剪掉j长度后的[i-j]之外的最大值
        return dp[target];
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.cutRope(3));
    }
}
