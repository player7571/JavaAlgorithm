import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] field = new char[N][N];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for(int i=0; i<N; i++){
            field[i] = br.readLine().toCharArray();
        }
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0]= true;
        int cnt=1;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i=0; i<4; i++){
                if(now[0]+dx[i]>=0&&now[1]+dy[i]>=0&&now[0]+dx[i]<N&&now[1]+dy[i]<N&&!visited[now[0]+dx[i]][now[1]+dy[i]]&&field[now[0]+dx[i]][now[1]+dy[i]]==field[now[0]][now[1]]) {
                    queue.add(new int[]{now[0] + dx[i], now[1] + dy[i]});
                    visited[now[0]+dx[i]][now[1]+dy[i]]=true;
                }
            }
            if(queue.isEmpty()){
                boolean brk = false;
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(!visited[i][j]){
                            queue.add(new int[]{i, j});
                            visited[i][j]=true;
                            cnt++;
                            brk=true;
                            break;
                        }
                    }
                    if(brk) break;
                }
            }
        }
        sb.append(cnt).append(" ");
        cnt=1;
        queue.add(new int[]{0, 0});
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                visited[i][j]=false;
            }
        }
        visited[0][0]= true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i=0; i<4; i++){
                if(now[0]+dx[i]>=0&&now[1]+dy[i]>=0&&now[0]+dx[i]<N&&now[1]+dy[i]<N&&!visited[now[0]+dx[i]][now[1]+dy[i]]) {
                    if(field[now[0]][now[1]]=='B'){
                        if(field[now[0]+dx[i]][now[1]+dy[i]]=='B'){
                            queue.add(new int[]{now[0] + dx[i], now[1] + dy[i]});
                            visited[now[0]+dx[i]][now[1]+dy[i]]=true;
                        }
                    }
                    else {
                        if(field[now[0]+dx[i]][now[1]+dy[i]]=='G'||field[now[0]+dx[i]][now[1]+dy[i]]=='R'){
                            queue.add(new int[]{now[0] + dx[i], now[1] + dy[i]});
                            visited[now[0]+dx[i]][now[1]+dy[i]]=true;
                        }
                    }
                }
            }
            if(queue.isEmpty()){
                boolean brk = false;
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(!visited[i][j]){
                            queue.add(new int[]{i, j});
                            visited[i][j]=true;
                            cnt++;
                            brk=true;
                            break;
                        }
                    }
                    if(brk) break;
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);

    }
}
