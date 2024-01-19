import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.print(bfs(N));
    }

    static int bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[100001];
        int cnt =0;
        queue.add(start);
        queue.add(cnt);
        while(!queue.isEmpty()){
            int next = queue.poll();
            cnt = queue.poll();
            if(next==K) break;
            if(visited[next]) continue;
            visited[next] = true;
            if(next+1<=100000&&!visited[next+1]) {
                queue.add(next+1);
                queue.add(cnt+1);
            }
            if(next*2<=100000&&!visited[next*2]) {
                queue.add(next*2);
                queue.add(cnt+1);
            }
            if(next-1>=0&&!visited[next-1]) {
                queue.add(next-1);
                queue.add(cnt+1);
            }
        }
        return cnt;
    }
}
