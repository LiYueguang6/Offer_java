package S19_正则表达式匹配;

public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        // .匹配任意字符
        // *匹配前一个字符0到无数次
        // 要考虑.*的问题
        int pattern_len = pattern.length;
        int str_len = str.length;
        // 可以选择从后往前匹配
        // 从前到后，a*a匹配应该考虑首和尾；从后往前，*应该考虑xa*，这里主要是无法判断需要往前多少个重复的a
        // 所以正确解法应该用dp算法，这里先使用递归循环尝试一下
        int st = str_len-1,pt = pattern_len-1;

        return co(str,pattern,st,pt);

    }
    public boolean co(char[] str, char[] pattern, int st, int pt) {
        if (st < 0 && pt < 0) // 1.如果两个数组都为空，返回true
            return true;
        else if (st == 0 && pt == 0) // 2.如果str和pattern都只有一个位置，即判断是否相等，TODO：可以归类到下面。
            return chareq(str[st],pattern[pt]);
        else if(pt< 0 && st>=0) { // 3.如果str不为空，pattern为空返回false
            return false;
        }
        else if (pattern[pt] == '*') { // 4.如果str不为空，且pattern当前位是*
            if (st>-1){
                // 如果str不为空，且重复字符相等
                // 后续可能是继续重复，或者是
                if (chareq(str[st],pattern[pt-1])){
                    return co(str, pattern, st-1,pt)||co(str, pattern, st,pt-2);
                }
                else
                    return co(str, pattern, st,pt-2);
            }else{
                // 如果str为空，则pattern前推两个，判断是否为*，如果一直到pt=-1，也是符合的
                return co(str,pattern,st,pt-2);
            }

        }
        else if (st<0&&pattern[pt]!='*')
            // 如果str不存在，且pattern不是*0次重复，就返回false
            return false;
        else if (chareq(str[st], pattern[pt])){ // 6.匹配成功，包括空字符，继续匹配前一个字符。
            return co(str, pattern, st - 1, pt - 1);
        }else
            return false;
    }
    public boolean chareq(char c1, char c2){
        if (c1==c2 || c1!='\0' && c2=='.')
            return true;
        return false;
    }


    public boolean match2(char[] str, char[] pattern)
    {
        // 尝试使用DP解法
        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1]; // 规模大于原数组
        dp[0][0] = true;  // 第一个位置设为true
        /*
        * 第一行，如果前一个符号是*号，也就是说前面两个的位置的符号是0到无数次重复的
        * 将当前的bool值等同于前面两个，目的不明
         */
        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];


        return true;
    }




    public static void main(String[] args) {
        Solution s = new Solution();
        char[] str = "ab".toCharArray();
        char[] pattern = "a.*".toCharArray();
        System.out.println(s.match(str, pattern));
    }
}
