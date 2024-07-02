import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] weight = new int[N];
        for(int i=0; i<N; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weight);
        int start = 0;
        int end = N-1;
        int cnt = 0;
        while (start<end){
            if(weight[start]+weight[end]<=K){
                cnt++;
                start++;
            }
            end--;
        }
        System.out.print(cnt);
    }
}
