import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(N-->0){
            String str = br.readLine();
            Map<Character, Integer> map = new HashMap<>();
            boolean bool = true;
            map.put(str.charAt(0), 1);
            for(int i=1; i<str.length(); i++){
                if(str.charAt(i)!=str.charAt(i-1)) {
                    if(map.getOrDefault(str.charAt(i), 0)==1) {
                        bool = false;
                        break;
                    }
                }
                map.put(str.charAt(i), 1);
            }
            if(bool) cnt++;
        }
        System.out.print(cnt);
    }
}
