import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] chk;
    static boolean[] visited;
    static boolean tf;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        while(K-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            visited = new boolean[V+1];
            chk = new int[V+1];
            tf = true;
            graph = new ArrayList[V+1];
            for(int i=1; i<=V; i++){
                graph[i] = new ArrayList<Integer>();
            }
            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int x= Integer.parseInt(st.nextToken());
                int y= Integer.parseInt(st.nextToken());
                graph[x].add(y);
                graph[y].add(x);
            }
            for(int i=1; i<=V; i++){
                if(tf){
                    dfs(i);
                }
                else break;
            }
            if(tf)sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb);
    }
    static void dfs(int start){
        visited[start] = true;
        for(int i: graph[start]){
            if(!visited[i]){
                chk[i] = (chk[start]+1)%2;
                dfs(i);
            }
            else if(chk[start]==chk[i]) tf=false;
        }
    }
}
