import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long ans = S/K;
        for(int i=0; i<S%K; i++){
            ans*=(S/K+1);
        }
        for(int i=1; i<K-S%K; i++){
            ans*=(S/K);
        }
        System.out.println(ans);
    }
}
