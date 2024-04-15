import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean zero;
        int[] cnt = new int[2];
        if(str.charAt(0)=='0'){
            zero = true;
            cnt[0]++;
        }
        else{
            zero = false;
            cnt[1]++;
        }
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i)=='0'){
                if(zero) continue;
                cnt[0]++;
                zero = true;
            }
            else{
                if(!zero) continue;
                cnt[1]++;
                zero = false;
            }
        }
        System.out.print(Math.min(cnt[0], cnt[1]));
    }
}
