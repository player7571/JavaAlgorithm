import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int [] N = new int[T];
        int max = 0;
        for(int i=0; i<T; i++) {
            N[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, N[i]);
        }
        int [] dp =  new int[max+3];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;
        for(int i=3; i<=max; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        for(int i=0; i<T; i++){
            if(N[i]==0) {
                sb.append("1 0\n");
                continue;
            }
            sb.append(dp[N[i]]).append(" ").append(dp[N[i]]+dp[N[i]-1]).append("\n");
        }
        System.out.print(sb);
    }
}
