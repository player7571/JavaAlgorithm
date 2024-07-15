import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> coin = new ArrayList<>();
        int[] ans = new int[k+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            int val = Integer.parseInt(br.readLine());
            if(k>=val){
                if(ans[k]==0){
                    coin.add(val);
                    ans[val] = 1;
                    queue.add(val);
                }
            }
        }
        while (!queue.isEmpty()){
            int now = queue.poll();
            for (Integer integer : coin) {
                int next = now + integer;
                if (next > k) continue;
                if (ans[now] + 1 < ans[next] || ans[next] == 0) {
                    ans[next] = ans[now] + 1;
                    queue.add(next);
                }
            }
        }
        System.out.print(ans[k]!=0 ? ans[k]: -1);
    }
}
