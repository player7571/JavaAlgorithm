import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            long length = y-x;
            if(length<4){
                sb.append(length).append("\n");
                continue;
            }
            long cnt;
            long now = 0;
            long k = 1;
            while(now<(length+1)/2){
                now+=k;
                k++;
            }
            cnt=--k;
            while(k>1){
                k--;
                now+=k;
                cnt++;
            }
            if(now<length) cnt++;
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
