import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N][3];
        int[][] dp = new int[N][3];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.arraycopy(house[0], 0, dp[0], 0, 3);
        for(int i=1; i<N; i++){
            for(int j=0; j<3; j++){
                dp[i][j] = dp[i-1][j]+1001;
                for(int k=0; k<3; k++){
                    if(j==k) continue;
                    dp[i][j] = Math.min(dp[i-1][k]+house[i][j], dp[i][j]);
                }
            }
        }
        System.out.print(Math.min(dp[N-1][2], Math.min(dp[N-1][0], dp[N-1][1])));
    }
}
