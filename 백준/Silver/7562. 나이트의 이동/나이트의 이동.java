import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dx = new int[]{-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = new int[]{-1, 1, -2, 2, -2, 2, -1, 1};
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int I = Integer.parseInt(br.readLine());
            int[][] field = new int[I][I];
            Queue<int[]> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            st = new StringTokenizer(br.readLine());
            int[] goal = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            while (!queue.isEmpty()){
                int[] now = queue.poll();
                if(now[0]==goal[0]&&now[1]==goal[1]) break;
                for(int i=0; i<8; i++){
                    int x = now[0]+dx[i];
                    int y = now[1]+dy[i];
                    if(x>=0&&y>=0&&x<I&&y<I&&field[x][y]==0){
                        field[x][y] = field[now[0]][now[1]]+1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            sb.append(field[goal[0]][goal[1]]).append("\n");
        }
        System.out.print(sb);
    }
}
