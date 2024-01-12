import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//2024-01-12
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        int [] coin = new int[N];
        for(int i=0; i<N; i++) {
            coin[i]= Integer.parseInt(br.readLine());
        }
        int min=0;
        for(int i=N-1; i>=0; i--){
            if(K>=coin[i]){
                min+=(K/coin[i]);
                K-=(coin[i]*(K/coin[i]));
                if(K==0) break;
            }
        }
        System.out.print(min);
    }
}
