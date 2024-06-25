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
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] field = new int[100001];
        for(int i=0; i<100001; i++){
            field[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        field[N] = 0;
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now+1<100001&&field[now+1]>field[now]+1) {
                queue.add(now+1);
                field[now+1] = field[now]+1;
            }
            if(now-1>=0&&field[now-1]>field[now]+1) {
                queue.add(now-1);
                field[now-1] = field[now]+1;
            }
            if(now*2<100001&&field[now*2]>field[now]) {
                queue.add(now*2);
                field[now*2] = field[now];
            }
        }
        System.out.print(field[K]);
    }
}
