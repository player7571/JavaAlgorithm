import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//2024-02-13
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int ans=1;
        for(int i=0; i<K; i++){
            ans*=(N-i);
        }
        for(int i=K; i>1; i--){
            ans/=i;
        }
        System.out.print(ans);
    }
}
