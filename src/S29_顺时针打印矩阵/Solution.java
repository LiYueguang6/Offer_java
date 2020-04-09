package S29_顺时针打印矩阵;
import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int r1 = -1, r2 = matrix.length, c1 = -1, c2 = matrix[0].length;
        ArrayList<Integer> pout = new ArrayList<>();
        while (r1<r2-1 && c1<c2-1){
            if (r1<r2-1)
                for (int i = c1+1; i < c2 ; i++) {
                    pout.add(matrix[r1+1][i]); // →，列号增加，大到边界值的左边一位
                }
            r1++; // 走完一行，行号增加
            if (c1<c2-1)
                for (int i = r1+1; i < r2; i++) {
                    pout.add(matrix[i][c2-1]);// ↓，行号增加，达到下边界值上一位
                }
            c2--; // 右边界左移一位
            if (r1<r2-1)
                for (int i = c2-1; i > c1; i--) {
                    pout.add(matrix[r2-1][i]);// ←，列号减小，达到左边界值右边一位
                }

            r2--; // 下边界值上移一位
            if (c1<c2-1)
                for (int i = r2-1; i>r1; i--)
                    pout.add(matrix[i][c1+1]);// ↑，行号减小，达到上边界值下边一位
            c1++; // 左边界值右一位
        }

        return pout;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{1,2},{3,4}};
        int[][] matrix = {{1},{2},{3}};
        System.out.println(s.printMatrix(matrix));
    }
}