import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int middle = Integer.parseInt(br.readLine());
        sb.append(middle).append("\n");
        for(int i=1; i<N; i++){
            int now = Integer.parseInt(br.readLine());
            if(now<middle){
                minHeap.add(now);
            }
            else{
                maxHeap.add(now);
            }
            if(maxHeap.size()<minHeap.size()){
                maxHeap.add(middle);
                middle = minHeap.poll();
            }
            else if(maxHeap.size()>minHeap.size()+1){
                minHeap.add(middle);
                middle = maxHeap.poll();
            }
            sb.append(middle).append("\n");
        }
        System.out.println(sb);
    }
}
