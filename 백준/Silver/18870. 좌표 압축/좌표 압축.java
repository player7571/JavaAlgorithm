import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] X = new int[N];
        int[] y = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            y[i] = X[i] = num;
        }
        Arrays.sort(y);
        int cnt=0;
        for(int i=0; i<N; i++){
            if(i!=N-1&&y[i]==y[i+1]) continue;
            map.put(y[i], cnt);
            cnt++;
        }
        for(int i=0; i<N; i++){
            sb.append(map.get(X[i])).append(" ");
        }
        System.out.print(sb);
    }
}
