package S16_数值的整数次方;

public class Solution {
    public double Power(double base, int exponent) {
        if(exponent==0)
            return 1;
        if(exponent==1)
            return base;
        double p = 1;
        boolean isNegative = false;
        //还要考虑指数为﹣的情况
        if (exponent<0) {
            isNegative = true;
            exponent = -exponent;
        }
        if(exponent%2==1){
            // exponent奇数
            p = Power(base,(exponent-1)/2);
            p = p*p*base;
        }else {
            // 偶数
            p = Power(base,exponent/2);
            p = p*p;
        }
        return isNegative?1/p:p;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.Power(2,0));
    }
}
