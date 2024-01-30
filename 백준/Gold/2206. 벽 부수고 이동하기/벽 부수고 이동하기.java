import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][][] map = new int[N][M][2];
        boolean[][] tf = new boolean[N][M];
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                tf[i][j] = str.charAt(j) == '0';
            }
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});
        map[0][0][0] = 1;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            now[2]++;
            int[] next = new int[2];
            int cnt=0;
            for(int i=0; i<4; i++){
                int x = now[0]+dx[i];
                int y = now[1]+dy[i];
                if(x<0||x>=N||y<0||y>=M) continue;
                if(map[x][y][now[3]]>now[2]||map[x][y][now[3]]==0){
                    if(tf[x][y]) {
                        queue.add(new int[]{x, y, now[2], now[3]});
                        map[x][y][now[3]] = now[2];
                        cnt++;
                    }
                    else{
                        if(now[3]==0){
                            queue.add(new int[]{x, y, now[2], 1});
                            map[x][y][1] = now[2];
                            cnt++;
                        }
                    }
                }
            }
        }
        if(map[N-1][M-1][1]==0&&map[N-1][M-1][0]==0) System.out.print(-1);
        else if(map[N-1][M-1][1]==0) System.out.print(map[N-1][M-1][0]);
        else if(map[N-1][M-1][0]==0) System.out.print(map[N-1][M-1][1]);
        else System.out.print(Math.min(map[N-1][M-1][0],map[N-1][M-1][1]));
    }
}
