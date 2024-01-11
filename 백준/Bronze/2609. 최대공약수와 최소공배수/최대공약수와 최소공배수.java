import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if(N-M==0){
            System.out.print(N+"\n"+N);
            return;
        }
        int max= Math.abs(N-M);
        while(N%max!=0||M%max!=0){
            max--;
        }
        sb.append(max).append("\n");
        for(int i=1; i<=M; i++){
            for(int j=1; j<=N; j++){
                if(N*i==M*j) {
                    sb.append(N*i);
                    System.out.print(sb);
                    return;
                }
            }
        }

    }
}
