import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T>0){
            long [] w= new long[4];
            long [] h= new long[4];
            int tf = 1;
            for(int i=0; i<4; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                w[i] = Long.parseLong(st.nextToken());
                h[i] = Long.parseLong(st.nextToken());
            }
            long [] len = new long[6];
            len[0] =calLen(w[0], w[1], h[0], h[1]);
            len[1] =calLen(w[0], w[2], h[0], h[2]);
            len[2] =calLen(w[0], w[3], h[0], h[3]);
            len[3] =calLen(w[1], w[2], h[1], h[2]);
            len[4] =calLen(w[1], w[3], h[1], h[3]);
            len[5] =calLen(w[2], w[3], h[2], h[3]);
            long li =len[0];
            long ls =li;
            for(int i=1; i<6; i++){
                ls = Math.max(len[i], ls);
                li = Math.min(len[i], li);
            }
            if(!(ls==li*2)) tf=0;
            sb.append(tf).append("\n");
            T--;
        }
        System.out.println(sb);
    }
    static long calLen(long w1, long w2, long h1, long h2){
        return ((w1-w2)*(w1-w2)+(h1-h2)*(h1-h2));
    }
    static boolean comLen(long a, long b){
        return a==b || a*2 == b || b*2 == a;
    }
}
