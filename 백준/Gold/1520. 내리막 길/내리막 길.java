import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] field;
    static int[][] dp;
    static int M, N;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        field = new int[M][N];
        dp = new int[M][N];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        dfs(0, 0);
        System.out.print(dfs(0, 0));
    }

    static int dfs(int m, int n){
        if(m==M-1&&n==N-1) {
            return 1;
        }
        if(dp[m][n]!=-1) return dp[m][n];
        dp[m][n] = 0;
        for(int i=0; i<4; i++){
            int xm = m+dx[i];
            int yn = n+dy[i];
            if(xm<M&&yn<N&&xm>=0&&yn>=0&&field[m][n]>field[xm][yn]){
                dp[m][n]+=dfs(xm, yn);
            }
        }
        return dp[m][n];
    }
}
