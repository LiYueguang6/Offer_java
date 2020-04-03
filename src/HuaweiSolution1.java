import java.util.Scanner;
public class HuaweiSolution1 {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int emptybottle;
        while (input.hasNext()){
            emptybottle = input.nextInt();
            int drinkbottle = 0;
            while(emptybottle > 2){
                int a = emptybottle/3;
                int b = emptybottle%3;
                drinkbottle += a;
                emptybottle = a+b;
            }
            if (emptybottle == 2){
                drinkbottle += 1;
            }
            System.out.println(drinkbottle);
        }
    }
}