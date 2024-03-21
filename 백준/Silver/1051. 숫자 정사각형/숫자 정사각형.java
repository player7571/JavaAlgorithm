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
        int[][] field = new int[N][M];
        for(int i=0; i<N; i++){
            char[] ch = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                field[i][j] = ch[j]-'0';
            }
        }
        int max = 1;
        for(int k=0; k<N; k++){
            for(int i=0; i<M; i++){
                for(int j=i+1; j<M; j++){
                    if(field[k][i]==field[k][j]){
                        int num = k+j-i;
                        if(num>=N) break;
                        if(field[num][i]==field[num][j]&&field[num][i]==field[k][i]){
                            max = Math.max((j-i+1)*(j-i+1), max);
                        }
                    }
                }
            }
        }
        System.out.print(max);
    }
}
