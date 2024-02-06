import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            if(n==1){
                int a = Integer.parseInt(br.readLine());
                int b = Integer.parseInt(br.readLine());
                sb.append(Math.max(a, b)).append("\n");
                continue;
            }
            int[][] dp = new int[2][n];
            for(int i=0; i<2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = dp[1][0]+dp[0][1];
            dp[1][1] = dp[0][0]+dp[1][1];
            for(int i=2; i<n; i++){
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2])+dp[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2])+dp[1][i];
            }
            sb.append(Math.max(dp[0][n-1], dp[1][n-1])).append("\n");
        }
        System.out.print(sb);
    }
}
