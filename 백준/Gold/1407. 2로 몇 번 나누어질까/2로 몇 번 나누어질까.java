import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long ans = (B-A+1)/2;
        if(B%2==1&&A%2==1) ans++;
        int start = 0;
        for(int i=1; (long)Math.pow(2, i)<=B; i++){
            start=i;
        }
        long sum=0;
        for(int i=start; i>0; i--){
            long cnt=B/(long)Math.pow(2, i)-(A-1)/(long)Math.pow(2, i);
            ans += ((long)Math.pow(2, i)*(cnt-sum));
            sum+=(cnt-sum);
        }
        System.out.println(ans);
    }
}
