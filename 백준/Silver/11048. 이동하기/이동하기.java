import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {1, 0};
        int[] dy = {0, 1};
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = Math.max(N, M);
        int[][] maze = new int[max+1][max+1];
        int[][] dp = new int[max+1][max+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + maze[i][j];
            }
        }
        System.out.print(dp[N][M]);
    }
}
