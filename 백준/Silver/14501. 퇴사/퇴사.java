import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++){
            int val = T[i]+i-1;
            if(val<=N) {
                dp[val] = Math.max(dp[val], dp[i-1]+P[i]);
            }
            if(dp[i]<dp[i-1]) dp[i] = dp[i-1];
        }
        System.out.print(dp[N]);
    }
}
