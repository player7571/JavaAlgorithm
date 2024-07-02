import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] price = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(price, ((o1, o2)-> Integer.compare(o1[0], o2[0])));
        int max = 0;
        int ans = 0;
        for(int i=0; i<N; i++){
            int now = 0;
            for(int j=i; j<N; j++){
                now+= Math.max(0, price[i][0]-price[j][1]);
            }
            if(max<now){
                ans = price[i][0];
                max = now;
            }
        }
        System.out.print(ans);
    }
}
