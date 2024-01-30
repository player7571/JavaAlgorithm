import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N+1];
        int cnt=1;
        for(int i=1; i<=N; i++){
            num[i] = i;
        }
        int sum=0, start=0, end=0;
        while(end<N){
            if(sum==N) {
                cnt++;
                sum=sum-num[++start]+num[++end];
            }
            else if(sum<N) sum+=num[++end];
            else sum-=num[++start];
        }
        System.out.print(cnt);
    }
}
