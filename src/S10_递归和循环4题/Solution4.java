package S10_递归和循环4题;

public class Solution4 {
    public int JumpFloorII(int target) {
        if (target <= 2)
            return target;
        int[] ways = new int[target];
        ways[0] = 1;
        ways[1] = 2;
        for (int i = 2; i < target; i++) {
            ways[i] = 1;
            for (int j = i;j>0;j--){
                ways[i] += ways[i-j];
            }
        }
        return ways[target - 1];
    }
    // 考虑到该方法时间复杂度为O(n^2)，空间复杂度为O(n)，应该还可以降低。可以尝试递归（应该还是存在重复计算）
    // 看到牛客上大神的解法，考虑到f(n)等于前面所有项相加1，用f(n-1)替换其他项之和，即可得到f(n)=2*f(n-1)
    public int JumpFloorII2(int target) {
        if (target <= 1)
            return target;
        else
            return 2*JumpFloorII2(target-1);
    }
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        int target = 4;
        System.out.println(s.JumpFloorII2(target));
    }
}
