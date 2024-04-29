import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] field = new boolean[N][N];
        int[] ans = new int[2];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            int cnt = 0;
            for(int j=0; j<N; j++){
                if(str.charAt(j)=='X') {
                    field[i][j] = true;
                    cnt=0;
                }
                else {
                    if(cnt==0) cnt++;
                    else {
                        if(cnt==2) continue;
                        ans[0]++;
                        cnt++;
                    }
                }
            }
        }
        for(int i=0; i<N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (field[j][i]) {
                    cnt = 0;
                } else {
                    if (cnt == 0) cnt++;
                    else {
                        if(cnt==2) continue;
                        cnt++;
                        ans[1]++;
                    }
                }
            }
        }
        System.out.print(ans[0]+" "+ans[1]);
    }
}
