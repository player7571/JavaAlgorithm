import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            num[i] = num[i-1]+Integer.parseInt(st.nextToken());
        }
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            sb.append(-num[Integer.parseInt(st.nextToken())-1]+num[Integer.parseInt(st.nextToken())]).append("\n");
        }
        System.out.print(sb);
    }
}
