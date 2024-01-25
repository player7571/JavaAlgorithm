import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1)==Math.abs(o2) ? Integer.compare(o1,o2) : Integer.compare(Math.abs(o1), Math.abs(o2));
            }
        });
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(heap.isEmpty()) sb.append("0\n");
                else sb.append(heap.poll()).append("\n");
            }
            else heap.add(x);
        }
        System.out.print(sb);
    }
}
