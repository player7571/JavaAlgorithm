import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger ans = BigInteger.valueOf(1);
        if(m>n/2) m = n-m;
        for(int i=0; i<m; i++){
            ans = ans.multiply(BigInteger.valueOf(n-i));
            ans = ans.divide(BigInteger.valueOf(i+1));
        }
        System.out.print(ans);
    }
}
