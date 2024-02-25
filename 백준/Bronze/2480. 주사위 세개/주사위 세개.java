import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] dice = br.readLine().toCharArray();
        if(dice[0]==dice[2]){
            if(dice[2]==dice[4]) System.out.print((dice[0]-'0')*1000+10000);
            else System.out.print((dice[0]-'0')*100+1000);
        }
        else if(dice[2]==dice[4]||dice[0]==dice[4]) System.out.print((dice[4]-'0')*100+1000);
        else {
            System.out.print((Math.max(dice[0], Math.max(dice[2], dice[4]))-'0')*100);
        }
    }
}
