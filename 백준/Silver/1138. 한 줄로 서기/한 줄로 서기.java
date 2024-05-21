import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] val = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for(int j=0; j<N; j++){
                if(cnt>=num&&val[j]==0) {
                    val[j] = i+1;
                    break;
                }
                if(val[j]==0) cnt++;
            }
        }
        for(int i=0; i<N; i++){
            System.out.print(val[i]+" ");
        }
    }
}
