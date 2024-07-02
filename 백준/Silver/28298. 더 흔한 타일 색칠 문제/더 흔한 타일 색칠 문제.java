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
        int K = Integer.parseInt(st.nextToken());
        int recolor = N*M;
        char[][] tile = new char[N][M];
        int[][][] color = new int[K][K][27];
        char[][] ans = new char[K][K];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            tile[i] = str.toCharArray();
        }
        for(int k=0; k<K; k++){
            for(int l=0; l<K; l++){
                for(int i=0; i<N-k; i+=K){
                    for(int j=0; j<M-l; j+=K){
                        color[k][l][tile[i+k][j+l]-'A']++;
                    }
                }
            }
        }
        for(int i=0; i<K; i++){
            for(int j=0; j<K; j++){
                int max=0, fix=0;
                for(int k=0; k<27; k++){
                    if(max<color[i][j][k]){
                        max = color[i][j][k];
                        fix = k;
                    }
                }
                ans[i][j] = (char) (fix+'A');
                recolor-=max;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(recolor).append("\n");
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(ans[i%K][j%K]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
