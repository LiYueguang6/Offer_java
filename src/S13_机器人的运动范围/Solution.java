package S13_机器人的运动范围;

public class Solution {
    private final static int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};
    private static int rows, cols, threshold;

    public int movingCount(int threshold, int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        int nums = 0;
        if (rows==0||cols==0)
            return 0;
        boolean[][] path = new boolean[rows][cols];
        movestep(0,0, path);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(path[i][j]==true)
                    nums++;
            }
        }
        return nums;


    }
    private boolean movestep(int row, int col, boolean[][] path){
        if (row<0||row>=rows||col<0||col>=cols||path[row][col])
            return false;
        else if (calu(row,col)){
            path[row][col]=true;
            for (int[] m:move) {
                movestep(row+m[0],col+m[1],path);
            }
        }
        return true;
    }
    private boolean calu(int row,int col){
        int rown = (this.rows+"").length();
        int coln = (this.cols+"").length();
        int sum=0;
        sum += row%10;
        for (int i = 1; i < rown; i++)
            sum += row/(Math.pow(10, i));

        sum += col%10;
        for (int i = 1; i < coln; i++)
            sum += col/(Math.pow(10, i));
        if (sum<=this.threshold)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int threshold=10;
        int rows = 1;
        int cols = 100;
        System.out.println(s.movingCount(threshold, rows, cols));
    }
}
