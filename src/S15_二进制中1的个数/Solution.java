package S15_二进制中1的个数;

public class Solution {
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }
    public int NumberOf1_2(int n) {
        return Integer.bitCount(n);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.NumberOf1_2(15));
    }
}
