import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] field = new int[N][N];
        int high = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int height = Integer.parseInt(st.nextToken());
                high = Math.max(high, height);
                field[i][j] = height;
            }
        }
        int ans = 0;
        while (high-->0){
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++) {
                    if(field[i][j]-high<=0) visited[i][j] = true;
                }
            }
            int cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++) {
                    if(visited[i][j]) continue;
                    cnt++;
                    queue.add(new int[]{i, j});
                    bfs(visited, queue);
                }
            }
            ans = Math.max(cnt, ans);
        }
        System.out.print(ans);
    }

    public static void bfs(boolean[][] visited, Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i=0; i<4; i++){
                int x = now[0]+dx[i];
                int y = now[1]+dy[i];
                if(x>=0&&x<N&&y>=0&&y<N&&!visited[x][y]){
                    visited[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }
    }

}
