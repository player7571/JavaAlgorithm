import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[N][N];
        int[][] field = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int len = field[now[0]][now[1]];
            if(len==-1) {
                System.out.print("HaruHaru");
                return;
            }
            if(now[0]+len<N&&!visited[now[0]+len][now[1]]) {
                visited[now[0]+len][now[1]] = true;
                queue.add(new int[]{now[0]+len, now[1]});
            }
            if(now[1]+len<N&&!visited[now[0]][now[1]+len]) {
                visited[now[0]][now[1]+len] = true;
                queue.add(new int[]{now[0], now[1]+len});
            }
        }
        System.out.print("Hing");
    }
}
