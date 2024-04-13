import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] prime = new boolean[100001];
        int[] count = new int[100001];
        prime[0] = prime[1] = true;
        for(int i=2; i<=100000; i++){
            if(prime[i]) continue;
            for(int j=i*2; j<=100000; j+=i){
                prime[j] = true;
                int val = j;
                while(val%i==0){
                    val/=i;
                    count[j]++;
                }
            }
        }
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int ans = 0;
        for(int i=A; i<=B; i++){
            if(!prime[count[i]]) ans++;
        }
        System.out.print(ans);

    }
}