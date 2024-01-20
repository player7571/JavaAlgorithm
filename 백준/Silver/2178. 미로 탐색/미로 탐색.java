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
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        boolean [][] maze = new boolean[N+2][M+2];
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            char [] ch = str.toCharArray();
            for(int j=1; j<=M; j++){
                if(ch[j-1]-'0'==1) maze[i][j] = true;
            }
        }
        Queue<int[]> route = new LinkedList<>();
        int [] info = {1, 1, 1}; //n, m, cnt;
        route.add(info);
        while(true){
            info = route.poll();
            int n= info[0];
            int m= info[1];
            int cnt = info[2];
            if(!maze[n][m]) continue;
            if(n==N&&m==M) {
                System.out.print(info[2]);
                return;
            }
            maze[n][m] = false;
//            System.out.println(n+" "+m);
            if(maze[n][m+1]) {
                route.add(new int[]{n, m+1, cnt+1});
            }
            if(maze[n+1][m]) {
                route.add(new int[]{n+1, m, cnt+1});
            }
            if(maze[n][m-1]) {
                route.add(new int[]{n, m-1, cnt+1});
            }
            if(maze[n-1][m]) {
                route.add(new int[]{n-1, m, cnt+1});
            }
        }
    }
}