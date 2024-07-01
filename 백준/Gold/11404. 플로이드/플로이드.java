import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] city = new int[n+1][n+1];
        while (m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(city[a][b]==0||city[a][b]>c){
                city[a][b] = c;
            }
        }
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                if(i==k) continue;
                for(int j=1; j<=n; j++){
                    if(j==k||i==j) continue;
                    if(city[i][k]!=0&&city[k][j]!=0){
                        if(city[i][j]==0||city[i][j]>city[i][k]+city[k][j]){
                            city[i][j] = city[i][k]+city[k][j];
                        }
                    }
                }
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                sb.append(city[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
