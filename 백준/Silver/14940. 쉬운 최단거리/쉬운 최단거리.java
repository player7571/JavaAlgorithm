import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] field;
    static int[][] sum;
    static boolean[][] visited;
    static int n, m, x, y;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        field = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
                if(field[i][j]==2){
                    field[i][j]=0;
                    x=i;
                    y=j;
                }
            }
        }
        bfs(x, y);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j]&&field[i][j]==1)sb.append("-1").append(" ");
                else sb.append(sum[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int ns, int ms){
        sum = new int[n][m];
        visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int[] val = new int[2];
        val[0] = ns;
        val[1] = ms;
        queue.add(new int[]{ns, ms});
        while(!queue.isEmpty()){
            val = queue.poll();
            for(int i=0; i<4; i++){
                int nx = val[0]+dx[i];
                int ny = val[1]+dy[i];
                if(nx<n&&ny<m&&nx>=0&&ny>=0){
                    if(field[nx][ny]!=0&&(sum[nx][ny]==0||sum[nx][ny]>sum[val[0]][val[1]]+field[nx][ny])){
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny]=true;
                        sum[nx][ny]=sum[val[0]][val[1]]+field[nx][ny];

                    }
                }
            }
        }
    }
}
