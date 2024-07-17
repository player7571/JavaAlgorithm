import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int[] num = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());;
        for(int i=0; i<M; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        int down = 1;
        int up = 1;
        int max = 0;
        for(int i=1; i<M; i++){
            if(num[i-1]<num[i]){
                down++;
                max = Math.max(max, up);
                up = 1;
            }
            else if(num[i-1]>num[i]){
                up++;
                max = Math.max(max, down);
                down = 1;
            }
        }
        System.out.print(Math.max(Math.max(max, up), down));
    }
}
