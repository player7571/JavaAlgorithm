import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int [] lc = new int[N];
        long sum;
        long max = lc[0] = Integer.parseInt(br.readLine());
        long min = 1;
        for(int i=1; i<N; i++) {
            lc[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lc[i]);
        }
        while(true){
            long num = (max+min)/2;
            sum=0;
            for(int i=0; i<N; i++) {
                sum+=lc[i]/num;
            }
            if(sum>=M) {
                if(max-min<1) {
                    sum=num;
                    break;
                }
                min=num+1;
            }
            else max=num-1;
        }
        System.out.print(sum);
    }
}
