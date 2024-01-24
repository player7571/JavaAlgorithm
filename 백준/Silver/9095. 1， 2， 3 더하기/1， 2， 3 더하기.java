import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            int cnt=0;
            while(!queue.isEmpty()){
                int val = queue.poll();
                if(val==n) cnt++;
                else{
                    if(val+1<=n) queue.add(val+1);
                    if(val+2<=n) queue.add(val+2);
                    if(val+3<=n) queue.add(val+3);
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
