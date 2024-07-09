import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[5];
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<5; i++){
            num[i] = Integer.parseInt(st.nextToken());
            ans = Math.min(num[i], ans);
        }
        while(true){
            int cnt = 0;
            for(int i=0; i<5; i++){
                if(ans%num[i]==0) cnt++;
                if(cnt==3){
                    System.out.print(ans);
                    return;
                }
            }
            ans++;
        }
    }
}
