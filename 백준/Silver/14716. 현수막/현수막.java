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
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] banner = new int[M][N];
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                banner[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(banner[i][j]==1) {
                    banner[i][j] = 0;
                    queue.add(new int[]{i, j});
                    while(!queue.isEmpty()){
                        int[] now = queue.poll();
                        for(int k=0; k<8; k++){
                            int x = now[0]+dx[k];
                            int y = now[1]+dy[k];
                            if(x>=0&&y>=0&&x<M&&y<N&&banner[x][y]==1){
                                banner[x][y] = 0;
                                queue.add(new int[]{x, y});
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}
