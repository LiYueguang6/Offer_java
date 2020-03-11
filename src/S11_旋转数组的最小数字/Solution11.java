package S11_旋转数组的最小数字;

import java.util.Arrays;

class Solution {

    public int minNumberInRotateArray(int [] array) {
        if (array.length==0)
            return 0;
        int l = 0,h = array.length-1;
        while (l<h){
            int m = (l+h-1)/2;
            if (array[l]==array[m]&&array[m]==array[h]){
                return minnumber(array, l, h);
            }
            else if(array[m]<=array[h]){
                h=m;
            }
            else
                l=m+1;
        }
        return array[l];
    }
    public int minnumber(int [] array,int l,int h){
        for(int i = l;i<h;i++){
            if(array[i]>array[i+1])
                return array[i+1];
        }
        return array[l];
    }
    public static void main(String args[]){
        Solution s = new Solution();
        int[] a = {1,1,1,0,1};
        System.out.println(s.minNumberInRotateArray(a));
    }
}
