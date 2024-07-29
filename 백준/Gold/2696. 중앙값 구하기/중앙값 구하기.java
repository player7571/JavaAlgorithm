import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int M = Integer.parseInt(br.readLine());
            sb.append((M+1)/2).append("\n");
            int middle = 0;
            boolean start = false;
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
            for(int i=0; i<=M/10; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int N = st.countTokens();
                for(int j=0; j<N; j++){
                    int now = Integer.parseInt(st.nextToken());
                    if(!start) {
                        middle = now;
                        sb.append(middle).append(" ");
                        start = true;
                        continue;
                    }
                    if(now<middle){
                        minHeap.add(now);
                    }
                    else{
                        maxHeap.add(now);
                    }
                    if(maxHeap.size()<minHeap.size()) {
                        maxHeap.add(middle);
                        middle = minHeap.poll();
                    }
                    else if(maxHeap.size()>minHeap.size()){
                        minHeap.add(middle);
                        middle = maxHeap.poll();
                    }
                    if(j%2==0) sb.append(middle).append(" ");
                }
                if(i%2==1||N!=10) sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
