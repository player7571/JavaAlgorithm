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
        int H = Integer.parseInt(st.nextToken());
        int [][][] tomato = new int[M][N][H];
        boolean [][][] visited = new boolean[M][N][H];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int min=0;
        Queue<int[]> queue = new LinkedList<>();
        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    tomato[j][i][k] = Integer.parseInt(st.nextToken());
                    if(tomato[j][i][k]==1) {
                        visited[j][i][k]=true;
                        queue.add(new int[]{j, i, k, 0});
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            int[] lo = queue.poll();
            for(int i=0; i<4; i++){
                if(lo[0]+dx[i]>=0&&lo[1]+dy[i]>=0&&lo[0]+dx[i]<M&&lo[1]+dy[i]<N){
                    if(tomato[lo[0]+dx[i]][lo[1]+dy[i]][lo[2]]==0&&!visited[lo[0]+dx[i]][lo[1]+dy[i]][lo[2]]){
                        queue.add(new int[] {lo[0]+dx[i], lo[1]+dy[i], lo[2], lo[3]+1});
                        visited[lo[0]+dx[i]][lo[1]+dy[i]][lo[2]] = true;
                    }
                }
            }
            if(lo[2]+1<H&&tomato[lo[0]][lo[1]][lo[2]+1]==0&&!visited[lo[0]][lo[1]][lo[2]+1]) {
                queue.add(new int[] {lo[0], lo[1], lo[2]+1, lo[3]+1});
                visited[lo[0]][lo[1]][lo[2]+1] = true;
            }
            if(lo[2]-1>=0&&tomato[lo[0]][lo[1]][lo[2]-1]==0&&!visited[lo[0]][lo[1]][lo[2]-1]) {
                queue.add(new int[] {lo[0], lo[1], lo[2]-1, lo[3]+1});
                visited[lo[0]][lo[1]][lo[2]-1] = true;
            }
            min=lo[3];
        }
        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(tomato[j][i][k]==0) {
                        if(!visited[j][i][k]){
                            System.out.print("-1");
                            return;
                        }
                    }
                }
            }
        }
        System.out.print(min);
    }
}
