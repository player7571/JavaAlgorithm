import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] house;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        house = new boolean[N+2][N+2];
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=N; j++){
                if(str.charAt(j-1)=='1') house[i][j]=true;
            }
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(house[i][j]) arr.add(bfs(i, j));
            }
        }
        sb.append(arr.size()).append("\n");
        Collections.sort(arr);
        for(Integer li : arr){
            sb.append(li).append("\n");
        }
        System.out.print(sb);
    }

    static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        int cnt =0;
        int [] now = {x, y};
        queue.add(now);
        while(!queue.isEmpty()){
            now = queue.poll();
            if(!house[now[0]][now[1]]) continue;
            cnt++;
            house[now[0]][now[1]] = false;
            for(int i=0; i<4; i++){
                if(house[now[0]+dx[i]][now[1]+dy[i]]) queue.add(new int[]{now[0]+dx[i], now[1]+dy[i]});
            }
        }
        return cnt;
    }
}
