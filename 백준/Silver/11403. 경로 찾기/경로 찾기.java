import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] G = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                if(st.nextToken().equals("1")){
                    G[i][j]=1;
                }
            }
        }
        boolean change = true;
        while(change){
            change = false;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    for(int k=0; k<N; k++){
                        if(G[i][k]==1&&G[k][j]==1&&G[i][j]==0) {
                            G[i][j]=1;
                            change = true;
                            break;
                        }
                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(G[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
