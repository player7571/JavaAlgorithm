import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int T = Integer.parseInt(br.readLine());
            int[] dp = new int[191230];
            dp[1] = 1;
            dp[2] = 2;
            for(int i=3; i<191230; i++){
                dp[i] = (dp[i-2]+dp[i-1])%1000000007;
            }
            while (T-->0){
                int N = Integer.parseInt(br.readLine());
                sb.append(dp[N]).append("\n");
            }
            System.out.print(sb);
        }
}
