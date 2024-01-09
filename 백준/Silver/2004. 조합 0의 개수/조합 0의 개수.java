import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        if(m==0 || n==m) {
            System.out.print(0);
            return;
        }
        if(n/2<m) m=n-m;
        int [] cnt = new int[5];
        int x=n;
        while(x>=5){
            x/=5;
            cnt[1]+=x;
        }
        x=n;
        while(x>=2){
            x/=2;
            cnt[2]+=x;
        }
        x=m;
        while(x>=5){
            x/=5;
            cnt[3]+=x;
        }
        x=n-m;
        while(x>=5){
            x/=5;
            cnt[3]+=x;
        }
        x=m;
        while(x>=2){
            x/=2;
            cnt[4]+=x;
        }
        x=n-m;
        while(x>=2){
            x/=2;
            cnt[4]+=x;
        }
        System.out.print(Math.min(cnt[1]-cnt[3],cnt[2]-cnt[4]));
    }
}
