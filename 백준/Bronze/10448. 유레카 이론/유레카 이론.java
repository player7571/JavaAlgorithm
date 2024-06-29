import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        boolean[] bool = new boolean[1001];
        int now = 0;
        for(int i=1; now+i<=1000; i++){
            now+=i;
            bool[now] = true;
        }
        while (T-->0){
            int K = Integer.parseInt(br.readLine());
            boolean tf = false;
            for(int i=1; i<=1000; i++){
                if(!bool[i]) continue;
                if(tf) break;
                for(int j=1; j<=1000; j++){
                    if(!bool[j]) continue;
                    if(tf) break;
                    for(int k=1; k<=1000; k++){
                        if(!bool[k]) continue;
                        if(tf) break;
                        if(i+j+k==K) tf = true;
                    }
                }
            }
            if(tf) sb.append("1\n");
            else sb.append("0\n");
        }
        System.out.print(sb);
    }
}
