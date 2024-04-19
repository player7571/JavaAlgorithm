import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long S = Long.parseLong(br.readLine());
        long cnt=0;
        for(int i=1; i<=S; i++){
            S-=i;
            cnt++;
        }
        System.out.print(cnt);
    }
}
