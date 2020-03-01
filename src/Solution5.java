public class Solution5 {
    public String replaceSpace(StringBuffer str) {
        if (str == null)
            return "false";
        int P1 = str.length() - 1;
        for (int i=0;i<=P1;i++){
            if (str.charAt(i) == ' '){
                str.append("  ");
            }
        }
        int P2 = str.length() - 1;
        for (int i=P1;i>-1;i--){
            char c = str.charAt(i);
            if (c == ' '){
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            }
            else
                str.setCharAt(P2--,c);
        }
        String str2 = str.toString();

        return str2;
    }
    public static void main(String args[]){
        StringBuffer str = new StringBuffer("");
        Solution5 s = new Solution5();
        System.out.println(s.replaceSpace(str));
    }
}