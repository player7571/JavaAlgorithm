import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] mbti = new String[N];
            boolean brk = false;
            for(int i=0; i<N; i++){
                mbti[i] = st.nextToken();
                map.put(mbti[i], map.getOrDefault(mbti[i], 0)+1);
                if(map.get(mbti[i])==3) {
                    sb.append(0).append("\n");
                    brk = true;
                    break;
                }
            }
            if(brk) continue;
            int min = 100;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(i==j) continue;
                    for(int k=0; k<N; k++){
                        if(j==k||i==k) continue;
                        min = Math.min(getDistance(mbti[i], mbti[j], mbti[k]), min);
                    }
                }
            }
            sb.append(min).append("\n");
        }
        System.out.print(sb);
    }

    static int getDistance(String a, String b, String c){
        int cnt=0;
        for(int i=0; i<4; i++){
            if(a.charAt(i)!=b.charAt(i)) cnt++;
            if(b.charAt(i)!=c.charAt(i)) cnt++;
            if(c.charAt(i)!=a.charAt(i)) cnt++;
        }
        return cnt;
    }
}
