import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            if(N<3) {
                sb.append("1\n");
                continue;
            }
            long[] dp = new long[N];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;
            for(int i=3; i<N; i++){
                dp[i] = dp[i-3]+dp[i-2];
            }
            sb.append(dp[N-1]).append("\n");
        }
        System.out.print(sb);
    }
}
