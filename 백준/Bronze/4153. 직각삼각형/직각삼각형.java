import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [] n = new int[3];
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) n[i] = Integer.parseInt(st.nextToken());
            if(n[0]+n[1]+n[2]==0) break;
            Arrays.sort(n);
            if (n[0] * n[0] + n[1] * n[1] == n[2] * n[2]) sb.append("right\n");
            else sb.append("wrong\n");
        }
        System.out.print(sb);
    }
}
