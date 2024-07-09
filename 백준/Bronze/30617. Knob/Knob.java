import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int ans = 0;
        if(l==r&&l!=0) ans++;
        while (T-->1){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            if(l==L&&l!=0) ans++;
            if(r==R&&r!=0) ans++;
            if(L==R&&L!=0) ans++;
            l = L;
            r = R;
        }
        System.out.print(ans);
    }
}
