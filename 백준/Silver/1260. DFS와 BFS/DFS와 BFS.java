import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean [] visit = new boolean[1001];
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int V= Integer.parseInt(st.nextToken());
        int [][] edge = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int num1= Integer.parseInt(st.nextToken());
            int num2= Integer.parseInt(st.nextToken());
            edge[num1][num2] = edge[num2][num1] = 1;
        }
        dfs(edge, V);
        sb.append("\n");
        for(int i=0; i<=N; i++) visit[i] =false;
        bfs(edge, V);
        System.out.print(sb);
    }
    static void dfs(int[][] edge, int V){
        sb.append(V).append(" ");
        visit[V]=true;
        for(int i=1; i<edge.length; i++){
            if(visit[i]) continue;
            if(edge[V][i]==1) dfs(edge, i);
        }
    }
    static void bfs(int[][] edge, int V){
        sb.append(V).append(" ");
        visit[V]=true;
        for(int i=1; i<edge.length; i++){
            if(visit[i]) continue;
            if(edge[V][i]==1) {
                queue.add(i);
                visit[i]=true;
            }
        }
        if(!queue.isEmpty())bfs(edge, queue.remove());
    }

}
