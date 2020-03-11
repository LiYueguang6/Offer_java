package S12_矩阵中的路径;

public class Solution {
    // 题目输入是一个一维数组，要先转换成二维数组

    public static char[][] conv(char[] matrix, int rows, int cols){
        char[][] matrix2 = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = matrix[cols*i+j];
            }
        }
        return matrix2;
    }
    // 先实现一个暴力搜索
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (rows==0||cols==0||str.length<1)
            return false;
        // 构建一个路径是否经过的矩阵
        boolean[][] path = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                path[i][j] = false;
            }
        }

        char[][] matrix2 = conv(matrix, rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix2[i][j] == str[0]){
                    if(isroute(path,matrix2,i,j,str,0,rows,cols))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean isroute(boolean[][] path, char[][] matrix, int row, int col,char[] str,int l,int rows,int cols){
        if (str.length==l)  // 如果l达到长度，则返回true，成功完成
            return true;
        else if(row<0||col<0||row>=rows||col>=cols||path[row][col]||matrix[row][col]!=str[l])
            //如果路径走过或者超出范围即返回false
            return false;


        else if (str[l]==matrix[row][col]){
            path[row][col] = true;
            l++;
            if (isroute(path,matrix,row-1,col,str,l,rows,cols)) //上
                return true;
            if (isroute(path,matrix,row+1,col,str,l,rows,cols)) // 下
                return true;
            if (isroute(path,matrix,row,col-1,str,l,rows,cols)) // 左
                return true;
            if (isroute(path,matrix,row,col+1,str,l,rows,cols)) // 右
                return true;
        }
        // 重要重要重要，如果前面没有return true这里需要把之前走过的全部设为false
        path[row][col] = false;
        return false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
//        char[] matrix={'a','b','c','e','s','f','c','s','a','d','e','e'};
//        int rows = 3, cols = 4;
//        char[] str = {'b','c','c','e','d'};
//        char[] str2 = {'a','b','c','d'};
//        char[] str3 = {'a','b'};
        //"ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS",5,8,"SGGFIECVAASABCEHJIGQEM"
        char[] matrix="ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        int rows=5,cols=8;
        char[] str="SGGFIECVAASABCEHJIGQEM".toCharArray();

        System.out.println(s.hasPath(matrix, rows, cols, str));
    }
}
