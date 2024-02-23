import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n+1];
        for(int i=0; i<=n; i++){
            num[i] = i;
        }
        boolean[] bool = new boolean[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==b) {
                if(str.equals("1")) sb.append("YES\n");
                continue;
            }
            while(bool[a]&&num[a]!=a){
                a = num[a];
            }
            while(bool[b]&&num[b]!=b){
                b = num[b];
            }
            if(str.equals("0")){
                if(a<b) {
                    num[b] = a;
                    bool[b] = true;
                }
                else {
                    num[a] = b;
                    bool[a] = true;
                }
            }
            else {
                if(num[a]==num[b]) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}
