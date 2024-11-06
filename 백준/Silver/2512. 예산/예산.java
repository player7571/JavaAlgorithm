import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];
        int num1 = 0, num2=0;
        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(st.nextToken());
            num1+=list[i];
            num2 = Math.max(num2, list[i]);
        }
        int M = Integer.parseInt(br.readLine());
        if(num1<=M){
            System.out.print(num2);
            return;
        }
        int min = 1;
        int max = M;
        int mid = (max+min)/2;
        int ans = 0;

        while(min!=max){
            int val = 0;
            for(int i=0; i<N; i++){
                val += Math.min(list[i], mid);
            }
            if(val==M){
                System.out.print(mid);
                return;
            }
            if(val>M){
                max = mid;
            }
            else {
                ans = Math.max(mid, ans);
                min = mid+1;
            }
            mid = (max+min)/2;
        }
        System.out.print(ans);
    }
}
