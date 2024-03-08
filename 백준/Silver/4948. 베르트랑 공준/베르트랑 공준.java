import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] bool = new boolean[246913];
        for(int i=2; i<=246912; i++){
            if(bool[i]) continue;
            for(int j=i*2; j<=246912; j+=i){
                bool[j] = true;
            }
        }
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            int cnt = 0;
            for(int i=n+1; i<=n*2; i++){
                if(!bool[i]) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
