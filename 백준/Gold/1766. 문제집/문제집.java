import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] degree = new int[N+1];
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            arr[i] = new ArrayList<Integer>();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            degree[b]++;
            arr[a].add(b);
        }
        for(int i=1; i<=N; i++){
            if(degree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now).append(" ");
            for(int i=0; i<arr[now].size(); i++){
                int x = arr[now].get(i);
                if(--degree[x]==0) queue.add(x);
            }
        }
        System.out.print(sb);
    }
}
