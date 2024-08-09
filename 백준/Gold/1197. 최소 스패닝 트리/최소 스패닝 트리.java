import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        node = new int[V+1];
        for(int i=1; i<=V; i++){
            node[i] = i;
        }
        int E = Integer.parseInt(st.nextToken());
        int[][] edge = new int[E+1][3];
        edge[0][2] = 100000001;
        int ans =0;
        for(int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edge[i][0] = A;
            edge[i][1] = B;
            edge[i][2] = C;
        }
        Arrays.sort(edge, ((o1, o2) -> o1[2]-o2[2]));
        for(int i=0; i<E; i++){
            if(union(edge[i][0], edge[i][1])){
                ans+=edge[i][2];
            }
        }
        System.out.print(ans);
    }

    static int find(int x){
        if(node[x]==x) return x;
        else return node[x] = find(node[x]);
    }
    static boolean union(int x, int y){
         int fx = find(x);
         int fy = find(y);
         if(fx==fy) return false;
         else {
             if(fx<fy) node[fy] = fx;
             else node[fx] = fy;
             return true;
         }
    }
}
