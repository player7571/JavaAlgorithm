import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] chk = new boolean[1000001];
        boolean[] chk2 = new boolean[(int)(max-min+1)];
        for(int i=2; i<chk.length; i++){
            if(!chk[i]){
                for(int j=i*2; j<chk.length; j+=i){
                    chk[j]=true;
                }
                long pow = (long) i*i;
                if(pow>max) continue;
                long num = (((((min-1)/pow)+1)*pow)-min);
                for(long j = num; j< chk2.length; j+=pow){
                    chk2[(int)j]=true;
                }
            }
        }
        int cnt=0;
        for(int i=0; i<chk2.length; i++){
            if(chk2[i]) cnt++;
        }
        System.out.print(max-min+1-cnt);
    }
}