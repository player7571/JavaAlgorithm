import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int k = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -Integer.compare(o1,o2);
                }
            });
            while(k-->0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                if(st.nextToken().equals("I")){
                    int num = Integer.parseInt(st.nextToken());
                    map.put(num, map.getOrDefault(num, 0)+1);
                    minHeap.add(num);
                    maxHeap.add(num);
                }
                else{
                    if(map.isEmpty()) continue;
                    int num;
                    if(Integer.parseInt(st.nextToken())==-1){
                        num=minHeap.poll();
                        while(map.getOrDefault(num, 0)==0){
                            num=minHeap.poll();
                        }
                    }
                    else{
                        num=maxHeap.poll();
                        while(map.getOrDefault(num, 0)==0){
                            num=maxHeap.poll();
                        }
                    }
                    if(map.get(num)==1){
                        map.remove(num);
                    }
                    else{
                        map.put(num, map.get(num)-1);
                    }
                }
            }
            if(map.isEmpty()) sb.append("EMPTY\n");
            else {
                while(map.getOrDefault(maxHeap.peek(), 0)==0){
                    maxHeap.poll();
                }
                while(map.getOrDefault(minHeap.peek(), 0)==0){
                    minHeap.poll();
                }
                sb.append(maxHeap.peek()).append(" ").append(minHeap.peek()).append("\n");
            }
        }
        System.out.print(sb);
    }
}
