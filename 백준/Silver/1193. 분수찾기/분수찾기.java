import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int n=0;
        int m=0;
        for(int i=1; n+i<X; i++){
            n+=i;
            m=i;
        }
        m+=2;
        if(m%2==1){
            System.out.print(X-n+"/"+(m-(X-n)));
        }
        else{
            System.out.print(m-(X-n)+"/"+(X-n));
        }
    }
}
