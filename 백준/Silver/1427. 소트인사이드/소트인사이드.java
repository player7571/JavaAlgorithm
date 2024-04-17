import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        Map<Integer, Integer>map = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            int val = str.charAt(i)-'0';
            map.put(val, map.getOrDefault(val, 0)+1);
        }
        for(int i=9; i>=0; i--){
            for(int j=0; j<map.getOrDefault(i, 0); j++){
                sb.append(i);
            }
        }
        System.out.print(sb);
    }
}
