import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] cnt = new int[str1.length()+1][str2.length()+1];
        int max = 0;
        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)) cnt[i][j] = cnt[i-1][j-1]+1;
                else cnt[i][j] = Math.max(cnt[i-1][j], cnt[i][j-1]);
                max = Math.max(max, cnt[i][j]);
            }
        }
        System.out.print(max);
    }
}
