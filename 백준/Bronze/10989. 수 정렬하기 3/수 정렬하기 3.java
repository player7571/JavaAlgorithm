import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            int val = Integer.parseInt(br.readLine());
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        for(int i=1; i<=10000; i++){
            for(int j=0; j<map.getOrDefault(i, 0); j++){
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}
