import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        for(int i=0; i<L; i++){
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0)+1);
            queue.add(str);
        }
        for(int i=0; i<K; i++){
            if(queue.isEmpty()) break;
            String str = queue.poll();
            if(map.get(str)>1){
                map.put(str, map.get(str)-1);
                i--;
            }
            else sb.append(str).append("\n");
        }
        System.out.print(sb);
    }
}
