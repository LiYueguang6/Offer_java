package S10_递归和循环4题;

public class Solution1 {
    // 递归方法,递归方法会重复计算
    public int Fibonacci(int n){
        if(n==0){
            return 0;
        }else if(n==1)
            return 1;
        else
            return Fibonacci(n-1)+Fibonacci(n-2);
    }
    // 不采用递归的方法可以不做重复计算
    public int Fibonacci2(int n) {
        int[] F = new int[n+1];
        for (int i=0;i<n+1;i++){
            if(i==0)
                F[0]=0;
            else if(i==1)
                F[1]=1;
            else
                F[i]=F[i-1]+F[i-2];
        }
        return F[n-1];
    }
    // Fibonacci2改进，降低空间复杂度
    public int Fibonacci3(int n){
        int pre=0, pre2=0,sum=0;
        for (int i=0;i<n+1;i++){
            if(i==0)
                pre2=0;
            else if(i==1) {
                pre = 1;
                sum = 1;
            }
            else{
                sum = pre+pre2;
                pre2 = pre;
                pre = sum;
            }

        }
        return sum;
    }

    public static void main(String args[]){
        int n = 1;
        Solution1 s = new Solution1();
        System.out.println(s.Fibonacci3(n));
    }
}
