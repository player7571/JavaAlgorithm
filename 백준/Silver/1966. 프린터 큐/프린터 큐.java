import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T!=0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int [] count= new int[10];
            count[0] = 1;
            int m=0;
            Queue<Integer> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                int num = Integer.parseInt(st.nextToken());
                count[num]++;
                queue.add(num);
                if(i==M) {
                    queue.add(0);
                    m = num;
                }
            }
            int K=9, num=0;
            while(true){
                while(count[K]==0) K--;
                if(K==m){
                    while(queue.peek()!=0) {
                        if(m==queue.remove())
                            num++;
                    }
                    break;
                }
                while(queue.peek()!=K){
                    queue.add(queue.remove());
                }
                queue.remove();
                count[K]--;
                num++;

            }
            sb.append(num).append("\n");
            T--;
        }
        System.out.println(sb);
    }
}
