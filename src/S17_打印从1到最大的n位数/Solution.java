package S17_打印从1到最大的n位数;

public class Solution {
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }



    //
    public void printnum(int n){
        if(n<=0)
            return;
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i]=0;
        }
        while (add(num)){
            boolean isstart = false;
            for (int i = 0; i < n; i++) {
                if (!isstart && num[i]!=0)
                    isstart = true;
                if (isstart)
                    System.out.print(num[i]);
            }
            System.out.println('\t');
        }

    }
    public boolean add(int[] num){
        int l = num.length;
        for (int i = l-1; i >= 0; i--) {

            int temp = num[i] + 1;
            num[i] = temp%10;
            if (temp/10==0){
                break;
            }else if(i==0 && num[0]==0){
                //如果有进位，且进位是最高位
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.printnum(3);
    }
}
