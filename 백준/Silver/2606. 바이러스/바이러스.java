import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, cnt =0;
    static boolean [][] net;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        net = new boolean[N+1][N+1];
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            net[x][y] = true;
            net[y][x] = true;
        }
        bfs();
        System.out.print(cnt-1);
    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        boolean [] visited = new boolean[N+1];
        queue.add(1);
        while(!queue.isEmpty()){
            int num = queue.poll();
            if(visited[num]) continue;
            visited[num] = true;
            for(int i=1; i<net.length; i++){
                if(visited[i]) continue;
                if(net[num][i]) queue.add(i);
            }
            cnt++;
        }
    }
}
