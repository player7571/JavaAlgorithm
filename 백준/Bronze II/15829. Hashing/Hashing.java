import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        BigInteger ans= BigInteger.valueOf(0);
        BigInteger x = BigInteger.valueOf(1);
        for(int i=0; i<L; i++){
            if(i!=0) x = x.multiply(BigInteger.valueOf(31));
            ans = ans.add(x.multiply(BigInteger.valueOf(str.charAt(i)-'a'+1)));
        }
        System.out.print(ans.mod(BigInteger.valueOf(1234567891)));
    }
}
