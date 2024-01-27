import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int fCoin = 0;
        int tCoin = 1;
        int i = 1;
        int money = s.nextInt();
        if(money%5==0) {
            fCoin = money/5;
            tCoin = 0;
        }
        else {
            while((money-2*i)%5 > 0){
                i++;
                tCoin = i;
            }
            fCoin = (money - tCoin*2)/5;
        }
        if(tCoin*2 + fCoin*5 != money) {
            System.out.println(-1);
        }
        else System.out.println(tCoin+fCoin);
    }
}
