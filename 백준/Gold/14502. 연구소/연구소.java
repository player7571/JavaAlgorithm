import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M, ans;
    static int[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        wall(0);
        System.out.print(ans);
    }

    static void wall(int cnt){
        if(cnt==3) {
            bfs();
            return;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(field[i][j]==0) {
                    field[i][j] = 1;
                    wall(cnt+1);
                    field[i][j] = 0;
                }
            }
        }
    }

    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        int[][] copy = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                copy[i][j] = field[i][j];
                if(copy[i][j]==2) queue.add(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            copy[now[0]][now[1]] = 2;
            for(int i=0; i<4; i++){
                int x = now[0]+dx[i];
                int y = now[1]+dy[i];
                if(x>=0&&y>=0&&x<N&&y<M&&copy[x][y]==0){
                    queue.add(new int[]{x, y});
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copy[i][j]==0) cnt++;
            }
        }
        ans = Math.max(ans, cnt);
    }
}
