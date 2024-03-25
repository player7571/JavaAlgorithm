import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] friend = new boolean[N][N];
        boolean[][] friend2 = new boolean[N][N];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                if(str.charAt(j)=='Y') {
                    friend[i][j] = true;
                    friend[j][i] = true;
                    friend2[i][j] = true;
                    friend2[j][i] = true;
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                for(int k=0; k<N; k++){
                    if(i==k||j==k) continue;
                    if(friend[i][k]&&friend[j][k]){
                        friend2[i][j]=true;
                        friend2[j][i]=true;
                    }
                }
            }
        }
        int max=0;
        for(int i=0; i<N; i++){
            int cnt=0;
            for(int j=0; j<N; j++){
                if(friend2[i][j]) cnt++;
            }
            max = Math.max(max, cnt);
        }
        System.out.print(max);
    }
}
