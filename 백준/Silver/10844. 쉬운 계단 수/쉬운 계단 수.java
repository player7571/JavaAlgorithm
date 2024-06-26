import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];
        if(N==1) {
            System.out.print("9");
            return;
        }
        for(int i=1; i<10; i++){
            dp[1][i] = 1;
        }
        for(int i=2; i<=N; i++){
            dp[i][0] = dp[i-1][1]%1000000000;
            dp[i][9] = dp[i-1][8]%1000000000;
            for(int j=1; j<9; j++){
                dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
            }
        }
        int ans = 0;
        for(int i=0; i<10; i++){
            ans = (ans+dp[N][i])%1000000000;
        }
        System.out.print(ans);
    }
}
