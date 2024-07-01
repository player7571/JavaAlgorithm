import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[][] field = new int[N+1][N+1];
        while (M-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            field[a][b] = c;
        }
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                if(k==i) continue;
                for(int j=1; j<=N; j++){
                    if(k==j||i==j) continue;
                    if(field[i][k]!=0&&field[k][j]!=0) {
                        if(field[i][j]==0||field[i][j]>field[i][k]+field[k][j]){
                            field[i][j] = field[i][k]+field[k][j];
                        }
                    }
                }
            }
        }
        int max = 0;
        for(int i=1; i<=N; i++){
            max = Math.max(field[i][X]+field[X][i], max);
        }
        System.out.print(max);
    }
}
