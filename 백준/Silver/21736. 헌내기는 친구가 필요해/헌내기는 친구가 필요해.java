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
        char[][] campus = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        int[] dx ={1, -1, 0, 0};
        int[] dy ={0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                campus[i][j] = str.charAt(j);
                if(campus[i][j]=='I') {
                    queue.add(new int[]{i, j});
                    visited[i][j]=true;
                }
            }
        }
        int cnt=0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(campus[now[0]][now[1]]=='P') cnt++;
            for(int i=0; i<4; i++){
                int x = now[0]+dx[i];
                int y = now[1]+dy[i];
                if(x<0||x>=N||y<0||y>=M) continue;
                if(!visited[x][y]&&campus[x][y]!='X') {
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        System.out.print(cnt==0 ? "TT" : cnt);
    }
}
