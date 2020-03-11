package S10_递归和循环4题;

public class Solution2 {
    public int RectCover(int target) {
        if (target==0)
            return 0;
        else if (target==1)
            return 1;
        else if (target==2)
            return 2;
        else {
            return RectCover(target-1)+RectCover(target-2);
        }
    }
    // 仔细考虑了一下，target大于2之后填充方法数量等于递归的f(n)=f(n-1)+f(n-2)，即斐波那契数列
    public int RectCover2(int target){
        int pre1=0,pre2=0;
        int sum =0;
        if(target==0)
            return 0;
        for(int i=1;i<target+1;i++){
            if (i==1){
                pre2 = 1;
                sum = 1;
            }
            else if (i==2){
                pre1 = 2;
                sum = 2;
            }
            else {
                sum = pre1+pre2;
                pre2 = pre1;
                pre1 = sum;
            }
        }
        return sum;
    }
    public static void main(String args[]){
        Solution2 s = new Solution2();
        System.out.println(s.RectCover2(4));
    }
}
