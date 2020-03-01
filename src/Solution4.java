public class Solution4 {
    public boolean Find(int target, int [][] array) {
        int rowsline = array.length;
        int columnline = array[0].length;
        int i=0,j=columnline-1;
        while (i<=rowsline-1 && j>=0){
            if(array[i][j]==target)
                return true;
            else if(array[i][j]>target)
                j = j-1;
            else
                i = i+1;
        }
        return false;
    }

    public static void main(String args[]){
        int[][] array = {{1,5,9,13},{2,6,10,14},{3,7,11,15},{4,8,12,16}};
        int target = 10;
        Solution4 s = new Solution4();
        System.out.println(s.Find(target, array));
    }
}