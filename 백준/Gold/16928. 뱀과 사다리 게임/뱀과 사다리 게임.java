import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ladder = new int[101];
    static int[] snl = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine());
            ladder[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        bfs(1, 0);
        System.out.print(snl[100]);
    }
    static void bfs(int start, int cnt){
        if(cnt>snl[start]&&snl[start]!=0) return;
        snl[start] = cnt;
        for(int i=1; i<7; i++){
            if(i+start>100) continue;
            bfs(ladder[start+i]!=0 ? ladder[start+i] : start+i, cnt+1);
        }
    }
}
