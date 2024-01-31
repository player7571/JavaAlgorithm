import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = N/10;
        int b = N%10;
        int cnt = 0;
        do {
            cnt++;
            int c = a+b;
            a = b;
            b = c%10;
        } while (a*10+b!=N);
        System.out.print(cnt);
    }
}
