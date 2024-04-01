import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] bool = new boolean[10001];
        bool[1] = true;
        for(int i=2; i<bool.length; i++){
            if(bool[i]) continue;
            for(int j=i*2; j<bool.length; j+=i){
                bool[j] = true;
            }
        }
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            int n = Integer.parseInt(br.readLine());
            for(int i=n/2; i>0; i--){
                if(!bool[i]&&!bool[n-i]) {
                    sb.append(i).append(" ").append(n-i).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
