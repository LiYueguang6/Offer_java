package 华为笔试题;

import java.util.Scanner;

public class HuaweiSolution2{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int len;
        while(input.hasNext()) {
            len = input.nextInt();
            if(len == 0)
                continue;
            int[] nums = new int[len];
            for (int i=0;i<len;i++){
                nums[i]=input.nextInt();
            }
            // 排序
            for (int i = 0;i<len-1;i++){
                int minid = i;
                for (int j = i+1; j < len; j++){
                    if (nums[j]<=nums[minid]){
                        minid = j;
                    }
                }
                if (minid != i){
                    int temp = nums[minid];
                    nums[minid] = nums[i];
                    nums[i] = temp;
                }
            }
            // 去重输出
            for (int i = 0;i<len;i++){
                if (i == 0)
                    System.out.println(nums[i]);
                else if(nums[i] != nums[i-1])
                    System.out.println(nums[i]);
            }
        }
    }
}