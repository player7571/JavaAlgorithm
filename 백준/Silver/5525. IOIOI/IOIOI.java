import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static String str;
    static int sum=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        str = br.readLine();
        for(int i=0; i<M; i++){
            if(str.charAt(i)=='I') i=count(i);
        }
        System.out.print(sum);
    }
    static int count(int cnt){
        int start = cnt;
        while(cnt<M-1&&str.charAt(cnt)!=str.charAt(cnt+1)){
            cnt++;
        }
        int pn;
        if(str.charAt(cnt)=='O') pn = cnt-start;
        else pn = cnt-start+1;
        if(pn-(2*N+1)>=0) sum+=((pn-(2*N+1))/2+1);
        return cnt;
    }
}
