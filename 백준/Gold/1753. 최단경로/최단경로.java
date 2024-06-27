import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int val;
        int edge;
        public Node(int val, int edge){
            this.val = val;
            this.edge = edge;
        }
    }

    static int[] ans;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        visited = new boolean[V+1];
        check = new boolean[V+1];
        ans = new int[V+1];
        list = new ArrayList[V+1];
        for(int i=1; i<=V; i++){
            list[i] = new ArrayList<>();
            ans[i] = Integer.MAX_VALUE;
        }

        while (E-->0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }
        ans[K] = 0;
        check[K] = true;
        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=V; i++){
            if(!check[i]){
                sb.append("INF\n");
                continue;
            }
            sb.append(ans[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dijkstra(int now){
        visited[now] = true;
        int next = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<list[now].size(); i++){
            int nextVal = list[now].get(i).val;
            check[nextVal] = true;
            if(visited[nextVal]) continue;
            if(list[now].get(i).edge+ans[now]<ans[nextVal]){
                ans[nextVal] = list[now].get(i).edge+ans[now];
            }
        }
        for(int i=1; i<visited.length; i++){
            if(visited[i]) continue;
            if(ans[i]<min){
                min = ans[i];
                next = i;
            }
        }
        if(next!=0) dijkstra(next);
    }
}
