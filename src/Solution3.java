import java.util.HashMap;

public class Solution3 {
    /**
     *
     * 首先是将数字和下标对应，就可以快速查找是否存在重复值
     *
     * */
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0)  //边界值判断：判断数组是否为空，长度是否小于0
            return false;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {  // 如果当前的值和序号不同，则执行，否则该数在合适的位置，遍历下一个
                if (nums[i] == nums[nums[i]]) {  // 如果该数和该数序号下的值相同，就返回该值
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);  // 否则，将该数字放到他所该在的位置
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    /**
     *
     * 哈希表（同上，但是尝试一下哈希表写法）
     * 不实用，空间复杂度高，可以用于尝试解决题目二
     *
     * */
    public boolean duplicate2(int[] nums, int length, int[] duplication){
        if (nums == null || length <= 0)  //边界值判断：判断数组是否为空，长度是否小于0
            return false;
        HashMap<Integer,Integer> hp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hp.containsValue(nums[i])){
                // TODO: 哈希表相应的操作待解决
                return true;
            }
            else{
                hp.put(i,nums[i]);
            }
        }
        return false;
    }
    /**
     *
     * n+1个数，范围是1到n
     * 题目二，限制条件空间复杂度O(1)，折半查找，统计数目
     *
     * */
//    public boolean duplicate3(int[] nums, int length, int[] duplication){
//        if(nums == null || length <= 0)  //length = n + 1
//            return false;
//        int start = 1;
//        int end = length - 1; // n
//        while(end != start){
//            if(end == start+1){
//                int c1 = count(start, start, nums, length);
//                int c2 = count(end, end, nums, length);
//                duplication[0] = (c1>c2?start:end);
//                return true;
//            }
//            else {
//                int middle = (end + start) / 2  ;
//                int c1 = count(start, middle, nums, length);
//                int c2 = count(middle+1, end, nums, length);
//                if(c1>middle-start+1 && c2==end-middle)
//                    end = middle;
//                else if(c1==middle-start+1 && c2>end-middle)
//                    start = middle+1;
//                else
//                    return false;
//            }
//        }
//        int c = count(start, end, nums, length);
//        if(c>1) {
//            duplication[0] = start;
//            return true;
//        }
//        return false;
//    }
    public boolean duplicate3(int[] nums, int length, int[] duplication){
        if(nums == null || length <= 0)  //length = n + 1
            return false;
        int start = 1;
        int end = length - 1; // n
        while(end != start){
            int middle = (end+start)/2;
            int c = count(start,middle,nums,length);
            if(c>middle-start+1)
                end = middle;
            else
                start = middle+1;
            if(start == end){
                duplication[0]=start;
                return true;
            }

        }
        return false;
    }
    private int count(int start, int end, int[] nums, int length){
        int c = 0;
        for(int i=0; i<length; i++){
            if(nums[i]>=start && nums[i]<=end)
                c++;
        }
        return c;
    }


    public static void main(String args[]){
//        int[] a = {2,3,1,0,2,5,3};
        int[] a = {1,2,3,4,5,6,7,8,9,6};
        int l = a.length;
        int[] b = new int[1];
        // 1
//        Solution3 s = new Solution3();
//        if (s.duplicate(a, l, b))
//            System.out.println(b[0]);
//        else
//            System.out.println(false);



        // 2 未完成
//        Solution3 s2 = new Solution3();
//        if (s2.duplicate2(a, l, b))
//            System.out.println(b[0]);
//        else
//            System.out.println(false);



        //3
        Solution3 s3 = new Solution3();
        if (s3.duplicate3(a, l, b))
            System.out.println(b[0]);
        else
            System.out.println(false);

    }
}