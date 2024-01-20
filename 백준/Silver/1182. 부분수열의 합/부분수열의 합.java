import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt;
    static int [] num;
    static int S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i]= Integer.parseInt(st.nextToken());
        }
        cnt=0;
        for(int i=0; i<num.length-1; i++){
            find(i, 0);
        }
        if(num[N-1]==S) cnt++;
        System.out.print(cnt);
    }
    static void find(int start, int sum){
        sum+=num[start];
        for(int i=start+1; i<num.length; i++){
            find(i, sum);
        }
        if(sum==S) cnt++;
    }
}
