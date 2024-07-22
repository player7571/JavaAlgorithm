import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int N = Integer.parseInt(br.readLine());
            int[] coin = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            long[] dp = new long[M+1];
            dp[0] = 1;
            for(int k=0; k<N; k++){
                int val = coin[k];
                for(int i=0; i<=M-val; i++){
                    dp[i+val] = dp[i]+dp[i+val];
                }
            }
            sb.append(dp[M]).append("\n");
        }
        System.out.print(sb);
    }
}
