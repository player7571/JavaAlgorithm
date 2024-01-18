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
        int [][] friend = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            friend[f1][f2] = friend[f2][f1] = 1;
        }
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++){
                    if(i==j||friend[i][k]==0||friend[k][j]==0) continue;
                    if(friend[i][j]==0) friend[i][j] = friend[i][k]+friend[k][j];
                    else friend[i][j] = friend[j][i] = Math.min(friend[i][j], friend[i][k]+friend[k][j]);
                }
            }
        }
        int sum, min=0, p=1;
        for(int i=1; i<=N; i++) {
            sum=0;
            for(int j=1; j<=N; j++){
                sum+= Math.min(friend[i][j], friend[j][i]);
            }
            if(i==1) min=sum;
            else {
                if(min>sum) {
                    min=sum;
                    p=i;
                }
            }
        }
        System.out.print(p);
    }
}
