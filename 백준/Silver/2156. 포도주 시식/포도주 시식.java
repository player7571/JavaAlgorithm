import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] drink = new int[n];
        int[] dp = new int[n];
        for(int i=0; i<n; i++){
            drink[i] = Integer.parseInt(br.readLine());
        }
        if(n==1) {
            System.out.print(drink[0]);
            return;
        }
        dp[0] = drink[0];
        dp[1] = drink[1]+drink[0];
        if(n==2) {
            System.out.print(dp[1]);
            return;
        }
        dp[2] = Math.max(dp[1], Math.max(drink[0]+drink[2], drink[1]+drink[2]));
        if(n==3) {
            System.out.print(Math.max(dp[2], dp[1]));
            return;
        }
        for(int i=3; i<n; i++){
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-3]+drink[i-1]+drink[i],dp[i-2]+drink[i]));
        }
        System.out.print(dp[n-1]);
    }
}
