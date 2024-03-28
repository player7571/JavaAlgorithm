import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] city = new int[N];
        long[] length = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N; i++){
            length[i] = length[i-1]+Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            int val = Integer.parseInt(st.nextToken());
            city[i] = val;
            Math.min(val, min);
        }
        BigInteger price = BigInteger.valueOf(0);
        for(int i=0; i<N-1; i++){
            int cnt=i;
            for(int j=i+1; j<N; j++){
                cnt=j;
                if(city[i]>city[j]){
                    break;
                }
            }
            price = price.add(BigInteger.valueOf((length[cnt]-length[i])*city[i]));
            i=cnt-1;
        }
        System.out.print(price);
    }
}
