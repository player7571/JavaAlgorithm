import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            ArrayList<String> arr = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String str = st.nextToken();
                map.put(str, map.getOrDefault(str, 0)+1);
                if(map.get(str)==1) arr.add(str);
            }
            int sum=1;
            for(int i=0; i<map.size(); i++){
                sum *= (map.get(arr.remove(0))+1);
            }
            sb.append(sum-1).append("\n");
        }
        System.out.print(sb);
    }
}
