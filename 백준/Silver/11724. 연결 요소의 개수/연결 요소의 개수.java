import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static boolean[][] g;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        g = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            g[n][m] = true;
            g[m][n] = true;
        }
        int cnt=1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start());
        while(!queue.isEmpty()){
            int val = queue.poll();
            for(int i=1; i<=N; i++){
                if(val==i) continue;
                if(!visited[i]&&g[val][i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
            if(queue.isEmpty()) {
                if(!visited[val]) visited[val] = true;
                int num = start();
                if(num!=0) {
                    queue.add(num);
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
    static int start(){
        for(int i=1; i<=N; i++){
            if(!visited[i]) return i;
        }
        return 0;
    }
}
