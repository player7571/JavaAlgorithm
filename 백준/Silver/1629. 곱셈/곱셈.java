import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C;
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ans = 1;
        if(B==1){
            ans=A%C;
        }
        else cal();
        System.out.print(ans);
    }
    static void cal(){
        long num = A;
        int x = 0;
        for(long i=2; i<=B; i*=2){
            num=(num*num)%C;
            x= (int) i;
        }
        B-=x;
        ans=((ans*num)%C);
        if(B<=1){
            if(B==1) ans=(ans*A)%C;
            return;
        }
        cal();
    }
}
