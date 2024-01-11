import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt=0;
        boolean [] n = new boolean[1001];
        n[0]=true;
        n[1]=true;
        for(int i=2; i<=1000; i++){
            if(!n[i]) for(int j=i*2; j<=1000; j+=i) n[j]=true;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            if(!n[Integer.parseInt(st.nextToken())]) cnt++;
        }
        System.out.print(cnt);
    }
}
