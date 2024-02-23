import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] student = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            student[i] = new ArrayList<>();
        }
        int[] cnt = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            cnt[B]++;
            student[A].add(B);
        }
        for(int i=1; i<=N; i++){
            if(cnt[i]==0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int x= queue.poll();
            sb.append(x).append(" ");
            for(int a :student[x]){
                if(--cnt[a]==0) queue.add(a);
            }
        }
        System.out.print(sb);
    }
}
