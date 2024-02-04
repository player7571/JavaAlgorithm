import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] bool = new boolean[1001];
        for(int i=2; i<=N; i++){
            if(!bool[i]){
                for(int j=i; j<=N; j+=i){
                    if(!bool[j]){
                        bool[j] = true;
                        if(--K==0) {
                            System.out.print(j);
                            return;
                        }
                    }
                }
            }
        }
    }
}
