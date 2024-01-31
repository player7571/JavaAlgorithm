import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] field = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                field[i][j] = Integer.parseInt(st.nextToken())+field[i-1][j];
            }
        }
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int[] num = new int[4];
            for(int i=0; i<4; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }
            int sum=0;
            for(int i=num[1]; i<=num[3]; i++){
                sum+=(field[num[2]][i]-field[num[0]-1][i]);
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
