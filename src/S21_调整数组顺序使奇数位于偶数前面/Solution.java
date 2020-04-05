package S21_调整数组顺序使奇数位于偶数前面;

public class Solution {
    public void reOrderArray(int [] array) {
        if (array.length < 2){
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1){
                // 奇数向左浮动
                for (int j = i - 1; j > -1; j--) {
                    if (array[j] % 2 == 0){
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }

            }
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        Solution s = new Solution();
        s.reOrderArray(a);
        for (int b:a) {
            System.out.println(b);
        }
    }
}
