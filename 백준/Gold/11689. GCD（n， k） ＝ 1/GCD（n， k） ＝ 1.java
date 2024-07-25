import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int N = (int) Math.sqrt(n);
        long ans = n;
        for(int i=2; i<=N; i++){
            if(n%i!=0) continue;
            ans -= ans/i;
            while (n%i==0){
                n/=i;
            }
        }
        System.out.print(n==1 ? ans : ans/n*(n-1));
    }
}
