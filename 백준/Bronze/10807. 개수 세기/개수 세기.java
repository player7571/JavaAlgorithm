import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2024-05-05
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[201];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[Integer.parseInt(st.nextToken())+100]++;
        }
        N = Integer.parseInt(br.readLine());
        System.out.print(num[N+100]);
    }
}
