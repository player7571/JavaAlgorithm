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
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(w==0&&h==0) break;
            int cnt =0;
            int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
            int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
            boolean[][] field = new boolean[h][w];
            Queue<int[]> queue= new LinkedList<>();
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    if(st.nextToken().equals("1")) field[i][j] = true;
                }
            }
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!field[i][j]) continue;
                    cnt++;
                    queue.add(new int[]{i, j});
                    while(!queue.isEmpty()){
                        int[] now = queue.poll();
                        for(int k=0; k<8; k++){
                            int x = now[0]+dx[k];
                            int y = now[1]+dy[k];
                            if(x>=0&&x<h&&y>=0&&y<w&&field[x][y]) {
                                field[x][y] = false;
                                queue.add(new int[]{x, y});
                            }
                        }
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
