import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Permutation p = new Permutation(N, M);
        p.dfs(0);
        p.print();
    }
    static class Permutation{
        int N, M;
        int [] num = new int[8];
        public Permutation(int N, int M){
            this.N = N;
            this.M = M;
            for(int i=0; i<N; i++){
                num[i] = i+1;
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        boolean [] check = new boolean[8];
        void dfs(int cnt){
            if(cnt==M){
                for(int i=0; i<M; i++){
                    int a= (deque.remove());
                    deque.add(a);
                    sb.append(a).append(" ");
                }
                sb.append("\n");
                return;
            }
            for(int i=0; i<N; i++){
                if(!check[i]){
                    check[i]=true;
                    deque.add(num[i]);
                    dfs(cnt+1);
                    deque.removeLast();
                    check[i]=false;
                }
            }
        }
        void print(){
            System.out.println(sb);
        }
    }
}
