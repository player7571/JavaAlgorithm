import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        boolean bool;
        for(int k=1; k<N; k++){
            bool = false;
            for(int i =0; i<k; i++){
                if(str.charAt(i)!=str.charAt(N-k+i)) {
                    if(bool) {
                        bool = false;
                        break;
                    }
                    bool = true;
                }
            }
            if(bool){
                System.out.print("YES");
                return;
            }
        }
        System.out.print("NO");
    }
}
