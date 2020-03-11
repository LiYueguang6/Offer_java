package S10_递归和循环4题;

public class Solution3 {
    public int JumpFloor(int target) {
        if (target<3)
            return target;
        int pre1 = 2, pre2 = 1,sum = 0;


        for (int i = 3; i < target+1; i++) {
            sum = pre1+pre2;
            pre2 = pre1;
            pre1 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int target = 4;
        System.out.println(s.JumpFloor(target));
    }
}
