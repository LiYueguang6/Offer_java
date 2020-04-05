package 华为笔试题;//import java.util.Scanner;
import java.util.*;
import java.math.BigInteger;
public class HuaweiSolution3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String Sixteen;
        while (input.hasNext()){
            Sixteen = input.next().substring(2);;
            Integer x;
            try {
                x = Integer.parseInt(Sixteen, 16);
            }catch (Exception e) {
                return;
            }
            System.out.println(x);
        }
    }
}
