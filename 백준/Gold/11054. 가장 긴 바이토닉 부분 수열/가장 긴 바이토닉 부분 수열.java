import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];
        int[] dp2 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++){
            dp[i] = 1;
            dp2[N-1-i]=1;
            for(int j=0; j<i; j++){
                if(A[i]>A[j]) dp[i] = Math.max(dp[i], dp[j]+1);
                if(A[N-1-i]>A[N-1-j]) dp2[N-1-i] = Math.max(dp2[N-1-i], dp2[N-1-j]+1);
            }
        }
        int max = 0;
        for(int i=0; i<N; i++){
            max = Math.max(dp[i]+dp2[i], max);
        }
        System.out.print(max-1);
    }
}
