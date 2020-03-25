package S20_表示数值的字符串;

public class Solution {
    public boolean isNumeric(char[] str) {
        int strl = str.length;
        if (strl==0 || str==null || !(str[0]=='-' || str[0]=='+' || (str[0]>='0'&&str[0]<='9')))
            // 长度为0，或者开头不是-+或者数字，返回false
            return false;
        boolean zf = false;
        boolean hasE = false, hasp = false;
        for (int i = 1; i < strl; i++) {
            if (!(str[i]=='e' || str[i]=='E' || str[i]=='.' || (str[i]>='0'&&str[i]<='9')))
                // 如果不是这些字符，就返回false
                return false;
            if (!hasE){
                // 整数

                if ((str[i] == 'e' || str[i] == 'E')){
                    hasE = true;
                    hasp = false;
                    if (i== strl-1)
                        return false;
                    if (str[i+1]=='-' || str[i+1]=='+')
                        // 如果e接的是正负号，往后推一位
                        i++;
                }
                if (str[i] == '.'){
                    if (hasp || (!hasp && (str[i-1]=='e'|| str[i-1]=='E')))
                        // 如果有小数点，或者没有小数点，前一个不是数字的返回false
                        return false;
                    else
                        hasp=true;
                }
            }
            else {
                // E后面的部分
                if (str[i] == 'e' || str[i] == 'E' || str[i] == '.'){
                    return false;
                }

            }
        }
        if (str[strl-1]=='E'||str[strl-1]=='e'||str[strl-1]=='.'||str[strl-1]=='-'||str[strl-1]=='+')
            return false;
        else
            return true;
    }

    // 正则
    public boolean isNumeric2(char[] str) {
        if (str == null || str.length == 0)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isNumeric2("12e".toCharArray()));
    }
}
